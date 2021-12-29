import java.util.ArrayList;

public class LineElement {

    private String idf ;
    private String nature ;                 // ATTR, VAR...
    private String type ;                   // int, struct... si c'est une fct --> ""
    private String value ;                  // valeur
    private String returnParam ;            // valeur de retour d'une fct sinon ""
    private ArrayList<String> fctParams= new ArrayList<>() ;   // les params de fct sinon null

    public LineElement(String idf, String nature, String type, String value, String returnParam, ArrayList<String> fctParams) {
        this.idf = idf ;
        this.nature = nature ;
        this.type = type ;
        this.value = value ;
        this.returnParam = returnParam ;
        this.fctParams = fctParams ;
    }

    public String getIdf() {
        return idf;
    }

    public String getNature() {
        return nature;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public String getReturnParam() {
        return returnParam;
    }

    public ArrayList<String> getFctParams() {
        return fctParams;
    }
}
