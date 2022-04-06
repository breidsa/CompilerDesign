default:
	clear
	jflex toy.l 
	bison toy.y -L java
	javac *.java 
	java toy.y < Test
	
clean:
	rm Yylex.java *.class Yylex.java Yylex.java\~