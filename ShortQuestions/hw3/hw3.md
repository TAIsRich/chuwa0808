1. What is the checked exception and unchecked exception in Java, could you give one example?
	1. Checked exception is compile exception, will occur in compile time, must be handle or throw before execution
		1. example: IOException
	2. Uncheck exception is run time exception, will occur when the code executed, can't caught by compiler
		1. example: NullPointerException
2.  Can there be multiple finally blocks? 
	1. you can have only one finally block per try/catch statement, but you can have multiple try/catch/finally statement
3.  When both catch and finally return values, what will be the final result?
	1. final result will be the one that return from finally
4.  What is optional? why do you use it? write an optional example
	1. Optional is class that allowed some or nothing input
	2. you use optional because option allow you to input null value but still keeps the function working
	3. public int sum(optional<Integer> a, optional<Integer> b), if one or both the value are null, no exception will be throw by using optioanl object
5.  Why finally always be executed ?
	1. Finally always executed because you might need to close the file or dealing other staff after exception throwed
6.  Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection 
7.  What is Java 8 new features ?
	1. Optional<T>
	2. Static method
8.  What are the types of design patterns in Java ?
	1. Creational, Structural, and Behavioral design patterns
9.  What are the SOLID Principles ?
	1. Single Responsibility
	2. Open/Closed
	3. Liskov Substitution
	4. Interface Segregation
	5. Dependency Inversion
10.  How can you achieve thread-safe singleton patterns in Java ?
	1. Adding a synchronized keyword to the function that creates thread
11.  What do you understand by the Open-Closed Principle (OCP) ?
	1. open for extension, close for modification
12.  Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.  
	  1.  It mean that if the object of type A can do something, the object of type B could also be able tp perform the same thing
	  2.  It means that all the objects of type A could execute all the methods present in its subtype B
	  3.  It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
	  4.  It means that for the class B to inherit class A, objects of type B and objects of type A must be same.  
	`1. It mean that if the object of type A can do something, the object of type B could also be able tp perform the same thing `
13.  Watch the design pattern video, and type the code, submit it to MavenProject folder
   singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
   Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9
   Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9
   Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9