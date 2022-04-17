
    recursePgm : /* empty sequence */ { $$ = new StmtList(); }
    | function recursePgm { StmtList pgm = (StmtList) $2; pgm.addElement($1); $$ = pgm; }
    | struct recursePgm  { StmtList pgm = (StmtList) $2; pgm.addElement($1); $$ = pgm; }
    ;

    // create pgm class that has a list of ASTNodes 
    pgm : function recursePgm { StmtList pgm = (StmtList) $2; pgm.addElement($1); $$ = pgm; }
    | struct recursePgm  { StmtList pgm = (StmtList) $2; pgm.addElement($1); $$ = pgm; }
    ;

    function : returnType IDENTIFIER LEFTPAREN declarationListZero RIGHTPAREN LBRACKET stmts RBRACKET {System.out.print("IN FUNCTION CALL");$$ = new FunctionConstruct($1, $2, $4, (StmtList)$7);
                                                                                                             Function ft = new Function($2, $1, (StmtList)$4); functions.put($2, ft);}
    ;
    
    struct : STRUCT IDENTIFIER LBRACKET declarationListOne RBRACKET { $$ = new StructCreator($2, (StmtList)$4); Struct st = new Struct($2,(StmtList)$4); statements.put($2, st);} /* {StmtList fieldTypes = new StmtList(); fieldTypes.addElement($4); $$ = new StructCreator($2, fieldTypes);} */
    ;  

    declarationListZero: /* empty */ {$$ = new StmtList();}  
    | declaration { System.out.println($$ = $1; }
    | declaration COMMA declarationList {StmtList decls = (StmtList) $3; decls.addElement($1); $$ = decls;} 
    ;    

    declarationList: declaration { $$ = $1; }
    | declaration COMMA declarationList {StmtList decls = (StmtList) $3; decls.addElement($1); $$ = decls;} 
    ;      

    declaration: type IDENTIFIER {System.out.print("IN DELC");$$ = new VarDef($1, $2); }
   
    ;

    stmtSeq : /* empty sequence */ { $$ = new StmtList();}
    | stmt stmtSeq { StmtList sequence = (StmtList) $2; sequence.addElement($1); $$ = sequence; }
    ;

    // type: INT { $$ = new VarDef($1, null); }
    // | BOOL { $$ = new VarDef($1, null); }
    // | STRING { $$ = new VarDef($1, null); }
    // ;
    
    type: INT { $$ = new Keyword($1); }
    | BOOL { $$ = new Keyword($1);}
    | STRING { System.out.print("IN TYPE CALL");$$ = new Keyword($1); }
    ;

    returnType: type { $$ = $1; }
    | VOID { $$ = new Keyword($1); }
    ;
    
                                                                

                   

                     
    

   
    
    param: IDENTIFIER {$$ = new VarDef(null, $1); } 
    ;

    paramList:  {$$ = new StmtList();}
    | paramList COMMA param {StmtList params = (StmtList) $1; params.addElement($3); $$ = params;}
    ;
    
    
    stmt : FOR LEFTPAREN IDENTIFIER EQ exp SEMICOLON exp SEMICOLON stmt RIGHTPAREN LBRACKET stmtSeq RBRACKET{ Asnmt iterator = new Asnmt($3, $5);
											               $$ = new ForLoop(iterator, $7, $9, (StmtList)$11);}
    | IF LEFTPAREN exp RIGHTPAREN LBRACKET stmtSeq RBRACKET SEMICOLON { $$ = new IfStmt($3, (StmtList) $6, null); }
    | IF LEFTPAREN exp RIGHTPAREN LBRACKET stmtSeq RBRACKET ELSE stmtSeq SEMICOLON { $$ = new IfStmt($3, (StmtList)$6, (StmtList)$9);}
    | PRINTF LEFTPAREN STRING RIGHTPAREN SEMICOLON { $$ = new EndFunction($1, $3); }
    | RETURN exp SEMICOLON { $$ = new EndFunction($1, $2); }
    | LBRACKET stmtSeq RBRACKET { $$ = $1; }
    | declaration SEMICOLON { $$ = $1; } \\TODO SWITCH ASSIGNMENT
    | IDENTIFIER EQ exp SEMICOLON { $$ = new Asnmt($1, $3); }
    | IDENTIFIER ATTRIBUTE Lexp EQ exp SEMICOLON { $$ = new Asnmt($3, $5); } \\TODO CHECK EXP 
    | IDENTIFIER LEFTPAREN exp RIGHTPAREN SEMICOLON { $$ = new Asnmt($1, $3); }
    | IDENTIFIER EQ LEFTPAREN exp RIGHTPAREN SEMICOLON { FunctionCall func = new FunctionCall($3, (StmtList) $4); $$ = new Asnmt($1, func); }  
    ;
    
    
    
    Lexp : param { StmtList emptyList = new StmtList(); emptyList.addElement($1); $$ = emptyList; }
    | param ATTRIBUTE Lexp { StmtList attributeList = (StmtList)$3; attributeList.addElement($1); $$ = attributeList; }
    ;
    
    // This will initially go to recurseProgram, and create an empty function that will either act as main, or just have the 1 required function
    // if there is only one in the test code
    
    
    
    exp : type { $$ = $1; }
    | TRUE { $$ = new Keyword($1); } 
    | FALSE { $$ = new Keyword($1); }
    | exp PLUS exp { $$ = new Arithmetic($1, $2, $3); }
    | exp MINUS exp { $$ = new Arithmetic($1,$2,$3); }
    | exp MULT exp { $$ = new Arithmetic($1, $2,$3); }
    | exp DIVIDE exp { $$ = new Arithmetic($1,$2, $3); }
    | exp MOD exp  { $$ = new Arithmetic($1,$2, $3); }
    | exp AND exp { $$ = new Logic($1, $2, $3); }
    | exp OR exp { $$ = new Logic($1, $2, $3); }
    | exp DOUBLEEQ exp { $$ = new Conditions($1, $2, $3); }
    | exp GREATERTHAN exp { $$ = new Conditions($1, $2, $3); }
    | exp LESSTHAN exp { $$ = new Conditions($1, $2, $3); }
    | exp GREATERTHANOREQ exp { $$ = new Conditions($1, $2, $3); }
    | exp LESSTHANOREQ exp { $$ = new Conditions($1, $2, $3); }
    | exp NOTEQ exp { $$ = new Conditions($1, $2, $3); }
    | IDENTIFIER EQ exp { $$ = new Asnmt($1, $3); }
    | NOT exp { $$ = new UnaryOperators($1, $2); }
    | MINUS exp { $$ = new UnaryOperators($1, $2); }
    | LEFTPAREN exp RIGHTPAREN { $$ = $2; }
    ;



/*
    pgm : function recursePgm 
    | struct pgm 
    ; 
    
    recursePgm : 
    | function recursePgm 
    | struct recursePgm  
    ; 


    function : returnType IDENTIFIER LEFTPAREN declarationListZero RIGHTPAREN LBRACKET stmts RBRACKET 
    ;

    struct : STRUCT IDENTIFIER LBRACKET declarationList RBRACKET 
    ;      

    declarationListZero: 
    | declaration
    | declaration COMMA declarationList
    ;    

    declarationList: declaration
    | declaration COMMA declarationList  
    ;      

    stmts :
    | stmt stmts 
    ;

    declaration: type IDENTIFIER 
    ;

    stmt : FOR LEFTPAREN IDENTIFIER EQ exp SEMICOLON exp SEMICOLON stmt RIGHTPAREN LBRACKET stmts RBRACKET 
    | IF LEFTPAREN exp RIGHTPAREN LBRACKET stmts RBRACKET 
    | IF LEFTPAREN exp RIGHTPAREN LBRACKET stmts RBRACKET ELSE LBRACKET stmt RBRACKET 
    | PRINTF LEFTPAREN STRING RIGHTPAREN SEMICOLON 
    | RETURN exp SEMICOLON
    | LBRACKET stmtSeq RBRACKET 
    | type IDENTIFIER SEMICOLON  
    | IDENTIFIER EQ exp SEMICOLON 
    | Lexp EQ exp SEMICOLON 
    | IDENTIFIER LEFTPAREN paramList RIGHTPAREN SEMICOLON
    | IDENTIFIER EQ IDENTIFIER LEFTPAREN paramList RIGHTPAREN SEMICOLON
    ;

    paramList: 
    | exp COMMA paramList 
    ;

    stmtSeq:
    | stmt COMMA stmts 
    ;

    type: INT 
    | BOOL 
    | STRING 
    ;


    // create pgm class that has a list of ASTNodes 
    returnType: type 
    | VOID 
    ;
    

    Lexp : exp 
    | exp ATTRIBUTE Lexp 
    ;


    

    exp : type 
    | TRUE 
    | FALSE 
    | exp PLUS exp 
    | exp MINUS exp
    | exp MULT exp  
    | exp DIVIDE exp 
    | exp MOD exp 
    | exp AND exp  
    | exp OR exp 
    | exp DOUBLEEQ exp
    | exp GREATERTHAN exp
    | exp LESSTHAN exp 
    | exp GREATERTHANOREQ exp 
    | exp LESSTHANOREQ exp 
    | exp NOTEQ exp 
    | IDENTIFIER EQ exp 
    | NOT exp 
    | MINUS exp 
    | LEFTPAREN exp RIGHTPAREN  
    ;
    
    
    

    

*/