package TDS;

import TDS.Symboles.*;
import ast.*;

import java.util.ArrayList;
import java.util.HashMap;

public class TdsVisitor implements AstVisitor<String> {

    public SymbolTable tds_root;
    public SymbolTable tds_current;
    public String new_tds_name;
    public boolean main = false;
    public ArrayList<String> Errors = SymbolTable.Errors;
    public ArrayList<Ast> list_var = null;

    public void showErrors() {
        if (Errors.isEmpty())
            System.out.println("No errors found.");
        else
            for (String str : Errors)
                System.out.println(str);
        System.out.println("Total: "+Errors.size());
    }

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
        HashMap<Symbole, String> table = new HashMap<Symbole, String>();    // Symbole est la clé K et String la valeur V
        ArrayList<String> idfs = new ArrayList<>();
        for (Ast champ : decltype.list) {                                   // remplissage des champs selon le type
            if (champ instanceof VarInt) {
                for (Idf idf : ((VarInt) champ).list) {
                    if (!idfs.contains(idf.name)) {
                        idfs.add(idf.name);
                        IntSymbole sb = new IntSymbole(idf.name);
                        table.put(sb, "int");
                    } else {
                        Errors.add("Error in "+tds_current.titre+", "+decltype.type+", champs"+": "+idf.name+" already used.");
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
                        Errors.add("Error in "+tds_current.titre+", "+decltype.type+", champs"+": "+idf.name+" already used.");
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
                    Errors.add("Error in "+tds_current.titre+", function "+name+", params"+": idf "+param.idf.name+" already used.");
                }
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
                    this.Errors.add("Error in "+tds_current.titre+", function "+name+", params"+": idf "+param.idf.name+" already used."); // améliorer le message d'erreur
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
        ArrayList<Symbole> params = create_array_param(intFct.params.list, intFct.type+" "+intFct.idf);
        LineElement line = tds_current.addLineFct(intFct.idf.name, NatureSymboles.FUNCTION, "int", params, params.size());
        
        // on vérifie si le idf est déjà utilisé
        if (line != null) { // finalement le newRegion ici n'est pas approprié, trouver un moyen de faire autrement car Bloc le fait déjà
            // tds_current = tds_current.newRegion(intFct.idf.name, tds_current);
            // tds_current.addListVar(intFct.params.list, NatureSymboles.PARAM_FUNC);
            this.new_tds_name = intFct.idf.name;
            this.list_var = intFct.params.list;
            String typeRetour = intFct.bloc.accept(this);
            // tds_current = tds_current.exitRegion(tds_current);
            checkMain(line);

            // contrôle du type de retour
            if (typeRetour == null) {
                Errors.add("Warning in "+tds_current.titre+" : no return for function int "+line.getIdf());
                return null;
            }
            else if (!typeRetour.equals("int")) {
                Errors.add("Error in "+tds_current.titre+" : no identical return type for function "+line.getIdf());
                return null;
            }

            // Ast bloc = intFct.bloc;
            // String result = lookUpReturnType(bloc); // à écrire
            // if (result==null) {
            //     Errors.add("Warning in "+tds_current.titre+" : no return for function "+line.getIdf());
            // }
        // controle type retour == type return
        }
        return null;
    }

    // String lookUpReturnType(Ast bloc){
    //     //renvoie le type de l'expr de return du bloc (c'est le bloc d'une déclaration de function)
    //     //S'il n'y a pas de "return", revoie null

    //     return null;
    // }


    @Override
    public String visit(StructFct structFct) {
        ArrayList<Symbole> params = create_array_param(structFct.params.list, structFct.type+" * "+structFct.idf_fct);
        LineElement line = tds_current.addLineFct(structFct.idf_fct.name, NatureSymboles.FUNCTION, structFct.type, params, params.size());
        
        // on vérifie si le idf est déjà utilisé
        if (line != null) {
            // tds_current = tds_current.newRegion(structFct.idf_fct.name, tds_current);
            // tds_current.addListVar(structFct.params.list, NatureSymboles.PARAM_FUNC);
            this.new_tds_name = structFct.idf_fct.name;
            this.list_var = structFct.params.list;
            String typeRetour = structFct.bloc.accept(this);
            // tds_current = tds_current.exitRegion(tds_current);
            checkMain(line);

            // controle du type de retour
            if (typeRetour == null) {
                Errors.add("Warning in "+tds_current.titre+" : no return for function struct "+line.getIdf());
                return null;
            }
            else if (!typeRetour.equals(structFct.type)) {
                Errors.add("Error in "+tds_current.titre+" : no identical return type for function "+line.getIdf());
                return null;
            }
        }
        return null;
    }

    @Override
    public String visit(Bloc bloc) {
        tds_current = tds_current.newRegion(this.new_tds_name);
        this.new_tds_name = "";
        if (list_var != null) {
            tds_current.addListVar(list_var, NatureSymboles.PARAM_FUNC);
            list_var = null;
        }
        String returnType = null;
        for (Ast ast : bloc.list) {
            if (ast instanceof Return || ast instanceof IfThen || ast instanceof IfThenElse || ast instanceof WhileInst || ast instanceof Bloc) {
                if (returnType == null)
                    returnType = ast.accept(this);
                else if (!returnType.equals(ast.accept(this)))
                    returnType = "";
                continue;
            }
            ast.accept(this);
        }
        tds_current = tds_current.exitRegion();
        return returnType;
    }


    @Override
    public String visit(Affect affect) {
        String left = affect.left.accept(this);
        String right = affect.right.accept(this);
        if (left == null || right == null) { // au moins l'un des vars n'existe pas
            return null;
        }
        if (!left.equals(right)) {
            Errors.add("Error in "+tds_current.titre+" : affect types don't match "+left+" and "+right);
            return null;
        }
        return left;

        // à faire avec funct check
        // if (affect.left instanceof Idf) {
        //     LineElement lineElement = tds_current.lookUp(((Idf) affect.left).name, tds_current);
        //     String typeIdf = lineElement.getSymbole().getType();
        //     if (typeIdf.equals(affect.right.accept(this))) {
        //         Errors.add("Error in "+tds_current.titre+": "+lineElement.getIdf()+" cannot be affected a type different to "+lineElement.getSymbole().getType());
        //     }
        // } else {
        //     String typeFleche = getTypeFleche((Fleche) affect.left);

        //     if(!checkType(affect.right,typeFleche)){
        //         Errors.add("Error in "+tds_current.titre+" : affect types dont match"+typeFleche);
        //     }

        // }
        // return null;
    }

    // public String getTypeFleche(Fleche fleche){
    //     //voir si les champs des structs sont vraiment dans les structs
    //     //renvoie le type de fleche
    //     return null;
    // }

    @Override
    public String visit(Fleche fleche) {
        String left = fleche.left.accept(this);
        String right = fleche.right.accept(this);
        if (left == null || right == null) {
            Errors.add("Error in "+tds_current.titre+": "+"arrow problem");
            return null;
        }
        LineElement lineElement = tds_current.lookUpStructDef(left);
        if (lineElement != null) { // on vérifie que la struct left soit bien définie
            if (fleche.right instanceof Idf) {
                StructDefSymbole structDefSymbole = (StructDefSymbole) lineElement.getSymbole();
                Symbole symbole = structDefSymbole.lookUpChamp(((Idf) fleche.right).name, tds_current.lookUp(((Idf) fleche.right).name).getSymbole().getType());
                if (symbole != null) { // on vérifie que le champ right soit bien un champ de left
                    return symbole.getType();
                } else {
                    Errors.add("Error in "+tds_current.titre+": "+right+" not champ of "+left);
                    return null;
                }
            } else {
                Errors.add("Error in"+tds_current.titre+": arrow problem");
                return null;
            }
        } else {
            Errors.add("Error in "+tds_current.titre+": "+left+" not defined TEST");
            return null;
        }
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
            if (divide.left instanceof Entier && ((Entier) divide.left).value == 0)
                Errors.add("Error in "+tds_current.titre+": division by zero");
            return right;
        }
        return null;
    }

    @Override
    public String visit(Oppose oppose) {
        String type = oppose.value.accept(this);
        // error pour -pointer
        if (oppose.op.equals("-") && !type.equals("int")) {
            Errors.add("Error in "+tds_current.titre+": -value needs value to be an arithmetic type");
            return null;
        }
        return type;
            

            // if (oppose.value instanceof Fleche) {
            //     type = oppose.value.accept(this);
            //     if (!type.equals("int")) {
            //         Errors.add("Error in "+tds_current.titre+" : -value needs value to be an arithmetic type");
            //         return null;
            //     }
            // }
            // else if (oppose.value instanceof Function) {
            //     type = oppose.value.accept(this);
            //     LineElement lineElement = tds_current.lookUp(((Idf) ((Function) oppose.value).idf).name, tds_current);
            //     if (lineElement != null && lineElement.getSymbole() instanceof FctSymbole && !((FctSymbole) lineElement.getSymbole()).getTypeRetour().equals("int")) {
            //         Errors.add("Error in "+tds_current.titre+" : -value needs value to be an arithmetic type");
            //     }
            // }
            //manque check pour Parenthesis quand expr c'est un pointeur
        

        /*if(oppose.value instanceof Idf){
            LineElement lineElement = tds_current.lookUp(((Idf) oppose.value).name,tds_current);
            if(lineElement==null){
                Errors.add("Error in "+tds_current.titre+" : "+"identifier "+((Idf) oppose.value).name+" not defined");
                return null;
            }
            else{
                if(lineElement.getSymbole() instanceof IntSymbole){
                    return tds_current;
                }
                else{
                    Errors.add("Error in "+tds_current.titre+" : "+((Idf) oppose.value).name+" not an integer");
                }
            }
        }

        if( oppose.value instanceof Function)*/
    }


    // public boolean checkType(Ast ast, String type) {
    //     // String left = ast.left.accept(this);
    //     // String right = ast.right.accept(this);

        
    //     return true;
    // }


    @Override
    public String visit(Function function) {
        // control sémantique
        String FunctIdf= ((Idf) function.idf).name;

        LineElement lineElement = tds_current.lookUpFunctDef(FunctIdf);

        // on vérifie que la funct left (idf) soit bien définie
        if (lineElement == null) {
            Errors.add("Error in "+tds_current.titre+": "+FunctIdf+" not defined");
            return null;
        }


        int nb = function.expression.size();
        FctSymbole fctSymbole = (FctSymbole) lineElement.getSymbole();

        // on vérifie que le nombre de params de la fonction correspond bien au nombre attendu
        if (nb != fctSymbole.getNbParam()) {
            Errors.add("Error in "+tds_current.titre+" : params number doesnt match expected number in "+lineElement.getIdf());
        } else {
            ArrayList<Symbole> paramsDecl = fctSymbole.getFctParams();
            ArrayList<Ast> paramsExec = function.expression;

            for (int i=0 ; i<fctSymbole.getNbParam() ; i++) {
                String typeDecl = paramsDecl.get(i).getType();
                if (!typeDecl.equals(paramsExec.get(i).accept(this))) {
                    Errors.add("Error in "+tds_current.titre+ " type of param number "+i+" doesn't match function \'"+fctSymbole.getTypeRetour()+" "+lineElement.getIdf()+"\' definition" );
                }
            }
        }
        return ((FctSymbole) lineElement.getSymbole()).getTypeRetour();
    }

    @Override
    public String visit(Sizeof sizeof) {
        if (tds_current.lookUpStructDef(sizeof.idf.name) == null) // la struct doit être définie
            Errors.add("Error in "+tds_current.titre+" sizeof invalid identifier: "+sizeof.idf.name);
        return "int";
    }

    @Override
    public String visit(Idf idf) {
        if (tds_current.lookUp(idf.name) != null) {
            System.out.println(tds_current.lookUp(idf.name).getSymbole().getType());
            return tds_current.lookUp(idf.name).getSymbole().getType();
        }
        return null;
    }

    @Override
    public String visit(IfThen ifThen) {
        return ifThen.thenBlock.accept(this);
    }

    @Override
    public String visit(IfThenElse ifThenElse) {
        String thenReturn = ifThenElse.thenBlock.accept(this);
        String elseReturn = ifThenElse.elseBlock.accept(this);
        if (thenReturn == null && elseReturn == null)   // on vérifie s'il y a des retours
            return null;
        if (thenReturn.equals(elseReturn))              // retours de même types
            return thenReturn;
        else                                            // des retours différents
            return "";
    }

    @Override
    public String visit(WhileInst whileInst) {
        return whileInst.instruction.accept(this);
    }

    @Override
    public String visit(Return return1) {
        return return1.value.accept(this);
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
