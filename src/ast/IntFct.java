package ast;

public class IntFct implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast idf1;
    public Ast params;
    public Ast bloc;

    public IntFct(Ast idf1,Ast params,Ast bloc){
        this.idf1 = idf1;
        this.params = params;
        this.bloc = bloc;
    }

}