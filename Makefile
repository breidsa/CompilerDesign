default:
	clear
	jflex ToY.l 
	bison ToY.y -L java 
	javac *.java -Xdiags:verbose 
	

	
clean:
	rm Yylex.java *.class Yylex.java Yylex.java\~