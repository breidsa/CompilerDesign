default:
	clear
	jflex toy.l 
	bison toy.y -L java --o ToYParser.java 
	javac *.java -Xdiags:verbose  
	java toy.y < Test
	
clean:
	rm Yylex.java *.class Yylex.java Yylex.java\~