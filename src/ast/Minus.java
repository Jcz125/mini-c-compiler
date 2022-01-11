package ast;

public class Minus implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int line;
    public Ast left;
    public Ast right;

    public Minus(Ast noeudTemporaire, Ast right, int line) {
        this.left = noeudTemporaire;
        this.right = right;
        this.line = line;
    }

}