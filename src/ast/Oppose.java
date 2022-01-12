package ast;

public class Oppose implements Ast {
  
  public <T> T accept(AstVisitor<T> visitor) {
    return visitor.visit(this);
  }

  public int line;
  public String op;
  public Ast value;

  public Oppose(String op, Ast val, int line) {
    this.op = op;
    this.value = val;
    this.line = line;
  }
}
