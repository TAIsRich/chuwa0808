1. What is the checked exception and unchecked exception in Java, could you give one example?
	•	Checked exceptions − A checked exception is an exception that is checked (notified) by the compiler at compilation-time, these are also called as compile time exceptions. These exceptions cannot simply be ignored, the programmer should take care of (handle) these exceptions.
		For example, if you use FileReader class in your program to read data from a file, if the file specified in its constructor doesn't exist, then a FileNotFoundException occurs, and the compiler prompts the programmer to handle the exception.
	•	Unchecked exceptions − An unchecked exception is an exception that occurs at the time of execution. These are also called as Runtime Exceptions. These include programming bugs, such as logic errors or improper use of an API. Runtime exceptions are ignored at the time of compilation.
	For example, if you have declared an array of size 5 in your program, and trying to call the 6th element of 	the array then an ArrayIndexOutOfBoundsExceptionexception occurs.

2. Can there be multiple finally blocks?
You can only have one finally clause per try/catch/finally statement, but you can have multiple such statements, either in the same method or in multiple methods.

3. When both catch and finally return values, what will be the final result?
The value from finally values

4. What is optional? why do you use it? write an optional example
Optional is a container object used to contain not-null objects. Optional object is used to represent null with absent value. This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values. It is introduced in Java 8 and is similar to what Optional is in Guava.

Every Java Programmer is familiar with NullPointerException. It can crash your code. And it is very hard to avoid it without using too many null checks. So, to overcome this, Java 8 has introduced a new class Optional in java.util package. It can help in writing a neat code without using too many null checks. By using Optional, we can specify alternate values to return or alternate code to run. This makes the code more readable because the facts which were hidden are now visible to the developer.

Eg: Optional<String> optional = Optional.empty();

5. Why finally always be executed ?

The finally block is always get executed unless there is an abnormal program termination either resulting from a JVM crash or from a call to System.exit().
	•	A finally block is always get executed whether the exception has occurred or not.
	•	If an exception occurs like closing a file or DB connection, then the finally block is used to clean up the code.
	•	We cannot say the finally block is always executes because sometimes if any statement like System.exit() or some similar code is written into try block then program will automatically terminate and the finally block will not be executed in this case.
	•	A finally block will not execute due to other conditions like when JVM runs out of memory when our java process is killed forcefully from task manager or console when our machine shuts down due to power failure and deadlock condition in our try block.

6. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/
src/main/java/com/chuwa/exercise/collection

7. What is Java 8 new features ?
Java 8 was released on 18th March 2014. That’s a long time ago but still many projects are running on Java 8. It’s because it was a major release with a lot of new features. Let’s look at all the exciting and major features of Java 8 with example code.
Some of the important Java 8 features are;
	1	forEach() method in Iterable interface
	2	default and static methods in Interfaces
	3	Functional Interfaces and Lambda Expressions
	4	Java Stream API for Bulk Data Operations on Collections
	5	Java Time API
	6	Collection API improvements
	7	Concurrency API improvements
	8	Java IO improvements

8. What are the types of design patterns in Java ?
In core java, there are mainly three types of design patterns, which are further divided into their sub-parts:
1.Creational Design Pattern
	1	Factory Pattern
	2	Abstract Factory Pattern
	3	Singleton Pattern
	4	Prototype Pattern
	5	Builder Pattern.
2. Structural Design Pattern
	1	Adapter Pattern
	2	Bridge Pattern
	3	Composite Pattern
	4	Decorator Pattern
	5	Facade Pattern
	6	Flyweight Pattern
	7	Proxy Pattern

3. Behavioral Design Pattern
	1	Chain Of Responsibility Pattern
	2	Command Pattern
	3	Interpreter Pattern
	4	Iterator Pattern
	5	Mediator Pattern
	6	Memento Pattern
	7	Observer Pattern
	8	State Pattern
	9	Strategy Pattern
	10	Template Pattern
	11	Visitor Pattern

9. What are the SOLID Principles ?

SOLID stands for:
	•	S - Single-responsiblity Principle
	•	O - Open-closed Principle
	•	L - Liskov Substitution Principle
	•	I - Interface Segregation Principle
	•	D - Dependency Inversion Principle

10. How can you achieve thread-safe singleton patterns in Java ?
A thread safe singleton is created so that singleton property is maintained even in multithreaded environment. To make a singleton class thread safe, getInstance() method is made synchronized so that multiple threads can’t access it simultaneously.

11. What do you understand by the Open-Closed Principle (OCP) ?
the open–closed principle states "software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification"; that is, such an entity can allow its behaviour to be extended without modifying its source code.

12. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be
substituted with any object of type B. What does this actually mean? (from OA ) choose your answer. 1
1. It mean that if the object of type A can do something, the object of type B could also be able tp
perform the same thing
2. It means that all the objects of type A could execute all the methods present in its subtype B
3. It means if a method is present in class A, it should also be present in class B so that the object of
type B could substitute object of type A.
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

13. Watch the design pattern video, and type the code, submit it to MavenProject folder
singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6
d9
Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6
d9
Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f
7accf859bf7f6d9