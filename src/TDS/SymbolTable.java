package TDS;

import TDS.Symboles.*;

import java.util.ArrayList;
import java.util.HashMap;


public class SymbolTable {

    private String name ;
    private ArrayList<LineElement> lines;
    private SymbolTable parent;
    private ArrayList<SymbolTable> children;


    public SymbolTable(String name, SymbolTable parent){
        this.name = name ;
        this.parent = parent;
        this.lines = new ArrayList<>() ;
        this.children = new ArrayList<>() ;
    }


    public String getName() {
        return name;
    }

    public SymbolTable getParent() {
        return parent;
    }

    public ArrayList<LineElement> getLines() {
        return lines;
    }

    public ArrayList<SymbolTable> getChildren() {
        return children;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLines(ArrayList<LineElement> lines) {
        this.lines = lines;
    }

    public void setChildren(ArrayList<SymbolTable> children) {
        this.children = children;
    }

    public void setParent(SymbolTable parent) {
        this.parent = parent;
    }

    public LineElement addLineInt(String idf, NatureSymboles nature) {
        for (LineElement line:lines) {
            if (line.getIdf().equals(idf)) {
                System.out.println("Idf already used");     //ajouter le numéro de ligne
                return null;
            }
        }
        Symbole newSymbole = new IntSymbole(idf);
        LineElement newLine = new LineElement(idf, nature, newSymbole);
        lines.add(newLine) ;
        return newLine;
    }


    public LineElement addLineStruct(String idf, NatureSymboles nature, String type) {
        for (LineElement line:lines) {
            if (line.getIdf().equals(idf)) {
                System.out.println("Idf already used");
                return null;
            }
        }
        Symbole newSymbole = new StructSymbole(idf, type);
        LineElement newLine = new LineElement(idf, nature, newSymbole);
        lines.add(newLine) ;
        return newLine;
    }


    public LineElement addLineFct(String idf, NatureSymboles nature, String typeRetour, HashMap<Symbole, String> fctParams, int nbParams) {
        for (LineElement line:lines) {
            if (line.getIdf().equals(idf)) {
                System.out.println("Idf already used");
                return null;
            }
        }
        Symbole newSymbole = new FctSymbole(typeRetour, fctParams, nbParams);
        LineElement newLine = new LineElement(idf, nature, newSymbole);
        lines.add(newLine) ;
        return newLine;
    }


    public LineElement addLineStructDef(String struct_name, NatureSymboles nature, String type, HashMap<Symbole, String> champs) {
        for (LineElement line:lines) {
            if (line.getIdf().equals(struct_name)) {
                System.out.println("Idf already used");
                return null;
            }
        }
        Symbole newSymbole = new StructDefSymbole(struct_name, type, champs);
        LineElement newLine = new LineElement(struct_name, nature, newSymbole);
        lines.add(newLine) ;
        return newLine;
    }


    public LineElement search(String idf, SymbolTable st) {
        for (LineElement line:lines) {
            if (line.getIdf().equals(idf)) {
                System.out.println("Var declared ");
                return line;
            }
        }
        System.out.println("Not found in the current table, searching in parent : ");

        if (st.parent != null)
            return search(idf, st.parent);

        return null ;
    }



//    public LineElement updateLineInt(String idf, String value) {
//        for (LineElement line:lines) {
//            if (line.getIdf().equals(idf) && (line.getValue().equals(""))) {
//                line.setValue(value);
//                return line;
//            }
//        }
//        System.out.println("Undeclared var");
//        return null ;
//    }
//
//
//    public LineElement search(String idf, SymbolTable st) {
//        for (LineElement line:lines) {
//            if (line.getIdf().equals(idf)) {
//                System.out.println("Var declared ");
//                return line;
//            }
//        }
//        System.out.println("Not found in the current table, searching in parent : ");
//
//        if (st.parent != null)
//            return search(idf, st.parent);
//
//        return null ;
//    }


    public SymbolTable newRegion(String name, SymbolTable currentSt) {
        SymbolTable newRegionTable = new SymbolTable(name, currentSt);
        currentSt.children.add(newRegionTable);
        return newRegionTable ;
    }


    public SymbolTable exitRegion(SymbolTable currentSt){
        return currentSt.parent ;
    }

}
