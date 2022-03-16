default:
	clear
	jflex toy.l
	javac Yylex.java
	java Yylex Test.txt
	
clean:
	rm Yylex.java *.class Yylex.java Yylex.java\~