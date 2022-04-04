default:
	clear
	jflex toy.l 
	javac Yylex.java
	java Yylex Test.txt
	bison toy.y 
 	# javac *.java \ 
	
clean:
	rm Yylex.java *.class Yylex.java Yylex.java\~