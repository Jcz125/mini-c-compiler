package TDS.Symboles;

import TDS.SymbolTable;

public abstract class Symbole {

    public SymbolTable st = null;

    public SymbolTable getSt() {
        return st;
    }

    public void setSt(SymbolTable st) {
        this.st = st;
    }

}
