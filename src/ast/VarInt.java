package ast;

import java.util.ArrayList;

public class VarInt implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int line;
    public String type = "int";
    public ArrayList<Idf> list;

    public VarInt (ArrayList<Idf> list, int line) {
        this.list = list;
        this.line = line;
    }
}
