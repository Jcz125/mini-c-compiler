package TDS;

import TDS.Symboles.*;
import ast.*;

import java.util.ArrayList;
import java.util.HashMap;

import TDS.SymbolTable;

public class TdsVisitor implements AstVisitor<SymbolTable> {

    SymbolTable tds_root;
    SymbolTable tds_current;
    boolean main = false;

    @Override
    public SymbolTable visit(Program program) {
        SymbolTable root = new SymbolTable("root", null);
        this.tds_root = this.tds_current = root;
        for (Ast ast : program.program)
            ast.accept(this);
        return root;
    }

    @Override
    public SymbolTable visit(DeclType decltype) {
        HashMap<Symbole, String> table = new HashMap<Symbole, String>(); // Symbole est la clé K et String la valeur V
        for (Ast champ : decltype.list) { // remplissage des champs selon le type
            if (champ instanceof VarInt) {
                for (Idf idf : ((VarInt) champ).list) {
                    IntSymbole sb = new IntSymbole(idf.name);
                    table.put(sb, "int");
                }
            } else {
                VarStruct s = (VarStruct) champ;
                for (Idf idf : s.list_idf) {
                    StructSymbole sb = new StructSymbole(s.type, idf.name);
                    table.put(sb, s.type);
                }
            }
        }
        tds_current.addLineStructDef(decltype.idf_name.name, NatureSymboles.STRUCT, decltype.type, table);
        return tds_current;
    }

    @Override
    public SymbolTable visit(VarInt varInt) {
        for(Idf idf : varInt.list){
            tds_current.addLineInt(idf.name, NatureSymboles.VARIABLE);
            // IntSymbole intSymbole = new IntSymbole(name);
            // LineElement lineElement = new LineElement(name,NatureSymboles.VARIABLE,intSymbole);
            // la fonction ci-dessus doit être mis dans addLineElement
            //addLineElement(lineElement);
        }
        return tds_current;
    }

    @Override
    public SymbolTable visit(VarStruct varStruct) {
        String type = varStruct.type;
        for (Idf idf : varStruct.list_idf) {
            tds_current.addLineStruct(idf.name, NatureSymboles.VARIABLE, type);
        }
        // for(int i=1; i<varStruct.list_idf.size();i++){
        //     Idf idf = varStruct.list_idf.get(i);
        //     String name= idf.name;
        //     StructSymbole structSymbole = new StructSymbole(varStruct.type, name);
        //     LineElement lineElement = new LineElement(name,NatureSymboles.VARIABLE,structSymbole);
            //addLineElement(lineElement);
        // }
        return tds_current;
    }

    public HashMap<Symbole, String> create_hashmap_param(ArrayList<Ast> list) {
        HashMap<Symbole, String> params = new HashMap<>();
        ArrayList<String> idfs = new ArrayList<>();
        for (Ast ast : list) {
            if (ast instanceof IntParam) {
                IntParam param = (IntParam) ast;
                if (idfs.contains(param.idf.name)) {
                    idfs.add(param.idf.name);
                    params.put(new IntSymbole(param.idf.name), "int");
                } else {
                    System.out.println("Function params : Idf already used"); // améliorer le message d'erreur
                } // de préférence stocker l'erreur quelque part et afficher tous les erreurs
            } else {
                StructPointer param = (StructPointer) ast;
                params.put(new StructSymbole(param.type, param.idf.name), param.type);
            }
        }
        return params;
    }

    @Override // pas terminer à finaliser manque le contrôle sémantique et repérage région
    public SymbolTable visit(IntFct intFct) {
        HashMap<Symbole, String> params = create_hashmap_param(intFct.params.list);
        LineElement line = tds_current.addLineFct(intFct.idf.name, NatureSymboles.FUNCTION, "int", params, params.size());
        if (line != null) {
            tds_current = tds_current.newRegion(intFct.idf.name, tds_current);
            tds_current.addListVar(intFct.params.list, NatureSymboles.PARAM_FUNC);
            intFct.bloc.accept(this);
            tds_current = tds_current.exitRegion(tds_current);
        }
        return tds_current;
    }


    @Override
    public SymbolTable visit(StructFct structFct) {
        HashMap<Symbole, String> params = create_hashmap_param(structFct.params.list);
        LineElement line = tds_current.addLineFct(structFct.idf_struct.name, NatureSymboles.FUNCTION, structFct.type, params, params.size());
        if (line != null) {
            tds_current = tds_current.newRegion(structFct.idf.name, tds_current);
            tds_current.addListVar(structFct.params.list, NatureSymboles.PARAM_FUNC);
            structFct.bloc.accept(this);
            tds_current = tds_current.exitRegion(tds_current);
        }
        return tds_current;
    }

    @Override
    public SymbolTable visit(Bloc bloc) {
        for(Ast ast:bloc.list){
            ast.accept(this);
        }
        return tds_current;
    }

    @Override
    public SymbolTable visit(Affect affect) {
        return null;
    }

    @Override
    public SymbolTable visit(Fleche fleche) {
        return null;
    }

    @Override
    public SymbolTable visit(OuLogique ouLogique) {
        return null;
    }

    @Override
    public SymbolTable visit(EtLogique etLogique) {
        return null;
    }

    @Override
    public SymbolTable visit(EqualTo equalTo) {
        return null;
    }

    @Override
    public SymbolTable visit(NotEqualTo notEqualTo) {
        return null;
    }

    @Override
    public SymbolTable visit(GreaterOrEqual greaterOrEqual) {
        return null;
    }

    @Override
    public SymbolTable visit(GreaterThan greaterThan) {
        return null;
    }

    @Override
    public SymbolTable visit(LessOrEqual lessOrEqual) {
        return null;
    }

    @Override
    public SymbolTable visit(LessThan lessThan) {
        return null;
    }

    @Override
    public SymbolTable visit(Plus plus) {
        return null;
    }

    @Override
    public SymbolTable visit(Minus minus) {
        return null;
    }

    @Override
    public SymbolTable visit(Mult mult) {
        return null;
    }

    @Override
    public SymbolTable visit(Divide divide) {
        return null;
    }

    @Override
    public SymbolTable visit(Oppose oppose) {
        return null;
    }

    @Override
    public SymbolTable visit(Function function) {
        return null;
    }

    @Override
    public SymbolTable visit(Sizeof sizeof) {
        return null;
    }

    @Override
    public SymbolTable visit(Idf idf) {
        return null;
    }

    @Override
    public SymbolTable visit(IfThen ifThen) {
        return null;
    }

    @Override
    public SymbolTable visit(IfThenElse ifThenElse) {
        return null;
    }

    @Override
    public SymbolTable visit(WhileInst whileInst) {
        return null;
    }

    @Override
    public SymbolTable visit(Return return1) {
        return null;
    }

    @Override
    public SymbolTable visit(Entier integer) {
        return null;
    }

    @Override
    public SymbolTable visit(Parametres parametres) {
        return null;
    }

    @Override
    public SymbolTable visit(IntParam intParam) {
        return null;
    }

    @Override
    public SymbolTable visit(StructPointer structPointer) {
        return null;
    }

}
