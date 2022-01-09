package TDS.Symboles;

import TDS.SymbolTable;

import java.io.FileWriter;
import java.io.IOException;
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
        for (Map.Entry<Symbole, String> mapentry : this.champs.entrySet()) {
            // if (mapentry.getValue().equals(type)) {
                if (mapentry.getKey().idf.equals(idf_champ)) {
                    return mapentry.getKey();
                }
            // }
        }
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
        }
        else {
            System.out.print(" Vide ");
        }
    }

    @Override
    public void displaySymbole_CSV(FileWriter csvWriter) {
        try {
            csvWriter.append("Type: " + this.type + ";" );
            csvWriter.append("Champs : ") ;
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
                for (String name : types.keySet()) {
                    String key = name.toString();
                    csvWriter.append("(");
                    if (!key.equals("int")) {
                        csvWriter.append(key + " * : ");
                    } else {
                        csvWriter.append(key + " : ");
                    }
                    /*ArrayList<String> s= types.get(name);
                    for(String i : s){
                        csvWriter.append(i+"  ");
                    }*/
                    csvWriter.append("["+String.join(",", types.get(name))+"]");
                    csvWriter.append(")");
                    csvWriter.append("   ");
                }
            }
            else {
                csvWriter.append(" Vide ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public String displaySymbole_CSV1() {
        String TDS = new String();

            TDS+=("Type: " + this.type + ";" );
            TDS+=("Champs : ") ;
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
                for (String name : types.keySet()) {
                    String key = name.toString();
                    TDS+=("(");
                    if (!key.equals("int")) {
                        TDS+=(key + " * : ");
                    } else {
                        TDS+=(key + " : ");
                    }
                    /*ArrayList<String> s= types.get(name);
                    for(String i : s){
                        csvWriter.append(i+"  ");
                    }*/
                    TDS+=("["+String.join(",", types.get(name))+"]");
                    TDS+=(")");
                    TDS+=("   ");
                }
            }
            else {
                TDS+=(" Vide ");
            }

        return TDS;
    }
}
