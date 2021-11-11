package ast;

public class StructFct implements Ast{

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast idf1;
    public Ast idf2;
    public Ast params;
    public Ast bloc;

    public StructFct(Ast idf1, Ast idf2,Ast params,Ast bloc){
        this.idf1 = idf1;
        this.idf2 = idf2;
        this.params = params;
        this.bloc = bloc;
    }

}