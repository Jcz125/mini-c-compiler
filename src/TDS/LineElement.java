package TDS;

import TDS.Symboles.Symbole;

public class LineElement {

    private String idf ;
    private NatureSymboles nature ;                   // VAR, FCT, PARAM, ...
    private Symbole symbole ;


    public LineElement(String idf, NatureSymboles nature, Symbole s) {
        this.idf = idf ;
        this.nature = nature ;
        this.symbole = s;
    }

    public String getIdf() {
        return idf;
    }

    public NatureSymboles getNature() {
        return nature;
    }

    public Symbole getSymbole() {
        return this.symbole;
    }
}
