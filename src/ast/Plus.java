package ast;

public class Plus implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;


    public Plus(Ast noeudTemporaire,Ast right){
        this.left=noeudTemporaire;
        this.right=right;
    }
}