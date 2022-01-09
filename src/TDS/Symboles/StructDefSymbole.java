package TDS.Symboles;

import TDS.SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class StructDefSymbole extends Symbole{

    private String type ;
    private HashMap<Symbole, String> champs ;

    public StructDefSymbole(){} ;

    public StructDefSymbole(String struct_name, String type, HashMap<Symbole, String> champs) {
        super();
        this.idf = struct_name;
        this.type = type ;
        this.champs = champs ;
    }

    public String getType() {
        return type;
    }

    public Symbole lookUpChamp(String idf_champ) {
        for (Map.Entry<Symbole, String> mapentry : this.champs.entrySet())
            if (mapentry.getKey().idf.equals(idf_champ))
                return mapentry.getKey();
        return null;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<Symbole, String> getChamps() {
        return champs;
    }

    public void setChamps(HashMap<Symbole, String> champs) {
        this.champs = champs;
    }

    public void addChamps(Symbole champs) {
        this.champs.put(champs, champs.idf) ;
    }

    @Override
    public SymbolTable getSt() {
        return super.getSt();
    }

    @Override
    public void displaySymbole() {
        System.out.print("Type: " + this.type + "       " );
        System.out.print("Champs : ") ;
        if (champs.size() != 0) {
            HashMap<String, ArrayList<String>> types = new HashMap<>();
            for (Symbole s : champs.keySet()) {
                String t = s.type.toString();
                String name = s.idf.toString();
                if (types.containsKey(t)) {
                    types.get(t).add(name);
                } else {
                    ArrayList<String> tab = new ArrayList<>();
                    tab.add(name);
                    types.put(t, tab);
                }

            }
            for (String name: types.keySet()) {
                String key = name.toString();
                System.out.print("(");
                if (!key.equals("int")){
                    System.out.print(key + " * : " );
                }
                else {
                    System.out.print(key + " : " );
                }
                System.out.print(types.get(name));
                System.out.print(")");
                System.out.print("      ");
            }
        } else
            System.out.print(" Vide ");
    }
}
