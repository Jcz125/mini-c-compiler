package ast;

public interface AstVisitor<T> {

    public T visit(Affect affect);
    public T visit(Fleche affect);
    public T visit(Idf affect);
    public T visit(IfThen affect);
    public T visit(IfThenElse affect);
    public T visit(Integer affect);
    public T visit(WhileInst affect);

}
