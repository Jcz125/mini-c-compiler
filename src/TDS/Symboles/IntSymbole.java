package TDS.Symboles;

import java.util.ArrayList;

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

    @Override
    public ArrayList<String> listCaracteristiques() {
        ArrayList<String> res = new ArrayList<>();
        res.add("int");
        return res;
    }

    @Override
    public String displaySymbole_CSV() {
            String TDS = new String();
        TDS+=(" Type : int ;");
            return TDS;
    }
}
