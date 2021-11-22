package graphViz;

import java.io.FileOutputStream;
import java.io.IOException;


import ast.Ast;
import ast.AstVisitor;
import ast.Bloc;
import ast.DeclInt;
import ast.DeclList;
import ast.DeclType;
import ast.DeclStruct;
import ast.Divide;
import ast.EqualTo;
import ast.EtLogique;
import ast.Fleche;
import ast.FlecheAffect;
import ast.GreaterOrEqual;
import ast.GreaterThan;
import ast.Idf;
import ast.IdfAffect;
import ast.IfThen;
import ast.IfThenElse;
import ast.Entier;
import ast.IntFct;
import ast.IntParam;
import ast.LessOrEqual;
import ast.LessThan;
import ast.Minus;
import ast.Mult;
import ast.NotEqualTo;
import ast.OuLogique;
import ast.Parametres;
import ast.Plus;
import ast.Program;
import ast.StructFct;
import ast.StructPointer;
import ast.WhileInst;
import ast.Function;

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

        String buffer = this.nodeBuffer + this.linkBuffer;
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

        for (Ast ast:program.program){

            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier, astState);

        }

        return nodeIdentifier;
    }


    @Override
    public String visit(DeclType decl_typ) {

        String nodeIdentifier = this.nextState();

        String idfState = decl_typ.idf.accept(this);

        this.addNode(nodeIdentifier, "Decl_Type");
        this.addTransition(nodeIdentifier, idfState);

        for (Ast ast:decl_typ.list){

            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier, astState);

        }

        return nodeIdentifier;

    }


    @Override
    public String visit(DeclList decl_list) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Decl_List");

        for (Ast ast:decl_list.instrList){

            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier, astState);

        }

        return nodeIdentifier;

    }


    @Override
    public String visit(DeclStruct decl_struct) {

        String nodeIdentifier = this.nextState();

        String idfState = decl_struct.struct_name.accept(this);

        this.addNode(nodeIdentifier, "decl_struct");
        this.addTransition(nodeIdentifier, idfState);


        for (Ast ast:decl_struct.list_idf){

            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier, astState);

        }

        return nodeIdentifier;

    }


    @Override
    public String visit(DeclInt decl_int) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Decl_Int");

        for (Ast ast:decl_int.list){

            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier, astState);

        }

        return nodeIdentifier;

    }


    @Override
    public String visit(IntFct intFunc) {

        String nodeIdentifier = this.nextState();

        String idfState = intFunc.idf.accept(this);
        String paramsState = intFunc.params.accept(this);
        String blocState = intFunc.bloc.accept(this);

        this.addNode(nodeIdentifier, "Decl_IntFct");
        this.addTransition(nodeIdentifier, idfState);
        this.addTransition(nodeIdentifier, paramsState);
        this.addTransition(nodeIdentifier, blocState);

        return nodeIdentifier;

    }


    @Override
    public String visit(StructFct StructFunc) {

        String nodeIdentifier = this.nextState();

        String idf1State = intFunc.idf_struct.accept(this);
        String idf2State = intFunc.idf.accept(this);
        String paramsState = intFunc.params.accept(this);
        String blocState = intFunc.bloc.accept(this);

        this.addNode(nodeIdentifier, "Decl_StructFct");
        this.addTransition(nodeIdentifier, idf1State);
        this.addTransition(nodeIdentifier, idf2State);
        this.addTransition(nodeIdentifier, paramsState);
        this.addTransition(nodeIdentifier, blocState);

        return nodeIdentifier;

    }


