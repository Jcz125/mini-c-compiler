package TDS.Symboles;

import TDS.SymbolTable;

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

    public String getIdf(){return this.idf;};

    public String getType(){return this.type;}


}
