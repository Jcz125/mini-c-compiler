package TDS.Symboles;

public class StructSymbole extends Symbole{

    public StructSymbole(String type, String idf) {
        super();
        this.idf = idf;
        this.type = type ;
    }

    public String getType() {
        return type;
    }

    @Override
    public void displaySymbole() {
        System.out.print(" type : " + this.type + " *       ");
    }
}
