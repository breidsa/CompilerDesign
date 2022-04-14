/* A Bison parser, made by GNU Bison 3.8.2.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2021 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */




import java.text.MessageFormat;
import java.util.ArrayList;
/* "%code imports" blocks.  */
/* "ToY.y":33  */

import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;

/* "ToY.java":55  */

/**
 * A Bison parser, automatically generated from <tt>ToY.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class ToY
{
  /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.8.2";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";



  /**
   * True if verbose error messages are enabled.
   */
  private boolean yyErrorVerbose = true;

  /**
   * Whether verbose error messages are enabled.
   */
  public final boolean getErrorVerbose() { return yyErrorVerbose; }

  /**
   * Set the verbosity of error messages.
   * @param verbose True to request verbose error messages.
   */
  public final void setErrorVerbose(boolean verbose)
  { yyErrorVerbose = verbose; }




  public enum SymbolKind
  {
    S_YYEOF(0),                    /* "end of file"  */
    S_YYerror(1),                  /* error  */
    S_YYUNDEF(2),                  /* "invalid token"  */
    S_INT(3),                      /* INT  */
    S_BOOL(4),                     /* BOOL  */
    S_STRING(5),                   /* STRING  */
    S_VOID(6),                     /* VOID  */
    S_IDENTIFIER(7),               /* IDENTIFIER  */
    S_COMMENT(8),                  /* COMMENT  */
    S_TRUE(9),                     /* TRUE  */
    S_FALSE(10),                   /* FALSE  */
    S_IF(11),                      /* IF  */
    S_THEN(12),                    /* THEN  */
    S_ELSE(13),                    /* ELSE  */
    S_FOR(14),                     /* FOR  */
    S_STRUCT(15),                  /* STRUCT  */
    S_RETURN(16),                  /* RETURN  */
    S_PRINTF(17),                  /* PRINTF  */
    S_SEMICOLON(18),               /* SEMICOLON  */
    S_COMMA(19),                   /* COMMA  */
    S_EQ(20),                      /* EQ  */
    S_ATTRIBUTE(21),               /* ATTRIBUTE  */
    S_RBRACKET(22),                /* RBRACKET  */
    S_LBRACKET(23),                /* LBRACKET  */
    S_LEFTPAREN(24),               /* LEFTPAREN  */
    S_RIGHTPAREN(25),              /* RIGHTPAREN  */
    S_LESSTHAN(26),                /* LESSTHAN  */
    S_GREATERTHAN(27),             /* GREATERTHAN  */
    S_DOUBLEEQ(28),                /* DOUBLEEQ  */
    S_LESSTHANOREQ(29),            /* LESSTHANOREQ  */
    S_GREATERTHANOREQ(30),         /* GREATERTHANOREQ  */
    S_NOTEQ(31),                   /* NOTEQ  */
    S_AND(32),                     /* AND  */
    S_OR(33),                      /* OR  */
    S_NOT(34),                     /* NOT  */
    S_PLUS(35),                    /* PLUS  */
    S_MINUS(36),                   /* MINUS  */
    S_MULT(37),                    /* MULT  */
    S_DIVIDE(38),                  /* DIVIDE  */
    S_MOD(39),                     /* MOD  */
    S_YYACCEPT(40),                /* $accept  */
    S_type(41),                    /* type  */
    S_returnType(42),              /* returnType  */
    S_struct(43),                  /* struct  */
    S_declaration(44),             /* declaration  */
    S_declarationList(45),         /* declarationList  */
    S_function(46),                /* function  */
    S_param(47),                   /* param  */
    S_paramList(48),               /* paramList  */
    S_stmt(49),                    /* stmt  */
    S_stmtSeq(50),                 /* stmtSeq  */
    S_Lexp(51),                    /* Lexp  */
    S_pgm(52),                     /* pgm  */
    S_recursePgm(53),              /* recursePgm  */
    S_exp(54);                     /* exp  */


    private final int yycode_;

    SymbolKind (int n) {
      this.yycode_ = n;
    }

    private static final SymbolKind[] values_ = {
      SymbolKind.S_YYEOF,
      SymbolKind.S_YYerror,
      SymbolKind.S_YYUNDEF,
      SymbolKind.S_INT,
      SymbolKind.S_BOOL,
      SymbolKind.S_STRING,
      SymbolKind.S_VOID,
      SymbolKind.S_IDENTIFIER,
      SymbolKind.S_COMMENT,
      SymbolKind.S_TRUE,
      SymbolKind.S_FALSE,
      SymbolKind.S_IF,
      SymbolKind.S_THEN,
      SymbolKind.S_ELSE,
      SymbolKind.S_FOR,
      SymbolKind.S_STRUCT,
      SymbolKind.S_RETURN,
      SymbolKind.S_PRINTF,
      SymbolKind.S_SEMICOLON,
      SymbolKind.S_COMMA,
      SymbolKind.S_EQ,
      SymbolKind.S_ATTRIBUTE,
      SymbolKind.S_RBRACKET,
      SymbolKind.S_LBRACKET,
      SymbolKind.S_LEFTPAREN,
      SymbolKind.S_RIGHTPAREN,
      SymbolKind.S_LESSTHAN,
      SymbolKind.S_GREATERTHAN,
      SymbolKind.S_DOUBLEEQ,
      SymbolKind.S_LESSTHANOREQ,
      SymbolKind.S_GREATERTHANOREQ,
      SymbolKind.S_NOTEQ,
      SymbolKind.S_AND,
      SymbolKind.S_OR,
      SymbolKind.S_NOT,
      SymbolKind.S_PLUS,
      SymbolKind.S_MINUS,
      SymbolKind.S_MULT,
      SymbolKind.S_DIVIDE,
      SymbolKind.S_MOD,
      SymbolKind.S_YYACCEPT,
      SymbolKind.S_type,
      SymbolKind.S_returnType,
      SymbolKind.S_struct,
      SymbolKind.S_declaration,
      SymbolKind.S_declarationList,
      SymbolKind.S_function,
      SymbolKind.S_param,
      SymbolKind.S_paramList,
      SymbolKind.S_stmt,
      SymbolKind.S_stmtSeq,
      SymbolKind.S_Lexp,
      SymbolKind.S_pgm,
      SymbolKind.S_recursePgm,
      SymbolKind.S_exp
    };

    static final SymbolKind get(int code) {
      return values_[code];
    }

    public final int getCode() {
      return this.yycode_;
    }

    /* Return YYSTR after stripping away unnecessary quotes and
       backslashes, so that it's suitable for yyerror.  The heuristic is
       that double-quoting is unnecessary unless the string contains an
       apostrophe, a comma, or backslash (other than backslash-backslash).
       YYSTR is taken from yytname.  */
    private static String yytnamerr_(String yystr)
    {
      if (yystr.charAt (0) == '"')
        {
          StringBuffer yyr = new StringBuffer();
          strip_quotes: for (int i = 1; i < yystr.length(); i++)
            switch (yystr.charAt(i))
              {
              case '\'':
              case ',':
                break strip_quotes;

              case '\\':
                if (yystr.charAt(++i) != '\\')
                  break strip_quotes;
                /* Fall through.  */
              default:
                yyr.append(yystr.charAt(i));
                break;

              case '"':
                return yyr.toString();
              }
        }
      return yystr;
    }

    /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
       First, the terminals, then, starting at \a YYNTOKENS_, nonterminals.  */
    private static final String[] yytname_ = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "\"end of file\"", "error", "\"invalid token\"", "INT", "BOOL",
  "STRING", "VOID", "IDENTIFIER", "COMMENT", "TRUE", "FALSE", "IF", "THEN",
  "ELSE", "FOR", "STRUCT", "RETURN", "PRINTF", "SEMICOLON", "COMMA", "EQ",
  "ATTRIBUTE", "RBRACKET", "LBRACKET", "LEFTPAREN", "RIGHTPAREN",
  "LESSTHAN", "GREATERTHAN", "DOUBLEEQ", "LESSTHANOREQ", "GREATERTHANOREQ",
  "NOTEQ", "AND", "OR", "NOT", "PLUS", "MINUS", "MULT", "DIVIDE", "MOD",
  "$accept", "type", "returnType", "struct", "declaration",
  "declarationList", "function", "param", "paramList", "stmt", "stmtSeq",
  "Lexp", "pgm", "recursePgm", "exp", null
    };
  }

    /* The user-facing name of this symbol.  */
    public final String getName() {
      return yytnamerr_(yytname_[yycode_]);
    }

  };


  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>ToY</tt>.
   */
  public interface Lexer {
    /* Token kinds.  */
    /** Token "end of file", to be returned by the scanner.  */
    static final int YYEOF = 0;
    /** Token error, to be returned by the scanner.  */
    static final int YYerror = 256;
    /** Token "invalid token", to be returned by the scanner.  */
    static final int YYUNDEF = 257;
    /** Token INT, to be returned by the scanner.  */
    static final int INT = 258;
    /** Token BOOL, to be returned by the scanner.  */
    static final int BOOL = 259;
    /** Token STRING, to be returned by the scanner.  */
    static final int STRING = 260;
    /** Token VOID, to be returned by the scanner.  */
    static final int VOID = 261;
    /** Token IDENTIFIER, to be returned by the scanner.  */
    static final int IDENTIFIER = 262;
    /** Token COMMENT, to be returned by the scanner.  */
    static final int COMMENT = 263;
    /** Token TRUE, to be returned by the scanner.  */
    static final int TRUE = 264;
    /** Token FALSE, to be returned by the scanner.  */
    static final int FALSE = 265;
    /** Token IF, to be returned by the scanner.  */
    static final int IF = 266;
    /** Token THEN, to be returned by the scanner.  */
    static final int THEN = 267;
    /** Token ELSE, to be returned by the scanner.  */
    static final int ELSE = 268;
    /** Token FOR, to be returned by the scanner.  */
    static final int FOR = 269;
    /** Token STRUCT, to be returned by the scanner.  */
    static final int STRUCT = 270;
    /** Token RETURN, to be returned by the scanner.  */
    static final int RETURN = 271;
    /** Token PRINTF, to be returned by the scanner.  */
    static final int PRINTF = 272;
    /** Token SEMICOLON, to be returned by the scanner.  */
    static final int SEMICOLON = 273;
    /** Token COMMA, to be returned by the scanner.  */
    static final int COMMA = 274;
    /** Token EQ, to be returned by the scanner.  */
    static final int EQ = 275;
    /** Token ATTRIBUTE, to be returned by the scanner.  */
    static final int ATTRIBUTE = 276;
    /** Token RBRACKET, to be returned by the scanner.  */
    static final int RBRACKET = 277;
    /** Token LBRACKET, to be returned by the scanner.  */
    static final int LBRACKET = 278;
    /** Token LEFTPAREN, to be returned by the scanner.  */
    static final int LEFTPAREN = 279;
    /** Token RIGHTPAREN, to be returned by the scanner.  */
    static final int RIGHTPAREN = 280;
    /** Token LESSTHAN, to be returned by the scanner.  */
    static final int LESSTHAN = 281;
    /** Token GREATERTHAN, to be returned by the scanner.  */
    static final int GREATERTHAN = 282;
    /** Token DOUBLEEQ, to be returned by the scanner.  */
    static final int DOUBLEEQ = 283;
    /** Token LESSTHANOREQ, to be returned by the scanner.  */
    static final int LESSTHANOREQ = 284;
    /** Token GREATERTHANOREQ, to be returned by the scanner.  */
    static final int GREATERTHANOREQ = 285;
    /** Token NOTEQ, to be returned by the scanner.  */
    static final int NOTEQ = 286;
    /** Token AND, to be returned by the scanner.  */
    static final int AND = 287;
    /** Token OR, to be returned by the scanner.  */
    static final int OR = 288;
    /** Token NOT, to be returned by the scanner.  */
    static final int NOT = 289;
    /** Token PLUS, to be returned by the scanner.  */
    static final int PLUS = 290;
    /** Token MINUS, to be returned by the scanner.  */
    static final int MINUS = 291;
    /** Token MULT, to be returned by the scanner.  */
    static final int MULT = 292;
    /** Token DIVIDE, to be returned by the scanner.  */
    static final int DIVIDE = 293;
    /** Token MOD, to be returned by the scanner.  */
    static final int MOD = 294;

    /** Deprecated, use YYEOF instead.  */
    public static final int EOF = YYEOF;


    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex() throws java.io.IOException;

    /**
     * Emit an errorin a user-defined way.
     *
     *
     * @param msg The string for the error message.
     */
     void yyerror(String msg);


  }


  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;





  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public ToY(Lexer yylexer)
  {

    this.yylexer = yylexer;

  }



  private int yynerrs = 0;

  /**
   * The number of syntax errors so far.
   */
  public final int getNumberOfErrors() { return yynerrs; }

  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror(String msg) {
      yylexer.yyerror(msg);
  }



  private final class YYStack {
    private int[] stateStack = new int[16];
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push(int state, Object value) {
      height++;
      if (size == height) {
        int[] newStateStack = new int[size * 2];
        System.arraycopy(stateStack, 0, newStateStack, 0, height);
        stateStack = newStateStack;

        Object[] newValueStack = new Object[size * 2];
        System.arraycopy(valueStack, 0, newValueStack, 0, height);
        valueStack = newValueStack;

        size *= 2;
      }

      stateStack[height] = state;
      valueStack[height] = value;
    }

    public final void pop() {
      pop(1);
    }

    public final void pop(int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (0 < num) {
        java.util.Arrays.fill(valueStack, height - num + 1, height + 1, null);
      }
      height -= num;
    }

    public final int stateAt(int i) {
      return stateStack[height - i];
    }

    public final Object valueAt(int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print(java.io.PrintStream out) {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++) {
        out.print(' ');
        out.print(stateStack[i]);
      }
      out.println();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yyLRGotoState(int yystate, int yysym) {
    int yyr = yypgoto_[yysym - YYNTOKENS_] + yystate;
    if (0 <= yyr && yyr <= YYLAST_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - YYNTOKENS_];
  }

  private int yyaction(int yyn, YYStack yystack, int yylen)
  {
    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    Object yyval = (0 < yylen) ? yystack.valueAt(yylen - 1) : yystack.valueAt(0);

    switch (yyn)
      {
          case 2: /* type: INT  */
  if (yyn == 2)
    /* "ToY.y":105  */
              { yyval = new VarDef(yystack.valueAt (0), null); };
  break;


  case 3: /* type: BOOL  */
  if (yyn == 3)
    /* "ToY.y":106  */
           { yyval = new VarDef(yystack.valueAt (0), null); };
  break;


  case 4: /* type: STRING  */
  if (yyn == 4)
    /* "ToY.y":107  */
             { yyval = new VarDef(yystack.valueAt (0), null); };
  break;


  case 5: /* returnType: type  */
  if (yyn == 5)
    /* "ToY.y":110  */
                     { yyval = yystack.valueAt (0); };
  break;


  case 6: /* returnType: VOID  */
  if (yyn == 6)
    /* "ToY.y":111  */
           { yyval = new Keyword(yystack.valueAt (0)); };
  break;


  case 7: /* struct: STRUCT IDENTIFIER LBRACKET declarationList RBRACKET  */
  if (yyn == 7)
    /* "ToY.y":114  */
                                                                 { yyval = new StructCreator(yystack.valueAt (3), (StmtList)yystack.valueAt (1)); Struct st = new Struct(yystack.valueAt (3),(StmtList)yystack.valueAt (1)); statements.put(yystack.valueAt (3), st);};
  break;


  case 8: /* declaration: type IDENTIFIER  */
  if (yyn == 8)
    /* "ToY.y":118  */
                                 {yyval = new VarDef(yystack.valueAt (1), yystack.valueAt (0)); };
  break;


  case 9: /* declaration: COMMA IDENTIFIER  */
  if (yyn == 9)
    /* "ToY.y":119  */
                       {yyval = new VarDef(null, yystack.valueAt (0));};
  break;


  case 10: /* declarationList: %empty  */
  if (yyn == 10)
    /* "ToY.y":122  */
                                 {yyval = new StmtList();};
  break;


  case 11: /* declarationList: declarationList COMMA declaration  */
  if (yyn == 11)
    /* "ToY.y":123  */
                                        {StmtList decls = (StmtList) yystack.valueAt (2); decls.addElement(yystack.valueAt (0)); yyval = decls;};
  break;


  case 12: /* function: returnType IDENTIFIER LEFTPAREN declarationList RIGHTPAREN LBRACKET stmtSeq RBRACKET SEMICOLON  */
  if (yyn == 12)
    /* "ToY.y":127  */
                                                                                                              {yyval = new FunctionConstruct(yystack.valueAt (8), yystack.valueAt (7), yystack.valueAt (5), (StmtList)yystack.valueAt (2));
                                                                                                             Function ft = new Function(yystack.valueAt (7), yystack.valueAt (8), (StmtList)yystack.valueAt (5)); functions.put(yystack.valueAt (7), ft);};
  break;


  case 13: /* param: IDENTIFIER  */
  if (yyn == 13)
    /* "ToY.y":131  */
                      {yyval = new VarDef(null, yystack.valueAt (0)); };
  break;


  case 14: /* paramList: %empty  */
  if (yyn == 14)
    /* "ToY.y":134  */
                {yyval = new StmtList();};
  break;


  case 15: /* paramList: paramList COMMA param  */
  if (yyn == 15)
    /* "ToY.y":135  */
                            {StmtList params = (StmtList) yystack.valueAt (2); params.addElement(yystack.valueAt (0)); yyval = params;};
  break;


  case 16: /* stmt: FOR LEFTPAREN IDENTIFIER EQ exp SEMICOLON exp SEMICOLON stmt RIGHTPAREN stmtSeq SEMICOLON  */
  if (yyn == 16)
    /* "ToY.y":140  */
                                                                                                     { Asnmt iterator = new Asnmt(yystack.valueAt (9), yystack.valueAt (7));
											               yyval = new ForLoop(iterator, yystack.valueAt (5), yystack.valueAt (3), (StmtList)yystack.valueAt (1));};
  break;


  case 17: /* stmt: IF LEFTPAREN exp RIGHTPAREN THEN stmtSeq SEMICOLON  */
  if (yyn == 17)
    /* "ToY.y":142  */
                                                         { yyval = new IfStmt(yystack.valueAt (4), (StmtList) yystack.valueAt (1), null); };
  break;


  case 18: /* stmt: IF LEFTPAREN exp RIGHTPAREN THEN stmtSeq ELSE stmtSeq SEMICOLON  */
  if (yyn == 18)
    /* "ToY.y":143  */
                                                                      { yyval = new IfStmt(yystack.valueAt (6), (StmtList)yystack.valueAt (3), (StmtList)yystack.valueAt (1));};
  break;


  case 19: /* stmt: PRINTF LEFTPAREN STRING RIGHTPAREN SEMICOLON  */
  if (yyn == 19)
    /* "ToY.y":144  */
                                                   { yyval = new EndFunction(yystack.valueAt (3)); };
  break;


  case 20: /* stmt: RETURN exp SEMICOLON  */
  if (yyn == 20)
    /* "ToY.y":145  */
                           { yyval = new EndFunction(yystack.valueAt (1)); };
  break;


  case 21: /* stmt: LBRACKET stmtSeq RBRACKET  */
  if (yyn == 21)
    /* "ToY.y":146  */
                                { yyval = yystack.valueAt (2); };
  break;


  case 22: /* stmt: declaration SEMICOLON  */
  if (yyn == 22)
    /* "ToY.y":147  */
                            { yyval = yystack.valueAt (1); };
  break;


  case 23: /* stmt: Lexp EQ exp SEMICOLON  */
  if (yyn == 23)
    /* "ToY.y":148  */
                            { yyval = new Asnmt(yystack.valueAt (3), yystack.valueAt (1)); };
  break;


  case 24: /* stmt: IDENTIFIER paramList SEMICOLON  */
  if (yyn == 24)
    /* "ToY.y":149  */
                                     { yyval = new FunctionCall(yystack.valueAt (2), yystack.valueAt (1)); };
  break;


  case 25: /* stmt: IDENTIFIER EQ IDENTIFIER paramList SEMICOLON  */
  if (yyn == 25)
    /* "ToY.y":150  */
                                                   { FunctionCall func = new FunctionCall(yystack.valueAt (2), (StmtList) yystack.valueAt (1)); yyval = new Asnmt(yystack.valueAt (4), func); };
  break;


  case 26: /* stmtSeq: %empty  */
  if (yyn == 26)
    /* "ToY.y":153  */
                                   { yyval = new StmtList();};
  break;


  case 27: /* stmtSeq: stmt SEMICOLON stmtSeq  */
  if (yyn == 27)
    /* "ToY.y":154  */
                             { StmtList sequence = (StmtList) yystack.valueAt (0); sequence.addElement(yystack.valueAt (2)); yyval = sequence; };
  break;


  case 28: /* Lexp: param  */
  if (yyn == 28)
    /* "ToY.y":157  */
                 { StmtList emptyList = new StmtList(); emptyList.addElement(yystack.valueAt (0)); yyval = emptyList; };
  break;


  case 29: /* Lexp: param ATTRIBUTE Lexp  */
  if (yyn == 29)
    /* "ToY.y":158  */
                           { StmtList attributeList = (StmtList)yystack.valueAt (0); attributeList.addElement(yystack.valueAt (2)); yyval = attributeList; };
  break;


  case 30: /* pgm: recursePgm  */
  if (yyn == 30)
    /* "ToY.y":165  */
                     { yyval = yystack.valueAt (0); };
  break;


  case 31: /* recursePgm: %empty  */
  if (yyn == 31)
    /* "ToY.y":168  */
                                      { yyval = new StmtList(); };
  break;


  case 32: /* recursePgm: function recursePgm  */
  if (yyn == 32)
    /* "ToY.y":169  */
                          { StmtList pgm = (StmtList) yystack.valueAt (0); pgm.addElement(yystack.valueAt (1)); yyval = pgm; };
  break;


  case 33: /* recursePgm: struct recursePgm  */
  if (yyn == 33)
    /* "ToY.y":170  */
                         { StmtList pgm = (StmtList) yystack.valueAt (0); pgm.addElement(yystack.valueAt (1)); yyval = pgm; };
  break;


  case 34: /* exp: type  */
  if (yyn == 34)
    /* "ToY.y":173  */
               { yyval = yystack.valueAt (0); };
  break;


  case 35: /* exp: TRUE  */
  if (yyn == 35)
    /* "ToY.y":174  */
           { yyval = new Keyword(yystack.valueAt (0)); };
  break;


  case 36: /* exp: FALSE  */
  if (yyn == 36)
    /* "ToY.y":175  */
            { yyval = new Keyword(yystack.valueAt (0)); };
  break;


  case 37: /* exp: exp PLUS exp  */
  if (yyn == 37)
    /* "ToY.y":176  */
                   { yyval = new Arithmetic(yystack.valueAt (2), yystack.valueAt (1), yystack.valueAt (0)); };
  break;


  case 38: /* exp: exp MINUS exp  */
  if (yyn == 38)
    /* "ToY.y":177  */
                    { yyval = new Arithmetic(yystack.valueAt (2),yystack.valueAt (1),yystack.valueAt (0)); };
  break;


  case 39: /* exp: exp MULT exp  */
  if (yyn == 39)
    /* "ToY.y":178  */
                   { yyval = new Arithmetic(yystack.valueAt (2), yystack.valueAt (1),yystack.valueAt (0)); };
  break;


  case 40: /* exp: exp DIVIDE exp  */
  if (yyn == 40)
    /* "ToY.y":179  */
                     { yyval = new Arithmetic(yystack.valueAt (2),yystack.valueAt (1), yystack.valueAt (0)); };
  break;


  case 41: /* exp: exp MOD exp  */
  if (yyn == 41)
    /* "ToY.y":180  */
                   { yyval = new Arithmetic(yystack.valueAt (2),yystack.valueAt (1), yystack.valueAt (0)); };
  break;


  case 42: /* exp: exp AND exp  */
  if (yyn == 42)
    /* "ToY.y":181  */
                  { yyval = new Logic(yystack.valueAt (2), yystack.valueAt (1), yystack.valueAt (0)); };
  break;


  case 43: /* exp: exp OR exp  */
  if (yyn == 43)
    /* "ToY.y":182  */
                 { yyval = new Logic(yystack.valueAt (2), yystack.valueAt (1), yystack.valueAt (0)); };
  break;


  case 44: /* exp: exp DOUBLEEQ exp  */
  if (yyn == 44)
    /* "ToY.y":183  */
                       { yyval = new Conditions(yystack.valueAt (2), yystack.valueAt (1), yystack.valueAt (0)); };
  break;


  case 45: /* exp: exp GREATERTHAN exp  */
  if (yyn == 45)
    /* "ToY.y":184  */
                          { yyval = new Conditions(yystack.valueAt (2), yystack.valueAt (1), yystack.valueAt (0)); };
  break;


  case 46: /* exp: exp LESSTHAN exp  */
  if (yyn == 46)
    /* "ToY.y":185  */
                       { yyval = new Conditions(yystack.valueAt (2), yystack.valueAt (1), yystack.valueAt (0)); };
  break;


  case 47: /* exp: exp GREATERTHANOREQ exp  */
  if (yyn == 47)
    /* "ToY.y":186  */
                              { yyval = new Conditions(yystack.valueAt (2), yystack.valueAt (1), yystack.valueAt (0)); };
  break;


  case 48: /* exp: exp LESSTHANOREQ exp  */
  if (yyn == 48)
    /* "ToY.y":187  */
                           { yyval = new Conditions(yystack.valueAt (2), yystack.valueAt (1), yystack.valueAt (0)); };
  break;


  case 49: /* exp: exp NOTEQ exp  */
  if (yyn == 49)
    /* "ToY.y":188  */
                    { yyval = new Conditions(yystack.valueAt (2), yystack.valueAt (1), yystack.valueAt (0)); };
  break;


  case 50: /* exp: exp EQ exp  */
  if (yyn == 50)
    /* "ToY.y":189  */
                 { yyval = new Asnmt(yystack.valueAt (2), yystack.valueAt (0)); };
  break;


  case 51: /* exp: NOT exp  */
  if (yyn == 51)
    /* "ToY.y":190  */
              { yyval = new UnaryOperators(yystack.valueAt (1), yystack.valueAt (0)); };
  break;


  case 52: /* exp: MINUS exp  */
  if (yyn == 52)
    /* "ToY.y":191  */
                { yyval = new UnaryOperators(yystack.valueAt (1), yystack.valueAt (0)); };
  break;


  case 53: /* exp: LEFTPAREN exp RIGHTPAREN  */
  if (yyn == 53)
    /* "ToY.y":192  */
                               { yyval = yystack.valueAt (1); };
  break;



/* "ToY.java":932  */

        default: break;
      }

    yystack.pop(yylen);
    yylen = 0;
    /* Shift the result of the reduction.  */
    int yystate = yyLRGotoState(yystack.stateAt(0), yyr1_[yyn]);
    yystack.push(yystate, yyval);
    return YYNEWSTATE;
  }




  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
  public boolean parse() throws java.io.IOException

  {


    /* Lookahead token kind.  */
    int yychar = YYEMPTY_;
    /* Lookahead symbol kind.  */
    SymbolKind yytoken = null;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;



    /* Semantic value of the lookahead.  */
    Object yylval = null;



    yyerrstatus_ = 0;
    yynerrs = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval);



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:

        /* Accept?  */
        if (yystate == YYFINAL_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yyPactValueIsDefault (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == YYEMPTY_)
          {

            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal();

          }

        /* Convert token to internal form.  */
        yytoken = yytranslate_ (yychar);

        if (yytoken == SymbolKind.S_YYerror)
          {
            // The scanner already issued an error message, process directly
            // to error recovery.  But do not keep the error token as
            // lookahead, it is too special and may lead us to an endless
            // loop in error recovery. */
            yychar = Lexer.YYUNDEF;
            yytoken = SymbolKind.S_YYUNDEF;
            label = YYERRLAB1;
          }
        else
          {
            /* If the proper action on seeing token YYTOKEN is to reduce or to
               detect an error, take that action.  */
            yyn += yytoken.getCode();
            if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode()) {
              label = YYDEFAULT;
            }

            /* <= 0 means reduce or error.  */
            else if ((yyn = yytable_[yyn]) <= 0)
              {
                if (yyTableValueIsError(yyn)) {
                  label = YYERRLAB;
                } else {
                  yyn = -yyn;
                  label = YYREDUCE;
                }
              }

            else
              {
                /* Shift the lookahead token.  */
                /* Discard the token being shifted.  */
                yychar = YYEMPTY_;

                /* Count tokens shifted since error; after three, turn off error
                   status.  */
                if (yyerrstatus_ > 0)
                  --yyerrstatus_;

                yystate = yyn;
                yystack.push(yystate, yylval);
                label = YYNEWSTATE;
              }
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction(yyn, yystack, yylen);
        yystate = yystack.stateAt(0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs;
            if (yychar == YYEMPTY_)
              yytoken = null;
            yyreportSyntaxError(new Context(this, yystack, yytoken));
          }

        if (yyerrstatus_ == 3)
          {
            /* If just tried and failed to reuse lookahead token after an
               error, discard it.  */

            if (yychar <= Lexer.YYEOF)
              {
                /* Return failure if at end of input.  */
                if (yychar == Lexer.YYEOF)
                  return false;
              }
            else
              yychar = YYEMPTY_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt(0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        // Pop stack until we find a state that shifts the error token.
        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yyPactValueIsDefault (yyn))
              {
                yyn += SymbolKind.S_YYerror.getCode();
                if (0 <= yyn && yyn <= YYLAST_
                    && yycheck_[yyn] == SymbolKind.S_YYerror.getCode())
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;


            yystack.pop ();
            yystate = yystack.stateAt(0);
          }

        if (label == YYABORT)
          /* Leave the switch.  */
          break;



        /* Shift the error token.  */

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  /**
   * Information needed to get the list of expected tokens and to forge
   * a syntax error diagnostic.
   */
  public static final class Context {
    Context(ToY parser, YYStack stack, SymbolKind token) {
      yyparser = parser;
      yystack = stack;
      yytoken = token;
    }

    private ToY yyparser;
    private YYStack yystack;


    /**
     * The symbol kind of the lookahead token.
     */
    public final SymbolKind getToken() {
      return yytoken;
    }

    private SymbolKind yytoken;
    static final int NTOKENS = ToY.YYNTOKENS_;

    /**
     * Put in YYARG at most YYARGN of the expected tokens given the
     * current YYCTX, and return the number of tokens stored in YYARG.  If
     * YYARG is null, return the number of expected tokens (guaranteed to
     * be less than YYNTOKENS).
     */
    int getExpectedTokens(SymbolKind yyarg[], int yyargn) {
      return getExpectedTokens (yyarg, 0, yyargn);
    }

    int getExpectedTokens(SymbolKind yyarg[], int yyoffset, int yyargn) {
      int yycount = yyoffset;
      int yyn = yypact_[this.yystack.stateAt(0)];
      if (!yyPactValueIsDefault(yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative
             indexes in YYCHECK.  In other words, skip the first
             -YYN actions for this state because they are default
             actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST_ - yyn + 1;
          int yyxend = yychecklim < NTOKENS ? yychecklim : NTOKENS;
          for (int yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck_[yyx + yyn] == yyx && yyx != SymbolKind.S_YYerror.getCode()
                && !yyTableValueIsError(yytable_[yyx + yyn]))
              {
                if (yyarg == null)
                  yycount += 1;
                else if (yycount == yyargn)
                  return 0; // FIXME: this is incorrect.
                else
                  yyarg[yycount++] = SymbolKind.get(yyx);
              }
        }
      if (yyarg != null && yycount == yyoffset && yyoffset < yyargn)
        yyarg[yycount] = null;
      return yycount - yyoffset;
    }
  }




  private int yysyntaxErrorArguments(Context yyctx, SymbolKind[] yyarg, int yyargn) {
    /* There are many possibilities here to consider:
       - If this state is a consistent state with a default action,
         then the only way this function was invoked is if the
         default action is an error action.  In that case, don't
         check for expected tokens because there are none.
       - The only way there can be no lookahead present (in tok) is
         if this state is a consistent state with a default action.
         Thus, detecting the absence of a lookahead is sufficient to
         determine that there is no unexpected or expected token to
         report.  In that case, just report a simple "syntax error".
       - Don't assume there isn't a lookahead just because this
         state is a consistent state with a default action.  There
         might have been a previous inconsistent state, consistent
         state with a non-default action, or user semantic action
         that manipulated yychar.  (However, yychar is currently out
         of scope during semantic actions.)
       - Of course, the expected token list depends on states to
         have correct lookahead information, and it depends on the
         parser not to perform extra reductions after fetching a
         lookahead from the scanner and before detecting a syntax
         error.  Thus, state merging (from LALR or IELR) and default
         reductions corrupt the expected token list.  However, the
         list is correct for canonical LR with one exception: it
         will still contain any token that will not be accepted due
         to an error action in a later state.
    */
    int yycount = 0;
    if (yyctx.getToken() != null)
      {
        if (yyarg != null)
          yyarg[yycount] = yyctx.getToken();
        yycount += 1;
        yycount += yyctx.getExpectedTokens(yyarg, 1, yyargn);
      }
    return yycount;
  }


  /**
   * Build and emit a "syntax error" message in a user-defined way.
   *
   * @param ctx  The context of the error.
   */
  private void yyreportSyntaxError(Context yyctx) {
      if (yyErrorVerbose) {
          final int argmax = 5;
          SymbolKind[] yyarg = new SymbolKind[argmax];
          int yycount = yysyntaxErrorArguments(yyctx, yyarg, argmax);
          String[] yystr = new String[yycount];
          for (int yyi = 0; yyi < yycount; ++yyi) {
              yystr[yyi] = yyarg[yyi].getName();
          }
          String yyformat;
          switch (yycount) {
              default:
              case 0: yyformat = "syntax error"; break;
              case 1: yyformat = "syntax error, unexpected {0}"; break;
              case 2: yyformat = "syntax error, unexpected {0}, expecting {1}"; break;
              case 3: yyformat = "syntax error, unexpected {0}, expecting {1} or {2}"; break;
              case 4: yyformat = "syntax error, unexpected {0}, expecting {1} or {2} or {3}"; break;
              case 5: yyformat = "syntax error, unexpected {0}, expecting {1} or {2} or {3} or {4}"; break;
          }
          yyerror(new MessageFormat(yyformat).format(yystr));
      } else {
          yyerror("syntax error");
      }
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yyPactValueIsDefault(int yyvalue) {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yyTableValueIsError(int yyvalue) {
    return yyvalue == yytable_ninf_;
  }

  private static final short yypact_ninf_ = -35;
  private static final byte yytable_ninf_ = -14;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
      47,   -35,   -35,   -35,   -35,     3,   -35,     7,    47,    47,
      19,   -35,     6,     8,   -35,   -35,   -35,   -35,   -35,    46,
     -12,     1,   -35,    38,    64,    65,   -35,   180,   -35,   -35,
     -18,    49,    50,    54,    51,   180,    58,    59,    63,    57,
      67,    78,    36,    54,    84,   -35,   -35,    54,    54,    54,
     -35,    66,    95,    85,   -35,   101,   180,    88,    54,   -35,
     -35,   101,   181,    89,   201,    -8,    -8,   -35,    54,    54,
      54,    54,    54,    54,    54,    54,    54,    54,    54,    54,
      54,    54,    87,   -35,   -35,   -35,   -35,   -35,    99,    48,
     -35,    98,    54,   -35,   215,   229,   229,   229,   229,   229,
     229,   215,   215,    -8,    -8,    -2,    -2,    -2,    96,   -35,
     -35,   180,   121,   -35,    10,    54,   180,   -35,   143,    97,
     180,   -35,    93,   180,   103,   -35
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte[] yydefact_ = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
      31,     2,     3,     4,     6,     0,     5,     0,    31,    31,
       0,    30,     0,     0,    33,    32,     1,    10,    10,     0,
       0,     0,     7,     0,     0,     0,    11,    26,     9,     8,
      14,     0,     0,     0,     0,    26,     0,    28,     0,     0,
       0,     0,     0,     0,     0,    35,    36,     0,     0,     0,
      34,     0,     0,     0,    22,     0,    26,     0,     0,    14,
      24,     0,     0,     0,     0,    51,    52,    20,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,    21,    13,    29,    27,    12,     0,     0,
      15,     0,     0,    53,    50,    46,    45,    44,    48,    47,
      49,    42,    43,    37,    38,    39,    40,    41,     0,    23,
      25,    26,     0,    19,     0,     0,    26,    17,     0,     0,
       0,    18,     0,    26,     0,    16
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte[] yypgoto_ = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -35,     0,   -35,   -35,    92,   104,   -35,    72,    81,     4,
     -34,    90,   -35,    61,   -32
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte[] yydefgoto_ = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
       0,    50,     7,     8,    36,    19,     9,    37,    42,    38,
      39,    40,    10,    11,    51
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final byte[] yytable_ = yytable_init();
  private static final byte[] yytable_init()
  {
    return new byte[]
    {
       6,    53,    41,   -13,     1,     2,     3,    21,     6,     6,
      12,    62,    68,    23,    13,    64,    65,    66,    68,    16,
      24,    25,    86,   116,    75,    76,    88,    25,   117,    17,
      75,    76,    18,    77,    78,    25,    94,    95,    96,    97,
      98,    99,   100,   101,   102,   103,   104,   105,   106,   107,
       1,     2,     3,     4,    60,    61,    25,     1,     2,     3,
     112,    27,     5,    45,    46,    21,   110,    61,    22,    14,
      15,    28,    29,    43,    44,    52,    54,   114,    47,    57,
      55,    56,   119,   118,    67,    59,    68,    58,    48,   124,
      49,    63,    69,    70,    71,    72,    73,    74,    75,    76,
      82,    77,    78,    79,    80,    81,    87,    83,    84,    92,
     111,    25,   108,    26,   113,   121,    25,   109,   123,    68,
      25,   125,    20,    25,   122,    69,    70,    71,    72,    73,
      74,    75,    76,    90,    77,    78,    79,    80,    81,   115,
      89,    68,     0,     0,     0,    85,     0,    69,    70,    71,
      72,    73,    74,    75,    76,     0,    77,    78,    79,    80,
      81,   120,     0,    68,     0,     0,     0,     0,     0,    69,
      70,    71,    72,    73,    74,    75,    76,     0,    77,    78,
      79,    80,    81,     1,     2,     3,     0,    30,     0,     0,
       0,    31,     0,     0,    32,     0,    33,    34,     0,    24,
       0,    68,     0,    35,     0,     0,    91,    69,    70,    71,
      72,    73,    74,    75,    76,     0,    77,    78,    79,    80,
      81,    68,     0,     0,     0,     0,    93,    69,    70,    71,
      72,    73,    74,    75,    76,    68,    77,    78,    79,    80,
      81,    69,    70,    71,    72,    73,    74,    75,    76,    68,
      77,    78,    79,    80,    81,   -14,   -14,   -14,   -14,   -14,
     -14,    75,    76,     0,    77,    78,    79,    80,    81
    };
  }

private static final byte[] yycheck_ = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
       0,    35,    20,    21,     3,     4,     5,    19,     8,     9,
       7,    43,    20,    25,     7,    47,    48,    49,    20,     0,
      19,    21,    56,    13,    32,    33,    58,    27,    18,    23,
      32,    33,    24,    35,    36,    35,    68,    69,    70,    71,
      72,    73,    74,    75,    76,    77,    78,    79,    80,    81,
       3,     4,     5,     6,    18,    19,    56,     3,     4,     5,
      92,    23,    15,     9,    10,    19,    18,    19,    22,     8,
       9,     7,     7,    24,    24,    24,    18,   111,    24,    22,
      21,    18,   116,   115,    18,     7,    20,    20,    34,   123,
      36,     7,    26,    27,    28,    29,    30,    31,    32,    33,
       5,    35,    36,    37,    38,    39,    18,    22,     7,    20,
      12,   111,    25,    21,    18,    18,   116,    18,    25,    20,
     120,    18,    18,   123,   120,    26,    27,    28,    29,    30,
      31,    32,    33,    61,    35,    36,    37,    38,    39,    18,
      59,    20,    -1,    -1,    -1,    55,    -1,    26,    27,    28,
      29,    30,    31,    32,    33,    -1,    35,    36,    37,    38,
      39,    18,    -1,    20,    -1,    -1,    -1,    -1,    -1,    26,
      27,    28,    29,    30,    31,    32,    33,    -1,    35,    36,
      37,    38,    39,     3,     4,     5,    -1,     7,    -1,    -1,
      -1,    11,    -1,    -1,    14,    -1,    16,    17,    -1,    19,
      -1,    20,    -1,    23,    -1,    -1,    25,    26,    27,    28,
      29,    30,    31,    32,    33,    -1,    35,    36,    37,    38,
      39,    20,    -1,    -1,    -1,    -1,    25,    26,    27,    28,
      29,    30,    31,    32,    33,    20,    35,    36,    37,    38,
      39,    26,    27,    28,    29,    30,    31,    32,    33,    20,
      35,    36,    37,    38,    39,    26,    27,    28,    29,    30,
      31,    32,    33,    -1,    35,    36,    37,    38,    39
    };
  }

/* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
   state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     3,     4,     5,     6,    15,    41,    42,    43,    46,
      52,    53,     7,     7,    53,    53,     0,    23,    24,    45,
      45,    19,    22,    25,    19,    41,    44,    23,     7,     7,
       7,    11,    14,    16,    17,    23,    44,    47,    49,    50,
      51,    20,    48,    24,    24,     9,    10,    24,    34,    36,
      41,    54,    24,    50,    18,    21,    18,    22,    20,     7,
      18,    19,    54,     7,    54,    54,    54,    18,    20,    26,
      27,    28,    29,    30,    31,    32,    33,    35,    36,    37,
      38,    39,     5,    22,     7,    51,    50,    18,    54,    48,
      47,    25,    20,    25,    54,    54,    54,    54,    54,    54,
      54,    54,    54,    54,    54,    54,    54,    54,    25,    18,
      18,    12,    54,    18,    50,    18,    13,    18,    54,    50,
      18,    18,    49,    25,    50,    18
    };
  }

/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    40,    41,    41,    41,    42,    42,    43,    44,    44,
      45,    45,    46,    47,    48,    48,    49,    49,    49,    49,
      49,    49,    49,    49,    49,    49,    50,    50,    51,    51,
      52,    53,    53,    53,    54,    54,    54,    54,    54,    54,
      54,    54,    54,    54,    54,    54,    54,    54,    54,    54,
      54,    54,    54,    54
    };
  }

/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     1,     1,     1,     1,     1,     5,     2,     2,
       0,     3,     9,     1,     0,     3,    12,     7,     9,     5,
       3,     3,     2,     4,     3,     5,     0,     3,     1,     3,
       1,     0,     2,     2,     1,     1,     1,     3,     3,     3,
       3,     3,     3,     3,     3,     3,     3,     3,     3,     3,
       3,     2,     2,     3
    };
  }




  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 294;
    if (t <= 0)
      return SymbolKind.S_YYEOF;
    else if (t <= code_max)
      return SymbolKind.get(yytranslate_table_[t]);
    else
      return SymbolKind.S_YYUNDEF;
  }
  private static final byte[] yytranslate_table_ = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39
    };
  }


  private static final int YYLAST_ = 268;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 16;
  private static final int YYNTOKENS_ = 40;

/* Unqualified %code blocks.  */
/* "ToY.y":45  */


/* ----------------- Global Hashmaps and Main Function ---------------- */

HashMap<Object, ID> functions = new HashMap<Object, ID>();
HashMap<Object, ID> statements = new HashMap<Object, ID>();
// HashMap<Object, ID> var = new HashMap<Object, ID>();

public static void main(String[] args) throws IOException {
FileReader yyin = new FileReader(args[0]);
 ToYLexer l = new ToYLexer(yyin);
 ToY p = new ToY(l);
 if (!p.parse()) System.out.println("INVALID");
 }

/* "ToY.java":1619  */

}
/* "ToY.y":197  */

/* ------------------------------------------------------- */
/*                       Start of AST                      */
/* ------------------------------------------------------- */

// Asbstract syntax tree base class.  
// methods: accept
//          accept method will call the Visitor class, will accept a node if deemed "correct" by semantic analysis 
//          this method will be applied in all subclasses that create nodes
abstract class ASTNode {
    abstract Object accept(Visitor v); /* This may have to be type ID...not sure */
    // might need children nodes
}

class StmtList {
	// stmtLists are ArrayList<Object>s, but are used in classes that create ASTNodes, so an Array<List> in this case is an ASTNode.
    ArrayList<Object> stmts;

    public StmtList() {
        stmts = new ArrayList<Object>();
    }

    public void addElement(Object n) {
        stmts.add(n);
    }

    public Object elementAt(int i) {
        return stmts.get(i);
    }
    // public int size() {
    // return stmts.size();
    // }
}

/* ----------------- AST Expression Subclasses ---------------- */
/* ------------------------------------------------------------ */

// Arithmetic Class that extends the ASTNode class
// creates two Nodes, the left and right sides of an arithmetic statement
// constructor allows semantic actions to initialize nodes
class Arithmetic extends ASTNode {
    public Object left, right, op;

    public Arithmetic(Object left, Object op, Object right) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public Object getLeft(){
        return this.left;
    }

    public Object getRight(){
        return this.right;
    }

    public Object getOp(){
        return this.op;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

class Logic extends ASTNode {
    public Object left, right, op;

    public Logic(Object left, Object op, Object right) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public Object getLeft(){
        return this.left;
    }

    public Object getRight(){
        return this.right;
    }

    public Object getOp(){
        return this.op;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// Conditions class that extends the ASTNode class
// creates two Nodes, the left and right sides of a conditional statement
// constructor allows semantic actions to initialize nodes
class Conditions extends ASTNode {
    public Object left, op, right;

    public Conditions(Object left, Object op, Object right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public Object getLeft(){
        return this.left;
    } 

    public Object getRight(){
        return this.right;
    }

    public Object getOp(){
        return this.op;
    }


    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// UnaryOperators class that extends the ASTNode class
// creates one Node, the right statement of a unary expression
// constructor allows semantic actions to initialize nodes
class UnaryOperators extends ASTNode {
    public Object op, right;

    public UnaryOperators(Object op, Object right) {
        this.op = op;
        this.right = right;
    }

    public Object getRight(){
        return this.right;
    }

    public Object getOp(){
        return this.op;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// EndFunctions class that extends the ASTNode class
// Used for return and print functions
// creates one node, the expression to be printed or returned
// constructor allows semantic actions to initialize nodes
class EndFunction extends ASTNode {
    Object exp;

    public EndFunction(Object exp) {
        this.exp = exp;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

/* ----------------- AST Statement/Method subclasses ---------------- */
/* ------------------------------------------------------------------ */

// ForLoop class that extends the ASTNode class
// creates four nodes, the for loop iterator, it's conditional, its
// incrementation statement, and the loop body
// constructor allows semantic actions to initialize nodes
class ForLoop extends ASTNode {

    Object iterator;
    Object conditional;
    Object increment;
    StmtList body;

    public ForLoop(Object iterator, Object conditional, Object increment, StmtList body) {
        this.iterator = iterator;
        this.conditional = conditional;
        this.increment = increment;
        this.body = body;
    }

    public Object getIterator(){
        return this.iterator;
    }

    public Object getConditional(){
        return this.conditional;
    }

    public Object getIncrement(){
        return this.increment;
    }

    public Object getBody(){
        return this.body;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// IfStmt class that extends the ASTNode class
// creates three nodes, the if statment conditional, the if statment body, and
// the else statement
// else statement can bc a null pointer, in which case only 2 nodes are created
// constructor allows semantic actions to initialize nodes
class IfStmt extends ASTNode {

    Object conditional;
    StmtList ifBody;
    StmtList elseBody;

    public IfStmt(Object conditional, StmtList ifBody, StmtList elseBody) {
        this.conditional = conditional;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

/* ----------------- AST Variable Subclasses ---------------- */
/* ---------------------------------------------------------- */

// Asnmt class that extends the ASTNode class
// The class is used when assigning objects to variables
// Creates two nodes, the variable and the expression
// constructor allows semantic actions to initialize nodes
class Asnmt extends ASTNode {
    Object var;
    Object exp;

    public Asnmt(Object var, Object exp) {
        this.var = var;
        this.exp = exp;
    }

    public Object getVar(){
        return this.var;
    }

    public Object getExp(){
        return this.exp;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// Decl class that extends the ASTNode class
// used for variable declarations, which can potentially be multiple in a row
// creates 1 node: a list of all the variable names
// constructor allows semantic actions to initialize nodes
class Decl extends ASTNode {
    // QUESTION: would we need type
    // String varType;
    // String name;
    
    // MAYBE DECL NEEDS A HASMAP
    ArrayList<Object> names;

    public Decl(ArrayList<Object> names) {
        // this.varType = varType;
        this.names = names;
    }

    public Object getNames(){
        return this.names;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


// this might just be a Var definition situation????
class ParamList extends ASTNode {
	StmtList params;
	
	public ParamList(StmtList params){
		this.params = params;
	}

    public Object getParams(){
        return this.params;
    }
	
	public Object accept(Visitor v) {
        	return v.visit(this);
    	}
}

class Keyword extends ASTNode {
	Object keyword;
	
	public Keyword(Object keyword){
		this.keyword = keyword;
	}

    public Object getKeyword(){
        return this.keyword;
    }
	
	public Object accept(Visitor v) {
        	return v.visit(this);
    	}
}

class VarDef extends ASTNode {
	
	Object type, name;
	
	public VarDef(Object type, Object name){
		this.type = type;
		this.name = name;
    }	

    public Object getType(){
        return this.type;
    }

    public Object getName(){
        return this.name;
    }

	public Object accept(Visitor v) {
        	return v.visit(this);
    }
}


// ------------------------------ Type class question
// -------------------------------------------

// ******** ASK QUESTION ABOUT WHAT TO DO FOR JUST TYPES ********
class Type extends ASTNode {

    public Type() {
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// ---------------------------------------- Program classes & subclasses 
// --------------------------------------

// Struct class that extends the ASTNode class
// creates 2 nodes: the name of the struct and an ArrayList of all the struct
// fieldTypes
// constructor allows semantic actions to initialize nodes
class StructCreator extends ASTNode {
    
    Object name;
    StmtList fieldTypes;

    public StructCreator(Object name, StmtList fieldTypes) {
        this.name = name;
        this.fieldTypes = fieldTypes;
    }

    public Object getName(){
        return this.name;
    }

    public StmtList getFeilds(){
        return this.fieldTypes;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// ****** QUESTION: does the body need to be another node? *******

// Function class that extends the ASTNode class
// creates 2 nodes, the function name and it's parameters
// constructor allows semantic actions to initialize nodes
class FunctionConstruct extends ASTNode {
    Object returnType;
    Object name;
    Object parameters;
    StmtList body;

    public FunctionConstruct(Object returnType, Object name, Object parameters, StmtList body) {
        this.returnType = returnType;
        this.name = name;
        this.parameters = parameters;
        this.body = body;
    }

    public Object getReturnType(){
        return this.returnType;
    }

    public Object getName(){
        return this.name;
    }

    public Object getParameters(){
        return this.parameters;
    }

    public StmtList getBody(){
        return this.body;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// FunctionCall class that extends the ASTNode class
// specifically for when you don't want to have full declarations in the
// parenthesis, just already declared param names
// creates 2 nodes, the name (a string) and the parameters, which are an array
// of strings (variable names)
// constructor allows semantic actions to initialize nodes
class FunctionCall extends ASTNode {
    Object name;
    Object parameters;
    // ASK ABOUT BODY

    public FunctionCall(Object name, Object parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public Object getName(){
        return this.name;
    }

    public Object getParameters(){
        return this.parameters;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// Program class, almost acts are our main parent node :)
class Program extends ASTNode {
	StmtList program;
	
	public Program(StmtList program){
		this.program = program;
	}

    public StmtList getProgram(){
        return this.program;
    }
	
	public Object accept(Visitor v) {
        	return v.visit(this);
    }
}
	


// ------------------------------------- Semantic Analysis JUMP
// ------------------------------------------

// An implementation of all the visitor methods
// These act as semantic analysis, so each of these methods will visit the nodes
// in the AST tree and make
// sure that they are semantically doing the correct thing
class AbstractVisitor implements Visitor {

    // arithmetic expressions

    public boolean visit(Arithmetic add) {
        int op = ((Yytoken)(add.getOp())).getToken();
        int left = ((Yytoken)(add.getLeft())).getToken();
        int right = ((Yytoken)(add.getRight())).getToken();
        if (op == ToYLexer.PLUS || op == ToYLexer.MINUS ){
            if ((left == ToYLexer.INT && right == ToYLexer.INT) ||(left == ToYLexer.STRING && right == ToYLexer.STRING) ){
                return true;
            }
        }
        if (op == ToYLexer.MULT || op == ToYLexer.DIVIDE ){
            if (left == ToYLexer.INT && right == ToYLexer.INT){
                return true;
            }
        }
        
        return false;
    }

    public boolean visit(Logic add) {
        int left = ((Yytoken)(add.getLeft())).getToken();
        int right = ((Yytoken)(add.getRight())).getToken();
        if (left == ToYLexer.BOOL && right == ToYLexer.BOOL){
            return true;
        }
        
        return false;
    }

    public boolean visit(Conditions add) {
        int op = ((Yytoken)(add.getOp())).getToken();
        int left = ((Yytoken)(add.getLeft())).getToken();
        int right = ((Yytoken)(add.getRight())).getToken();
        if (op == ToYLexer.GREATERTHAN || op == ToYLexer.GREATERTHANOREQ || op == ToYLexer.LESSTHAN || op == ToYLexer.LESSTHANOREQ ){
            if (left == ToYLexer.INT && right == ToYLexer.INT){
                return true;
            }
        }
        if (op == ToYLexer.DOUBLEEQ || op == ToYLexer.NOTEQ ){
            if ((left == ToYLexer.INT && right == ToYLexer.INT) || (left == ToYLexer.STRING && right == ToYLexer.STRING) ){
                return true;
            }
        }
        
        return false;
    }

    public boolean visit(UnaryOperators add) {
        int op = ((Yytoken)(add.getOp())).getToken();
        int right = ((Yytoken)(add.getRight())).getToken();
        if (op == ToYLexer.NOT && right == ToYLexer.BOOL){
            return true;
        }
        if (op == ToYLexer.MINUS && right == ToYLexer.INT){
            return true;
        }
        return false;
    }

    //SO I THINK FOR THIS WE MIGHT NEED TO PULL THE TYPE FROM SOMEWHERE I AM KINDA CONFUSED 
    public boolean visit(Asnmt add) {
        return false;
    }

    public boolean visit(Decl add) {
        return false;
    }

    public boolean visit(EndFunction add) {
        return false;
    }

    public boolean visit(ForLoop add) {
        return false;
    }

    public boolean visit(IfStmt add) {
        return false;
    }

    public boolean visit(StructCreator add) {
        return false;
    }

    public boolean visit(Type add) {
        return false;
    }

    public boolean visit(FunctionConstruct add) {
        return false;
    }

    public boolean visit(FunctionCall add) {
        return false;
    }
    
    public boolean visit(ParamList add) {
        return false;
    }
    
    public boolean visit(VarDef add) {
        int type = ((Yytoken)(add.getType())).getToken();
        int name = ((Yytoken)(add.getName())).getToken();
        // CHECK DO WE NEED TO CHECK IF THIS IS OF TYPE STRUCT 
        if ((type == ToYLexer.BOOL || type == ToYLexer.INT || type == ToYLexer.STRING ) && name == ToYLexer.IDENTIFIER){
            return true;
        }
        return false;
    }
    
    public boolean visit(Program add) {
    	return false;
    }
    
    public boolean visit(Keyword add) {
        int keyword = ((Yytoken)(add.getKeyword())).getToken();
        if( keyword == ToYLexer.VOID || keyword == ToYLexer.TRUE || keyword == ToYLexer.FALSE ){
            return true;
        }
    	return false;
    }

}

// A declaration of all the visitor methods for each AST subclass
interface Visitor {

    public boolean visit(Arithmetic symbol);

    public boolean visit(Logic symbol);

    public boolean visit(Conditions symbol);

    public boolean visit(UnaryOperators symbol);

    public boolean visit(Asnmt symbol);

    public boolean visit(Decl symbol);

    public boolean visit(EndFunction symbol);

    public boolean visit(ForLoop symbol);

    public boolean visit(IfStmt symbol);

    public boolean visit(StructCreator symbol);
    
    public boolean visit(VarDef vardef);

    public boolean visit(Type symbol);

    public boolean visit(FunctionConstruct symbol);

    public boolean visit(FunctionCall symbol);
    
    public boolean visit(ParamList paramList);
    
    public boolean visit(Program program);
    
    public boolean visit(Keyword keyword);

}


// Java code for the HashMaps ID TYPES -------------------------------------------------------------------------
class ID {
    Object name;
    Object scope;
    // String type;
    // String returnType;
    // ArrayList<String> parameterTypes;
    // ArrayList<String> fieldTypes;
    // int size;

    public ID(Object name) {
        this.name = name;
        // this.type = type;
        // this.returnType = returnType;
        // this.parameterTypes = parameterTypes;
        // this.fieldTypes = fieldTypes;
        // this.size = size;
    }
    public Object getName(){
       return this.name;
    }
    public Object getScope(Object Scope){
       return this.scope;
    }
    public void setScope(Object Scope){
       this.scope = scope;
    }
}

class Var extends ID {
    Object type;

    public Var(Object name, Object type) {
        super(name);
        this.type = type;

    }
}

class Function extends ID {
    Object returnType;
    StmtList parameterTypes;

    public Function(Object name, Object returnType, StmtList parameterTypes) {
        super(name);
        this.returnType = returnType;
        this.parameterTypes = parameterTypes;
    }

}

class Struct extends ID {
    StmtList fieldTypes;
    //Object size; TOOK OUT SIZE

    public Struct(Object name, StmtList fieldTypes){ //Object size
        super(name);
        this.fieldTypes = fieldTypes;
        //this.size = size;
    }

}
   
 // symbol table class -------------------------------------------------------------------------
  class SymbolTable{
   
   int scope = 0; 
   HashMap<Object, ID> currentScope; 
   ArrayList<HashMap<Object, ID>> table;

   public SymbolTable() {
		table = new ArrayList<HashMap<Object, ID>>();
		table.add(new HashMap<Object, ID>());
	}

   public void addScope(){
      table.add(new HashMap<Object, ID>());
      scope++;
   }

   public void enterScope(){
      this.scope++;
   }

   public void exitScope(){
      this.scope--;
   }
   
   //see if the symbol is already included in the table returns the symbol if found
   public ID find_symbol(ID id){
      for (int i = this.scope; i >= 0; i--) {
			if (this.table.get(i).containsKey(id.getName())) {
				return this.table.get(i).get(id.getName());
			}
		}
		return null;

   }

   //adds all the information we need to know about x in current scope
   public boolean add_symbol(ID id){
      if (id != null && find_symbol(id) == null) {
			this.table.get(this.scope).put(id.getName(), id);
			id.setScope(this.scope);
			return true;
		}
		return false;
   }

   //check if x is in current scope and if it is returns the symbol 
   public ID check_scope(ID id){
      if(this.currentScope.containsKey(id.getName())){
         return this.table.get(this.scope).get(id.getName());
      }
      return null;
      
   } 

  }



// for the parser and lexer link ------------------------------------------------------
    class ToYLexer implements ToY.Lexer {
      Yylex yylex;
    
     

    public ToYLexer(FileReader is){
      yylex = new Yylex(is);
     }

    
     
     @Override
     public void yyerror (String s){
     System.err.println(s);
     }
      Object yylval;
     
     @Override
      public Yytoken getLVal() {
         return token;
      }

      Yytoken token;

      @Override
      public int yylex () throws IOException{
         token = yylex.yylex();
         return token.type;
      }
    }
    
