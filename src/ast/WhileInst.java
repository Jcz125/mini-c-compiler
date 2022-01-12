package ast;

public class WhileInst implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int line;
    public Ast condition;
    public Ast instruction;

    public WhileInst(Ast condition, Ast instruction, int line) {
        this.condition = condition;
        this.instruction = instruction;
        this.line = line;
    }
}
