package ast;

public class StructPointer extends Param {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int line;
    public String type;
    public Idf idftype;
    public Idf idf;

    public StructPointer(Idf idf1, Idf idf2, int line) {
        this.type = "struct " + idf1.name;
        this.idftype = idf1;
        this.idf = idf2;
        this.line = line;
    }

}