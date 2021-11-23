package ast;

public class FlecheAffect implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast fleche;
    public Ast expression;

    public FlecheAffect(Ast fleche, Ast expr) {
        this.fleche = fleche;
        this.expression = expr;
    }

}