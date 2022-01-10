package TDS.Symboles;

import TDS.SymbolTable;

import java.util.ArrayList;

public class FctSymbole extends Symbole {

    private String typeRetour ;
    private ArrayList<Symbole> fctParams;
    private int nbParam ;

    public FctSymbole() {} ;

    public FctSymbole(String idf, String  typeRetour, ArrayList<Symbole> fctParams, int nbParam) {
        super();
        this.idf = idf;
        this.type = typeRetour;
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
        if (this.typeRetour.equals("int") || this.typeRetour.equals("void") || this.typeRetour.equals("void *"))
            System.out.print("Type de retour : " + this.typeRetour + "       " );
        else
            System.out.print("Type de retour : " + this.typeRetour + " *       " );
        System.out.print("Nbre de params : " +  this.nbParam + "       ");

        if (this.nbParam != 0) {
            System.out.print("Params : ");
            for (Symbole s : fctParams) {
                String name = s.idf;
                String type = s.type;
                if (!type.equals("int"))
                    System.out.print("(" + name + " __ " + type + " *)" + "  |  ");
                else
                    System.out.print("(" + name + " __ " + type + ")" + "  |  ");
            }
        }
    }




    @Override
    public String displaySymbole_CSV() {
            String TDS = new String();
            if (this.typeRetour.equals("int") || this.typeRetour.equals("void") || this.typeRetour.equals("void *")) {
                TDS+=("Type de retour : " + this.typeRetour + ";"+"Nombre de params : " + this.nbParam+ ";");
            }
            else {
                TDS+=("Type de retour : " + this.typeRetour + "*"+ ";"+"Nombre de params : " + this.nbParam+ ";");
                //csvWriter.append( );
            }
            if (this.nbParam != 0) {
                TDS+=("Params : ");
                for (Symbole s : fctParams) {
                    String name = s.idf;
                    String type = s.type;
                    if (!type.equals("int"))
                        TDS+=("(" + name + " __ " + type + " *)" + "  |  ");
                    else
                        TDS+=("(" + name + " __ " + type + ")" + "  |  ");
                }


            }
            return TDS;
    }
}

