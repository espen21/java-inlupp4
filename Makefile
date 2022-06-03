CP = "src:tests"
FLAGS = -cp


parser: compile
	java $(FLAGS) $(CP) ParserDriver
debug: compile
	jdb  src/ParserDriver 

compile: src/*.java src/symbolic/*.java
	javac src/*.java src/symbolic/*.java

test: compileTests
	java $(FLAGS) $(CP) org.junit.runner.JUnitCore ParserTests


compileTests: compile
	javac $(FLAGS) $(CP) tests/ParserTests.java


clean: cleanClasses cleanEmacsTemps cleanTestClasses

cleanClasses: 
	rm -f src/*.class && rm -f src/symbolic/*.class

cleanEmacsTemps:
	rm -f src/*~ &&  rm -f src/symbolic/*~

cleanTestClasses:
	rm -f tests/*.class && rm -f tests/*~
