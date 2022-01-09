package ast;

public class Divide implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public Divide(Ast noeudTemporaire, Ast right) {
        this.left = noeudTemporaire;
        this.right = right;
    }
}
