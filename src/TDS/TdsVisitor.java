package TDS;

import TDS.Symboles.*;
import ast.*;

import java.util.ArrayList;
import java.util.HashMap;

public class TdsVisitor implements AstVisitor<String> {

    public SymbolTable tds_root;
    public SymbolTable tds_current;
    public boolean main = false;
    public ArrayList<String> Errors = SymbolTable.Errors;

    @Override
    public String visit(Program program) {
        SymbolTable root = new SymbolTable("root", null);
        this.tds_root = this.tds_current = root;
        for (Ast ast : program.program)
            ast.accept(this);
        return null;
    }

    @Override
    public String visit(DeclType decltype) {
        HashMap<Symbole, String> table = new HashMap<Symbole, String>(); // Symbole est la clé K et String la valeur V
        for (Ast champ : decltype.list) { // remplissage des champs selon le type
            if (champ instanceof VarInt) {
                for (Idf idf : ((VarInt) champ).list) {
                    IntSymbole sb = new IntSymbole(idf.name);
                    table.put(sb, "int");
                }
            } else {
                VarStruct s = (VarStruct) champ;
                for (Idf idf : s.list_idf) {
                    StructSymbole sb = new StructSymbole(s.type, idf.name);
                    table.put(sb, s.type);
                }
            }
        }
        tds_current.addLineStructDef(decltype.idf_name.name, NatureSymboles.STRUCT, decltype.type, table);
        return null;
    }

    @Override
    public String visit(VarInt varInt) {
        for(Idf idf : varInt.list){
            tds_current.addLineInt(idf.name, NatureSymboles.VARIABLE);
        }
        return null;
    }

    @Override
    public String visit(VarStruct varStruct) {
        String type = varStruct.type;
        for (Idf idf : varStruct.list_idf) {
            tds_current.addLineStruct(idf.name, NatureSymboles.VARIABLE, type);
        }
        return null;
    }

    public HashMap<Symbole, String> create_hashmap_param(ArrayList<Ast> list) {
        HashMap<Symbole, String> params = new HashMap<>();
        ArrayList<String> idfs = new ArrayList<>();
        for (Ast ast : list) {
            if (ast instanceof IntParam) {
                IntParam param = (IntParam) ast;
                if (!idfs.contains(param.idf.name)) {
                    idfs.add(param.idf.name);
                    params.put(new IntSymbole(param.idf.name), "int");
                } else {
                    System.out.println("Function params : Idf already used"); // améliorer le message d'erreur
                } // de préférence stocker l'erreur quelque part et afficher tous les erreurs
            } else {
                StructPointer param = (StructPointer) ast;
                params.put(new StructSymbole(param.type, param.idf.name), param.type);
            }
        }
        return params;
    }

    public ArrayList<Symbole> create_array_param(ArrayList<Ast> list) {
        ArrayList<Symbole> params = new ArrayList<>();
        ArrayList<String> idfs = new ArrayList<>();
        for (Ast ast : list) {
            if (ast instanceof IntParam) {
                IntParam param = (IntParam) ast;
                if (!idfs.contains(param.idf.name)) {
                    idfs.add(param.idf.name);
                    params.add(new IntSymbole(param.idf.name));
                } else {
                    System.out.println("Function params : Idf already used"); // améliorer le message d'erreur
                } // de préférence stocker l'erreur quelque part et afficher tous les erreurs
            } else {
                StructPointer param = (StructPointer) ast;
                params.add(new StructSymbole(param.type, param.idf.name));
            }
        }
        return params;
    }

    @Override // pas terminer à finaliser manque le contrôle sémantique et repérage région
    public String visit(IntFct intFct) {
        //HashMap<Symbole, String> params = create_hashmap_param(intFct.params.list);
        ArrayList<Symbole> params = create_array_param(intFct.params.list);

        LineElement line = tds_current.addLineFct(intFct.idf.name, NatureSymboles.FUNCTION, "int", params, params.size());
        //on check si le idf est déjà utilisé
        if(line==null){
            Errors.add("Error in "+tds_current.getName()+" : idf "+intFct.idf.name+" already used");
        }
        if (line != null) {
            tds_current = tds_current.newRegion(intFct.idf.name, tds_current);
            tds_current.addListVar(intFct.params.list, NatureSymboles.PARAM_FUNC);
            intFct.bloc.accept(this);
            tds_current = tds_current.exitRegion(tds_current);
            // ajout de vérif main
        }

        //controle type de return
        Ast bloc = intFct.bloc;
        String result = lookUpReturnType(bloc);
        if(result==null){
            Errors.add("Error in "+tds_current.getName()+" : no return for function "+line.getIdf());
        }

        return null;
    }

