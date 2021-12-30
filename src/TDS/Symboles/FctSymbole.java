package TDS.Symboles;

import TDS.SymbolTable;

import java.util.ArrayList;

public class FctSymbole extends Symbole {

    private String typeRetour ;
    private ArrayList<Symbole> fctParams ;
    private int nbParam ;

    public FctSymbole() {} ;

    public FctSymbole(String  typeRetour, ArrayList<Symbole> fctParams, int nbParam) {
        super();
        this.typeRetour = typeRetour ;
        this.fctParams = fctParams ;
        this.nbParam = nbParam ;
    }

    public ArrayList<Symbole> getFctParams() {
        return fctParams;
    }

    public String getTypeRetour() {
        return typeRetour;
    }

    public int getNbParam() {
        return nbParam;
    }

    public void setFctParams(ArrayList<Symbole> fctParams) {
        this.fctParams = fctParams;
    }

    public void addFctParam(Symbole param) {
        this.fctParams.add(param);
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
