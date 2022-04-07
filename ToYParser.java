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
/* "toy.y":8  */

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;

/* "ToYParser.java":52  */

/**
 * A Bison parser, automatically generated from <tt>toy.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class ToYParser
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
    S_IDENTIFIER(6),               /* IDENTIFIER  */
    S_TRUE(7),                     /* TRUE  */
    S_FALSE(8),                    /* FALSE  */
    S_IF(9),                       /* IF  */
    S_THEN(10),                    /* THEN  */
    S_ELSE(11),                    /* ELSE  */
    S_FOR(12),                     /* FOR  */
    S_AND(13),                     /* AND  */
    S_OR(14),                      /* OR  */
    S_MOD(15),                     /* MOD  */
    S_VOID(16),                    /* VOID  */
    S_RETURN(17),                  /* RETURN  */
    S_PRINTF(18),                  /* PRINTF  */
    S_STRUCT(19),                  /* STRUCT  */
    S_RBRACKET(20),                /* RBRACKET  */
    S_LBRACKET(21),                /* LBRACKET  */
    S_SEMICOLON(22),               /* SEMICOLON  */
    S_COMMA(23),                   /* COMMA  */
    S_LESSTHAN(24),                /* LESSTHAN  */
    S_GREATERTHAN(25),             /* GREATERTHAN  */
    S_DOUBLEEQ(26),                /* DOUBLEEQ  */
    S_LESSTHANOREQ(27),            /* LESSTHANOREQ  */
    S_GREATERTHANOREQ(28),         /* GREATERTHANOREQ  */
    S_NOTEQ(29),                   /* NOTEQ  */
    S_NOT(30),                     /* NOT  */
    S_LEFTPAREN(31),               /* LEFTPAREN  */
    S_RIGHTPAREN(32),              /* RIGHTPAREN  */
    S_PLUS(33),                    /* PLUS  */
    S_MINUS(34),                   /* MINUS  */
    S_MULT(35),                    /* MULT  */
    S_DIVIDE(36),                  /* DIVIDE  */
    S_EQ(37),                      /* EQ  */
    S_ATTRIBUTE(38),               /* ATTRIBUTE  */
    S_YYACCEPT(39),                /* $accept  */
    S_type(40),                    /* type  */
    S_returnType(41),              /* returnType  */
    S_struct(42),                  /* struct  */
    S_declaration(43),             /* declaration  */
    S_proc(44),                    /* proc  */
    S_stmt(45),                    /* stmt  */
    S_stmtSeq(46),                 /* stmtSeq  */
    S_Lexp(47),                    /* Lexp  */
    S_pgm(48),                     /* pgm  */
    S_recursePgm(49),              /* recursePgm  */
    S_exp(50),                     /* exp  */
    S_op(51);                      /* op  */


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
      SymbolKind.S_IDENTIFIER,
      SymbolKind.S_TRUE,
      SymbolKind.S_FALSE,
      SymbolKind.S_IF,
      SymbolKind.S_THEN,
      SymbolKind.S_ELSE,
      SymbolKind.S_FOR,
      SymbolKind.S_AND,
      SymbolKind.S_OR,
      SymbolKind.S_MOD,
      SymbolKind.S_VOID,
      SymbolKind.S_RETURN,
      SymbolKind.S_PRINTF,
      SymbolKind.S_STRUCT,
      SymbolKind.S_RBRACKET,
      SymbolKind.S_LBRACKET,
      SymbolKind.S_SEMICOLON,
      SymbolKind.S_COMMA,
      SymbolKind.S_LESSTHAN,
      SymbolKind.S_GREATERTHAN,
      SymbolKind.S_DOUBLEEQ,
      SymbolKind.S_LESSTHANOREQ,
      SymbolKind.S_GREATERTHANOREQ,
      SymbolKind.S_NOTEQ,
      SymbolKind.S_NOT,
      SymbolKind.S_LEFTPAREN,
      SymbolKind.S_RIGHTPAREN,
      SymbolKind.S_PLUS,
      SymbolKind.S_MINUS,
      SymbolKind.S_MULT,
      SymbolKind.S_DIVIDE,
      SymbolKind.S_EQ,
      SymbolKind.S_ATTRIBUTE,
      SymbolKind.S_YYACCEPT,
      SymbolKind.S_type,
      SymbolKind.S_returnType,
      SymbolKind.S_struct,
      SymbolKind.S_declaration,
      SymbolKind.S_proc,
      SymbolKind.S_stmt,
      SymbolKind.S_stmtSeq,
      SymbolKind.S_Lexp,
      SymbolKind.S_pgm,
      SymbolKind.S_recursePgm,
      SymbolKind.S_exp,
      SymbolKind.S_op
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
  "STRING", "IDENTIFIER", "TRUE", "FALSE", "IF", "THEN", "ELSE", "FOR",
  "AND", "OR", "MOD", "VOID", "RETURN", "PRINTF", "STRUCT", "RBRACKET",
  "LBRACKET", "SEMICOLON", "COMMA", "LESSTHAN", "GREATERTHAN", "DOUBLEEQ",
  "LESSTHANOREQ", "GREATERTHANOREQ", "NOTEQ", "NOT", "LEFTPAREN",
  "RIGHTPAREN", "PLUS", "MINUS", "MULT", "DIVIDE", "EQ", "ATTRIBUTE",
  "$accept", "type", "returnType", "struct", "declaration", "proc", "stmt",
  "stmtSeq", "Lexp", "pgm", "recursePgm", "exp", "op", null
    };
  }

    /* The user-facing name of this symbol.  */
    public final String getName() {
      return yytnamerr_(yytname_[yycode_]);
    }

  };


  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>ToYParser</tt>.
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
    /** Token IDENTIFIER, to be returned by the scanner.  */
    static final int IDENTIFIER = 261;
    /** Token TRUE, to be returned by the scanner.  */
    static final int TRUE = 262;
    /** Token FALSE, to be returned by the scanner.  */
    static final int FALSE = 263;
    /** Token IF, to be returned by the scanner.  */
    static final int IF = 264;
    /** Token THEN, to be returned by the scanner.  */
    static final int THEN = 265;
    /** Token ELSE, to be returned by the scanner.  */
    static final int ELSE = 266;
    /** Token FOR, to be returned by the scanner.  */
    static final int FOR = 267;
    /** Token AND, to be returned by the scanner.  */
    static final int AND = 268;
    /** Token OR, to be returned by the scanner.  */
    static final int OR = 269;
    /** Token MOD, to be returned by the scanner.  */
    static final int MOD = 270;
    /** Token VOID, to be returned by the scanner.  */
    static final int VOID = 271;
    /** Token RETURN, to be returned by the scanner.  */
    static final int RETURN = 272;
    /** Token PRINTF, to be returned by the scanner.  */
    static final int PRINTF = 273;
    /** Token STRUCT, to be returned by the scanner.  */
    static final int STRUCT = 274;
    /** Token RBRACKET, to be returned by the scanner.  */
    static final int RBRACKET = 275;
    /** Token LBRACKET, to be returned by the scanner.  */
    static final int LBRACKET = 276;
    /** Token SEMICOLON, to be returned by the scanner.  */
    static final int SEMICOLON = 277;
    /** Token COMMA, to be returned by the scanner.  */
    static final int COMMA = 278;
    /** Token LESSTHAN, to be returned by the scanner.  */
    static final int LESSTHAN = 279;
    /** Token GREATERTHAN, to be returned by the scanner.  */
    static final int GREATERTHAN = 280;
    /** Token DOUBLEEQ, to be returned by the scanner.  */
    static final int DOUBLEEQ = 281;
    /** Token LESSTHANOREQ, to be returned by the scanner.  */
    static final int LESSTHANOREQ = 282;
    /** Token GREATERTHANOREQ, to be returned by the scanner.  */
    static final int GREATERTHANOREQ = 283;
    /** Token NOTEQ, to be returned by the scanner.  */
    static final int NOTEQ = 284;
    /** Token NOT, to be returned by the scanner.  */
    static final int NOT = 285;
    /** Token LEFTPAREN, to be returned by the scanner.  */
    static final int LEFTPAREN = 286;
    /** Token RIGHTPAREN, to be returned by the scanner.  */
    static final int RIGHTPAREN = 287;
    /** Token PLUS, to be returned by the scanner.  */
    static final int PLUS = 288;
    /** Token MINUS, to be returned by the scanner.  */
    static final int MINUS = 289;
    /** Token MULT, to be returned by the scanner.  */
    static final int MULT = 290;
    /** Token DIVIDE, to be returned by the scanner.  */
    static final int DIVIDE = 291;
    /** Token EQ, to be returned by the scanner.  */
    static final int EQ = 292;
    /** Token ATTRIBUTE, to be returned by the scanner.  */
    static final int ATTRIBUTE = 293;

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
  public ToYParser(Lexer yylexer)
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
        
