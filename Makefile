default:
	clear
	jflex ToY.l 
	bison ToY.y -L java 
	javac *.java -Xdiags:verbose
	java ToY Test.txt

	
clean:
	rm Yylex.java *.class Yylex.java Yylex.java\~