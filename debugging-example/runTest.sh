#!/bin/bash
javac -cp /usr/share/java/junit4.jar:. SortTestNew.java
java -cp /usr/share/java/junit4.jar:. org.junit.runner.JUnitCore SortTestNew
