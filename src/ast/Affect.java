package ast;

import java.util.ArrayList;

public class Affect implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Ast> vars;
    public Ast expression;

    public Affect(ArrayList<Ast> list, Ast expr) {
        this.vars = list;
        this.expression = expr;
    }
}
