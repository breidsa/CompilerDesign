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
/* "ToY.y":35  */

import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;

/* "ToY.java":58  */

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
    S_NUMBER(40),                  /* NUMBER  */
    S_WORD(41),                    /* WORD  */
    S_END(42),                     /* END  */
    S_O(43),                       /* "end o file"  */
    S_YYACCEPT(44),                /* $accept  */
    S_pgm(45),                     /* pgm  */
    S_recursePgm(46),              /* recursePgm  */
    S_function(47),                /* function  */
    S_struct(48),                  /* struct  */
    S_declarationListZero(49),     /* declarationListZero  */
    S_declarationList(50),         /* declarationList  */
    S_stmts(51),                   /* stmts  */
    S_declaration(52),             /* declaration  */
    S_stmt(53),                    /* stmt  */
    S_paramList(54),               /* paramList  */
    S_stmtSeq(55),                 /* stmtSeq  */
    S_type(56),                    /* type  */
    S_returnType(57),              /* returnType  */
    S_exp(58),                     /* exp  */
    S_Lexp(59);                    /* Lexp  */


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
      SymbolKind.S_NUMBER,
      SymbolKind.S_WORD,
      SymbolKind.S_END,
      SymbolKind.S_O,
      SymbolKind.S_YYACCEPT,
      SymbolKind.S_pgm,
      SymbolKind.S_recursePgm,
      SymbolKind.S_function,
      SymbolKind.S_struct,
      SymbolKind.S_declarationListZero,
      SymbolKind.S_declarationList,
      SymbolKind.S_stmts,
      SymbolKind.S_declaration,
      SymbolKind.S_stmt,
      SymbolKind.S_paramList,
      SymbolKind.S_stmtSeq,
      SymbolKind.S_type,
      SymbolKind.S_returnType,
      SymbolKind.S_exp,
      SymbolKind.S_Lexp
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
  "NUMBER", "WORD", "END", "\"end o file\"", "$accept", "pgm",
  "recursePgm", "function", "struct", "declarationListZero",
  "declarationList", "stmts", "declaration", "stmt", "paramList",
  "stmtSeq", "type", "returnType", "exp", "Lexp", null
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
    /** Token NUMBER, to be returned by the scanner.  */
    static final int NUMBER = 295;
    /** Token WORD, to be returned by the scanner.  */
    static final int WORD = 296;
    /** Token END, to be returned by the scanner.  */
    static final int END = 297;
    /** Token "end o file", to be returned by the scanner.  */
    static final int O = 298;

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
          case 2: /* pgm: function recursePgm  */
  if (yyn == 2)
    /* "ToY.y":142  */
                               { StmtList pgm = ((StmtList)(yystack.valueAt (0))); ast.addElement(((Object)(yystack.valueAt (1)))); yyval = pgm; };
  break;


  case 3: /* pgm: struct pgm  */
  if (yyn == 3)
    /* "ToY.y":143  */
                 { StmtList pgm = ((StmtList)(yystack.valueAt (0))); ast.addElement(((Object)(yystack.valueAt (1)))); yyval = pgm; };
  break;


  case 4: /* recursePgm: %empty  */
  if (yyn == 4)
    /* "ToY.y":146  */
                 { yyval = new StmtList(); };
  break;


  case 5: /* recursePgm: function recursePgm  */
  if (yyn == 5)
    /* "ToY.y":147  */
                          { StmtList pgm = ((StmtList)(yystack.valueAt (0))); ast.addElement(((Object)(yystack.valueAt (1)))); yyval = pgm;  };
  break;


  case 6: /* recursePgm: struct recursePgm  */
  if (yyn == 6)
    /* "ToY.y":148  */
                        { StmtList pgm =  ((StmtList)(yystack.valueAt (0))); ast.addElement(((Object)(yystack.valueAt (1)))); yyval = pgm; };
  break;


  case 7: /* function: returnType IDENTIFIER LEFTPAREN declarationListZero RIGHTPAREN LBRACKET stmts RBRACKET  */
  if (yyn == 7)
    /* "ToY.y":152  */
                                                                                                       {yyval = new FunctionConstruct(((Object)(yystack.valueAt (7))), ((Yytoken)(yystack.valueAt (6))), ((StmtList)(yystack.valueAt (4))), ((StmtList)(yystack.valueAt (1))));
                                                                                                         Function ft = new Function(((Yytoken)(yystack.valueAt (6))), ((Object)(yystack.valueAt (7))), (StmtList)((StmtList)(yystack.valueAt (4)))); functions.put(((Yytoken)(yystack.valueAt (6))), ft);};
  break;


  case 8: /* struct: STRUCT IDENTIFIER LBRACKET declarationList RBRACKET  */
  if (yyn == 8)
    /* "ToY.y":157  */
                                                                 { yyval = new StructCreator(((Yytoken)(yystack.valueAt (3))), ((StmtList)(yystack.valueAt (1)))); Struct st = new Struct(((Yytoken)(yystack.valueAt (3))),(StmtList)((StmtList)(yystack.valueAt (1)))); statements.put(((Yytoken)(yystack.valueAt (3))), st);};
  break;


  case 9: /* declarationListZero: %empty  */
  if (yyn == 9)
    /* "ToY.y":160  */
                         { yyval = new StmtList();};
  break;


  case 10: /* declarationListZero: declaration  */
  if (yyn == 10)
    /* "ToY.y":161  */
                  {yyval = new StmtList(((Object)(yystack.valueAt (0)))); };
  break;


  case 11: /* declarationListZero: declaration COMMA declarationList  */
  if (yyn == 11)
    /* "ToY.y":162  */
                                        {StmtList decls = ((StmtList)(yystack.valueAt (0))); decls.addElement(((Object)(yystack.valueAt (2)))); yyval = decls;};
  break;


  case 12: /* declarationList: declaration  */
  if (yyn == 12)
    /* "ToY.y":165  */
                                 { yyval = ((Object)(yystack.valueAt (0))); };
  break;


  case 13: /* declarationList: declaration COMMA declarationList  */
  if (yyn == 13)
    /* "ToY.y":166  */
                                        { StmtList decls = ((StmtList)(yystack.valueAt (0))); decls.addElement(((Object)(yystack.valueAt (2)))); yyval = decls;};
  break;


  case 14: /* stmts: %empty  */
  if (yyn == 14)
    /* "ToY.y":169  */
            { yyval = new StmtList();};
  break;


  case 15: /* stmts: stmt stmts  */
  if (yyn == 15)
    /* "ToY.y":170  */
                 { StmtList sequence = ((StmtList)(yystack.valueAt (0))); sequence.addElement(((Object)(yystack.valueAt (1)))); yyval = sequence; };
  break;


  case 16: /* declaration: type IDENTIFIER  */
  if (yyn == 16)
    /* "ToY.y":173  */
                                 { yyval = new VarDef(((Object)(yystack.valueAt (1))), ((Yytoken)(yystack.valueAt (0)))); };
  break;


  case 17: /* stmt: FOR LEFTPAREN IDENTIFIER EQ exp SEMICOLON exp SEMICOLON stmt RIGHTPAREN LBRACKET stmts RBRACKET  */
  if (yyn == 17)
    /* "ToY.y":176  */
                                                                                                           { Asnmt iterator = new Asnmt(((Yytoken)(yystack.valueAt (10))), ((Object)(yystack.valueAt (8))));
										               yyval = new ForLoop(iterator, ((Object)(yystack.valueAt (6))), ((Object)(yystack.valueAt (4))), ((StmtList)(yystack.valueAt (1))));};
  break;


  case 18: /* stmt: IF LEFTPAREN exp RIGHTPAREN LBRACKET stmts RBRACKET  */
  if (yyn == 18)
    /* "ToY.y":178  */
                                                          { yyval = new IfStmt(((Object)(yystack.valueAt (4))), ((StmtList)(yystack.valueAt (1))), null); };
  break;


  case 19: /* stmt: IF LEFTPAREN exp RIGHTPAREN LBRACKET stmts RBRACKET ELSE LBRACKET stmts RBRACKET  */
  if (yyn == 19)
    /* "ToY.y":179  */
                                                                                       { yyval = new IfStmt(((Object)(yystack.valueAt (8))), ((StmtList)(yystack.valueAt (5))), ((StmtList)(yystack.valueAt (1))));};
  break;


  case 20: /* stmt: PRINTF LEFTPAREN STRING RIGHTPAREN SEMICOLON  */
  if (yyn == 20)
    /* "ToY.y":180  */
                                                   { yyval = new EndFunction(((Yytoken)(yystack.valueAt (4))), ((Yytoken)(yystack.valueAt (2)))); };
  break;


  case 21: /* stmt: PRINTF LEFTPAREN IDENTIFIER RIGHTPAREN SEMICOLON  */
  if (yyn == 21)
    /* "ToY.y":181  */
                                                       { yyval = new EndFunction(((Yytoken)(yystack.valueAt (4))), ((Yytoken)(yystack.valueAt (2)))); };
  break;


  case 22: /* stmt: RETURN exp SEMICOLON  */
  if (yyn == 22)
    /* "ToY.y":182  */
                           { yyval = new EndFunction(((Yytoken)(yystack.valueAt (2))), ((Object)(yystack.valueAt (1)))); };
  break;


  case 23: /* stmt: LBRACKET stmtSeq RBRACKET  */
  if (yyn == 23)
    /* "ToY.y":183  */
                                { yyval = ((Yytoken)(yystack.valueAt (2))); };
  break;


  case 24: /* stmt: type IDENTIFIER SEMICOLON  */
  if (yyn == 24)
    /* "ToY.y":184  */
                                { yyval = new VarDef(((Object)(yystack.valueAt (2))), ((Yytoken)(yystack.valueAt (1)))); };
  break;


  case 25: /* stmt: IDENTIFIER EQ exp SEMICOLON  */
  if (yyn == 25)
    /* "ToY.y":185  */
                                  { yyval = new Asnmt(((Yytoken)(yystack.valueAt (3))), ((Object)(yystack.valueAt (1)))); };
  break;


  case 26: /* stmt: IDENTIFIER EQ exp  */
  if (yyn == 26)
    /* "ToY.y":186  */
                        { System.out.println("Into correct assignment"); yyval = new Asnmt(((Yytoken)(yystack.valueAt (2))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 27: /* stmt: IDENTIFIER ATTRIBUTE Lexp EQ exp SEMICOLON  */
  if (yyn == 27)
    /* "ToY.y":187  */
                                                 {System.out.println("Into wrong assignment"); yyval = new Asnmt(((Yytoken)(yystack.valueAt (5))), ((StmtList)(yystack.valueAt (3))));};
  break;


  case 28: /* stmt: IDENTIFIER LEFTPAREN paramList RIGHTPAREN SEMICOLON  */
  if (yyn == 28)
    /* "ToY.y":188  */
                                                          {yyval = new FunctionCall(((Yytoken)(yystack.valueAt (4))), ((Yytoken)(yystack.valueAt (3))));};
  break;


  case 29: /* stmt: IDENTIFIER EQ IDENTIFIER LEFTPAREN paramList RIGHTPAREN SEMICOLON  */
  if (yyn == 29)
    /* "ToY.y":189  */
                                                                        {FunctionCall func = new FunctionCall(((Yytoken)(yystack.valueAt (4))), ((StmtList)(yystack.valueAt (2)))); yyval = new Asnmt(((Yytoken)(yystack.valueAt (6))), func);};
  break;


  case 31: /* paramList: %empty  */
  if (yyn == 31)
    /* "ToY.y":193  */
               { yyval = new StmtList();};
  break;


  case 32: /* paramList: exp COMMA paramList  */
  if (yyn == 32)
    /* "ToY.y":194  */
                          {StmtList params = ((StmtList)(yystack.valueAt (0))); params.addElement(((Object)(yystack.valueAt (2)))); yyval = params;};
  break;


  case 33: /* stmtSeq: %empty  */
  if (yyn == 33)
    /* "ToY.y":197  */
             { yyval = new StmtList();};
  break;


  case 34: /* stmtSeq: stmt COMMA stmtSeq  */
  if (yyn == 34)
    /* "ToY.y":198  */
                         { StmtList sequence = ((StmtList)(yystack.valueAt (0))); sequence.addElement(((Object)(yystack.valueAt (2)))); yyval = sequence; };
  break;


  case 35: /* type: INT  */
  if (yyn == 35)
    /* "ToY.y":201  */
              { yyval = new Keyword(((Yytoken)(yystack.valueAt (0)))); };
  break;


  case 36: /* type: BOOL  */
  if (yyn == 36)
    /* "ToY.y":202  */
           { yyval = new Keyword(((Yytoken)(yystack.valueAt (0)))); };
  break;


  case 37: /* type: STRING  */
  if (yyn == 37)
    /* "ToY.y":203  */
             { yyval = new Keyword(((Yytoken)(yystack.valueAt (0)))); };
  break;


  case 38: /* returnType: type  */
  if (yyn == 38)
    /* "ToY.y":206  */
                     { yyval = ((Object)(yystack.valueAt (0))); };
  break;


  case 39: /* returnType: VOID  */
  if (yyn == 39)
    /* "ToY.y":207  */
           { yyval = new Keyword(((Yytoken)(yystack.valueAt (0)))); };
  break;


  case 40: /* exp: NUMBER  */
  if (yyn == 40)
    /* "ToY.y":210  */
                { yyval = new Literals(((Yytoken)(yystack.valueAt (0)))); };
  break;


  case 41: /* exp: WORD  */
  if (yyn == 41)
    /* "ToY.y":211  */
           { yyval = new Literals(((Yytoken)(yystack.valueAt (0)))); };
  break;


  case 42: /* exp: TRUE  */
  if (yyn == 42)
    /* "ToY.y":212  */
           { yyval = new Keyword(((Yytoken)(yystack.valueAt (0)))); };
  break;


  case 43: /* exp: FALSE  */
  if (yyn == 43)
    /* "ToY.y":213  */
            { yyval = new Keyword(((Yytoken)(yystack.valueAt (0)))); };
  break;


  case 44: /* exp: IDENTIFIER  */
  if (yyn == 44)
    /* "ToY.y":214  */
                 { yyval = new Literals(((Yytoken)(yystack.valueAt (0)))); };
  break;


  case 45: /* exp: exp PLUS exp  */
  if (yyn == 45)
    /* "ToY.y":215  */
                   { yyval = new Arithmetic(((Object)(yystack.valueAt (2))), ((Yytoken)(yystack.valueAt (1))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 46: /* exp: exp MINUS exp  */
  if (yyn == 46)
    /* "ToY.y":216  */
                    { yyval = new Arithmetic(((Object)(yystack.valueAt (2))), ((Yytoken)(yystack.valueAt (1))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 47: /* exp: exp MULT exp  */
  if (yyn == 47)
    /* "ToY.y":217  */
                   { yyval = new Arithmetic(((Object)(yystack.valueAt (2))), ((Yytoken)(yystack.valueAt (1))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 48: /* exp: exp DIVIDE exp  */
  if (yyn == 48)
    /* "ToY.y":218  */
                     { yyval = new Arithmetic(((Object)(yystack.valueAt (2))), ((Yytoken)(yystack.valueAt (1))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 49: /* exp: exp MOD exp  */
  if (yyn == 49)
    /* "ToY.y":219  */
                  { yyval = new Arithmetic(((Object)(yystack.valueAt (2))), ((Yytoken)(yystack.valueAt (1))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 50: /* exp: exp AND exp  */
  if (yyn == 50)
    /* "ToY.y":220  */
                  { System.out.println("Goes to AND expression");yyval = new Logic(((Object)(yystack.valueAt (2))), ((Yytoken)(yystack.valueAt (1))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 51: /* exp: exp OR exp  */
  if (yyn == 51)
    /* "ToY.y":221  */
                 { yyval = new Logic(((Object)(yystack.valueAt (2))), ((Yytoken)(yystack.valueAt (1))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 52: /* exp: exp DOUBLEEQ exp  */
  if (yyn == 52)
    /* "ToY.y":222  */
                       { yyval = new Conditions(((Object)(yystack.valueAt (2))), ((Yytoken)(yystack.valueAt (1))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 53: /* exp: exp GREATERTHAN exp  */
  if (yyn == 53)
    /* "ToY.y":223  */
                          { yyval = new Conditions(((Object)(yystack.valueAt (2))), ((Yytoken)(yystack.valueAt (1))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 54: /* exp: exp LESSTHAN exp  */
  if (yyn == 54)
    /* "ToY.y":224  */
                       { yyval = new Conditions(((Object)(yystack.valueAt (2))), ((Yytoken)(yystack.valueAt (1))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 55: /* exp: exp GREATERTHANOREQ exp  */
  if (yyn == 55)
    /* "ToY.y":225  */
                              { yyval = new Conditions(((Object)(yystack.valueAt (2))), ((Yytoken)(yystack.valueAt (1))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 56: /* exp: exp LESSTHANOREQ exp  */
  if (yyn == 56)
    /* "ToY.y":226  */
                           { yyval = new Conditions(((Object)(yystack.valueAt (2))), ((Yytoken)(yystack.valueAt (1))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 57: /* exp: exp NOTEQ exp  */
  if (yyn == 57)
    /* "ToY.y":227  */
                    { yyval = new Conditions(((Object)(yystack.valueAt (2))), ((Yytoken)(yystack.valueAt (1))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 58: /* exp: NOT exp  */
  if (yyn == 58)
    /* "ToY.y":228  */
              { yyval = new UnaryOperators(((Yytoken)(yystack.valueAt (1))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 59: /* exp: MINUS exp  */
  if (yyn == 59)
    /* "ToY.y":229  */
                { yyval = new UnaryOperators(((Yytoken)(yystack.valueAt (1))), ((Object)(yystack.valueAt (0)))); };
  break;


  case 60: /* exp: LEFTPAREN exp RIGHTPAREN  */
  if (yyn == 60)
    /* "ToY.y":230  */
                               {yyval = ((Object)(yystack.valueAt (1)));};
  break;


  case 61: /* Lexp: IDENTIFIER  */
  if (yyn == 61)
    /* "ToY.y":233  */
                      { StmtList emptyList = new StmtList(); emptyList.addElement(((Yytoken)(yystack.valueAt (0)))); yyval = emptyList;};
  break;


  case 62: /* Lexp: IDENTIFIER ATTRIBUTE Lexp  */
  if (yyn == 62)
    /* "ToY.y":234  */
                                { StmtList attributeList = ((StmtList)(yystack.valueAt (0))); attributeList.addElement(((Yytoken)(yystack.valueAt (2)))); yyval = attributeList;};
  break;



/* "ToY.java":1010  */

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

  private static final short yypact_ninf_ = -92;
  private static final short yytable_ninf_ = -1;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
       8,   -92,   -92,   -92,   -92,    13,    37,     8,     8,   -92,
      40,    28,   -92,   -92,     8,     8,   -92,    46,    23,   -92,
     -92,    23,    57,    65,    78,    61,    70,   -92,    23,   -92,
      67,    23,   -92,   200,   -92,    20,   -92,    68,    69,    -2,
      72,   200,    76,   200,    92,     9,    96,    -2,    -2,    98,
     -92,   -92,   -92,    -2,    -2,    -2,   -92,   -92,    84,    41,
      87,    85,   -92,   -92,    91,   101,   100,   103,   120,   131,
     163,   199,   121,   214,     3,    44,   -92,    -2,    -2,    -2,
      -2,    -2,    -2,    -2,    -2,    -2,    -2,    -2,    -2,    -2,
     147,   172,   200,   -92,   -92,    -2,   -92,    96,    -2,   139,
      -2,   150,    -2,   -92,   228,   228,   228,   228,   228,   228,
       3,     3,    44,    44,    36,    36,     3,   170,   188,   -92,
     184,   -92,   116,   -92,   -92,   200,   132,   -92,   -92,   192,
     -92,   190,    -2,   -92,   202,   148,   195,   200,   200,   194,
     191,   197,   -92,   200,   211,   -92
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
       0,    35,    36,    37,    39,     0,     0,     4,     0,    38,
       0,     0,     1,     2,     4,     4,     3,     0,     0,     5,
       6,     9,     0,    12,     0,     0,    10,     8,     0,    16,
       0,     0,    13,    14,    11,     0,    30,     0,     0,     0,
       0,    33,     0,    14,     0,     0,     0,    31,     0,     0,
      44,    42,    43,     0,     0,     0,    40,    41,     0,     0,
       0,     0,     7,    15,     0,    44,    26,    61,     0,     0,
       0,     0,     0,     0,    58,    59,    22,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,    33,    23,    24,    31,    25,     0,     0,     0,
      31,     0,     0,    60,    54,    53,    52,    56,    55,    57,
      50,    51,    45,    46,    47,    48,    49,     0,     0,    34,
       0,    62,     0,    28,    32,    14,     0,    20,    21,     0,
      27,     0,     0,    29,    18,     0,     0,     0,    14,     0,
       0,     0,    19,    14,     0,    17
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final short[] yypgoto_ = yypgoto_init();
  private static final short[] yypgoto_init()
  {
    return new short[]
    {
     -92,   213,    52,     2,    17,   -92,   -25,   -43,   201,   -40,
     -91,   156,    73,   -92,   -24,   165
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte[] yydefgoto_ = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
       0,     6,    13,    14,    15,    25,    22,    42,    23,    43,
      69,    61,    44,    10,    70,    68
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final short[] yytable_ = yytable_init();
  private static final short[] yytable_init()
  {
    return new short[]
    {
      63,    60,     7,    32,   120,    50,    34,    51,    52,   124,
       7,     1,     2,     3,     4,    58,    65,     8,    51,    52,
      11,    66,    53,     5,    71,     8,     1,     2,     3,    73,
      74,    75,    54,    53,    55,    -1,    -1,    12,    56,    57,
      45,    46,    -1,    54,    47,    55,    90,    17,    91,    56,
      57,    18,    60,   104,   105,   106,   107,   108,   109,   110,
     111,   112,   113,   114,   115,   116,    19,    20,    83,    84,
      21,    85,    86,     9,   122,    89,    83,    84,   126,    27,
       9,     9,   131,    89,    28,    29,    30,     9,     9,    31,
      33,    24,    48,    49,    24,   140,    59,   139,    62,    64,
     144,    24,    76,    67,    24,    72,    92,    93,   135,    94,
      77,    78,    79,    80,    81,    82,    83,    84,    96,    85,
      86,    87,    88,    89,    97,    95,    77,    78,    79,    80,
      81,    82,    83,    84,   130,    85,    86,    87,    88,    89,
      98,   102,    77,    78,    79,    80,    81,    82,    83,    84,
     132,    85,    86,    87,    88,    89,    99,   123,    77,    78,
      79,    80,    81,    82,    83,    84,   137,    85,    86,    87,
      88,    89,   117,   125,    77,    78,    79,    80,    81,    82,
      83,    84,   100,    85,    86,    87,    88,    89,   127,    77,
      78,    79,    80,    81,    82,    83,    84,   118,    85,    86,
      87,    88,    89,     1,     2,     3,   128,    35,    36,   129,
     133,    37,   134,   142,    38,   136,    39,    40,   138,   141,
     143,    16,    26,    41,   101,    77,    78,    79,    80,    81,
      82,    83,    84,   145,    85,    86,    87,    88,    89,   103,
      77,    78,    79,    80,    81,    82,    83,    84,   119,    85,
      86,    87,    88,    89,    -1,    -1,    -1,    -1,    -1,    -1,
      83,    84,   121,    85,    86,    87,    88,    89
    };
  }

private static final short[] yycheck_ = yycheck_init();
  private static final short[] yycheck_init()
  {
    return new short[]
    {
      43,    41,     0,    28,    95,     7,    31,     9,    10,   100,
       8,     3,     4,     5,     6,    39,     7,     0,     9,    10,
       7,    45,    24,    15,    48,     8,     3,     4,     5,    53,
      54,    55,    34,    24,    36,    32,    33,     0,    40,    41,
      20,    21,    39,    34,    24,    36,     5,     7,     7,    40,
      41,    23,    92,    77,    78,    79,    80,    81,    82,    83,
      84,    85,    86,    87,    88,    89,    14,    15,    32,    33,
      24,    35,    36,     0,    98,    39,    32,    33,   102,    22,
       7,     8,   125,    39,    19,     7,    25,    14,    15,    19,
      23,    18,    24,    24,    21,   138,    24,   137,    22,     7,
     143,    28,    18,     7,    31,     7,    19,    22,   132,    18,
      26,    27,    28,    29,    30,    31,    32,    33,    18,    35,
      36,    37,    38,    39,    21,    24,    26,    27,    28,    29,
      30,    31,    32,    33,    18,    35,    36,    37,    38,    39,
      20,    20,    26,    27,    28,    29,    30,    31,    32,    33,
      18,    35,    36,    37,    38,    39,    25,    18,    26,    27,
      28,    29,    30,    31,    32,    33,    18,    35,    36,    37,
      38,    39,    25,    23,    26,    27,    28,    29,    30,    31,
      32,    33,    19,    35,    36,    37,    38,    39,    18,    26,
      27,    28,    29,    30,    31,    32,    33,    25,    35,    36,
      37,    38,    39,     3,     4,     5,    18,     7,     8,    25,
      18,    11,    22,    22,    14,    13,    16,    17,    23,    25,
      23,     8,    21,    23,    25,    26,    27,    28,    29,    30,
      31,    32,    33,    22,    35,    36,    37,    38,    39,    25,
      26,    27,    28,    29,    30,    31,    32,    33,    92,    35,
      36,    37,    38,    39,    26,    27,    28,    29,    30,    31,
      32,    33,    97,    35,    36,    37,    38,    39
    };
  }

/* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
   state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     3,     4,     5,     6,    15,    45,    47,    48,    56,
      57,     7,     0,    46,    47,    48,    45,     7,    23,    46,
      46,    24,    50,    52,    56,    49,    52,    22,    19,     7,
      25,    19,    50,    23,    50,     7,     8,    11,    14,    16,
      17,    23,    51,    53,    56,    20,    21,    24,    24,    24,
       7,     9,    10,    24,    34,    36,    40,    41,    58,    24,
      53,    55,    22,    51,     7,     7,    58,     7,    59,    54,
      58,    58,     7,    58,    58,    58,    18,    26,    27,    28,
      29,    30,    31,    32,    33,    35,    36,    37,    38,    39,
       5,     7,    19,    22,    18,    24,    18,    21,    20,    25,
      19,    25,    20,    25,    58,    58,    58,    58,    58,    58,
      58,    58,    58,    58,    58,    58,    58,    25,    25,    55,
      54,    59,    58,    18,    54,    23,    58,    18,    18,    25,
      18,    51,    18,    18,    22,    58,    13,    18,    23,    53,
      51,    25,    22,    23,    51,    22
    };
  }

/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    44,    45,    45,    46,    46,    46,    47,    48,    49,
      49,    49,    50,    50,    51,    51,    52,    53,    53,    53,
      53,    53,    53,    53,    53,    53,    53,    53,    53,    53,
      53,    54,    54,    55,    55,    56,    56,    56,    57,    57,
      58,    58,    58,    58,    58,    58,    58,    58,    58,    58,
      58,    58,    58,    58,    58,    58,    58,    58,    58,    58,
      58,    59,    59
    };
  }

/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     0,     2,     2,     8,     5,     0,
       1,     3,     1,     3,     0,     2,     2,    13,     7,    11,
       5,     5,     3,     3,     3,     4,     3,     6,     5,     7,
       1,     0,     3,     0,     3,     1,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     3,     3,     3,     3,     3,
       3,     3,     3,     3,     3,     3,     3,     3,     2,     2,
       3,     1,     3
    };
  }




  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 298;
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
      35,    36,    37,    38,    39,    40,    41,    42,    43
    };
  }


  private static final int YYLAST_ = 267;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 12;
  private static final int YYNTOKENS_ = 44;

/* Unqualified %code blocks.  */
/* "ToY.y":50  */


/* ----------------- Global Hashmaps and Main Function ---------------- */

 HashMap<Object, ID> functions = new HashMap<Object, ID>();
 HashMap<Object, ID> statements = new HashMap<Object, ID>();
// // HashMap<Object, ID> var = new HashMap<Object, ID>();

SymbolTable symbolTable = new SymbolTable();
static Program ast = new Program(new StmtList());


public static void main(String[] args) throws IOException {
        File initialFile = new File(args[0]);
        InputStream targetStream = new FileInputStream(initialFile);
        BufferedReader br = new BufferedReader(new FileReader(initialFile));
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        ToYLexer l = new ToYLexer(targetStream);
        ToY p = new ToY(l);
        if (!p.parse()){
            System.out.println("INVALID");
        } else{
            System.out.println("VAlID SYNTAX FROM PARSER");
            System.out.println();
        }

        AbstractVisitor v = new AbstractVisitor();
        if(v.visit(ast)){
            System.out.println("VALID SYNTAX FROM SEMANTIC");
        }else{
            System.out.println();
            System.out.println("INVALID SYNTAX FROM SEMANTIC");
        }

}

/* "ToY.java":1731  */

}
/* "ToY.y":238  */

/* ------------------------------------------------------- */
/*                       Start of AST                      */
/* ------------------------------------------------------- */


abstract class ASTNode {
    public abstract Object accept(Visitor v);  /* This may have to be type ID...not sure */
    // might need children nodes
}

class StmtList extends ASTNode{

    ArrayList<Object> stmts;

    public StmtList() {
        stmts = new ArrayList<Object>();
    }

    public StmtList(Object add) {
        stmts = new ArrayList<Object>();
        stmts.add(add);
    }

    public void addElement(Object n) {
        stmts.add(n);
    }

    public int getSize(){
        return stmts.size();
    }

    public Object elementAt(int i) {
        return stmts.get(i);
    }

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

/* ----------------- AST Expression Subclasses ---------------- */
/* ------------------------------------------------------------ */

// Arithmetic Class that extends the ASTNode class
// creates two Nodes, the left and right sides of an arithmetic statement
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

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


// Logic class that extends the ASTNode class
// creates two Nodes, the left and right sides of a conditional statement
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

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


// Conditions class that extends the ASTNode class
// creates two Nodes, the left and right sides of a conditional statement
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

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


// UnaryOperators class that extends the ASTNode class
// creates one Node, the right statement of a unary expression
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
    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


// EndFunctions class that extends the ASTNode class
// Used for return and print functions
// creates one node, the expression to be printed or returned
class EndFunction extends ASTNode {
    Object type;
    Object exp;

    public EndFunction(Object type, Object exp) {
        this.type = type;   
        this.exp = exp;
    }

    public Object getType(){
        return this.type;
    }

    public Object getExp(){
        return this.exp;
    }
    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


/* ----------------- AST Statement/Method subclasses ---------------- */
/* ------------------------------------------------------------------ */

// ForLoop class that extends the ASTNode class
// creates four nodes, the for loop iterator, it's conditional, its
// incrementation statement, and the loop body
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

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

// IfStmt class that extends the ASTNode class
// creates three nodes, the if statment conditional, the if statment body, and
// the else statement
// else statement can bc a null pointer, in which case only 2 nodes are created
class IfStmt extends ASTNode {

    Object conditional;
    StmtList ifBody;
    StmtList elseBody;

    public IfStmt(Object conditional, StmtList ifBody, StmtList elseBody) {
        this.conditional = conditional;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    public Object getConditional(){
        return this.conditional;
    }

    public Object getIfBody(){
        return this.ifBody;
    }

    public Object getElseBody(){
        return this.elseBody;
    }

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }

}


/* ----------------- AST Variable Subclasses ---------------- */
/* ---------------------------------------------------------- */

// Asnmt class that extends the ASTNode class
// The class is used when assigning objects to variables
// Creates two nodes, the variable and the expression
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
    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }

}


class ParamList extends ASTNode {

	StmtList params;
	
	public ParamList(StmtList params){
		this.params = params;
	}

    	public Object getParameters(){
        	return this.params;
    	}
	
	@Override
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
	
	@Override
	public Object accept(Visitor v) {
        	return v.visit(this);
    	}
}

 class Literals extends ASTNode {
 
    Object literal;

    public Literals(Object literal){
        this.literal = literal;
    }

    public Object getInstance(){
        return this.literal;
    }

    @Override
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

    	@Override
	public Object accept(Visitor v) {
        	return v.visit(this);
    	}
}


/* ------------------- Program classes & subclasses------------------ */
/* ------------------------------------------------------------------ */


// Struct class that extends the ASTNode class
// creates 2 nodes: the name of the struct and an ArrayList of all the struct
// fieldTypes
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
    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


// Function class that extends the ASTNode class
// creates 2 nodes, the function name and it's parameters
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
    
    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// FunctionCall class that extends the ASTNode class
// specifically for when you don't want to have full declarations in the
// parenthesis, just already declared param names
// creates 2 nodes, the name (a string) and the parameters, which are an array
// of strings (variable names)
class FunctionCall extends ASTNode {

    Object name;
    Object parameters;

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
    
    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

// Program class
class Program extends ASTNode {

	StmtList program;
	
	public Program(StmtList program){
		this.program = program;
	}

    	public StmtList getProgram(){
    	    	return this.program;
    	}

    	public void addElement(Object add) {
        	program.addElement(add);
    	}

	@Override
	public Object accept(Visitor v) {
        	return v.visit(this);
    }
}
	

/* ---------------------------- Start of Semantic Analysis ---------------------------- */
/* ------------------------------------------------------------------------------------ */



/* ----------------- AbstractVisitor implementations and Visitor definitions ----------------- */
/* ------------------------------------------------------------------------------------------- */

// An implementation of all the visitor methods
// These act as semantic analysis, so each of these methods will visit the nodes
// in the AST tree and make sure that they are semantically doing the correct thing
class AbstractVisitor implements Visitor {

    public boolean tryHelper(Object item){
        System.out.println(item);
        try {
            System.out.println("TryHelp FOR");
            ForLoop forloop = (ForLoop)item;
            if(visit(forloop)){
                    return true;
        }}catch(Exception e) {} 
        try {
                System.out.println("TryHelp IF");
                IfStmt ifStmt = (IfStmt)item;
                if(visit(ifStmt)){
                        return true;
                }
        }catch(Exception e) {} 
        try {
                    System.out.println("TryHelp END FUNCT");
                    EndFunction endFunction = (EndFunction)item;
                    if(visit(endFunction)){
                            return true;
                    }
        }catch (Exception e){} 
        try {
            System.out.println("TryHelp Var Def");
            VarDef varDef = (VarDef)item;
            if(visit(varDef)){
                return true;
            }
        }catch (Exception e){}
        try {
            System.out.println("Asgnmt");
            Asnmt asnmt = (Asnmt)item;
            if(visit(asnmt)){
                return true;
            } 
        }catch (Exception e){}
        try {
            System.out.println("TryHELP ParamList");
            ParamList paramlist = (ParamList)item;
            if(visit(paramlist)){
                return true;
            }
        }catch (Exception e){}
        try {
            System.out.println("TryHelp FucntCall");
            FunctionCall funcCall = (FunctionCall)item;
            if(visit(funcCall)){
                return true;
            }
        }catch (Exception e){}
        try{
            System.out.println("TryHelp Arithmetic");
            Arithmetic art = (Arithmetic)item;
            if(visit(art)){
                return true;
            }
        }catch (Exception e){}
        try{
            System.out.println("TryHelp Condition");
            Conditions condition = (Conditions)item;
            if(visit(condition)){
                return true;
            }
        }catch (Exception e){}
        
	
	return false;
	}	
	

    public boolean visit(Arithmetic add) {
    
        System.out.println("IN ARITHMETIC VISITOR");
	
        int op = ((Yytoken)(add.getOp())).getToken();
        System.out.println(op);
        int left = ((Yytoken)(((Literals)add.getLeft()).getInstance())).getToken();
        System.out.println(add.getLeft());
        int right = ((Yytoken)(((Literals)add.getRight()).getInstance())).getToken();
        System.out.println(right);
        System.out.println("Values " + left + right + op);
        if (op == ToYLexer.PLUS || op == ToYLexer.MINUS ){
            if (((left == ToYLexer.NUMBER || left == ToYLexer.IDENTIFIER) && (right == ToYLexer.NUMBER || right == ToYLexer.IDENTIFIER)) || ((left == ToYLexer.STRING || left == ToYLexer.IDENTIFIER) && (right == ToYLexer.STRING || right == ToYLexer.IDENTIFIER))){
                return true;
            }
        }
        if (op == ToYLexer.MULT || op == ToYLexer.DIVIDE || op == ToYLexer.MOD ){
            if ((left == ToYLexer.NUMBER || left == ToYLexer.IDENTIFIER) && (right == ToYLexer.NUMBER || right == ToYLexer.IDENTIFIER) ){
                return true;
            }
        }
        
        return false;
    }


    public boolean visit(Logic add) {
    
        System.out.println("IN LOGIC VISITOR");
	
        int left = ((Yytoken)(add.getLeft())).getToken();
        int right = ((Yytoken)(add.getRight())).getToken();
	
        if (left == ToYLexer.BOOL && right == ToYLexer.BOOL){
            return true;
        }
        return false;
    }


    public boolean visit(Conditions add) {
    
        System.out.println("IN CONDITIONS VISITOR");
        System.out.print(((Yytoken)(((Literals)add.getLeft()).getInstance())).getToken());
	
        int op = ((Yytoken)(add.getOp())).getToken();
        int left = ((Yytoken)(((Literals)add.getLeft()).getInstance())).getToken();
        int right = ((Yytoken)(((Literals)add.getRight()).getInstance())).getToken();
	
        if (op == ToYLexer.GREATERTHAN || op == ToYLexer.GREATERTHANOREQ || op == ToYLexer.LESSTHAN || op == ToYLexer.LESSTHANOREQ ){
            System.out.println("CHECK ME 1");
            if ((left == ToYLexer.NUMBER || left == ToYLexer.IDENTIFIER) && (right == ToYLexer.NUMBER || right == ToYLexer.IDENTIFIER)){
                System.out.println("CHECK ME 2");
                return true;
            }
        }
	
        if (op == ToYLexer.DOUBLEEQ || op == ToYLexer.NOTEQ ){
            if (((left == ToYLexer.NUMBER || left == ToYLexer.IDENTIFIER) && (right == ToYLexer.NUMBER || left == ToYLexer.IDENTIFIER)) || ((left == ToYLexer.WORD || left == ToYLexer.IDENTIFIER) && (right == ToYLexer.WORD || left == ToYLexer.IDENTIFIER)) ){
                return true;
            }
        }
        
        return false;
    }
    

    public boolean visit(UnaryOperators add) {
        System.out.println("IN UNARYOPERATORS VISITOR");
        
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
    

    //TODO -- do we need to check expression here? 
    public boolean visit(Asnmt add) {
    
        System.out.println("IN ASNMT VISITOR");
        System.out.println(add.getExp());
	
        int name = (((Yytoken)(add.getVar())).getToken());
        Object item = add.getExp();
        System.out.println(add.getExp());
        if (!(name == ToYLexer.IDENTIFIER)){
            return false;
        }
	
        if(!tryHelper(item)){
            System.out.println("IN TryHELPER");
            return false;
        }else{  
        }
        return true;
    }
    

    //TODO -- do we need to check expression 
    public boolean visit(EndFunction add) {
    
        System.out.println("IN ENDFUNCTION VISITOR");
        int type = ((Yytoken)(add.getType())).getToken();
	
        // ADD have to add expresison here 
        if (type == ToYLexer.PRINTF){
            int printME = ((Yytoken)(add.getExp())).getToken(); 
            if(printME != ToYLexer.STRING){
                return false;
            }
        }
        if(type == ToYLexer.RETURN){
            //if exp here 
        }
        return true;
    }
    

    //TODO -- do we need to check the statements in the body of the for loop?
    public boolean visit(ForLoop add) {
    
        System.out.println("IN FORLOOP VISITOR");
	
        Asnmt iterator = ((Asnmt)(add.getIterator()));
        System.out.println("Assignment");
	
        Conditions condition = ((Conditions)(add.getConditional()));
        System.out.println("condition");
	
        System.out.println(add.getIncrement());
        Asnmt increment = ((Asnmt)(add.getIncrement()));
        System.out.println("increment");
	
        StmtList body = ((StmtList)(add.getBody()));
        System.out.println("body");
      
        int name = (((Yytoken)(iterator.getVar())).getToken());
        int item = ((Yytoken)((Literals)iterator.getExp()).getInstance()).getToken();

        //CHECK ITERATION
        if(!(name == ToYLexer.IDENTIFIER)){
             return false;
        }
        if(!(item == ToYLexer.IDENTIFIER || item == ToYLexer.NUMBER )){
             return false;
        }
       
        //CHECK CONDITIONAL
        if (!visit(condition)){
             System.out.println("Check Condition");
            return false; 
        }
        //checks for incrementation at pos 3 of for loop 
        //TODO FINISH FORLOOP  
        int name2 = (((Yytoken)(increment.getVar())).getToken());
        Asnmt exp = (Asnmt)(increment.getExp());
        if (!visit(increment)){
            System.out.println("Check increment");
            return false; 
        }
        System.out.println("VALID increment");
        
       
        for(int i = 0; i < body.getSize(); i++) {
            System.out.println(body.getSize());
            System.out.println("Check body");
            System.out.println(body.elementAt(i));
            if(!(tryHelper(body.elementAt(i)))){    
                    System.out.println("Check element of body");         
                    return false;               
                }                                  
        }
	    return true;
    }
			
   
    //TODO -- check the if and else bodies 
    public boolean visit(IfStmt add) {
    
        System.out.println("IN IFSTMT VISITOR");
	
        Conditions condition = ((Conditions)(add.getConditional()));
        StmtList ifBody = ((StmtList)(add.getIfBody()));
        StmtList elseBody = ((StmtList)(add.getElseBody()));
	
        //checks for conditional expression at pos 2 in for loop 
        if (!visit(condition)){
            return false; 
        }

        return true;
    }


    public boolean visit(StructCreator add) {
    
        System.out.println("IN STRUCTCREATOR VISITOR");
	
        int name = ((Yytoken)(add.getName())).getToken();
        StmtList fields = ((StmtList)(add.getFeilds()));
	
        if(!(name == ToYLexer.IDENTIFIER)){
            return false; 
        }
	
        for (int i = 0; i < fields.getSize(); i++){
            VarDef v = (VarDef) fields.elementAt(i);
            if(!visit(v)){
                return false;
            }
         }
        return true;
    }


    //TODO -- body 
    public boolean visit(FunctionConstruct add) {
    
        System.out.println("IN FUNCTIONCONSTRUCT VISITOR");
	
        System.out.println(((Yytoken)((Keyword)(add.getReturnType())).getKeyword()).getToken());
        int returnType = ((Yytoken)((Keyword)(add.getReturnType())).getKeyword()).getToken();
	
        System.out.println(add.getName());
        int name = ((Yytoken)(add.getName())).getToken();
	
        StmtList params = ((StmtList)(add.getParameters()));
        StmtList body = ((StmtList)(add.getBody()));
	
        if(!(returnType == ToYLexer.INT || returnType == ToYLexer.STRING || returnType == ToYLexer.BOOL || returnType == ToYLexer.VOID)){
            return false; 
        }
	
        System.out.println("VALID RETURN TYPE");
        if(!(name == ToYLexer.IDENTIFIER)){
             return false; 
        }
	
        System.out.println("VALID NAME");
        for (int i = 0; i < params.getSize(); i++){
            VarDef v = ((VarDef)(params.elementAt(i)));
            if(!visit(v)){
                return false;
            }
         }
	 
        for (int i = 0; i < body.getSize(); i++){
            System.out.println(body.getSize());
            System.out.println(body.elementAt(i));
            if(!tryHelper(body.elementAt(i))){
                return false;
            }
        }
        return true;

    }


    public boolean visit(FunctionCall add) {
    
        System.out.println("IN FUNCTIONCALL VISITOR");
	
        int name = ((Yytoken)(add.getName())).getToken();
        StmtList params = ((StmtList)(add.getParameters()));
	
        if(!(name == ToYLexer.IDENTIFIER)){
            return false; 
        }
	
        for (int i = 0; i < params.getSize(); i++){
            int v = ((Yytoken)(params.elementAt(i))).getToken();
            if(!(v == ToYLexer.IDENTIFIER)){
                return false;
            }
         }
        return true;
        
    }
    
    
    public boolean visit(ParamList add) {
    
        System.out.println("IN PARAMLIST VISITOR");
        StmtList params = ((StmtList)(add.getParameters()));
	
        for (int i = 0; i < params.getSize(); i++){
            int v = ((Yytoken)(params.elementAt(i))).getToken();
            if(!(v == ToYLexer.IDENTIFIER)){
                return false;
            }
         }
        return true;
    }
    
    
    public boolean visit(VarDef add) {
    
        System.out.println("IN VARDEF VISITOR");
	
        int type = ((Yytoken)((Keyword)(add.getType())).getKeyword()).getToken();
        int name = ((Yytoken)(add.getName())).getToken();
	
        if ((type == ToYLexer.BOOL || type == ToYLexer.INT || type == ToYLexer.STRING ) && name == ToYLexer.IDENTIFIER){
            return true;
        }
        return false;
    }
    
    
    //TODO how to different between type function and construct 
    public boolean visit(Program add) {
    
        System.out.println("IN PROGRAM VISITOR");
        StmtList pgm = (StmtList) add.getProgram();
	
        for (int i = 0; i < pgm.getSize(); i++){
            try{
                FunctionConstruct function = (FunctionConstruct)(pgm.elementAt(i));
                if(visit(function)){
                    return true;
                }
                try{
                    StructCreator struct = (StructCreator)(pgm.elementAt(i));
                    if(visit(struct)){
                        return true;
                    }
                }catch(Exception e){
                    
                }

            }catch(Exception e){

            }
        }

    	return false;
    }
    
    
    public boolean visit(Keyword add) {
    
        System.out.println("IN KEYWORD VISITOR");
	
        int keyword = ((Yytoken)(add.getKeyword())).getToken();
        if( keyword == ToYLexer.VOID || keyword == ToYLexer.TRUE || keyword == ToYLexer.FALSE ){
            return true;
        }
    	return false;
    }


     public boolean visit(StmtList add) {
            return true;
     }
     

    public boolean visit(Literals add){
    
        System.out.println("IN LITERAL VISITOR");
        return true;
    }

}

// A declaration of all the visitor methods for each AST subclass
interface Visitor {

    public boolean visit(Arithmetic symbol);

    public boolean visit(Logic symbol);

    public boolean visit(Conditions symbol);

    public boolean visit(UnaryOperators symbol);

    public boolean visit(Asnmt symbol);

    public boolean visit(EndFunction symbol);

    public boolean visit(ForLoop symbol);

    public boolean visit(IfStmt symbol);

    public boolean visit(StructCreator symbol);
    
    public boolean visit(VarDef vardef);

    public boolean visit(FunctionConstruct symbol);

    public boolean visit(FunctionCall symbol);
    
    public boolean visit(ParamList paramList);
    
    public boolean visit(Program program);
    
    public boolean visit(Keyword keyword);

    public boolean visit(StmtList keyword);

    public boolean visit(Literals literal);

}


/* ------------------------- Symbol Table Helper Functions ------------------------- */
/* --------------------------------------------------------------------------------- */
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
   
/* ---------------------------- Symbol Table Class ------------------------ */
/* ------------------------------------------------------------------------ */

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



/* --------------------- Parser - Lexer Link --------------------- */
/* ------------------------------------------------------------- */
    class ToYLexer implements ToY.Lexer {
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
    
     	Yytoken token;
     
     	@Override
      	public Object getLVal() {
        	return token;
      	}

      	@Override
      	public int yylex () throws IOException{
         	token = (yylex.yylex());
         	if(token != null){
            		return token.getToken();
         	}else{
            		return 0;
         	}
    	}
}
    
/*
to get the string name Yytoken.getValue();
Var addVar = new Var(name.type);
symbolTable.add_symbol(addVar);
*/
