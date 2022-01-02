package TDS;

import TDS.Symboles.IntSymbole;
import TDS.Symboles.StructSymbole;
import ast.*;

public class TdsVisitor implements AstVisitor<String> {


    @Override
    public String visit(Bloc bloc) {
        for(Ast ast:bloc.list){
            ast.accept(this);
        }
        return null;
    }

    @Override
    public String visit(VarInt varInt) {
        for(Idf idf:varInt.list ){
            String name= idf.name;
            IntSymbole intSymbole = new IntSymbole(name);
            // LineElement lineElement = new LineElement(name,NatureSymboles.VARIABLE,intSymbole);
            // la fonction ci-dessus doit être mis dans addLineElement
            //addLineElement(lineElement);
        }
        return null;
    }

    @Override
    public String visit(VarStruct varStruct) {
        for(int i=1; i<varStruct.list_idf.size();i++){
            Idf idf=varStruct.list_idf.get(i);
            String name= idf.name;
            StructSymbole structSymbole = new StructSymbole(varStruct.type, name);
            LineElement lineElement = new LineElement(name,NatureSymboles.VARIABLE,structSymbole);
            //addLineElement(lineElement);
        }

        return null;
    }



    @Override
    public String visit(DeclType decltype) {


        return null;
    }

    @Override
    public String visit(Divide divide) {
        return null;
    }

    @Override
    public String visit(EqualTo equalTo) {
        return null;
    }

    @Override
    public String visit(EtLogique etLogique) {
        return null;
    }

    @Override
    public String visit(Fleche fleche) {
        return null;
    }

    @Override
    public String visit(Function function) {
        return null;
    }

    @Override
    public String visit(GreaterOrEqual greaterOrEqual) {
        return null;
    }

    @Override
    public String visit(GreaterThan greaterThan) {
        return null;
    }

    @Override
    public String visit(Idf idf) {
        return null;
    }

    @Override
    public String visit(IfThen ifThen) {
        return null;
    }

    @Override
    public String visit(IfThenElse ifThenElse) {
        return null;
    }

    @Override
    public String visit(Entier integer) {
        return null;
    }

    @Override
    public String visit(IntFct intFct) {
        return null;
    }

    @Override
    public String visit(IntParam intParam) {
        return null;
    }

    @Override
    public String visit(LessOrEqual lessOrEqual) {
        return null;
    }

    @Override
    public String visit(LessThan lessThan) {
        return null;
    }

    @Override
    public String visit(Minus minus) {
        return null;
    }

    @Override
    public String visit(Mult mult) {
        return null;
    }

    @Override
    public String visit(NotEqualTo notEqualTo) {
        return null;
    }

    @Override
    public String visit(OuLogique ouLogique) {
        return null;
    }

    @Override
    public String visit(Parametres parametres) {
        return null;
    }

    @Override
    public String visit(Plus plus) {
        return null;
    }

    @Override
    public String visit(Program program) {
        return null;
    }

    @Override
    public String visit(StructFct structFct) {
        return null;
    }

    @Override
    public String visit(StructPointer structPointer) {
        return null;
    }

    @Override
    public String visit(WhileInst whileInst) {
        return null;
    }

    @Override
    public String visit(Affect affect) {
        return null;
    }

    @Override
    public String visit(Return return1) {
        return null;
    }

    @Override
    public String visit(Sizeof sizeof) {
        return null;
    }

    @Override
    public String visit(Oppose oppose) {
        return null;
    }
}