//    @Override
//    public String visit(Bloc bloc) {
//
//        String nodeIdentifier = this.nextState();
//
//        this.addNode(nodeIdentifier, "Bloc");
//
//        for (Ast ast:bloc.list){
//
//            String astState = ast.accept(this);
//            this.addTransition(nodeIdentifier, astState);
//
//        }
//
//        return nodeIdentifier;
//
//    }


    @Override
    public String visit(Devide div) {

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

        for (Ast ast:params.list){

            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier, astState);

        }

        return nodeIdentifier;

    }


    @Override
    public String visit(IntParam IntParam) {

        String nodeIdentifier = this.nextState();

        String idfState = IntParam.idf.accept(this);

        this.addNode(nodeIdentifier, " IntParam ");
        this.addTransition(nodeIdentifier, idfState);

        return nodeIdentifier;

    }


    @Override
    public String visit(StructPointer pointer) {

        String nodeIdentifier = this.nextState();

        String idf1State = paramINT.idf1.accept(this);
        String idf2State = paramINT.idf2.accept(this);

        this.addNode(nodeIdentifier, " Struct_Pointer ");
        this.addTransition(nodeIdentifier, idf1State);
        this.addTransition(nodeIdentifier, idf2State);

        return nodeIdentifier;

    }


    @Override
    public String visit(WhileInst whileI) {

        String nodeIdentifier = this.nextState();

        String CondState = whileI.condition.accept(this);
        String InstState = whileI.instruction.accept(this);

        this.addNode(nodeIdentifier, " While ");
        this.addTransition(nodeIdentifier, CondState);
        this.addTransition(nodeIdentifier, InstState);

        return nodeIdentifier;

    }


    @Override
    public String visit(IfThen ifThen) {

        String nodeIdentifier = this.nextState();

        String conditionState = ifThen.condition.accept(this);
        String thenBlockState = ifThen.thenBlock.accept(this);

        this.addNode(nodeIdentifier, "IfThen");

        this.addTransition(nodeIdentifier, conditionState);
        this.addTransition(nodeIdentifier, thenBlockState);

        return nodeIdentifier;

    }


    @Override
    public String visit(IfThenElse ifThenElse) {

        String nodeIdentifier = this.nextState();

        String conditionState = ifThenElse.condition.accept(this);
        String thenBlockState = ifThenElse.thenBlock.accept(this);
        String elseBlockState = ifThenElse.elseBlock.accept(this);

        this.addNode(nodeIdentifier, "IfThenElse");

        this.addTransition(nodeIdentifier, conditionState);
        this.addTransition(nodeIdentifier, thenBlockState);
        this.addTransition(nodeIdentifier, elseBlockState);

        return nodeIdentifier;

    }


    @Override
    public String visit(IdfAffect IdfAffect) {

        String nodeIdentifier = this.nextState();

        String idfState = IdfAffect.idf.accept(this);
        String expressionState = IdfAffect.expression.accept(this);

        this.addNode(nodeIdentifier, " = ");

        this.addTransition(nodeIdentifier, idfState);
        this.addTransition(nodeIdentifier, expressionState);

        return nodeIdentifier;

    }


    @Override
    public String visit(FlecheAffect FlecheAffect) {

        String nodeIdentifier = this.nextState();

        String flecheState = FlecheAffect.fleche.accept(this);
        String expressionState = FlecheAffect.expression.accept(this);

        this.addNode(nodeIdentifier, " = ");

        this.addTransition(nodeIdentifier, flecheState);
        this.addTransition(nodeIdentifier, expressionState);

        return nodeIdentifier;

    }


    @Override
    public String visit(Fleche Fleche) {

        String nodeIdentifier = this.nextState();

        String idf1State = Fleche.idf1.accept(this);
        String idf2State = Fleche.idf2.accept(this);

        this.addNode(nodeIdentifier, " --> ");

        this.addTransition(nodeIdentifier, idf1State);
        this.addTransition(nodeIdentifier, idf2State);

        return nodeIdentifier;

    }


    /* ------------------------------------------------------------------------------------------------------------- */

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


    //Ici on doit écrire les méthodes pour visit notre grammaire
    /*@Override
    public String visit(Affect affect) {

        String nodeIdentifier = this.nextState();

        String idfState = affect.idf.accept(this);
        String expressionState = affect.expression.accept(this);

        this.addNode(nodeIdentifier, "Affect");
        this.addTransition(nodeIdentifier, idfState);
        this.addTransition(nodeIdentifier, expressionState);

        return nodeIdentifier;

    }

    @Override
    public String visit(Divide divide) {

        String nodeIdentifier = this.nextState();

        String leftState = divide.left.accept(this);
        String rightState = divide.right.accept(this);

        this.addNode(nodeIdentifier, "/");
        
        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;
    }

    @Override
    public String visit(Idf idf) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, idf.name);

        return nodeIdentifier;

    }

    @Override
    public String visit(IfThen ifThen) {

        String nodeIdentifier = this.nextState();

        String conditionState = ifThen.condition.accept(this);
        String thenBlockState = ifThen.thenBlock.accept(this);

        this.addNode(nodeIdentifier, "IfThen");

        this.addTransition(nodeIdentifier, conditionState);
        this.addTransition(nodeIdentifier, thenBlockState);

        return nodeIdentifier;
        
    }

    @Override
    public String visit(IfThenElse ifThenElse) {
        
        String nodeIdentifier = this.nextState();

        String conditionState = ifThenElse.condition.accept(this);
        String thenBlockState = ifThenElse.thenBlock.accept(this);
        String elseBlockState = ifThenElse.elseBlock.accept(this);
        
        this.addNode(nodeIdentifier, "IfThenElse");

        this.addTransition(nodeIdentifier, conditionState);
        this.addTransition(nodeIdentifier, thenBlockState);
        this.addTransition(nodeIdentifier, elseBlockState);

        return nodeIdentifier;

    }

    @Override
    public String visit(InstrList instrList) {
        
        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Program");

        for (Ast ast:instrList.instrList){

            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier, astState);

        }

        return nodeIdentifier;

    }

    @Override
    public String visit(IntNode intNode) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, String.valueOf(intNode.value));

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
    public String visit(Print print) {

        String nodeIdentifier = this.nextState();

        String valueState = print.value.accept(this);

        this.addNode(nodeIdentifier, "print");
        this.addTransition(nodeIdentifier, valueState);

        return nodeIdentifier;


    }

    @Override
    public String visit(Program program) {

        String nodeIdentifier = this.nextState();

        String instructionsState =program.instructions.accept(this);

        this.addNode(nodeIdentifier, "Program");
        this.addTransition(nodeIdentifier, instructionsState);

        return nodeIdentifier;

    }*/
    
}
