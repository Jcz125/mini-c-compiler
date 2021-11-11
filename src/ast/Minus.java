package ast;

public class Minus implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public Minus(Ast noeudTemporaire,Ast right){
        this.left=noeudTemporaire;
        this.right=right;
    }

}