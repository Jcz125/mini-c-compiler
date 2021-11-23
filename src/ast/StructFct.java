package ast;

public class StructFct implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast idf_struct;
    public Ast idf;
    public Ast params;
    public Ast bloc;

    public StructFct(Ast struct, Ast idf,Ast params,Ast bloc) {
        this.idf_struct = struct;
        this.idf = idf;
        this.params = params;
        this.bloc = bloc;
    }

}