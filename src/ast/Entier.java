package ast;

public class Entier implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public int value;

    public Entier(int value){
        this.value=value;
    }
}
