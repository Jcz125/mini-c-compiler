package ast;

public abstract class Param implements Ast {
  public abstract <T> T accept(AstVisitor<T> visitor);

  public String type;
  public Idf idf;


}
