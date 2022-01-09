package ast;

import java.util.ArrayList;

public class Function implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast idf;
    public ArrayList<Ast> expression;

    public Function(Ast idf, ArrayList<Ast> expr) {
        this.idf = idf;
        this.expression = expr;
    }

}