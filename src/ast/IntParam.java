package ast;

public class IntParam implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }


    public Ast idf;


    public IntParam(Ast idf){
        this.idf = idf;
    }

}