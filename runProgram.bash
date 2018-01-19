#!/bin/bash
compile="javac -cp 'hamcrest-core-1.3.jar;.;junit-4.12.jar' StringList.java StringArrayList.java StringArrayListTest.java"
eval $compile
run="java -cp 'junit-4.12.jar;.;hamcrest-core-1.3.jar' org.junit.runner.JUnitCore StringArrayListTest"
eval $run