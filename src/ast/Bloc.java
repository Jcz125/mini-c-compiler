package ast;

import java.util.ArrayList;

public class Bloc implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    // public ArrayList<Ast> list_decl; // pas sur que ce la soit utile
    // public ArrayList<Ast> list_instr; // ce traitement peut-il se faire en sémantique ?
    public ArrayList<Ast> list;

    public Bloc(ArrayList<Ast> list) { // ArrayList<Ast> list_decl, ArrayList<Ast> list_instr) {
        // this.list_decl = list_decl;
        // this.list_instr = list_instr;
        this.list = list;
    }
}