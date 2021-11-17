package ast;

import java.util.ArrayList;

public class Parametres implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }


    public ArrayList<Ast> list;

    public Parametres (ArrayList<Ast> list){
        this.list = list;
    }


}