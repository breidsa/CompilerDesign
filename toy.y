

%define api.parser.class {ToYParser}
%define api.parser.public
%define parse.error verbose


%code imports {
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer
}


%code {
public static void main(String[] args) throws IOException {
 ToYLexer l = new ToYLexer(System.in);
 ToYParser p = new ToYParser(l);
 if (!p.parse()) System.out.println("INVALID");
}
}

/* Bison Declarations */
/* Questions: does boolean and stuff have to come from the lexer?? */
%token <Integer> INT
%token <Identifier> BOOL STRING IDENTIFIER
%token <Boolean> TRUE FALSE IF THEN ELSE FOR
%token VOID RETURN PRINTF STRUCT
%token RBRACKET LBRACKET SEMICOLON LESSTHAN GREATERTHAN DOUBLEEQ LESSTHANOREQ GREATERTHANOREQ NOTEQ NOT LEFTPAREN RIGHTPAREN PLUS MINUS MULT DIVIDE EQ


%type type
%type returnType
%type input
%type declaration
%type line
%type exp
%type op
%type stmt
%type pgm
%type struct
%type string
%type proc


%start program

%%
    
    program:
    stmt {program}
    ;
    
    type: int | bool | string;
    
    returnType: type | void;
    
    input: line | input line;
    
    declaration: type IDENTIFIER;
    
    line: '\n'
    | exp '\n' { System.out.println($exp); }
    | error '\n'
    ;
    
    
    /* op : PLUS
    | MINUS 
    | MULT
    | DIVIDE
    | AND
    | OR
    */
    
    
    op  : PLUS
    | MINUS
    | MULT
    | DIVIDE
    | AND
    | OR
    | DOUBLEEQ
    | GREATERTHAN
    | LESSTHAN
    | GREATERTHANOREQ
    | LESSTHATOREQ
    | NOTEQ
    | EQ
    ;
   
    
    
    exp : INT
    | STRING 
    | TRUE
    | FALSE
    | exp op exp 
    | NOT exp 
    | l - exp 
    | LEFTPAREN exp RIGHTPAREN
    ;
    
     
    /* need help on struct */
    /* ask abt statement keyword*/
    stmt : FOR LEFTPAREN IDENTIFIER EQUAL exp SEMICOLON exp SEMICOLON < statement > RIGHTPAREN < statement >
    | IF LEFTPAREN exp RIGHTPAREN THEN < statement >
    | IF (< expr >) then < statement > else < statement >
    | printf (< string >) SEMICOLON
    | return <expr > SEMICOLON
    | { < statement - seq > } # compound statement
    | <type > <id > SEMICOLON # variable declaration
    | <l - exp > = <expr > SEMICOLON # assignment
    | <id >( < expr > ,...) SEMICOLON # void procedure call
    | id = <id >( < expr > ,...) SEMICOLON # non - void procedure call
    ;
    
    < statement - seq > : # empty sequence
    | <stmt > < statement - seq >
    ;
    
    <l - exp > : <id > | < id > . <l - exp >
    ;
    
    < pgm > : <proc > <pgm’>
    | < struct > <pgm > 
    ;
    
    < pgm’> : # empty sequence
    | <proc> <pgm’>
    | <struct> <pgm’>
    ;
    
    <struct> : <struct> <id> { < declaration >, < declaration >, ... }
    ;
    
    <proc> : <return_type> <id> ( < declaration >, ... ) { < statement > }
    ;
   
   

%%
    
    class ToYLexer implements ToY.L {
     InputStreamReader it;
     Yylex yylex;
     
     public ToYLexer(InputStream is){
     it = new InputStreamReader(is);
     yylex = new Yylex(it);
     }
     
     @Override
     public void yyerror (String s){
     System.err.println(s);
     }
     ParserToken yylval;
     
     @Override
     public Object getLVal() {
     // Returns the semantic value of the last token that yylex returned.
     return yylval;
     }
     
     @Override
     public int yylex () throws IOException{
     // Returns the next token. Here we get the next Token from the Lexer
     return yylex.yylex();
     }
    }
    
    /*
    class SymbolTable {
    enter_scope()
    exit_scope()
    
    }
    */


