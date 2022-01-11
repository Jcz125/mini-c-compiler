package ast;

public class IntFct implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int line;
    public String type = "int";
    public Idf idf;
    public Parametres params;
    public Ast bloc;

    public IntFct(Idf idf, Parametres params, Ast bloc, int line) {
        this.idf = idf;
        this.params = params;
        this.bloc = bloc;
        this.line = line;
    }

}