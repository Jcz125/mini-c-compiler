package TDS.Symboles;

import java.io.FileWriter;
import java.io.IOException;

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
    public void displaySymbole_CSV(FileWriter csvWriter) {
        try {
            csvWriter.append(" Type : int ;");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String displaySymbole_CSV1() {
            String TDS = new String();
        TDS+=(" Type : int ;");
            return TDS;
    }
}
