package ast;

import java.util.ArrayList;

public class VarStruct implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int line;
    public String type;
    public Idf struct_name;
    public ArrayList<Idf> list_idf;

    public VarStruct (Idf struct, ArrayList<Idf> list_idf, int line) {
        this.struct_name = struct;
        this.list_idf = list_idf;
        this.type = "struct " + struct.name;
        this.line = line;
    }
}
