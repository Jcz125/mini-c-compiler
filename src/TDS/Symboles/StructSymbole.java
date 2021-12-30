package TDS.Symboles;

import TDS.SymbolTable;

import java.util.ArrayList;

public class StructSymbole extends Symbole{

    private String type ;
    private ArrayList<Symbole> champs ;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Symbole> getChamps() {
        return champs;
    }

    public void setChamps(ArrayList<Symbole> champs) {
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
