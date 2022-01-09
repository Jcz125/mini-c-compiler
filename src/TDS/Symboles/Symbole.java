package TDS.Symboles;

import TDS.SymbolTable;

import java.io.FileWriter;

public abstract class Symbole {

    public SymbolTable st = null;
    protected String idf ;
    protected String type ;

    public SymbolTable getSt() {
        return st;
    }

    public void setSt(SymbolTable st) {
        this.st = st;
    }

    public abstract void displaySymbole();

    public abstract void displaySymbole_CSV(FileWriter csvWriter);
    public abstract String displaySymbole_CSV1();
    public String getIdf(){return this.idf;};

    public String getType(){return this.type;}


}
