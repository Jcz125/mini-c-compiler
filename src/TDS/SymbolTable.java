package TDS;

import TDS.Symboles.*;

import java.util.ArrayList;
import java.util.HashMap;

public class SymbolTable {

    private ArrayList<LineElement> lines;
    private SymbolTable parent;
    private ArrayList<SymbolTable> children;


    public SymbolTable(SymbolTable parent){
        this.parent = parent;
        this.lines = new ArrayList<>() ;
        this.children = new ArrayList<>() ;
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


    public LineElement addLineFct(String idf, NatureSymboles nature, String typeRetour, HashMap<String, Symbole> fctParams, int nbParams) {
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


    public LineElement addLineStructDef(String idf, NatureSymboles nature, String type, HashMap<String, Symbole> champs) {
        for (LineElement line:lines) {
            if (line.getIdf().equals(idf)) {
                System.out.println("Idf already used");
                return null;
            }
        }
        Symbole newSymbole = new StructDefSymbole(idf, type, champs);
        LineElement newLine = new LineElement(idf, nature, newSymbole);
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


    public SymbolTable newRegion(SymbolTable currentSt) {
        SymbolTable newRegionTable = new SymbolTable(currentSt);
        currentSt.children.add(newRegionTable);
        return newRegionTable ;
    }


    public SymbolTable exitRegion(SymbolTable currentSt){
        return currentSt.parent ;
    }

}
