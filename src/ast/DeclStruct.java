package ast;

import java.util.ArrayList;

public class DeclStruct implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Idf struct_name;
    public ArrayList<Ast> list_idf;

    public DeclStruct (Idf struct, ArrayList<Ast> list_idf){
        this.struct_name = struct;
        this.list_idf = list_idf;
    }


}