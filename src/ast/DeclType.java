package ast;

import java.util.ArrayList;

public class DeclType implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast idf;
    public ArrayList<Ast> list;

    public DeclType (Ast idf, ArrayList<Ast> list) {
        this.idf = idf;
        this.list = list;
    }
}
