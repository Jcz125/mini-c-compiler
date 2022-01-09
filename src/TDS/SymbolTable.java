package TDS;

import TDS.Symboles.*;
import ast.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class SymbolTable {

    public static ArrayList<String> Errors = new ArrayList<>();
    public int niveau;
    public String numero;
    public String titre;
    private String name;
    private ArrayList<LineElement> lines;
    private SymbolTable parent;
    private ArrayList<SymbolTable> children;
    //private File file ;
    //private FileWriter csvWriter;
    public static String TDS;



    public SymbolTable(String name, SymbolTable parent) {
        /*this.file = new File("./out/TDS.csv");
        try {
            this.csvWriter = new FileWriter("./out/TDS.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        this.name = name;
        if (parent == null) {
            this.niveau = 0;
            this.numero = "0";
            this.titre = "#"+0+"-"+"0"+" "+name;
        } else {
            this.niveau = parent.niveau + 1;
            this.numero = parent.numero + "." + (parent.children.size()+1);
            this.titre = "#"+this.niveau+"-"+this.numero+" "+this.name;
        }
        this.parent = parent;
        this.lines = new ArrayList<>();
        this.children = new ArrayList<>();
        this.TDS="";
    }


    public String getName() {
        return name;
    }

    public SymbolTable getParent() {
        return parent;
    }

    public ArrayList<LineElement> getLines() {
        return lines;
    }

    public ArrayList<SymbolTable> getChildren() {
        return children;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLines(ArrayList<LineElement> lines) {
        this.lines = lines;
    }

    public void setChildren(ArrayList<SymbolTable> children) {
        this.children = children;
    }

    public void setParent(SymbolTable parent) {
        this.parent = parent;
    }



    public LineElement addLineInt(String idf, NatureSymboles nature) {
        for (LineElement line:lines) {
            if (line.getIdf().equals(idf)) {
                Errors.add("Error in "+this.titre+": [idf] "+idf+" already used");
                return null;
            }
        }
        Symbole newSymbole = new IntSymbole(idf);
        LineElement newLine = new LineElement(idf, nature, newSymbole);
        lines.add(newLine) ;
        return newLine;
    }


    public LineElement addLineStruct(String idf, NatureSymboles nature, String type) {
        LineElement struct = this.lookUpStructDef(type);
        for (LineElement line : lines) {
            if (line.getIdf().equals(idf)) {
                Errors.add("Error in "+this.titre+": add struct var: [idf] "+idf+" already used");
                return null;
            }
        }
        if (struct != null) {
            Symbole newSymbole = new StructSymbole(type, idf);
            LineElement newLine = new LineElement(idf, nature, newSymbole);
            lines.add(newLine);
            return newLine;
        } else {
            Errors.add("Error in "+this.titre+": "+type+" is not defined");
            return null;
        }
    }


    public LineElement addLineFct(String idf, NatureSymboles nature, String typeRetour, ArrayList<Symbole> fctParams, int nbParams) {
        for (LineElement line : lines) {
            if (line.getIdf().equals(idf)) {
                Errors.add("Error in "+this.titre+": add function: [idf] "+idf+" already used");
                return null;
            }
        }
        Symbole newSymbole = new FctSymbole(idf, typeRetour, fctParams, nbParams);
        LineElement newLine = new LineElement(idf, nature, newSymbole);
        lines.add(newLine) ;
        return newLine;
    }


    public LineElement addLineStructDef(String struct_name, NatureSymboles nature, String type, HashMap<Symbole, String> champs) {
        for (LineElement line : lines) {
            if (line.getIdf().equals(struct_name)) {
                Errors.add("Error in "+this.titre+": add struct def: [idf] "+struct_name+" already used");
                return null;
            }
        }
        Symbole newSymbole = new StructDefSymbole(struct_name, type, champs);
        LineElement newLine = new LineElement(struct_name, nature, newSymbole);
        lines.add(newLine) ;
        return newLine;
    }

    /* Cette fonction permet d'ajouter la liste des vars (params ou decls) l'un à la suite de l'autre dans la TDS */
    public void addListVar(ArrayList<Ast> list, NatureSymboles nature) {
        if (nature == NatureSymboles.PARAM_FUNC) {
            for (Ast ast : list) {
                if (ast instanceof IntParam) {
                    IntParam param = (IntParam) ast;
                    addLineInt(param.idf.name, nature);
                } else {
                    StructPointer param = (StructPointer) ast;
                    addLineStruct(param.idf.name, nature, param.type);
                }
            }
        } else if (nature == NatureSymboles.VARIABLE) {
            for (Ast ast : list) {
                if (ast instanceof VarInt) {
                    VarInt var = (VarInt) ast;
                    for (Idf idf : var.list)
                        addLineInt(idf.name, nature);
                } else {
                    VarStruct var = (VarStruct) ast;
                    for (Idf idf : var.list_idf)
                        addLineStruct(idf.name, nature, var.type);
                }
            }
        }
    }


    public LineElement lookUp(String idf) {
        for (LineElement line : this.lines)
            if (line.getIdf().equals(idf))
                return line;
        if (this.parent != null)
            return this.parent.lookUp(idf);
        return null;
    }

    public LineElement lookUpStructDef(String idf) { // struct idf_name
            for (LineElement line : this.lines)
                if (line.getNature()==NatureSymboles.STRUCT && line.getSymbole().getType().equals(idf))
                    return line;
            if (this.parent != null)
                return this.parent.lookUpStructDef(idf);
            return null;
    }

    public LineElement lookUpFunctDef(String idf) {
        for (LineElement line : this.lines)
            if(line.getIdf().equals(idf) && line.getNature()==NatureSymboles.FUNCTION)
                return line;
        if (this.parent != null)
            return this.parent.lookUpFunctDef(idf);
        return null;
    }

    public void displayTDS() {
        if (this != null) {
            String father = "Pas de parent";
            if (this.parent != null) {
                father = this.parent.titre;
            }
            System.out.println("\nTable courante:  " + this.titre + "              " + "mon pere:  " + father );
            System.out.print("-------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("IDF                NATURE                CARACTERISTIQUES SYMBOLE              ");
            System.out.print("-------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------");
            for (LineElement line : this.lines) {
                String idf = line.getIdf();
                NatureSymboles nature = line.getNature();
                Symbole s = line.getSymbole() ;
                System.out.print(idf + "              " + nature + "              ");
                s.displaySymbole();
                System.out.println();
            }
            System.out.print("-------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println() ;
        }
    }



    public void displayTDS_CSV() {

        File file = new File("./out/TDS.csv");
        try {
            FileWriter csvWriter = new FileWriter("./out/TDS.csv");
            //csvWriter.append("hellooooooo");
            //csvWriter.append("\nTable courante: " + "mon pere:  " +"\n" );
            if (this != null) {
                String father = "Pas de parent";

                if (this.parent != null) {
                    father = this.parent.titre;
                }
                //System.out.println("hello\n");
                csvWriter.append("Table courante: " + this.titre + ";" + "mon pere:  " +father+"\n" );
                csvWriter.append("IDF;"+"NATURE;"+"CARACTERISTIQUES "+" SYMBOLE\n");
                for (LineElement line : this.lines) {
                    String idf = line.getIdf();
                    NatureSymboles nature = line.getNature();
                    Symbole s = line.getSymbole() ;

                    System.out.println("\n"+idf + ";" + nature + ";");
                    csvWriter.append("\n"+idf + ";" + nature + ";");
                    s.displaySymbole_CSV(csvWriter);
                }
            }
            csvWriter.flush();
            csvWriter.close();
            } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public String displayTDS_CSV1() {

        //File file = new File("./out/TDS.csv");

            //FileWriter csvWriter = new FileWriter("./out/TDS.csv");
            if (this != null) {
                String father = "Pas de parent";
                System.out.println("hello\n");
                if (this.parent != null) {
                    father = this.parent.titre;
                }

                this.TDS += ("\n Table courante: " + this.titre + ";" + "mon pere:  " + father );
                this.TDS += ("\nIDF;" + "NATURE;" + "CARACTERISTIQUES " + " SYMBOLE");
                for (LineElement line : this.lines) {
                    String idf = line.getIdf();
                    NatureSymboles nature = line.getNature();
                    Symbole s = line.getSymbole();
                    this.TDS += ( "\n"+ idf + ";" + nature + ";");
                     String symbole = s.displaySymbole_CSV1();
                     this.TDS += symbole;

                }
                this.TDS+="\n";

            }
            return this.TDS;
    }

    /*public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }*/

    public void displayAll_CSV() {
            this.displayTDS_CSV();
            /*for (SymbolTable s : this.children) {
                s.displayAll_CSV();
            }*/
    }

    public String displayAll_CSV1() {
        this.displayTDS_CSV1();
        for (SymbolTable s : this.children) {
            s.displayAll_CSV1();
        }

        return this.TDS;
    }

    public void afficher(){
        File file = new File("./TDS_CSV/TDS.csv");
        try {
            FileWriter csvWriter = new FileWriter("./out/TDS.csv");
            this.displayAll_CSV1();
            System.out.println(this.TDS);
            csvWriter.append(this.TDS);
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void displayAll() {
        this.displayTDS();
        for (SymbolTable s : this.children)
            s.displayAll();
    }


    public SymbolTable newRegion(String name) {
        SymbolTable newRegionTable = new SymbolTable(name, this);
        this.children.add(newRegionTable);
        return newRegionTable;
    }


    public SymbolTable exitRegion() {
        return this.parent;
    }
}
