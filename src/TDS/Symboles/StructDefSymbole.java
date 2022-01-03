package TDS.Symboles;

import TDS.SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;

public class StructDefSymbole extends Symbole{

    private String type ;
    private HashMap<Symbole, String> champs ;

    public StructDefSymbole(){} ;

    public StructDefSymbole(String struct_name, String type, HashMap<Symbole, String> champs) {
        super();
        this.idf = struct_name;
        this.type = type ;
        this.champs = champs ;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<Symbole, String> getChamps() {
        return champs;
    }

    public void setChamps(HashMap<Symbole, String> champs) {
        this.champs = champs;
    }

    public void addChamps(Symbole champs) {
        this.champs.put(champs, champs.idf) ;
    }

    @Override
    public SymbolTable getSt() {
        return super.getSt();
    }

    @Override
    public void displaySymbole() {
        System.out.print("Type: " + this.type + "       " );
        System.out.print("Champs : ") ;
        if (champs.size() != 0) {
            ArrayList<String> intTab = new ArrayList<>() ;
            for (Symbole s : champs.keySet()){
//                if (s instanceof IntSymbole){
//                    intTab.add(s.idf.toString()) ;
////                    String name = s.idf.toString();
////                    System.out.print("( int: " + name + ")" + "  |  ") ;
//                }
//                else if (s instanceof StructSymbole) {
//                    ArrayList<String> StructTab1 = new ArrayList<>() ;
//
//                }
            String name = s.idf.toString() ;
            String type = s.type.toString() ;
            System.out.print("(" + name + " __ " + type + ")" + "  |  ") ;
            }
        }
        else {
            System.out.println(" Vide ");
        }
    }
}
