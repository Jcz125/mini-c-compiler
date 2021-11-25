package ast;

import java.util.ArrayList;

public class Fleche implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Ast> idfList;

    public Fleche(ArrayList<Ast> list) {
        this.idfList = list;
    }
    
    // public Ast idf1;
    // public Ast idf2;

    // public Fleche(Ast idf1, Ast idf2) {
    //     // this.idf1 = idf1;
    //     // this.idf2 = idf2;
    // }
}