    String lookUpReturnType(Ast bloc){
        //renvoie le type de l'expr de return du bloc (c'est le bloc d'une déclaration de function)
        //S'il n'y a pas de "return", revoie null

        return null;
    }


    @Override
    public String visit(StructFct structFct) {
        //HashMap<Symbole, String> params = create_hashmap_param(structFct.params.list);
        ArrayList<Symbole> params = create_array_param(structFct.params.list);
        LineElement line = tds_current.addLineFct(structFct.idf_fct.name, NatureSymboles.FUNCTION, structFct.type, params, params.size());
        if (line != null) {
            tds_current = tds_current.newRegion(structFct.idf_fct.name, tds_current);
            tds_current.addListVar(structFct.params.list, NatureSymboles.PARAM_FUNC);
            structFct.bloc.accept(this);
            tds_current = tds_current.exitRegion(tds_current);
        }
        return null;
    }

    @Override
    public String visit(Bloc bloc) {
        for(Ast ast:bloc.list){
            ast.accept(this);
        }
        return null;
    }


    @Override
    public String visit(Affect affect) {
        // à faire avec funct check
        if (affect.left instanceof Idf) {
            LineElement lineElement= tds_current.lookUp(((Idf) affect.left).name,tds_current);
            String typeIdf = lineElement.getSymbole().getType();
            if(!checkType(affect.right,typeIdf)){
                Errors.add("Error in "+tds_current.getName()+": "+lineElement.getIdf()+" cannot be affected a type different to "+lineElement.getSymbole().getType());
            }
        }
        else{
            String typeFleche = getTypeFleche((Fleche) affect.left);

            if(!checkType(affect.right,typeFleche)){
                Errors.add("Error in "+tds_current.getName()+" : affect types dont match"+typeFleche);
            }

        }
        return null;
    }

    public String getTypeFleche(Fleche fleche){
        //renvoie le type de fleche
        return null;
    }
    //à vérifier,Céline will check
    @Override
    public String visit(Fleche fleche) {
        //control sémantique
        String left= ((Idf) fleche.left).name;
        String right= ((Idf) fleche.right).name;
        //LineElement lineElement = tds_current.lookUp(left,tds_current);
        LineElement lineElement = tds_current.lookUpStructDef(left,tds_current);
        //on vérifie que la struct left soit bien définie
        if(lineElement == null){
            Errors.add("Error in "+tds_current.getName()+": "+left+" not defined");
           // return null;
        }

        StructDefSymbole structDefSymbole = (StructDefSymbole) lineElement.getSymbole();
        Symbole symbole=structDefSymbole.lookUpChamp(right);
        //on vérifie que le champ right soit bien un champ de left
        if(symbole == null){
            Errors.add("Error in "+tds_current.getName()+": "+right+" not champ of "+left);
            //return null;
        }

        return null;
    }

    @Override
    public String visit(OuLogique ouLogique) {
        return null;
    }

    @Override
    public String visit(EtLogique etLogique) {
        return null;
    }

    @Override
    public String visit(EqualTo equalTo) {
        return null;
    }

    @Override
    public String visit(NotEqualTo notEqualTo) {
        return null;
    }

    @Override
    public String visit(GreaterOrEqual greaterOrEqual) {
        return null;
    }

    @Override
    public String visit(GreaterThan greaterThan) {
        return null;
    }

    @Override
    public String visit(LessOrEqual lessOrEqual) {
        return null;
    }

    @Override
    public String visit(LessThan lessThan) {
        return null;
    }

    @Override
    public String visit(Plus plus) {
        return null;
    }

