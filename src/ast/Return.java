package ast;

public class Return implements Ast {
  
  public <T> T accept(AstVisitor<T> visitor) {
    return visitor.visit(this);
  }

  public Ast value;

  public Return(Ast val) {
    this.value = val;
  }
}