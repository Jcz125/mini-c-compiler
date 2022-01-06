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
    public ArrayList<Ast> list_var = null;

    @Override
    public String visit(Program program) {
        SymbolTable root = new SymbolTable("root", null);
        this.tds_root = this.tds_current = root;
        root.addLineFct("malloc", NatureSymboles.FUNCTION, "void *", new ArrayList<Symbole>(){{add(new IntSymbole("n"));}}, 1);
        root.addLineFct("print", NatureSymboles.FUNCTION, "void", new ArrayList<Symbole>(){{add(new IntSymbole("n"));}}, 1);
        for (Ast ast : program.program)
            ast.accept(this);
        return null;
    }

    @Override
    public String visit(DeclType decltype) {
        HashMap<Symbole, String> table = new HashMap<Symbole, String>(); // Symbole est la clé K et String la valeur V
        ArrayList<String> idfs = new ArrayList<>();
        for (Ast champ : decltype.list) { // remplissage des champs selon le type
            if (champ instanceof VarInt) {
                for (Idf idf : ((VarInt) champ).list) {
                    if (!idfs.contains(idf.name)) {
                        idfs.add(idf.name);
                        IntSymbole sb = new IntSymbole(idf.name);
                        table.put(sb, "int");
                    } else {
                        Errors.add("Error in "+tds_current.getName()+", "+decltype.type+", champs"+": "+idf.name+" already used.");
                    }
                }
            } else {
                VarStruct s = (VarStruct) champ;
                for (Idf idf : s.list_idf) {
                    if (!idfs.contains(idf.name)) {
                        idfs.add(idf.name);
                        StructSymbole sb = new StructSymbole(s.type, idf.name);
                        table.put(sb, s.type);
                    } else {
                        Errors.add("Error in "+tds_current.getName()+", "+decltype.type+", champs"+": "+idf.name+" already used.");
                    }
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

    public HashMap<Symbole, String> create_hashmap_param(ArrayList<Ast> list, String name) {
        HashMap<Symbole, String> params = new HashMap<>();
        ArrayList<String> idfs = new ArrayList<>();
        for (Ast ast : list) {
            if (ast instanceof IntParam) {
                IntParam param = (IntParam) ast;
                if (!idfs.contains(param.idf.name)) {
                    idfs.add(param.idf.name);
                    params.put(new IntSymbole(param.idf.name), "int");
                } else {
                    this.Errors.add("Error in "+tds_current.getName()+", "+name+", params"+": idf "+param.idf.name+" already used.");
                    Errors.add("Function params : Idf already used"); // améliorer le message d'erreur
                } // de préférence stocker l'erreur quelque part et afficher tous les erreurs
            } else {
                StructPointer param = (StructPointer) ast;
                params.put(new StructSymbole(param.type, param.idf.name), param.type);
            }
        }
        return params;
    }

    public ArrayList<Symbole> create_array_param(ArrayList<Ast> list, String name) {
        ArrayList<Symbole> params = new ArrayList<>();
        ArrayList<String> idfs = new ArrayList<>();
        for (Ast ast : list) {
            if (ast instanceof IntParam) {
                IntParam param = (IntParam) ast;
                if (!idfs.contains(param.idf.name)) {
                    idfs.add(param.idf.name);
                    params.add(new IntSymbole(param.idf.name));
                } else {
                    this.Errors.add("Error in "+tds_current.getName()+", "+name+", params"+": idf "+param.idf.name+" already used."); // améliorer le message d'erreur
                }
            } else {
                StructPointer param = (StructPointer) ast;
                params.add(new StructSymbole(param.type, param.idf.name));
            }
        }
        return params;
    }

    public void checkMain(LineElement line) {
        if (line.getIdf().equals("main") && (line.getNature() == NatureSymboles.FUNCTION) && (((FctSymbole) line.getSymbole()).getNbParam() == 0)) {
            this.main = true;
        }
    }

    @Override // pas terminer à finaliser manque le contrôle sémantique
    public String visit(IntFct intFct) {
        // HashMap<Symbole, String> params = create_hashmap_param(intFct.params.list);
        ArrayList<Symbole> params = create_array_param(intFct.params.list, intFct.type+" "+intFct.idf);

        LineElement line = tds_current.addLineFct(intFct.idf.name, NatureSymboles.FUNCTION, "int", params, params.size());
        // on check si le idf est déjà utilisé
        if (line != null) { // finalement le newRegion ici n'est pas approprié, trouver un moyen de faire autrement car Bloc le fait déjà
            // tds_current = tds_current.newRegion(intFct.idf.name, tds_current);
            // tds_current.addListVar(intFct.params.list, NatureSymboles.PARAM_FUNC);
            this.list_var = intFct.params.list;
            String typeRetour = intFct.bloc.accept(this);
            // tds_current = tds_current.exitRegion(tds_current);
            checkMain(line);

            //controle type de return
            if (typeRetour == null) {
                Errors.add("Warning in "+tds_current.getName()+" : no return for function int "+line.getIdf());
                return null;
            }
            else if (!typeRetour.equals("int")) {
                Errors.add("Warning in "+tds_current.getName()+" : no identical return type for function "+line.getIdf());
                return null;
            }

            // Ast bloc = intFct.bloc;
            // String result = lookUpReturnType(bloc); // à écrire
            // if (result==null) {
            //     Errors.add("Warning in "+tds_current.getName()+" : no return for function "+line.getIdf());
            // }
        // controle type retour == type return
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
        ArrayList<Symbole> params = create_array_param(structFct.params.list, structFct.type+" * "+structFct.idf_fct);
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
    public String visit(Bloc bloc) { // doit faire newRegion ici vérifier
        tds_current = tds_current.newRegion(tds_current.getName()+"#"+tds_current.getChildren().size()+1, tds_current);
        if (list_var != null) {
            tds_current.addListVar(list_var, NatureSymboles.PARAM_FUNC);
            list_var = null;
        }
        String returnType = null;
        for(Ast ast:bloc.list) {
            if (ast instanceof Return || ast instanceof IfThen || ast instanceof IfThenElse || ast instanceof WhileInst || ast instanceof Bloc) {
                if (returnType == null)
                    returnType = ast.accept(this);
                else if (!returnType.equals(ast.accept(this)))
                    returnType = "";
            }
            ast.accept(this);
        }
        tds_current = tds_current.exitRegion(tds_current);
        return returnType;
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
        //voir si les champs des structs sont vraiment dans les structs
        //renvoie le type de fleche
        return null;
    }
    //à vérifier,Céline will check
    @Override
    public String visit(Fleche fleche) {
        String left = fleche.accept(this);
        String right = fleche.accept(this);
        LineElement line; // faire un look peut-être

        //control sémantique
        // String left= ((Idf) fleche.left).name;
        // String right= ((Idf) fleche.right).name;
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
        String left = ouLogique.left.accept(this);
        String right = ouLogique.right.accept(this);
        if (left.equals(right)) {
            return right;
        }
        return null;
    }

    @Override
    public String visit(EtLogique etLogique) {
        String left = etLogique.left.accept(this);
        String right = etLogique.right.accept(this);
        if (left.equals(right)) {
            return right;
        }
        return null;
    }

    @Override
    public String visit(EqualTo equalTo) {
        String left = equalTo.left.accept(this);
        String right = equalTo.right.accept(this);
        if (left.equals(right)) {
            return right;
        }
        return null;
    }

    @Override
    public String visit(NotEqualTo notEqualTo) {
        String left = notEqualTo.left.accept(this);
        String right = notEqualTo.right.accept(this);
        if (left.equals(right)) {
            return right;
        }
        return null;
    }

    @Override
    public String visit(GreaterOrEqual greaterOrEqual) {
        String left = greaterOrEqual.left.accept(this);
        String right = greaterOrEqual.right.accept(this);
        if (left.equals(right)) {
            return right;
        }
        return null;
    }

    @Override
    public String visit(GreaterThan greaterThan) {
        String left = greaterThan.left.accept(this);
        String right = greaterThan.right.accept(this);
        if (left.equals(right)) {
            return right;
        }
        return null;
    }

    @Override
    public String visit(LessOrEqual lessOrEqual) {
        String left = lessOrEqual.left.accept(this);
        String right = lessOrEqual.right.accept(this);
        if (left.equals(right)) {
            return right;
        }
        return null;
    }

    @Override
    public String visit(LessThan lessThan) {
        String left = lessThan.left.accept(this);
        String right = lessThan.right.accept(this);
        if (left.equals(right)) {
            return right;
        }
        return null;
    }

    @Override
    public String visit(Plus plus) {
        String left = plus.left.accept(this);
        String right = plus.right.accept(this);
        if (left.equals(right)) {
            return right;
        }
        return null;
    }

    @Override
    public String visit(Minus minus) {
        String left = minus.left.accept(this);
        String right = minus.right.accept(this);
        if (left.equals(right)) {
            return right;
        }
        return null;
    }

    @Override
    public String visit(Mult mult) {
        String left = mult.left.accept(this);
        String right = mult.right.accept(this);
        if (left.equals(right)) {
            return right;
        }
        return null;
    }

    @Override
    public String visit(Divide divide) {
        String left = divide.left.accept(this);
        String right = divide.right.accept(this);
        if (left.equals(right)) {
            return right;
        }
        return null;
    }

    @Override
    public String visit(Oppose oppose) {
        String type = oppose.value.accept(this);
        // error pour -pointer
        if (oppose.op.equals("-") && !type.equals("int")) {
            Errors.add("Error in "+tds_current.getName()+" : -value needs value to be an arithmetic type");
            return null;
        }
            

            // if (oppose.value instanceof Fleche) {
            //     type = oppose.value.accept(this);
            //     if (!type.equals("int")) {
            //         Errors.add("Error in "+tds_current.getName()+" : -value needs value to be an arithmetic type");
            //         return null;
            //     }
            // }
            // else if (oppose.value instanceof Function) {
            //     type = oppose.value.accept(this);
            //     LineElement lineElement = tds_current.lookUp(((Idf) ((Function) oppose.value).idf).name, tds_current);
            //     if (lineElement != null && lineElement.getSymbole() instanceof FctSymbole && !((FctSymbole) lineElement.getSymbole()).getTypeRetour().equals("int")) {
            //         Errors.add("Error in "+tds_current.getName()+" : -value needs value to be an arithmetic type");
            //     }
            // }
            //manque check pour Parenthesis quand expr c'est un pointeur
        

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

        return type;
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
        //on vérifie que la funct left (idf) soit bien définie
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
            //idf doit etre defini
            Errors.add("Error in"+tds_current.getName()+"sizeof invalid identifier: "+sizeof.idf.name);
            return null;
        }
    }

    @Override
    public String visit(Idf idf) {
        return tds_current.lookUp(idf.name, tds_current).getSymbole().getType();
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
        return return1.accept(this);
    }

    @Override
    public String visit(Entier integer) {
        return "int";
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
