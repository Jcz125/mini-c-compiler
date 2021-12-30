package TDS.Symboles;

import TDS.SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;

public class StructDefSymbole extends Symbole{

    private String type ;
    private HashMap<String,String> champs ;

    public StructDefSymbole(){} ;

    public StructDefSymbole(String type, HashMap<String, String> champs) {
        super();
        this.type = type ;
        this.champs = champs ;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, String> getChamps() {
        return champs;
    }

    public void setChamps(HashMap<String, String> champs) {
        this.champs = champs;
    }

    public void addChamps(Symbole champs) {
        this.champs.add(champs) ;
    }

    @Override
    public SymbolTable getSt() {
        return super.getSt();
    }
}
