package ast;

public class IntFct implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String type = "int";
    public Ast idf;
    public Ast params;
    public Ast bloc;

    public IntFct(Ast idf, Ast params, Ast bloc) {
        this.idf = idf;
        this.params = params;
        this.bloc = bloc;
    }

}