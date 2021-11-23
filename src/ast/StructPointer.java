package ast;

public class StructPointer implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast idf1;
    public Ast idf2;

    public StructPointer(Ast idf1, Ast idf2) {
        this.idf1 = idf1;
        this.idf2 = idf2;
    }

}