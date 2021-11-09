<<<<<<< HEAD
grammar grammaire1;
=======
grammar grammaire;
>>>>>>> 8c84be591d82ba45d2af867bf51cc73d05a0b209


@header{
package parser;
}


program : decl* EOF;

decl :
      decl_typ
    | decl_fct
    ;

decl_typ :
      STRUCT IDF '{'decl_vars*'}' SEMICOLON;

decl_vars :
      INT (IDF COMMA)* IDF SEMICOLON                  #IntDecl
    | STRUCT IDF ('*' IDF COMMA)* ('*' IDF) SEMICOLON #StructDecl
    ;

decl_fct :
      INT IDF '('params')' bloc                       #IntFct
    | STRUCT IDF '*' IDF '('params')' bloc            #StructFct
    ;

param :
      INT IDF                                         #IntParam
    | STRUCT IDF '*' IDF                              #StructPointer
    ;

bloc :
      '{'decl_vars* instruction*'}';

instruction :
      SEMICOLON                                       #None
<<<<<<< HEAD
    | expr SEMICOLON                                  #Expression
    | affect SEMICOLON                                #Affectation
    | if_instruction                                  #IfInst
    | while_instruction                               #WhileInst
    | bloc                                            #BlocInst
=======
    | expr SEMICOLON
    | affect SEMICOLON
    | if_instruction
    | while_instruction
    | bloc
>>>>>>> 8c84be591d82ba45d2af867bf51cc73d05a0b209
    | RETURN expr SEMICOLON                           #Return
    ;

if_instruction :
      IF '('expr')' instruction                       #IfThen
    | IF '('expr')' instruction ELSE instruction      #IfThenElse
    ;
<<<<<<< HEAD

=======
    
>>>>>>> 8c84be591d82ba45d2af867bf51cc73d05a0b209
while_instruction :
      WHILE '('expr')' instruction;

affect :    // est-ce qu'on peut faire a = b = c (plusieurs affectation) ?
      IDF '=' expr;

expr :
      or_op;

or_op :
<<<<<<< HEAD
      et_op ('||' et_op)*;
=======
      et_op (|| et_op)*;
>>>>>>> 8c84be591d82ba45d2af867bf51cc73d05a0b209

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

value :
      INTEGER                                         #Integer
    | IDF                                             #Identifier
    | IDF '->' IDF                                    #Arrow
    | IDF '('params')'                                #Function
    | SIZEOF '('STRUCT IDF')'                         #Sizeof
    | '('expr')'                                      #Parenthesis
    ;


// parameters
params :
      param? | (param COMMA)+ param;

<<<<<<< HEAD
//lexer ruler
OPERATOR :
      '==' | '!=' | '<' | '<=' | '>' | '>=' | '+' | '-' | '*' | '/' | '&&' | '||' ;

INTEGER :
      '0'
    | '1'..'9' ('0'..'9')*
    | '\'' [\u0020-\u007E] '\''
=======
// lexer rules
INTEGER :
      '0'
    | '1'..'9' ('0'..'9')*
    | '\''([\u0020-\u007E] | '\\' | '\'' | '\"')'\''
>>>>>>> 8c84be591d82ba45d2af867bf51cc73d05a0b209
    ;

IDF :
      ('a'..'z' | 'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9' | '_')* ;

CHARACTERS :
<<<<<<< HEAD
      [\u0020-\u007E];
=======
      [\u0020-\u007E]
    | '\\'
    | '\''
    | '\"'
    ;
>>>>>>> 8c84be591d82ba45d2af867bf51cc73d05a0b209


// semicolon and parentheses
SEMICOLON : ';' ;
COMMA : ',' ;


// key words
INT : 'int' ;
IF : 'if' ;
ELSE : 'else' ;
WHILE : 'while' ;
STRUCT : 'struct' ;
RETURN : 'return' ;
SIZEOF : 'sizeof' ;


// commenters
COMMENTERS :
<<<<<<< HEAD
      ('/*' [\u0000-\u007E]* '*/'|'//' [\u0000-\u007E]* ('\u000A' | '\u000D'))  -> skip;
    // ~[\u000A\u000D]
    // '/*' ([\u0020-\u007E] | '\\' | '\'' | '\"')* '*/'
    // | '//' ([\u0020-\u007E] | '\\' | '\'' | '\"')*
=======
     ( '/*' [\u0000-\u007E]* '*/'
    | '//' [\u0000-\u007E]* ('\u000A' | '\u000D') )  // ~[\u000A\u000D] )
    -> skip;
//       '/*' ([\u0020-\u007E] | '\\' | '\'' | '\"')* '*/' 
//     | '//' ([\u0020-\u007E] | '\\' | '\'' | '\"')* 
>>>>>>> 8c84be591d82ba45d2af867bf51cc73d05a0b209


// skip
WS :
      ('\t' | ' ' | '\r' | '\n')+ -> skip;
