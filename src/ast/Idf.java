package ast;

public class Idf implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int line;
    public String name;

    public Idf(String name, int line) {
        this.name = name;
        this.line = line;
    }


}