package TDS.Symboles;

import TDS.SymbolTable;

import java.util.HashMap;
import java.util.Locale;

public class FctSymbole extends Symbole {

   // private String idf;
    private String typeRetour ;
    private HashMap<Symbole, String> fctParams;
    private int nbParam ;

    public FctSymbole() {} ;

    public FctSymbole(String  typeRetour, HashMap<Symbole, String> fctParams, int nbParam) {
        super();
        this.typeRetour = typeRetour ;
        this.fctParams = fctParams ;
        this.nbParam = nbParam ;
    }

    public HashMap<Symbole, String> getFctParams() {
        return fctParams;
    }

    public String getTypeRetour() {
        return typeRetour;
    }

    public int getNbParam() {
        return nbParam;
    }

    public void setFctParams(HashMap<Symbole, String> fctParams) {
        this.fctParams = fctParams;
    }

    public void addFctParam(Symbole param) {
        this.fctParams.put(param, param.idf) ;
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


    @Override
    public void displaySymbole() {
        System.out.print("Type de retour : " + this.typeRetour + "       " );
        System.out.print("Nbre de params : " +  this.nbParam + "       ") ;

        if (this.nbParam != 0) {
            System.out.print("Params : ") ;
            for (Symbole s : fctParams.keySet()){
                String name = s.idf.toString() ;
                String type = s.type.toString() ;
                System.out.print("(" + name + " __ " + type + ")" + "  |  ") ;
            }
        }
    }
}
