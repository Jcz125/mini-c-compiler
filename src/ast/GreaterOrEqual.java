package ast;

public class GreaterOrEqual implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int line;
    public Ast left;
    public Ast right;

    public GreaterOrEqual(Ast noeudTemporaire, Ast right, int line) {
        this.left = noeudTemporaire;
        this.right = right;
        this.line = line;
    }
}