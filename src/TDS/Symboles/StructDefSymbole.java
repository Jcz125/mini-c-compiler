package TDS.Symboles;

import TDS.SymbolTable;

import java.util.HashMap;

public class StructDefSymbole extends Symbole{

    private String type ;
    private HashMap<String,Symbole> champs ;

    public StructDefSymbole(){} ;

    public StructDefSymbole(String idf, String type, HashMap<String,Symbole> champs) {
        super();
        this.idf=idf;
        this.type = type ;
        this.champs = champs ;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String,Symbole> getChamps() {
        return champs;
    }

    public void setChamps(HashMap<String,Symbole> champs) {
        this.champs = champs;
    }

    public void addChamps(Symbole champs) {
        this.champs.put(champs.idf, champs) ;
    }

    @Override
    public SymbolTable getSt() {
        return super.getSt();
    }
}
