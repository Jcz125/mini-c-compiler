package ast;

public class Affect implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int line;
    public Ast left;
    public Ast right;

    public Affect(Ast left, Ast noeudTemporaire, int line) {
        this.left = left;
        this.right = noeudTemporaire;
        this.line = line;
    }
}
