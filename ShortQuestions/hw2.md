1. What is wrapper class in Java and Why we need wrapper class?
A Wrapper class is a class which contains the primitive data types (int, char, short, byte, etc). 
In other words, wrapper classes provide a way to use primitive data types (int, char, short, byte, etc) as objects. 
These wrapper classes come under java.util package.
The reason to have Wrapper Class is:
(1) Wrapper Class will convert primitive data types into objects. 
The objects are necessary if we wish to modify the arguments passed into the method 
(because primitive types are passed by value).
(2) The classes in java.util package handles only objects and hence wrapper classes help in this case also.
(3) Data structures in the Collection framework such as ArrayList and 
Vector store only the objects (reference types) and not the primitive types.
(4) The object is needed to support synchronization in multithreading.

2. What is the difference between HashMap and HashTable?
HashMap is non-syncronized and is not thread safe while HashTable is thread safe and is synchronized.
HashMap allows one null key and values can be null whereas HashTable doesn't allow null key or value.
HashMap is faster than HashTable.
HashMap iterator is fail-safe where HashTable iterator is not fail-safe.
HashMap extends AbstractMap class where HashTable extends Dictionary class.

3. What is String pool in Java and why we need String pool?
String pool is nothing but a storage area in Java heap
where string literals stores. It is also known as String Intern Pool or String Constant Pool. 
It is just like object allocation. By default, it is empty and privately maintained by the Java String
class. Whenever we create a string the string object occupies some space in the heap memory. 
Creating a number of strings may increase the cost and memory too which may reduce the performance also.

The JVM performs some steps during the initialization of string literals that increase the performance 
and decrease the memory load. To decrease the number of String objects created in the JVM the String class 
keeps a pool of strings.

When we create a string literal, the JVM first check that literal in the String pool. 
If the literal is already present in the pool, it returns a reference to the pooled instance.
If the literal is not present in the pool, a new String object takes place in the String pool.

4. What is Java garbage collection?
Java garbage collection is the process by which Java programs perform automatic memory management. 
Java programs compile to bytecode that can be run on a Java Virtual Machine, or JVM for short. 
When Java programs run on the JVM, objects are created on the heap, which is a portion of memory dedicated to the program. 
Eventually, some objects will no longer be needed. The garbage collector finds these unused objects and deletes them to 
free up memory.

5. What are access modifiers and their scopes in Java?
Access modifiers are keywords that can be used to control the visibility of fields, methods, and constructors in a class. 
The four access modifiers in Java are public, protected, default, and private.
Four Types of Access Modifiers
Private: We can access the private modifier only within the same class and not from outside the class.
Default: We can access the default modifier only within the same package and not from outside the package. 
And also, if we do not specify any access modifier it will automatically consider it as default.
Protected: We can access the protected modifier within the same package and also from outside the package 
with the help of the child class. If we do not make the child class, we cannot access it from outside the package. 
So inheritance is a must for accessing it from outside the package.
Public: We can access the public modifier from anywhere. We can access public modifiers from within the class 
as well as from outside the class and also within the package and outside the package.

6. What is final key word? (Filed, Method, Class)
Java final keyword is a non-access specifier that is used to restrict a class, variable, and method. 
If we initialize a variable with the final keyword, then we cannot modify its value.
If we declare a method as final, then it cannot be overridden by any subclasses. 
And, if we declare a class as final, we restrict the other classes to inherit or extend it.
In other words, the final classes can not be inherited by other classes.

7. What is static keyword? (Filed, Method, Class). When do we usually use it?
In Java, static keyword is mainly used for memory management. It can be used with variables, methods, blocks and
nested classes. It is a keyword which is used to share the same variable or method of a given class. 
Basically, static is used for a constant variable or a method that is same for every instance of a class. 
The main method of a class is generally labeled static.

In order to create a static member (block, variable, method, nested class), you need to precede its declaration 
with the keyword static. When a member of the class is declared as static, it can be accessed before the objects
of its class are created, and without any object reference.

8. What is the differences between overriding and overloading?
When two or more methods in the same class have the same name but different parameters, it’s called Overloading. 
When the method signature (name and parameters) are the same in the superclass and the child class, it’s called Overriding.

Overriding vs Overloading
Overriding implements Runtime Polymorphism whereas Overloading implements Compile time polymorphism.
The method Overriding occurs between superclass and subclass. Overloading occurs between the methods in the same class.
Overriding methods have the same signature i.e. same name and method arguments. Overloaded method names are the same 
but the parameters are different.
With Overloading, the method to call is determined at the compile-time. With overriding, the method call is determined 
at the runtime based on the object type.
If overriding breaks, it can cause serious issues in our program because the effect will be visible at runtime. 
Whereas if overloading breaks, the compile-time error will come and it’s easy to fix.

9. What is the differences between super and this?
super() as well as this() keyword both are used to make constructor calls. 
super() is used to call Base class’s constructor(i.e, Parent’s class) 
while this() is used to call the current class’s constructor. 

