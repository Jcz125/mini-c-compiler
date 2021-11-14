package ast;

import java.util.ArrayList;

public class DeclStruct implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }


    public ArrayList<Ast> list_idf

    public DeclStruct (ArrayList<Ast> list_idf){

        this.list_idf = list_idf;
    }


}