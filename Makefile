default:
	clear
	jflex ToY.l 
	bison ToY.y -L java '-Wcounterexamples'
	javac *.java -Xdiags:verbose 
	java ToY 

	
clean:
	rm Yylex.java *.class Yylex.java Yylex.java\~