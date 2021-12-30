package ast;

public interface AstVisitor<T> {

    public T visit(Bloc bloc);
    public T visit(VarInt varInt);
    public T visit(VarStruct varStruct);
    public T visit(DeclType declType);
    public T visit(Divide divide);
    public T visit(EqualTo equalTo);
    public T visit(EtLogique etLogique);
    public T visit(Fleche fleche);
    public T visit(Function function);
    public T visit(GreaterOrEqual greaterOrEqual);
    public T visit(GreaterThan greaterThan);
    public T visit(Idf idf);
    public T visit(IfThen ifThen);
    public T visit(IfThenElse ifThenElse);
    public T visit(Entier integer);
    public T visit(IntFct intFct);
    public T visit(IntParam intParam);
    public T visit(LessOrEqual lessOrEqual);
    public T visit(LessThan lessThan);
    public T visit(Minus minus);
    public T visit(Mult mult);
    public T visit(NotEqualTo notEqualTo);
    public T visit(OuLogique ouLogique);
    public T visit(Parametres parametres);
    public T visit(Plus plus);
    public T visit(Program program);
    public T visit(StructFct structFct);
    public T visit(StructPointer structPointer);
    public T visit(WhileInst whileInst);
    public T visit(Affect affect);
    public T visit(Return return1);
    public T visit(Sizeof sizeof);
    // public T visit(Param param);
    public T visit(Oppose oppose);

}
