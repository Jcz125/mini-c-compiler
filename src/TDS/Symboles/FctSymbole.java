package TDS.Symboles;

import TDS.SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;

public class FctSymbole extends Symbole {

   // private String idf;
    private String typeRetour ;
    private HashMap<String,Symbole> fctParams;
    private int nbParam ;

    public FctSymbole() {} ;

    public FctSymbole(String  typeRetour, HashMap<String, Symbole> fctParams, int nbParam) {
        super();
        this.typeRetour = typeRetour ;
        this.fctParams = fctParams ;
        this.nbParam = nbParam ;
    }

    public HashMap<String, Symbole> getFctParams() {
        return fctParams;
    }

    public String getTypeRetour() {
        return typeRetour;
    }

    public int getNbParam() {
        return nbParam;
    }

    public void setFctParams(HashMap<String, Symbole> fctParams) {
        this.fctParams = fctParams;
    }

//    public void addFctParam(Symbole param) {
//        this.fctParams.add(param);
//    }
    public void addFctParam(Symbole param) {
        this.fctParams.put(param.idf, param) ;
    }

    public void setTypeRetour(String typeRetour) {
        this.typeRetour = typeRetour;
    }

    public void setNbParam(int nbParam) {
        this.nbParam = nbParam;
    }

    @Override
    public SymbolTable getSt() {
        return super.getSt();
    }
}
