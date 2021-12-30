package ast;

// import java.util.ArrayList;

public class Fleche implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public Fleche(Ast noeudTemporaire, Ast right) {
        this.left = noeudTemporaire;
        this.right = right;
    }

    // public ArrayList<Ast> idfList;

    // public Fleche(ArrayList<Ast> list) {
    //     this.idfList = list;
    // }
}