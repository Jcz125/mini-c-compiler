package ast;

import java.util.ArrayList;

public class Bloc implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int line;
    public ArrayList<Ast> list;

    public Bloc(ArrayList<Ast> list, int line) {
        this.list = list;
        this.line = line;
    }
}