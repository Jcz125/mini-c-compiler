package ast;

import java.util.ArrayList;

public class DeclList implements Ast {
    
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    public ArrayList<Ast> instrList;

    public DeclList(ArrayList<Ast> list) {
        this.instrList = list;
    }
}