/* "ToYParser.java":554  */

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
    Context(ToYParser parser, YYStack stack, SymbolKind token) {
      yyparser = parser;
      yystack = stack;
      yytoken = token;
    }

    private ToYParser yyparser;
    private YYStack yystack;


    /**
     * The symbol kind of the lookahead token.
     */
    public final SymbolKind getToken() {
      return yytoken;
    }

    private SymbolKind yytoken;
    static final int NTOKENS = ToYParser.YYNTOKENS_;

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

  private static final short yypact_ninf_ = -37;
  private static final byte yytable_ninf_ = -1;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
     266,   -37,   -37,   -37,   -37,   -37,     0,   -37,     8,   266,
     266,     4,     6,    -1,   -37,   266,   266,   -37,   -37,    83,
      83,   -37,   -37,    25,    13,     5,   -37,    83,    19,     9,
     256,   -37,    -3,    10,    15,    14,    17,   256,    43,    35,
      20,    14,    52,    53,    14,    55,   -37,   -37,    40,   -37,
     -37,    14,    14,   -37,    38,    85,   256,    71,    78,   -37,
      14,    70,    61,   -37,    95,    56,   221,   120,   -37,   -37,
     -37,   -37,   -37,   -37,   -37,   -37,   -37,   -37,   -37,   -37,
     -37,   -37,   -37,    14,    69,   -37,   -37,   -37,   145,    89,
      14,   102,    14,   -37,   221,    91,   -37,   -37,   162,   256,
     187,   -37,    92,   104,    14,   -37,   256,   204,   -37,   256,
      84,   256,   -37
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
       0,     2,     3,     4,     5,     7,     0,     6,     0,     0,
      27,     0,     0,     0,    26,    27,    27,    25,     1,     0,
       0,    29,    28,     0,     0,     0,     9,     0,     0,     0,
       0,     8,     5,     0,     0,     0,     0,    21,     0,     0,
       0,     0,     0,     0,     0,     0,    30,    31,    23,    32,
      33,     0,     0,    36,     0,     0,    21,     0,     0,    10,
       0,     0,     0,    24,     0,     0,    35,     0,    43,    44,
      42,    15,    47,    46,    45,    49,    48,    50,    38,    39,
      40,    41,    51,     0,     0,    22,    16,    17,     0,     0,
       0,     0,     0,    37,    34,     0,    18,    19,     0,     0,
       0,    14,     0,    12,     0,    20,     0,     0,    13,     0,
       0,     0,    11
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte[] yypgoto_ = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -37,    23,   -37,     2,    -2,     3,   -29,    62,   -30,   108,
      -6,   -36,   -37
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte[] yydefgoto_ = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
       0,    38,     8,    15,    24,    16,    56,    57,    53,    11,
      17,    54,    83
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
      40,    39,     9,    10,    18,    61,    12,    40,    64,    21,
      22,     9,    10,    63,    13,    66,    67,    46,    25,    47,
      48,    49,    50,     7,    88,    29,    40,    19,    41,    31,
      20,    26,     7,     7,    42,    43,    27,    28,     7,     7,
      30,    44,    23,    23,    51,    52,    45,    94,    55,    58,
      23,    68,    69,    70,    98,    59,   100,    60,    62,    48,
      71,    65,    72,    73,    74,    75,    76,    77,   107,    40,
     103,    78,    79,    80,    81,    82,    40,   108,    43,    40,
     110,    40,   112,    68,    69,    70,     1,     2,     3,     4,
      84,    86,    90,    92,    72,    73,    74,    75,    76,    77,
      87,    95,    89,    78,    79,    80,    81,    82,    68,    69,
      70,    97,    99,   101,   105,   106,   111,    14,    85,    72,
      73,    74,    75,    76,    77,     0,     0,    91,    78,    79,
      80,    81,    82,    68,    69,    70,     0,     0,     0,     0,
       0,     0,     0,     0,    72,    73,    74,    75,    76,    77,
       0,     0,    93,    78,    79,    80,    81,    82,    68,    69,
      70,     0,     0,     0,     0,     0,     0,    96,     0,    72,
      73,    74,    75,    76,    77,    68,    69,    70,    78,    79,
      80,    81,    82,     0,     0,     0,    72,    73,    74,    75,
      76,    77,     0,     0,   102,    78,    79,    80,    81,    82,
      68,    69,    70,     0,     0,     0,     0,     0,     0,   104,
       0,    72,    73,    74,    75,    76,    77,    68,    69,    70,
      78,    79,    80,    81,    82,     0,   109,     0,    72,    73,
      74,    75,    76,    77,    68,    69,    70,    78,    79,    80,
      81,    82,     0,     0,     0,    72,    73,    74,    75,    76,
      77,     0,     0,     0,    78,    79,    80,    81,    82,     1,
       2,     3,    32,     0,     0,    33,     0,     0,    34,     1,
       2,     3,     4,    35,    36,     0,     0,    37,     0,     0,
       0,     0,     5,     0,     0,     6
    };
  }

