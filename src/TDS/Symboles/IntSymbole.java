package TDS.Symboles;

public class IntSymbole extends Symbole{

    public IntSymbole(String idf) {
        this.type = "int" ;
        this.idf = idf;
    } ;

    public String getType() {
        return type;
    }

    @Override
    public void displaySymbole() {
        System.out.print(" Type : int ");
    }
}
