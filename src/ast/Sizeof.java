package ast;

public class Sizeof implements Ast {
  
  public <T> T accept(AstVisitor<T> visitor) {
    return visitor.visit(this);
  }

  public Ast idf;

  public Sizeof(Ast idf) {
    this.idf = idf;
  }
}