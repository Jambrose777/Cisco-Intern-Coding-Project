javac GNode.java
javac MyGNode.java
javac Test.java
g++ -Wall -std=c++11 -o wordCount wordCount.cpp
 
java Test
echo
./wordCount

rm *.class
rm wordCount
