package ast;

public class IntParam extends Param {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int line;
    public String type;
    public Idf idf;

    public IntParam(String str, Idf idf, int line) {
        this.type = str;
        this.idf = idf;
        this.line = line;
    }
}
