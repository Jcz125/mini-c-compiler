package ast;

import java.util.ArrayList;

public class Bloc implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> bloc;

    public Bloc(ArrayList<Ast> list){
        this.bloc = bloc;
    }


}