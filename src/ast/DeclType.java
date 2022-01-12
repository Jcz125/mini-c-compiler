package ast;

import java.util.ArrayList;

public class DeclType implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int line;
    public String type;
    public Idf idf_name;
    public ArrayList<Ast> list;

    public DeclType (Idf idf, ArrayList<Ast> list, int line) {
        this.idf_name = idf;
        this.list = list;
        this.type = "struct " + idf.name;
        this.line = line;
    }
}
