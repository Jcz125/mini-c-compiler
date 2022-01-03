package ast;

public class WhileInst implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast condition;
    public Ast instruction;

    public WhileInst(Ast condition, Ast instruction) {
        this.condition = condition;
        this.instruction = instruction;
    }
}