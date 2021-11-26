package ast;

public class Affect implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    // public ArrayList<Ast> vars;
    // public Ast expression;

    // public Affect(ArrayList<Ast> list, Ast expr) {
    //     this.vars = list;
    //     this.expression = expr;
    // }

    public Ast left;
    public Ast right;

    public Affect(Ast left, Ast noeudTemporaire) {
        this.left = left;
        this.right = noeudTemporaire;
    }
}
