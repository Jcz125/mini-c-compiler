package TDS;

import TDS.Symboles.*;
import ast.*;

import java.util.ArrayList;
import java.util.HashMap;


public class SymbolTable {

    public static ArrayList<String> Errors = new ArrayList<>();
    private String name ;
    private ArrayList<LineElement> lines;
    private SymbolTable parent;
    private ArrayList<SymbolTable> children;


    public SymbolTable(String name, SymbolTable parent){
        this.name = name ;
        this.parent = parent;
        this.lines = new ArrayList<>() ;
        this.children = new ArrayList<>() ;
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
                System.out.println("Idf already used");     //ajouter le numéro de ligne
                return null;
            }
        }
        Symbole newSymbole = new IntSymbole(idf);
        LineElement newLine = new LineElement(idf, nature, newSymbole);
        lines.add(newLine) ;
        return newLine;
    }


    public LineElement addLineStruct(String idf, NatureSymboles nature, String type) {
        for (LineElement line:lines) {
            if (line.getIdf().equals(idf)) {
                System.out.println("Idf already used");
                return null;
            }
        }
        Symbole newSymbole = new StructSymbole(type, idf);
        LineElement newLine = new LineElement(idf, nature, newSymbole);
        lines.add(newLine) ;
        return newLine;
    }


    public LineElement addLineFct(String idf, NatureSymboles nature, String typeRetour, ArrayList<Symbole> fctParams, int nbParams) {
        for (LineElement line:lines) {
            if (line.getIdf().equals(idf)) {
                //System.out.println("Idf already used");
                return null;
            }
        }
        Symbole newSymbole = new FctSymbole(typeRetour, fctParams, nbParams);
        LineElement newLine = new LineElement(idf, nature, newSymbole);
        lines.add(newLine) ;
        return newLine;
    }


    public LineElement addLineStructDef(String struct_name, NatureSymboles nature, String type, HashMap<Symbole, String> champs) {
        for (LineElement line:lines) {
            if (line.getIdf().equals(struct_name)) {
                Errors.add("Error in "+this.name+" : idf already used "+line.getIdf());
                // System.out.println("Idf already used");
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


    public LineElement lookUp(String idf, SymbolTable st) {
        for (LineElement line:lines) {
            if (line.getIdf().equals(idf)) {
                // System.out.println("Var declared ");
                return line;
            }
        }
        // System.out.println("Not found in the current table, searching in parent : ");

        if (st.parent != null)
            return lookUp(idf, st.parent);

        return null ;
    }

    public LineElement lookUpStructDef(String idf, SymbolTable symbolTable){

            for(LineElement line : symbolTable.lines){
                if(line.getIdf().equals(idf) && line.getNature()==NatureSymboles.STRUCT){
                    return line;
                }
            }
            if(symbolTable.parent != null){
                return lookUpStructDef(idf, symbolTable.parent);
            }

            return null;
    }

    public LineElement lookUpFunctDef(String idf, SymbolTable symbolTable){

        for(LineElement line : symbolTable.lines){
            if(line.getIdf().equals(idf) && line.getNature()==NatureSymboles.FUNCTION){
                return line;
            }
        }
        if(symbolTable.parent != null){
            return lookUpStructDef(idf, symbolTable.parent);
        }

        return null;
    }

    public void displayTDS() {
        if(this != null) {
            String father = "Pas de parent";
            if(this.parent != null) {
                father = this.parent.getName();
            }
            System.out.println("\nTable courante:  " + this.name + "              " + "mon pere:  " + father );
            System.out.print("-------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("IDF                NATURE                CARACTERISTIQUES SYMBOLE              ");
            System.out.print("-------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------");
            for (LineElement line : this.lines){
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
        if(this != null) {
            this.displayTDS();
            for (SymbolTable s : this.children ) {
                s.displayAll();
            }
        }
        else {
            System.out.print("Vide");
        }
    }


//    public LineElement updateLineInt(String idf, String value) {
//        for (LineElement line:lines) {
//            if (line.getIdf().equals(idf) && (line.getValue().equals(""))) {
//                line.setValue(value);
//                return line;
//            }
//        }
//        System.out.println("Undeclared var");
//        return null ;
//    }
//
//


    public SymbolTable newRegion(String name, SymbolTable currentSt) {
        SymbolTable newRegionTable = new SymbolTable(name, currentSt);
        currentSt.children.add(newRegionTable);
        return newRegionTable ;
    }


    public SymbolTable exitRegion(SymbolTable currentSt){
        return currentSt.parent ;
    }

}
