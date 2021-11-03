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
      STRUCT IDF '{' decl_vars* '}' SEMICOLON;

decl_vars :
      INT (IDF COMMA)* IDF SEMICOLON
    | STRUCT IDF ('*' IDF COMMA)* ('*' IDF) SEMICOLON
    ;

decl_fct :
      INT IDF '(' ((param)? | (param COMMA)+ param) ')' bloc
    | STRUCT IDF '*' IDF '('((param)? | (param COMMA)+ param)')' bloc
    ;

param :
      INT IDF
    | STRUCT IDF '*' IDF
    ;

bloc :
      '{' decl_vars* instruction* '}';

instruction :
      SEMICOLON
    | expr SEMICOLON
    | if_instruction
    | while_instruction
    | bloc
    | RETURN expr SEMICOLON
    ;

if_instruction :
      IF '('expr')' instruction
    | IF '('expr')' instruction ELSE instruction
    ;
    
while_instruction :
      WHILE '(' expr ')' instruction;

expr :
      INTEGER
    | IDF
    | expr '->' IDF
    | IDF '(' ((expr)? | (expr COMMA)+ expr) ')'
    | '!' expr
    | '-' expr
    | expr OPERATOR expr
    | SIZEOF '(' STRUCT IDF ')'
    | '(' expr ')'
    ;


//lexer ruler
OPERATOR :
      '=' | '==' | '!=' | '<' | '<=' | '>' | '>=' | '+' | '-' | '*' | '/' | '&&' | '||' ;

DIGITS :
      ('0'..'9') ;

INTEGER :
      '0'
    | '1'..'9' DIGITS*
    | '\''CHARACTERS'\'';

IDF :
      (LETTRE_MIN | LETTRE_MAJ)(LETTRE_MIN | LETTRE_MAJ | DIGITS | '_')* ;

LETTRE_MIN :
      ('a'..'z');

LETTRE_MAJ :
      ('A'..'Z');

CHARACTERS :
      [\u0020-\u007E]
    | '\\'
    | '\''
    | '\"'
    ;


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
      '/*' CHARACTERS* '*/' 
    | '//' CHARACTERS* 
    ;


// skip
WS :
      ('\t' | ' ' | '\r' | '\n')+ -> skip ;
