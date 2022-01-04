package TDS.Symboles;

import TDS.SymbolTable;

import java.util.ArrayList;

public class FctSymbole extends Symbole {

   // private String idf;
    private String typeRetour ;
    private ArrayList<Symbole> fctParams;
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
        this.fctParams.add(param) ;
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
            for(Symbole s : fctParams){
                String name = s.idf;
                String type = s.type;
                System.out.print("(" + name + " __ " + type + ")" + "  |  ") ;
            }
            /*for (Symbole s : fctParams.keySet()){
                String name = s.idf.toString() ;
                String type = s.type.toString() ;
                System.out.print("(" + name + " __ " + type + ")" + "  |  ") ;
            }*/
        }
    }
}
