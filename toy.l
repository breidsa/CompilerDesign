class Token {
    String text;
    String label;
    Token (String t, String l) {
        text = t;
        label = l;
    }
    public String toString() {
        return String.format("%s %s", type, text);
    }
}
%%

%public
%class Subst
%standalone
Digit = [0 - 9]
AnyLet = [A - Za - z]
Others = [0 - 9 & .]
WhiteSp = [\040\ n]
%unicode

%{
  String name;
%}

%%

{Digit}+ {
    return "Digit";
}
{WhiteSp}+ {
    return "White Space Here";
}

"name " [a-zA-Z]+  { name = yytext().substring(5); }
[Hh] "ello"        { System.out.print(yytext()+" "+name+"!"); }

