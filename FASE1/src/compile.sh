#/bin/bash
find -name "*.java" > paths.txt
javac -d "." @paths.txt

