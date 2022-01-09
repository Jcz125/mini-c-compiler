package TDS.Symboles;

import java.io.FileWriter;
import java.io.IOException;

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

    @Override
    public void displaySymbole_CSV(FileWriter csvWriter) {
        try {
            csvWriter.append(" Type : " + this.type + " * ;");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String displaySymbole_CSV1() {
        String TDS = new String();
        TDS+=(" Type : " + this.type + " * ;");
        return TDS;
    }
}
