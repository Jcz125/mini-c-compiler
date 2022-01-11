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
    public ArrayList<Ast> list_var = null;
    public ArrayList<String> errors = new ArrayList<>();

    public void showErrors() {
        if (this.errors.isEmpty())
            System.out.println("No errors found.");
        else
            for (String str : this.errors)
                System.out.println(str);
        System.out.println("Total: "+this.errors.size());
    }

    @Override
    public String visit(Program program) {
        SymbolTable root = new SymbolTable("root", null);
        this.tds_root = this.tds_current = root;
        if (root.addLineFct("malloc", NatureSymboles.FUNCTION, "void *", new ArrayList<Symbole>(){{add(new IntSymbole("n"));}}, 1) == null)
            this.errors.add("Error in "+tds_current.titre+": add function: [idf] 'malloc' already used");
        if (root.addLineFct("print", NatureSymboles.FUNCTION, "void", new ArrayList<Symbole>(){{add(new IntSymbole("n"));}}, 1) == null)
            this.errors.add("Error in "+tds_current.titre+": add function: [idf] 'print' already used");
        for (Ast ast : program.program)
            ast.accept(this);
        if (main == false)
            this.errors.add("No int main() found.");
        return null;
    }

    @Override
    public String visit(DeclType decltype) {
        HashMap<Symbole, String> table = new HashMap<Symbole, String>();    // Symbole est la clé K et String la valeur V
        ArrayList<String> idfs = new ArrayList<>();
        ArrayList<String> local_errors = new ArrayList<>();
        for (Ast champ : decltype.list) {                                   // remplissage des champs selon le type
            if (champ instanceof VarInt) {
                for (Idf idf : ((VarInt) champ).list) {
                    if (!idfs.contains(idf.name)) {
                        idfs.add(idf.name);
                        IntSymbole sb = new IntSymbole(idf.name);
                        table.put(sb, "int");
                    } else
                        local_errors.add("Error at line  "+idf.line+" in "+tds_current.titre+": "+decltype.type+", field: '"+idf.name+"' already used");
                }
            } else {
                VarStruct s = (VarStruct) champ;
                for (Idf idf : s.list_idf) {
                    if (!idfs.contains(idf.name)) {
                        idfs.add(idf.name);
                        StructSymbole sb = new StructSymbole(s.type, idf.name);
                        table.put(sb, s.type);
                    } else
                        local_errors.add("Error at line  "+idf.line+" in "+tds_current.titre+": "+decltype.type+", field: '"+idf.name+"' already used");
                }
            }
        }
        if (tds_current.addLineStructDef(decltype.idf_name.name, NatureSymboles.STRUCT, decltype.type, table) == null)
            this.errors.add("Error at line  "+decltype.line+" in "+tds_current.titre+": add struct def: [idf] '"+decltype.idf_name.name+"' already used");
        this.errors.addAll(local_errors);
        return null;
    }

    @Override
    public String visit(VarInt varInt) {
        for (Idf idf : varInt.list) {
            if (tds_current.addLineInt(idf.name, NatureSymboles.VARIABLE, varInt.line) == null)
                this.errors.add("Error at line "+varInt.line+" in "+tds_current.titre+": [idf] '"+idf.name+"' already used");
        }
        return null;
    }

    @Override
    public String visit(VarStruct varStruct) {
        String type = varStruct.type;
        for (Idf idf : varStruct.list_idf) {
            if (tds_current.addLineStruct(idf.name, NatureSymboles.VARIABLE, type) == null)
                this.errors.add("Error at line "+varStruct.line+" in "+tds_current.titre+": add struct var: [idf] '"+idf.name+"' already used");
        }
        return null;
    }
