package TDS.Symboles;

import TDS.SymbolTable;

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
        for (Symbole s : champs.keySet()){
            String name = s.idf.toString() ;
            String type = s.type.toString() ;
            System.out.print("(" + name + " __ " + type + ")" + "  |  ") ;
        }
    }
}
