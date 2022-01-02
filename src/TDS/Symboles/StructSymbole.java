package TDS.Symboles;

public class StructSymbole extends Symbole{

    //private String idf;
    //private String type ;

    public StructSymbole(String type, String idf) {
        super();
        this.type = type ;
        this.idf = idf;
    }

    public String getType() {
        return type;
    }
}
