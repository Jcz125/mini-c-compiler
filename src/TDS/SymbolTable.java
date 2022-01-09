package TDS;

import TDS.Symboles.*;
import ast.*;

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


    public SymbolTable(String name, SymbolTable parent) {
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
                Errors.add("Error in "+this.titre+", add struct var: [idf] "+idf+" already used");
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
                Errors.add("Error in "+this.titre+", add function: [idf] "+idf+" already used");
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
                Errors.add("Error in "+this.titre+", add struct def: [idf] "+struct_name+" already used");
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
