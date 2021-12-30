package TDS.Symboles;

import java.util.ArrayList;

public class StructSymbole extends Symbole{

    private String idf;
    private String type ;

    public StructSymbole(String type, ArrayList champs) {
        super();
        this.type = type ;
    }

    public String getType() {
        return type;
    }
}
