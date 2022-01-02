package TDS.Symboles;

public class IntSymbole extends Symbole{

    //private String idf;
    //private String type = "int" ;

    public IntSymbole(String idf) {
        this.type = "int" ;
        this.idf=idf;
    } ;

    public String getType() {
        return type;
    }
}
