package ast;

import java.util.ArrayList;

public class Program implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> program;

    public Program(ArrayList<Ast> list){
        this.program = list;
    }


}