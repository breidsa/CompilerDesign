default:
	clear
	jflex ToY.l 
	bison ToY.y -L java '-Wcounterexamples'
	javac *.java -Xdiags:verbose 
	java Yylex Test.txt
	java ToY Test.txt

	
clean:
	rm Yylex.java *.class Yylex.java Yylex.java\~