10. What is the Java load sequence?
Class starts from being loaded into the virtual machine memory to unloading the memory. 
Its whole life cycle includes seven stages: loading, verification, preparation, parsing, initialization, use and unloading. 
"The first process of loading "yes" class plus mechanism ". In the loading stage, the virtual machine mainly completes three things:
(1) Get the binary byte stream defined by a class through its fully qualified name
(2) The static storage structure represented by this byte stream is transformed into the runtime data structure of the method area
(3) A class object representing this class is generated in the heap as an access to these data in the method area.
Compared with other stages of class loading, the loading stage is the most controllable stage, 
because programmers can load using the system’s class loader or their own class loader. 
We will introduce this class loader in detail in the last part. 
Here, we only need to know that the role of class loader is the three things that the above virtual machine needs to complete.

11. What is Polymorphism? And how Java implements it?
Polymorphism is the ability of an object to take on different forms. In Java, polymorphism refers to the ability of a class 
to provide different implementations of a method, depending on the type of object that is passed to the method.

To put it simply, polymorphism in Java allows us to perform the same action in many different ways. 
Any Java object that can pass more than one IS-A test is polymorphic in Java. Therefore, all the Java objects are 
polymorphic as it has passed the IS-A test for their own type and for the class Object.

Java implements polymorphism in two ways: 
1. Static or compile-time polymorphism is done by method overloading 
(more then one methods sharing the same name but different number/types/order of parameters) 
2. Dynamic or runtime polymorphism is done by method overriding (defining a method in the child class which has the same name
and same number/types/order of parameters as that in parent class)

12. What is Encapsulation? How Java implements it? And why we need encapsulation?
Encapsulation in Java is a mechanism of wrapping the data (variables) and code acting on the data (methods) together as a 
single unit. In encapsulation, the variables of a class will be hidden from other classes, and can be accessed only through 
the methods of their current class. Therefore, it is also known as data hiding.

To achieve encapsulation in Java:
Declare the variables of a class as private.
Provide public setter and getter methods to modify and view the variables values.

Benefits of Encapsulation
The fields of a class can be made read-only or write-only.
A class can have total control over what is stored in its fields.

13. What is Interface and what is abstract class? What are the differences between them?
Interface:
The interface is a blueprint that can be used to implement a class. The interface does not contain any concrete methods
(methods that have code). All the methods of an interface are abstract methods.
An interface cannot be instantiated. However, classes that implement interfaces can be instantiated. 
Interfaces never contain instance variables but, they can contain public static final variables 
(i.e., constant class variables)

Abstract；
A class which has the abstract keyword in its declaration is called abstract class. Abstract classes should have at least one
abstract method. , i.e., methods without a body. It can have multiple concrete methods.
Abstract classes allow you to create blueprints for concrete classes. But the inheriting class should implement the abstract method.
Abstract classes cannot be instantiated.

Type of methods: Interface can have only abstract methods. An abstract class can have abstract and non-abstract methods. From Java 8, it can have default and static methods also.
Final Variables: Variables declared in a Java interface are by default final. An abstract class may contain non-final variables.
Type of variables: Abstract class can have final, non-final, static and non-static variables. The interface has only static and final variables.
Implementation: Abstract class can provide the implementation of the interface. Interface can’t provide the implementation of an abstract class.
Inheritance vs Abstraction: A Java interface can be implemented using the keyword “implements” and an abstract class can be extended using the keyword “extends”.
Multiple implementations: An interface can extend one or more Java interfaces, an abstract class can extend another Java class and implement multiple Java interfaces.
Accessibility of Data Members: Members of a Java interface are public by default. A Java abstract class can have class members like private, protected, etc.

14. design a parking lot (put the code to codingQuestions/coding1 folder, )
1. If you have no ability to design it, please find the solution in internet, then understand it, then type it.
(Do not just copy and paste)

15. What are Queue interface implementations and what are the differences and when to use what?
The Queue interface of the Java collections framework provides the functionality of the queue data structure. 
It extends the Collection interface.
In order to use the functionalities of Queue, we need to use classes that implement it:
ArrayDeque
LinkedList
PriorityQueue

16. What is Runtime/unchecked exception? what is Compile/Checked Exception?
In Java, exceptions under Error and RuntimeException classes are unchecked exceptions, everything else under throwable is checked. 
Consider the following Java program. It compiles fine, but it throws ArithmeticException when run. 
The compiler allows it to compile because ArithmeticException is an unchecked exception.

17. what is the difference between throw and throws?
Both throw and throws are concepts of exception handling in Java. The throws keyword is used to declare which exceptions can 
be thrown from a method, while the throw keyword is used to explicitly throw an exception within a method or block of code.

The throws keyword is used in a method signature and declares which exceptions can be thrown from a method. 
The throws keyword can be useful for propagating exceptions in the call stack and allows exceptions to not necessarily be 
handled within the method that declares these exceptions.

On the other hand, the throw keyword is used within a method body, or any block of code, and is used to explicitly throw a 
single exception. The throw keyword can be useful for throwing exceptions based on certain conditions within a code block and
for throwing custom exceptions.

18. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime
exception before Exception?
Because the inheritance relation ship is:
java.lang.Object
	java.lang.Throwable
		java.lang.Exception
			java.lang.RuntimeException
				java.lang.NullPointerException
So in the exception order, we need to go with NUll-Runtime-Exception order to be checked