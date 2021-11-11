package ast;

public class Integer implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public int value;

    public Integer(int value){
        this.value=value;
    }
}
