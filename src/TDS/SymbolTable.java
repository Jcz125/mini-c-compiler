package TDS;

import java.util.ArrayList;

public class SymbolTable {

    private ArrayList<LineElement> lines;
    private SymbolTable parent;
    private ArrayList<SymbolTable> children;


    public SymbolTable(SymbolTable parent){
        this.parent = parent;
        this.lines = new ArrayList<>() ;
        this.children = new ArrayList<>() ;
    }


    public LineElement addLine(String idf, String nature, String type, String value, String returnParam, ArrayList<String> fctParams) {
        for (LineElement line:lines) {
            if (line.getIdf().equals(idf)) {
                System.out.println("Idf already used");     //ajouter le numéro de ligne
                return null;
            }
        }
        LineElement newLine = new LineElement(idf, nature, type, value, returnParam, fctParams);
        lines.add(newLine) ;
//        if (type.equals("")) {
//            SymbolTable newTab = new SymbolTable(this) ;
//            this.children.add(newTab) ;
//        }

//        SymbolTable newTab = newRegion(this) ;
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


    public SymbolTable newRegion(SymbolTable currentSt) {
        SymbolTable newRegionTable = new SymbolTable(currentSt);
        currentSt.children.add(newRegionTable);
        return newRegionTable ;
    }


    public SymbolTable exitRegion(SymbolTable currentSt){
        return currentSt.parent ;
    }

}
