1. Read those codes and type it one by one by yourself. the push the code to your branch. 
	1. https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8
2.  practice stream API at least 3 times
	a. https://blog.devgenius.io/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82
3.  Write the Singleton design pattern include eager load and lazy load. 
	1. done
4.  What is Runtime Exception? could you give me some examples?
	1. Runtime Exception is uncheck exception that occur at run time, can't caught by compilers
	2. Example: Null Pointer Exceptions, Arithmetic Exception
5.  Could you give me one example of NullPointerException?
	1. String str = null;
	2. System.out.println(str);
6.  What is the Optional class?
	1. Optional class creates a optional objects of a type
	2. Can avoid null checks and run time nullPointerExceptions
7. What is the @FunctionalInterface?
	1. functional interface can have only one abstruct method
	2. can have lot of default methods
	3. Lambda is the implementation of the abstract method
8.  what is lamda?
	1. lambda is a short block of code that has parameter and expressions
9.  What is Method Reference?
	1. A way to simpify the lambda expressioon 
	2. Arrays.sort(stringsArray, String::compareToIgnoreCase);
10. What is Java 8 new features?
	1. StreamApi
	2. Functional Interface
	3. Lambda
	4. Optional
11. Lambda can use unchanged variable outside of lambda? what is the details?
	1. Yes, Lambda can use unchanged variable outside of lambda
	2. Final variables and non static variables that has no changed after it created can be use