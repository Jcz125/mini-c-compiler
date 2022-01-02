
import parser.grammaireLexer;
import parser.grammaireParser;
import parser.grammaireParser.ProgramContext;


import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import TDS.SymbolTable;
import TDS.TdsVisitor;
import ast.*;
import graphViz.GraphVizVisitor;

public class Main {

    public static void main(String[] args){

        if (args.length < 1){
            System.out.println("Error : Expected 1 argument filepath, found 0");
            return;
        }

        String testFile = args[0];

        try {

            //chargement du fichier et construction du parser

            CharStream input = CharStreams.fromFileName(testFile);
            grammaireLexer lexer = new grammaireLexer(input);
            CommonTokenStream stream = new CommonTokenStream(lexer);
            grammaireParser parser = new grammaireParser(stream);

            // Récupération du noeud program (le noeud à la racine)
            ProgramContext program = parser.program();

            // Visiteur de création de l'AST + création de l'AST
            AstCreator creator = new AstCreator();
            Ast ast = program.accept(creator);

            // Visiteur de représentation graphique + appel
            GraphVizVisitor graphViz = new GraphVizVisitor();
            ast.accept(graphViz);
        
            graphViz.dumpGraph("./out/tree.dot");

            // Visiteur de l'AST + création de la TDS + contrôle sémentique
            TdsVisitor tds_visitor = new TdsVisitor();
            SymbolTable tds = ast.accept(tds_visitor);
            tds.displayAll() ;

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (RecognitionException e) {
            e.printStackTrace();
        }
        
    }
    
}