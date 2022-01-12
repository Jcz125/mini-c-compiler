# Dépôt pour le projet de compilation 2021

### Les membres du groupe 25 : 
Gisel RODRIGUEZ BAIDE   G4 ;
Chaima TOUNSI OMEZZINE  G3 ;
Céline ZHANG            G3 ;

## Pour compiler le parser et générer les visiteurs :
### Linux :
```bash 
java -jar ./lib/antlr-4.9.2-complete.jar grammaire.g4 -no-listener -visitor -o ./src/parser
```
ou
```bash 
make parser
```

### Windows :
```bash
java -jar ./lib/antlr-4.9.2-complete.jar grammaire.g4 -no-listener -visitor -o ./src/parser
```

## Pour construire l'AST, la TDS et afficher les contrôles sémantiques :
### Linux :
```bash
javac -cp ./lib/antlr-4.9.2-complete.jar:./src ./src/Main.java -d ./bin
java -cp ./lib/antlr-4.9.2-complete.jar:./bin Main $(target)
```
ou
```bash
make compile
make run target=[path_du_fichier]
``` 

### Windows :
```bash
javac  -cp "./lib/antlr-4.9.2-complete.jar;./src" ./src/Main.java -d ./bin
java -cp "./lib/antlr-4.9.2-complete.jar;./bin" Main [nom_du_fichier]
```

## Pour afficher et enregistrer l'AST :
```bash
dot -Tsvg ./out/tree.dot -o ./out/tree.svg
```
## Pour afficher et enregistrer la TDS :
```bash
dot -Tsvg ./out/tds.dot -o ./out/tds.svg
```
