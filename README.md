Dépôt pour le projet de compilation 2021

Les membres du groupe: 
Gisel RODRIGUEZ BAIDE   G4 ;
Chaima TOUNSI OMEZZINE  G3 ;
Céline ZHANG            G3 ;

Pour compiler le parser et générer les visiteurs :
Linux :
java -jar ./lib/antlr-4.9.2-complete.jar grammaire.g4 -no-listener -visitor -o ./src/parser
ou
make parser

Windows :
java -jar ./lib/antlr-4.9.2-complete.jar grammaire.g4 -no-listener -visitor -o ./src/parser

Pour construire l'AST :
Linux :
javac -cp ./lib/antlr-4.9.2-complete.jar:./src ./src/Main.java -d ./bin
java -cp ./lib/antlr-4.9.2-complete.jar:./bin Main $(target)
ou 
make compile
make run target=[path_du_fichier]

Windows :
javac  -cp "./lib/antlr-4.9.2-complete.jar;./src" ./src/Main.java -d ./bin
java -cp "./lib/antlr-4.9.2-complete.jar;./bin" Main [nom_du_fichier]

Pour afficher l'AST :
dot -Tsvg ./out/tree.dot -o ./out/tree.svg