package ast;

public class IntParam implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String type;
    public Idf idf;

    public IntParam(String str, Idf idf) {
        this.type = str;
        this.idf = idf;
    }
}
