package ast;

public class Sizeof implements Ast {
  
  public <T> T accept(AstVisitor<T> visitor) {
    return visitor.visit(this);
  }

  public Idf idf;

  public Sizeof(Idf idf) {
    this.idf = idf;
  }
}