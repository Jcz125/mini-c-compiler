package ast;

public class Return implements Ast {
  
  public <T> T accept(AstVisitor<T> visitor) {
    return visitor.visit(this);
  }

  public int line;
  public Ast value;

  public Return(Ast val, int line) {
    this.value = val;
    this.line = line;
  }
}