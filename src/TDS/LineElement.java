package TDS;

import TDS.Symboles.Symbole;

public class LineElement {

    private String idf ;
    private NatureSymboles nature ;                   // VAR, FCT, PARAM, ...
    private Symbole symbole ;


    public LineElement(String idf, String type, NatureSymboles nature) {
        this.idf = idf ;
        this.nature = nature ;
    }

    public String getIdf() {
        return idf;
    }

    public NatureSymboles getNature() {
        return nature;
    }

}
