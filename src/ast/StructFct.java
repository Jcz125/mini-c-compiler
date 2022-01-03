package ast;

public class StructFct implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String type;
    public Idf idf_struct;
    public Idf idf;
    public Parametres params;
    public Ast bloc;

    public StructFct(Idf struct, Idf idf, Parametres params, Ast bloc) {
        this.idf_struct = struct;
        this.idf = idf;
        this.params = params;
        this.bloc = bloc;
        this.type = "struct " + idf_struct.name;
    }
}