private static final byte[] yycheck_ = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
      30,    30,     0,     0,     0,    41,     6,    37,    44,    15,
      16,     9,     9,    43,     6,    51,    52,     3,    20,     5,
       6,     7,     8,     0,    60,    27,    56,    21,    31,    20,
      31,     6,     9,    10,    37,    38,    23,    32,    15,    16,
      21,    31,    19,    20,    30,    31,    31,    83,    31,     6,
      27,    13,    14,    15,    90,    20,    92,    37,     6,     6,
      22,     6,    24,    25,    26,    27,    28,    29,   104,    99,
      99,    33,    34,    35,    36,    37,   106,   106,    38,   109,
     109,   111,   111,    13,    14,    15,     3,     4,     5,     6,
       5,    20,    31,    37,    24,    25,    26,    27,    28,    29,
      22,    32,    32,    33,    34,    35,    36,    37,    13,    14,
      15,    22,    10,    22,    22,    11,    32,     9,    56,    24,
      25,    26,    27,    28,    29,    -1,    -1,    32,    33,    34,
      35,    36,    37,    13,    14,    15,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    24,    25,    26,    27,    28,    29,
      -1,    -1,    32,    33,    34,    35,    36,    37,    13,    14,
      15,    -1,    -1,    -1,    -1,    -1,    -1,    22,    -1,    24,
      25,    26,    27,    28,    29,    13,    14,    15,    33,    34,
      35,    36,    37,    -1,    -1,    -1,    24,    25,    26,    27,
      28,    29,    -1,    -1,    32,    33,    34,    35,    36,    37,
      13,    14,    15,    -1,    -1,    -1,    -1,    -1,    -1,    22,
      -1,    24,    25,    26,    27,    28,    29,    13,    14,    15,
      33,    34,    35,    36,    37,    -1,    22,    -1,    24,    25,
      26,    27,    28,    29,    13,    14,    15,    33,    34,    35,
      36,    37,    -1,    -1,    -1,    24,    25,    26,    27,    28,
      29,    -1,    -1,    -1,    33,    34,    35,    36,    37,     3,
       4,     5,     6,    -1,    -1,     9,    -1,    -1,    12,     3,
       4,     5,     6,    17,    18,    -1,    -1,    21,    -1,    -1,
      -1,    -1,    16,    -1,    -1,    19
    };
  }

/* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
   state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     3,     4,     5,     6,    16,    19,    40,    41,    42,
      44,    48,     6,     6,    48,    42,    44,    49,     0,    21,
      31,    49,    49,    40,    43,    43,     6,    23,    32,    43,
      21,    20,     6,     9,    12,    17,    18,    21,    40,    45,
      47,    31,    37,    38,    31,    31,     3,     5,     6,     7,
       8,    30,    31,    47,    50,    31,    45,    46,     6,    20,
      37,    50,     6,    47,    50,     6,    50,    50,    13,    14,
      15,    22,    24,    25,    26,    27,    28,    29,    33,    34,
      35,    36,    37,    51,     5,    46,    20,    22,    50,    32,
      31,    32,    37,    32,    50,    32,    22,    22,    50,    10,
      50,    22,    32,    45,    22,    22,    11,    50,    45,    22,
      45,    32,    45
    };
  }

/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    39,    40,    40,    40,    40,    41,    41,    42,    43,
      44,    45,    45,    45,    45,    45,    45,    45,    45,    45,
      45,    46,    46,    47,    47,    48,    48,    49,    49,    49,
      50,    50,    50,    50,    50,    50,    50,    50,    51,    51,
      51,    51,    51,    51,    51,    51,    51,    51,    51,    51,
      51,    51
    };
  }

/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     1,     1,     1,     1,     1,     1,     7,     2,
       8,    11,     6,     8,     5,     3,     3,     3,     4,     5,
       7,     0,     2,     1,     3,     2,     2,     0,     2,     2,
       1,     1,     1,     1,     3,     2,     1,     3,     1,     1,
       1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
       1,     1
    };
  }




  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 293;
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
      35,    36,    37,    38
    };
  }


  private static final int YYLAST_ = 285;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 18;
  private static final int YYNTOKENS_ = 39;

/* Unqualified %code blocks.  */
/* "toy.y":17  */

public static void main(String[] args) throws IOException {
 ToYLexer l = new ToYLexer(System.in);
 ToYParser p = new ToYParser(l);
 if (!p.parse()) System.out.println("INVALID");
}

/* "ToYParser.java":1234  */

}
/* "toy.y":127  */

    
    class ToyLexer implements toy.Lexer {
     InputStreamReader it;
     Yylex yylex;
     
     public ToyLexer(InputStream is){
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
    public class SymbolTable {
    enter_scope()
    exit_scope()
    
    }
    */


