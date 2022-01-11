package ast;

public class IfThen implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int line;
    public Ast condition;
    public Ast thenBlock;

    public IfThen(Ast condition, Ast thenBlock, int line) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.line = line;
    }
}
