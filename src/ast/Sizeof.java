package ast;

public class Sizeof implements Ast {
  
  public <T> T accept(AstVisitor<T> visitor) {
    return visitor.visit(this);
  }

  public int line;
  public String type;
  public Idf idf;

  public Sizeof(Idf idf, int line) {
    this.idf = idf;
    this.type = "struct " + idf.name;
    this.line = line;
  }
}