    @Override
    public String visit(Minus minus) {
        return null;
    }

    @Override
    public String visit(Mult mult) {
        return null;
    }

    @Override
    public String visit(Divide divide) {
        return null;
    }

    @Override
    public String visit(Oppose oppose) {
        // error pour -pointer
        if(oppose.op.equals("-")){
            if(oppose.value instanceof Fleche){
                Errors.add("Error in "+tds_current.getName()+" : -value needs value to be an arithmetic type");
            }
            if(oppose.value instanceof Function){
                LineElement lineElement = tds_current.lookUp(((Idf) ((Function) oppose.value).idf).name,tds_current);
                if(lineElement.getSymbole() instanceof StructSymbole){
                    Errors.add("Error in "+tds_current.getName()+" : -value needs value to be an arithmetic type");
                }
            }
            //manque check pour Parenthesis quand expr c'est un pointeur
        }

        /*if(oppose.value instanceof Idf){
            LineElement lineElement = tds_current.lookUp(((Idf) oppose.value).name,tds_current);
            if(lineElement==null){
                Errors.add("Error in "+tds_current.getName()+" : "+"identifier "+((Idf) oppose.value).name+" not defined");
                return null;
            }
            else{
                if(lineElement.getSymbole() instanceof IntSymbole){
                    return tds_current;
                }
                else{
                    Errors.add("Error in "+tds_current.getName()+" : "+((Idf) oppose.value).name+" not an integer");
                }
            }
        }

        if( oppose.value instanceof Function)*/

        return null;
    }


    public boolean checkType(Ast ast, String type) {
        // String left = ast.left.accept(this);
        // String right = ast.right.accept(this);
        
        return true;
    }


    @Override
    public String visit(Function function) {
        //control sémantique
        String FunctIdf= ((Idf) function.idf).name;

        LineElement lineElement = tds_current.lookUpFunctDef(FunctIdf,tds_current);
        //on vérifie que la funct left soit bien définie
        if(lineElement == null){
            Errors.add("Error in "+tds_current.getName()+": "+FunctIdf+" not defined");
            return null;
        }

        int nb = function.expression.size();
        FctSymbole fctSymbole = (FctSymbole) lineElement.getSymbole();
        //on vérifie que le nombre de params de la fonction correspond bien au nombre attendu
        if(nb!=fctSymbole.getNbParam()){
            Errors.add("Error in "+tds_current.getName()+" : params number doesnt match expected number in"+lineElement.getIdf());
            //return null
        }

        ArrayList<Symbole> paramsDecl = fctSymbole.getFctParams();

        //Il manque vérifier les types des params

        ArrayList<Ast> paramsExec = function.expression;

        for(int i=0 ; i<fctSymbole.getNbParam() ; i++){
            String typeDecl = paramsDecl.get(i).getType();
            if(!checkType(paramsExec.get(i),typeDecl)){
                Errors.add("Error in "+tds_current.getName()+ "type of param number "+i+" doesnt match function"+fctSymbole.getIdf()+" definition" );
            }
            //checkType(Ast ast, String type) renvoie un boolean (true si les 2 types pareils et false sinon)

        }

        return null;
    }

    @Override
    public String visit(Sizeof sizeof) {
        if(tds_current.lookUpStructDef(sizeof.idf.name,tds_current)!=null){
            return null;
        }
        else {
            Errors.add("Error in"+tds_current.getName()+"sizeof invalid identifier: "+sizeof.idf.name);
            return null;
        }
    }

    @Override
    public String visit(Idf idf) {
        return null;
    }

    @Override
    public String visit(IfThen ifThen) {
        return null;
    }

    @Override
    public String visit(IfThenElse ifThenElse) {
        return null;
    }

    @Override
    public String visit(WhileInst whileInst) {
        return null;
    }

    @Override
    public String visit(Return return1) {
        return null;
    }

    @Override
    public String visit(Entier integer) {
        return null;
    }

    @Override
    public String visit(Parametres parametres) {
        return null;
    }

    @Override
    public String visit(IntParam intParam) {

        return null;
    }

    @Override
    public String visit(StructPointer structPointer) {
        return null;
    }

}
