package TDS;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class grapheTDS {

    private int state;
    private String nodeBuffer;
    private String linkBuffer;
    private ArrayList<String> titres;

    public grapheTDS(){
        this.state = 0;
        this.nodeBuffer = "digraph \"tds\"{\n\n\tnodesep=1;\n\tranksep=1;\n\n";
        this.linkBuffer = "\n";
        this.titres=new ArrayList<>();
        titres.add(" #0-0 root ");
        titres.add("#1-0.1 fct1" );
    }

    public void dumpGraph(String filepath) throws IOException {

        FileOutputStream output = new FileOutputStream(filepath);

        String buffer = this.nodeBuffer + this.linkBuffer+"}";
        byte[] strToBytes = buffer.getBytes();

        output.write(strToBytes);

        output.close();

    }


    public String nextState(){
        int returnedState = this.state;
        this.state++;
        return "N"+ returnedState;
    }

    public void addTransition(String from,String dest){
        this.linkBuffer += String.format("\t%s -> %s; \n", from,dest);

    }

    public void addNode(String node,String label){
        this.nodeBuffer += String.format("\t%s [label=\"%s\", shape=\"box\"];\n", node,label);

    }



    /*@Override
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
        this.addNode(nodeType, decl_struct.type+" *");

        this.addTransition(nodeIdentifier, nodeType);

        for (Ast ast:decl_struct.list_idf) {

            String astState = ast.accept(this);
            this.addTransition(nodeIdentifier, astState);

        }

        return nodeIdentifier;

    }*/

}