/* NON UTILISEE
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
                    this.errors.add("Error at line "+param.line+" in "+tds_current.titre+": function "+name+", params"+": idf "+param.idf.name+" already used");
                }
            } else {
                StructPointer param = (StructPointer) ast;
                params.put(new StructSymbole(param.type, param.idf.name), param.type);
            }
        }
        return params;
    }
*/
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
                    this.errors.add("Error at line "+param.line+" in "+tds_current.titre+": function "+name+", params"+": [idf] '"+param.idf.name+"' already used"); // améliorer le message d'erreur
                }
            } else {
                StructPointer param = (StructPointer) ast;
                params.add(new StructSymbole(param.type, param.idf.name));
            }
        }
        return params;
    }

    public void checkMain(LineElement line) {
        if (line.getIdf().equals("main") && (line.getNature() == NatureSymboles.FUNCTION) && (((FctSymbole) line.getSymbole()).getNbParam() == 0))
            this.main = true;
    }

    @Override
    public String visit(IntFct intFct) {
        ArrayList<Symbole> params = create_array_param(intFct.params.list, intFct.type+" "+intFct.idf);
        LineElement line = tds_current.addLineFct(intFct.idf.name, NatureSymboles.FUNCTION, "int", params, params.size());
        
        // on vérifie si le idf est déjà utilisé
        if (line != null) {
            this.new_tds_name = intFct.idf.name;
            this.list_var = intFct.params.list;
            String typeRetour = intFct.bloc.accept(this);
            checkMain(line);

            // contrôle du type de retour
            if (typeRetour == null)
                this.errors.add("Warning at line "+intFct.line+" in "+tds_current.titre+": no return or invalid return for function: int "+line.getIdf());
            else if (!(typeRetour.equals("int") || typeRetour.equals("void")))
                this.errors.add("Warning at line "+intFct.line+" in "+tds_current.titre+": no identical return type or missing some return for function: int "+line.getIdf());
        } else this.errors.add("Error at line "+intFct.line+" in "+tds_current.titre+": add function: [idf] '"+intFct.idf.name+"' already used");
        return null;
    }

    @Override
    public String visit(StructFct structFct) {
        ArrayList<Symbole> params = create_array_param(structFct.params.list, structFct.type+" * "+structFct.idf_fct);
        LineElement line = tds_current.addLineFct(structFct.idf_fct.name, NatureSymboles.FUNCTION, structFct.type, params, params.size());
        
        // on vérifie si le idf est déjà utilisé
        if (line != null) {
            this.new_tds_name = structFct.idf_fct.name;
            this.list_var = structFct.params.list;
            String typeRetour = structFct.bloc.accept(this);
            checkMain(line);

            // controle du type de retour
            if (typeRetour == null)
                this.errors.add("Warning at line "+structFct.line+" in "+tds_current.titre+": no return or invalid return for function: "+structFct.type+" * "+line.getIdf());
            else if (!(typeRetour.equals(structFct.type) || typeRetour.equals("void *")))
                this.errors.add("Warning at line "+structFct.line+" in "+tds_current.titre+": no identical return type or missing some return for function: "+structFct.type+" * "+line.getIdf());
        } else this.errors.add("Error at line "+structFct.line+" in "+tds_current.titre+": add function: [idf] '"+structFct.idf_fct.name+"' already used");
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
                if (returnType == null) {
                    returnType = ast.accept(this);
                } else {
                    String newReturn = ast.accept(this);
                    if ("void".equals(newReturn) || "void *".equals(newReturn))
                        this.errors.add("Warning in "+tds_current.titre+": 'void' return type, pointer without a cast");
                    else if (returnType.equals("") || !returnType.equals(newReturn))
                        returnType = "";
                }
                continue;
            }
            if (ast != null)
                ast.accept(this);
        }
        tds_current = tds_current.exitRegion();
        return returnType;
    }

    @Override
    public String visit(Affect affect) {
        String left = affect.left.accept(this);
        String right = affect.right.accept(this);
        if (left == null) { // au moins l'un des vars n'existe pas
            if (affect.left instanceof Fleche)
                this.errors.add("Error at line "+affect.line+" in "+tds_current.titre+": var '"+(affect.left instanceof Idf ? ((Idf) affect.left).name : (((Idf) ((Fleche) affect.left).right).name))+"' doesn't exist");
            return null;
        }
        if (!(left.equals(right) || "void".equals(right) || "void *".equals(right))) {
            this.errors.add("Error at line "+affect.line+" in "+tds_current.titre+": assignment types ('"+left+"' and '"+right+"') don't match");
            return null;
        }
        if ("void".equals(right) || left.equals("int") && "void *".equals(right))
            this.errors.add("Warning at line "+affect.line+" in "+tds_current.titre+": void assignment");
        return left;
    }

    @Override
    public String visit(Fleche fleche) {
        String left = fleche.left.accept(this);
        // String right = fleche.right.accept(this); // inutile
        if (left == null) {
            // this.errors.add("Error at line "+fleche.line+" in "+tds_current.titre+": arrow problem: "+"struct not defined");
            return null;
        }
        LineElement lineElement = tds_current.lookUpStructDef(left);
        if (lineElement != null) { // on vérifie que la struct left soit bien définie
            if (fleche.right instanceof Idf) {
                StructDefSymbole structDefSymbole = (StructDefSymbole) lineElement.getSymbole(); // on récupère le struct à droite
                Symbole symbole = structDefSymbole.lookUpChamp(((Idf) fleche.right).name);
                if (symbole != null) { // on vérifie que le champ right soit bien un champ de left
                    return symbole.getType();
                } else
                    this.errors.add("Error at line "+fleche.line+" in "+tds_current.titre+": '"+((Idf) fleche.right).name+"' not a field of '"+left+"'");
            } else
                this.errors.add("Error at line "+fleche.line+" in "+tds_current.titre+": arrow problem");
        } else if (left.equals("int"))
                this.errors.add("Error at line "+fleche.line+" in "+tds_current.titre+" invalid type argument of -> (have 'int')");
            else this.errors.add("Error at line "+fleche.line+" in "+tds_current.titre+": '"+left+"' not defined");
        return null;
    }

    @Override
    public String visit(OuLogique ouLogique) {
        String left = ouLogique.left.accept(this);
        String right = ouLogique.right.accept(this);
        if (left == null || right == null)
            return null;
        if (!left.equals(right) && ((ouLogique.right instanceof Entier && ((Entier) ouLogique.right).value == 0) ? false : true))
            this.errors.add("Warning at line "+ouLogique.line+" in "+tds_current.titre+": || comparaison between different types (integer and pointer)");
        return "int";
    }

    @Override
    public String visit(EtLogique etLogique) {
        String left = etLogique.left.accept(this);
        String right = etLogique.right.accept(this);
        if (left == null || right == null)
            return null;
        if (!left.equals(right) && ((etLogique.right instanceof Entier && ((Entier) etLogique.right).value == 0) ? false : true))
            this.errors.add("Warning at line "+etLogique.line+" in "+tds_current.titre+": && comparaison between different types (integer and pointer)");
        return "int";
    }

    @Override
    public String visit(EqualTo equalTo) {
        String left = equalTo.left.accept(this);
        String right = equalTo.right.accept(this);
        if (left == null || right == null)
            return null;
        if (!left.equals(right) && ((equalTo.right instanceof Entier && ((Entier) equalTo.right).value == 0) ? false : true))
            this.errors.add("Warning at line "+equalTo.line+" in "+tds_current.titre+": == comparaison between different types (integer and pointer)");
        return "int";
    }

    @Override
    public String visit(NotEqualTo notEqualTo) {
        String left = notEqualTo.left.accept(this);
        String right = notEqualTo.right.accept(this);
        if (left == null || right == null)
            return null;
        if (!left.equals(right) && ((notEqualTo.right instanceof Entier && ((Entier) notEqualTo.right).value == 0) ? false : true))
            this.errors.add("Warning at line "+notEqualTo.line+" in "+tds_current.titre+": != comparaison between different types (integer and pointer)");
        return "int";
    }

    @Override
    public String visit(GreaterOrEqual greaterOrEqual) {
        String left = greaterOrEqual.left.accept(this);
        String right = greaterOrEqual.right.accept(this);
        if (left == null || right == null)
            return null;
        if (!left.equals(right) && ((greaterOrEqual.right instanceof Entier && ((Entier) greaterOrEqual.right).value == 0) ? false : true))
            this.errors.add("Warning at line "+greaterOrEqual.line+" in "+tds_current.titre+": >= comparaison between different types (integer and pointer)");
        return "int";
    }

    @Override
    public String visit(GreaterThan greaterThan) {
        String left = greaterThan.left.accept(this);
        String right = greaterThan.right.accept(this);
        if (left == null || right == null)
            return null;
        if (!left.equals(right) && ((greaterThan.right instanceof Entier && ((Entier) greaterThan.right).value == 0) ? false : true))
            this.errors.add("Warning at line "+greaterThan.line+" in "+tds_current.titre+": > comparaison between different types (integer and pointer)");
        return "int";
    }

    @Override
    public String visit(LessOrEqual lessOrEqual) {
        String left = lessOrEqual.left.accept(this);
        String right = lessOrEqual.right.accept(this);
        if (left == null || right == null)
            return null;
        if (!left.equals(right) && ((lessOrEqual.right instanceof Entier && ((Entier) lessOrEqual.right).value == 0) ? false : true))
            this.errors.add("Warning at line "+lessOrEqual.line+" in "+tds_current.titre+": <= comparaison between different types (integer and pointer)");
        return "int";
    }

    @Override
    public String visit(LessThan lessThan) {
        String left = lessThan.left.accept(this);
        String right = lessThan.right.accept(this);
        if (left == null || right == null)
            return null;
        if (!left.equals(right) && ((lessThan.right instanceof Entier && ((Entier) lessThan.right).value == 0) ? false : true))
            this.errors.add("Warning at line "+lessThan.line+" in "+tds_current.titre+": < comparaison between different types (integer and pointer)");
        return "int";
    }

    @Override
    public String visit(Plus plus) {
        String left = plus.left.accept(this);
        String right = plus.right.accept(this);
        if (left == null || right == null)
            return null;
        if (left.equals(right)) {
            if (!left.equals("int")) {
                this.errors.add("Error at line "+plus.line+" in "+tds_current.titre+": addition between pointers");
                return null;
            }
            return right;
        } else {
            this.errors.add("Warning at line "+plus.line+" in "+tds_current.titre+": addition between different types (integer and pointer)");
            if (!left.equals("int")) return left;
            else return right;
        }
    }

    @Override
    public String visit(Minus minus) {
        String left = minus.left.accept(this);
        String right = minus.right.accept(this);
        if (left == null || right == null)
            return null;
        if (left.equals(right)) {
            if (!left.equals("int")) {
                this.errors.add("Error at line "+minus.line+" in "+tds_current.titre+": subtraction between pointers");
                return null;
            }
            return right;
        } else {
            this.errors.add("Warning at line "+minus.line+" in "+tds_current.titre+": subtraction between different types (integer and pointer)");
            if (!left.equals("int")) return left;
            else return right;
        }
    }

    @Override
    public String visit(Mult mult) {
        String left = mult.left.accept(this);
        String right = mult.right.accept(this);
        if (left == null || right == null)
            return null;
        if (!left.equals("int") || !right.equals("int")) {
            this.errors.add("Error at line "+mult.line+" in "+tds_current.titre+": multiplication of pointer");
            return null;
        }
        return right;
    }

    @Override
    public String visit(Divide divide) {
        String left = divide.left.accept(this);
        String right = divide.right.accept(this);
        if (left == null || right == null)
            return null;
        if (!left.equals("int") || !right.equals("int")) {
            this.errors.add("Error at line "+divide.line+" in "+tds_current.titre+": division of pointer");
            return null;
        }
        if (divide.left instanceof Entier && ((Entier) divide.left).value == 0)
            this.errors.add("Error at line "+divide.line+" in "+tds_current.titre+": division by zero");
        return right;
    }

    @Override
    public String visit(Oppose oppose) {
        String type = oppose.value.accept(this);
        // erreur pour -pointer
        if (oppose.op.equals("-") && !"int".equals(type)) {
            this.errors.add("Error at line "+oppose.line+" in "+tds_current.titre+": -value needs value to be an arithmetic type");
            return null;
        }
        return type;
    }

    @Override
    public String visit(Function function) {
        // control sémantique
        String functIdf = ((Idf) function.idf).name;
        if (functIdf.equals("malloc") || functIdf.equals("print")) {
            if (function.expression.size() != 1 || !"int".equals(function.expression.get(0).accept(this))) {
                String signFct;
                if (functIdf.equals("malloc")) signFct = "void * malloc";
                else signFct = "void print";
                this.errors.add("Error at line "+function.line+" in "+tds_current.titre+": type of param number "+0+" doesn't match function '"+signFct+"' definition" );
            }
            return functIdf.equals("malloc") ? "void *" : "void";
        }
        // on vérifie que la funct left (idf) soit bien définie
        LineElement lineElement = tds_current.lookUpFunctDef(functIdf);
        if (lineElement == null) {
            this.errors.add("Error at line "+function.line+" in "+tds_current.titre+": '"+functIdf+"' not defined");
            return null;
        }
        // on vérifie que le nombre de params de la fonction correspond bien au nombre attendu
        int nb = function.expression.size();
        FctSymbole fctSymbole = (FctSymbole) lineElement.getSymbole();
        if (nb != fctSymbole.getNbParam()) {
            this.errors.add("Error at line "+function.line+" in "+tds_current.titre+": params number doesn't match expected number in function '"+fctSymbole.getType()+" "+fctSymbole.getIdf()+"' definition");
        } else {
            ArrayList<Symbole> paramsDecl = fctSymbole.getFctParams();
            ArrayList<Ast> paramsExec = function.expression;
            for (int i=0 ; i<fctSymbole.getNbParam() ; i++) {
                String typeDecl = paramsDecl.get(i).getType();
                if (!typeDecl.equals(paramsExec.get(i).accept(this)))
                    this.errors.add("Error at line "+function.line+" in "+tds_current.titre+": type of param number "+i+" doesn't match function '"+fctSymbole.getType()+" "+fctSymbole.getIdf()+"' definition");
            }
        }
        return ((FctSymbole) lineElement.getSymbole()).getTypeRetour();
    }

    @Override
    public String visit(Sizeof sizeof) {
        if (tds_current.lookUpStructDef("struct "+sizeof.idf.name) == null) // la struct doit être définie
            this.errors.add("Error at line "+sizeof.line+" in "+tds_current.titre+": sizeof invalid identifier: "+sizeof.idf.name);
        return "int";
    }

    @Override
    public String visit(Idf idf) {
        if (tds_current.lookUp(idf.name) != null)
            return tds_current.lookUp(idf.name).getSymbole().getType();
        this.errors.add("Error at line "+idf.line+" in "+tds_current.titre+": [idf] "+idf.name+" not found");
        return null;
    }

    @Override
    public String visit(IfThen ifThen) {
        ifThen.condition.accept(this);
        return ifThen.thenBlock==null ? null : ifThen.thenBlock.accept(this);
    }

    @Override
    public String visit(IfThenElse ifThenElse) {
        ifThenElse.condition.accept(this);
        String thenReturn = ifThenElse.thenBlock==null ? null : (ifThenElse.thenBlock instanceof Return ? ifThenElse.thenBlock.accept(this) : null);
        String elseReturn = ifThenElse.elseBlock==null ? null : (ifThenElse.elseBlock instanceof Return ? ifThenElse.elseBlock.accept(this) : null);
        if (thenReturn == null || elseReturn == null)   // on vérifie s'il y a des retours
            return null;
        if (thenReturn.equals(elseReturn))              // retours de même types
            return thenReturn;
        else                                            // des retours différents
            return "";
    }

    @Override
    public String visit(WhileInst whileInst) {
        whileInst.condition.accept(this);
        return whileInst.instruction==null ? null : whileInst.instruction.accept(this);
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
