package ast;

import java.util.ArrayList;

public class DeclInt implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }


    public ArrayList<Ast> list;

    public DeclInt (ArrayList<Ast> list){
        this.list = list;
    }


}