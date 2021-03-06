grammar grammaire;


@header{
package parser;
}


program : decl* EOF;

decl :
      decl_typ
    | decl_fct
    ;

decl_typ :
      'struct' IDF '{'decl_vars*'}' ';';

decl_vars :
      'int' (IDF ',')* IDF ';'                        #IntDecl
    | 'struct' IDF ('*' IDF ',')* ('*' IDF) ';'       #StructDecl
    ;

decl_fct :
      'int' IDF '('params')' bloc                     #IntFct
    | 'struct' IDF '*' IDF '('params')' bloc          #StructFct
    ;

params :
      param?                                          #Parametre
    | (param ',')+ param                              #Parametres
    ;

param :
      'int' IDF                                       #IntParam
    | 'struct' IDF '*' IDF                            #StructPointer
    ;

bloc :
      '{'decl_vars* instruction*'}';

instruction :
      ';'                                             #None
    | expr ';'                                        #Expression
    | affect ';'                                      #Affectation
    | if_instruction                                  #IfInst
    | while_instruction                               #WhileInst
    | bloc                                            #BlocInst
    | 'return' expr ';'                               #Return
    ;

if_instruction :
      'if' '('expr')' instruction                     #IfThen
    | 'if' '('expr')' instruction 'else' instruction  #IfThenElse
    ;

while_instruction :
      'while' '('expr')' instruction;

affect :
      ((IDF|fleche) '=')+ expr;

expr :
      or_op;

or_op :
      et_op ('||' et_op)*;

et_op :
      egalite ('&&' egalite)*;

egalite :
      comparaison (('=='|'!=') comparaison)*;

comparaison :
      somme (('<'|'<='|'>'|'>=') somme)*;

somme :
      produit (('+'|'-') produit)*;

produit :
      oppose (('*'|'/') oppose)*;

oppose :
      ('!'|'-')?value;

fleche :
      (IDF '->')+ IDF;

value :
      INTEGER                                         #Integer
    | IDF                                             #Identifier
    | fleche                                          #Arrow
    | IDF '('((expr ',')* expr)?')'                   #Function
    | 'sizeof' '(''struct' IDF')'                     #Sizeof
    | '('expr')'                                      #Parenthesis
    ;


//lexer ruler
INTEGER :
      '0'
    | '1'..'9' ('0'..'9')*
    | '\'' [\u0020\u0021\u0023-\u0026\u0028-\u005B\u005D-\u007E] '\''
    | '\'' ('\u005C\u0027'|'\u005C\u0022'|'\u005C\u005C') '\''
    ;

IDF :
      ('a'..'z' | 'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9' | '_')* ;


// commenters
COMMENTERS :
      ('/*' .*? '*/'|'//' ~[\u000A\u000D]*) -> skip;


// skip
WS :
      ('\t' | ' ' | '\r' | '\n')+ -> skip;
