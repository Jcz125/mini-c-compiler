package ast;

public class Entier implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int line;
    public int value;

    public Entier(int value, int line) {
        this.value = value;
        this.line = line;
    }
}
