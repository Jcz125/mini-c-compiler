package ast;

public class IntFct implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast idf;
    public Ast params;
    public Ast bloc;

    public IntFct(Ast idf, Ast params, Ast bloc){
        this.idf = idf;
        this.params = params;
        this.bloc = bloc;
    }

}