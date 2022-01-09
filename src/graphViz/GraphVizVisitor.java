package graphViz;

import ast.*;

import java.io.FileOutputStream;
import java.io.IOException;


public class GraphVizVisitor implements AstVisitor<String> {

    private int state;
    private String nodeBuffer;
    private String linkBuffer;

    public GraphVizVisitor(){
        this.state = 0;
        this.nodeBuffer = "digraph \"ast\"{\n\n\tnodesep=1;\n\tranksep=1;\n\n";
        this.linkBuffer = "\n";
    }

    public void dumpGraph(String filepath) throws IOException{
            
        FileOutputStream output = new FileOutputStream(filepath);

        String buffer = this.nodeBuffer + this.linkBuffer+"}";
        byte[] strToBytes = buffer.getBytes();

        output.write(strToBytes);

        output.close();

    }


    private String nextState(){
        int returnedState = this.state;
        this.state++;
        return "N"+ returnedState;
    }

    private void addTransition(String from,String dest){
        this.linkBuffer += String.format("\t%s -> %s; \n", from,dest);

    }

    private void addNode(String node,String label){
        this.nodeBuffer += String.format("\t%s [label=\"%s\", shape=\"box\"];\n", node,label);

    }


    @Override
    public String visit(Program program) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Program");

        for (Ast ast:program.program) {

            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier, astState);

        }

        return nodeIdentifier;
    }


    @Override
    public String visit(DeclType decl_typ) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Decl_Type");

        String nodeType = this.nextState();
        this.addNode(nodeType, decl_typ.type);

        this.addTransition(nodeIdentifier, nodeType);

        String nodeChamps = this.nextState();
        this.addNode(nodeChamps, "Champs");

        this.addTransition(nodeIdentifier, nodeChamps);

        for (Ast ast:decl_typ.list) {

            String astState = ast.accept(this);
            this.addTransition(nodeChamps, astState);

        }

        return nodeIdentifier;

    }


    @Override
    public String visit(VarStruct decl_struct) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Var");

        String nodeType = this.nextState();
        this.addNode(nodeType, decl_struct.type);
        
        this.addTransition(nodeIdentifier, nodeType);

        for (Ast ast:decl_struct.list_idf) {

            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier, astState);

        }

        return nodeIdentifier;

    }


    @Override
    public String visit(VarInt decl_int) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Var");

        String nodeType = this.nextState();
        this.addNode(nodeType, "int");

        this.addTransition(nodeIdentifier, nodeType);

        for (Ast ast:decl_int.list) {

            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier, astState);

        }

        return nodeIdentifier;

    }


    @Override
    public String visit(IntFct intFunc) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Decl_Fct");

        String nodeType = this.nextState();
        this.addNode(nodeType, "int");
        
        String idfState = intFunc.idf.accept(this);
        String paramsState = intFunc.params.accept(this);
        String blocState = intFunc.bloc.accept(this);

        this.addTransition(nodeIdentifier, nodeType);
        this.addTransition(nodeIdentifier, idfState);
        this.addTransition(nodeIdentifier, paramsState);
        this.addTransition(nodeIdentifier, blocState);

        return nodeIdentifier;

    }


    @Override
    public String visit(StructFct structFunc) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Decl_StructFct");

        String nodeType = this.nextState();
        this.addNode(nodeType, structFunc.type);

        String idfState = structFunc.idf_fct.accept(this);
        String paramsState = structFunc.params.accept(this);
        String blocState = structFunc.bloc.accept(this);

        this.addTransition(nodeIdentifier, nodeType);
        this.addTransition(nodeIdentifier, idfState);
        this.addTransition(nodeIdentifier, paramsState);
        this.addTransition(nodeIdentifier, blocState);

        return nodeIdentifier;

    }


    @Override
    public String visit(Divide div) {

        String nodeIdentifier = this.nextState();

        String leftState = div.left.accept(this);
        String rightState = div.right.accept(this);

        this.addNode(nodeIdentifier, " / ");
        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;

    }


    @Override
    public String visit(Parametres params) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Parameters");

        if (params.list.size() != 0) {
            for (Ast ast:params.list) {
                String astState = ast.accept(this);
                this.addTransition(nodeIdentifier, astState);
            }
        }
        return nodeIdentifier;

    }


    @Override
    public String visit(IntParam intParam) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Param");

        String nodeType = this.nextState();
        this.addNode(nodeType, "int");

        String idfState = intParam.idf.accept(this);

        this.addTransition(nodeIdentifier, nodeType);
        this.addTransition(nodeIdentifier, idfState);

        return nodeIdentifier;
    }


    @Override
    public String visit(StructPointer pointer) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Param");

        String nodeType = this.nextState();
        this.addNode(nodeType, pointer.type);

        String idfState = pointer.idf.accept(this);

        this.addTransition(nodeIdentifier, nodeType);
        this.addTransition(nodeIdentifier, idfState);

        return nodeIdentifier;
    }


    @Override
    public String visit(WhileInst whileI) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, " While ");

        String CondState = whileI.condition.accept(this);
        this.addTransition(nodeIdentifier, CondState);

        if (whileI.instruction != null) {
            String InstState = whileI.instruction.accept(this);
            this.addTransition(nodeIdentifier, InstState);
        }
        return nodeIdentifier;

    }


    @Override
    public String visit(IfThen ifThen) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "IfThen");

        String conditionState = ifThen.condition.accept(this);
        this.addTransition(nodeIdentifier, conditionState);

        if (ifThen.thenBlock != null) {
            String thenBlockState = ifThen.thenBlock.accept(this);
            this.addTransition(nodeIdentifier, thenBlockState);
        }
        return nodeIdentifier;

    }


    @Override
    public String visit(IfThenElse ifThenElse) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "IfThenElse");

        String conditionState = ifThenElse.condition.accept(this);
        this.addTransition(nodeIdentifier, conditionState);

        if (ifThenElse.thenBlock != null) {
            String thenBlockState = ifThenElse.thenBlock.accept(this);
            this.addTransition(nodeIdentifier, thenBlockState);
        }
        if (ifThenElse.elseBlock != null) {
            String elseBlockState = ifThenElse.elseBlock.accept(this);
            this.addTransition(nodeIdentifier, elseBlockState);
        }
        return nodeIdentifier;

    }


    @Override
    public String visit(Fleche fleche) {

        String nodeIdentifier = this.nextState();
        String leftState = fleche.left.accept(this);
        String rightState = fleche.right.accept(this);

        this.addNode(nodeIdentifier, " --> ");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        // for (Ast ast:Fleche.idfList) {

        //     String astState = ast.accept(this);
        //     this.addTransition(nodeIdentifier, astState);

        // }
        return nodeIdentifier;

    }


    @Override
    public String visit(Affect affect) {

        String nodeIdentifier = this.nextState();
        String leftState = affect.left.accept(this);
        String rightState = affect.right.accept(this);

        this.addNode(nodeIdentifier, " = ");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;

    }

    @Override
    public String visit(Return return1) {
        String nodeIdentifier = this.nextState();
        String value = return1.value.accept(this);
        this.addNode(nodeIdentifier, "return");
        this.addTransition(nodeIdentifier, value);
        return nodeIdentifier;
    }

    @Override
    public String visit(Sizeof sizeof) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "sizeof");

        String nodeType = this.nextState();
        this.addNode(nodeType, sizeof.type);
        // String idf = sizeof.idf.accept(this);
        
        this.addTransition(nodeIdentifier, nodeType);

        return nodeIdentifier;
    }


    @Override
    public String visit(Entier entier) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, String.valueOf(entier.value));
        return nodeIdentifier;
    }

    @Override
    public String visit(Idf idf) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, idf.name);
        return nodeIdentifier;
    }

    @Override
    public String visit(Bloc bloc) {

        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Bloc");
        if (bloc.list.size() != 0) {
            for (Ast ast : bloc.list) {
                if (ast != null) {
                    String astState = ast.accept(this);
                    this.addTransition(nodeIdentifier, astState);
                }
                // else {
                //     String nodeNone = this.nextState();
                //     this.addNode(nodeIdentifier, "None");
                //     this.addTransition(nodeIdentifier, nodeNone);
                // }
            }
        }
        return nodeIdentifier;
    }

    @Override
    public String visit(Function function) {

        String nodeIdentifier = this.nextState();
        String idfState = function.idf.accept(this);

        this.addNode(nodeIdentifier, "Function");

        String nodeParams = this.nextState();
        this.addNode(nodeParams, "Params");

        this.addTransition(nodeIdentifier, idfState);
        this.addTransition(nodeIdentifier, nodeParams);

        for (Ast ast: function.expression) {
            String astState = ast.accept(this);
            this.addTransition(nodeParams, astState);
        }
        return nodeIdentifier;
    }


    @Override
    public String visit(Minus minus) {

        String nodeIdentifier = this.nextState();

        String leftState = minus.left.accept(this);
        String rightState = minus.right.accept(this);

        this.addNode(nodeIdentifier, "-");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;
    }

    @Override
    public String visit(Plus plus) {

        String nodeIdentifier = this.nextState();

        String leftState = plus.left.accept(this);
        String rightState = plus.right.accept(this);

        this.addNode(nodeIdentifier, "+");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;

    }

    @Override
    public String visit(Mult mult) {

        String nodeIdentifier = this.nextState();

        String leftState = mult.left.accept(this);
        String rightState = mult.right.accept(this);

        this.addNode(nodeIdentifier, "*");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;

    }



    @Override
    public String visit(OuLogique ouLogique) {

        String nodeIdentifier = this.nextState();

        String leftState = ouLogique.left.accept(this);
        String rightState = ouLogique.right.accept(this);

        this.addNode(nodeIdentifier, "||");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;

    }

    @Override
    public String visit(EtLogique etLogique) {

        String nodeIdentifier = this.nextState();

        String leftState = etLogique.left.accept(this);
        String rightState = etLogique.right.accept(this);

        this.addNode(nodeIdentifier, "&&");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;

    }

    @Override
    public String visit(LessOrEqual lessOrEqual) {

        String nodeIdentifier = this.nextState();

        String leftState = lessOrEqual.left.accept(this);
        String rightState = lessOrEqual.right.accept(this);

        this.addNode(nodeIdentifier, "<=");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;

    }

    @Override
    public String visit(LessThan lessThan) {

        String nodeIdentifier = this.nextState();

        String leftState = lessThan.left.accept(this);
        String rightState = lessThan.right.accept(this);

        this.addNode(nodeIdentifier, "<");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;

    }

    @Override
    public String visit(GreaterThan greaterThan) {

        String nodeIdentifier = this.nextState();

        String leftState = greaterThan.left.accept(this);
        String rightState = greaterThan.right.accept(this);

        this.addNode(nodeIdentifier, ">");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;

    }

    @Override
    public String visit(GreaterOrEqual greaterOrEqual) {

        String nodeIdentifier = this.nextState();

        String leftState = greaterOrEqual.left.accept(this);
        String rightState = greaterOrEqual.right.accept(this);

        this.addNode(nodeIdentifier, ">=");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;

    }

    @Override
    public String visit(EqualTo equalTo) {

        String nodeIdentifier = this.nextState();

        String leftState = equalTo.left.accept(this);
        String rightState = equalTo.right.accept(this);

        this.addNode(nodeIdentifier, "==");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;

    }

    @Override
    public String visit(NotEqualTo notEqualTo) {

        String nodeIdentifier = this.nextState();

        String leftState = notEqualTo.left.accept(this);
        String rightState = notEqualTo.right.accept(this);

        this.addNode(nodeIdentifier, "!=");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;

    }

    @Override
    public String visit(Oppose oppose) {
        
        String nodeIdentifier = this.nextState();
        String op = oppose.op;

        this.addNode(nodeIdentifier, op);
        this.addTransition(nodeIdentifier, oppose.value.accept(this));

        return nodeIdentifier;

    }
}
