1.What is wrapper class in Java and Why we need wrapper class?

A Wrapper class is a class which contains the primitive data types (int, char, short, byte, etc). In other words, wrapper classes provide a way to use primitive data types (int, char, short, byte, etc) as objects.
Wrapper Class will convert primitive data types into objects. The objects are necessary if we wish to modify the arguments passed into the method (because primitive types are passed by value).
2.What is the difference between HashMap and HashTable?

HashMap is non-synchronized. It is not thread-safe and can’t be shared between many threads without proper synchronization code whereas Hashtable is synchronized. It is thread-safe and can be shared with many threads.
HashMap allows one null key and multiple null values whereas Hashtable doesn’t allow any null key or value.
HashMap is generally preferred over HashTable if thread synchronization is not needed.
3.What is String pool in Java and why we need String pool?

String Pool is a storage area in Java heap.
String allocation, like all object allocation, proves to be a costly affair in both the cases of time and memory. The JVM performs some steps while initializing string literals to increase performance and decrease memory overhead.
4.What is Java garbage collection?

Garbage collection in Java is the process by which Java programs perform automatic memory management. Java programs compile to bytecode that can be run on a Java Virtual Machine, or JVM for short. When Java programs run on the JVM, objects are created on the heap, which is a portion of memory dedicated to the program. Eventually, some objects will no longer be needed. The garbage collector finds these unused objects and deletes them to free up memory.
5.What are access modifiers and their scopes in Java?

As the name suggests access modifiers in Java helps to restrict the scope of a class, constructor, variable, method, or data member. There are four types of access modifiers available in java:
Default – No keyword required:
Same Class, Same package subclass, Same package non-subclass
Private
Same Class
Protected
Same Class, Same package subclass, Same package non-subclass, Different package subclass
Public
Same Class, Same package subclass, Same package non-subclass, Different package subclass, Different package non-subclass
6.What is final key word? (Filed, Method, Class)

When a variable is declared with the final keyword, its value can’t be modified, essentially, a constant. This also means that you must initialize a final variable.
When a class is declared with final keyword, it is called a final class. A final class cannot be extended(inherited).
When a method is declared with final keyword, it is called a final method. A final method cannot be overridden.
7.What is static keyword? (Filed, Method, Class). When do we usually use it?

If you need to do the computation in order to initialize your static variables, you can declare a static block that gets executed exactly once, when the class is first loaded.
When a variable is declared as static, then a single copy of the variable is created and shared among all objects at the class level. Static variables are, essentially, global variables. All instances of the class share the same static variable.
When a method is declared with the static keyword, it is known as the static method. The most common example of a static method is the main( ) method. As discussed above, Any static member can be accessed before any objects of its class are created, and without reference to any object. Methods declared as static have several restrictions:
They can only directly call other static methods.
They can only directly access static data.
They cannot refer to this or super in any way.
A class can be made static only if it is a nested class. We cannot declare a top-level class with a static modifier but can declare nested classes as static. Such types of classes are called Nested static classes. Nested static class doesn’t need a reference of Outer class. In this case, a static class cannot access non-static members of the Outer class.
8.What is the differences between overriding and overloading?

When two or more methods in the same class have the same name but different parameters, it's called Overloading. When the method signature (name and parameters) are the same in the superclass and the child class, it's called Overriding.
9.What is the differences between super and this?

this keyword mainly represents the current instance of a class. On other hand super keyword represents the current instance of a parent class.
10.What is the Java load sequence?

Maven Lifecycle: Below is a representation of the default Maven lifecycle and its 8 steps: Validate, Compile, Test, Package, Integration test, Verify, Install and Deploy.
11.What is Polymorphism? And how Java implements it?

Polymorphism in Java is the phenomenon by which an object can acquire an ability to operate from different perspectives.
Java implements polymorphism in two ways: 1. Static or compile-time polymorphism is done by method overloading 2. Dynamic or runtime polymorphism is done by method overriding.
12.What is Encapsulation? How Java implements it? And why we need encapsulation?

Encapsulation describes the idea of bundling data and methods that work on that data within one unit, like a class in Java. This concept is also often used to hide the internal representation, or state of an object from the outside. This is called information hiding.
Make the instance variables private so that they cannot be accessed directly from outside the class. You can only set and get values of these variables through the methods of the class.
The major advantage of encapsulation in Java is data hiding. Using encapsulation we can allow the programmer to decide on the access to data and methods operating on that data. For example, if we want a particular piece of data to be inaccessible to anyone outside the class, then we make that data private.
13.What is Interface and what is abstract class? What are the differences between them?

An abstract class allows you to create functionality that subclasses can implement or override. An interface only allows you to define functionality, not implement it.
14.design a parking lot (put the code to codingQuestions/coding1 folder, )


15.What are Queue interface implementations and what are the differences and when to use what?

LinkedBlockingQueue — an optionally bounded FIFO blocking queue backed by linked nodes
ArrayBlockingQueue — a bounded FIFO blocking queue backed by an array
PriorityBlockingQueue — an unbounded blocking priority queue backed by a heap
DelayQueue — a time-based scheduling queue backed by a heap
SynchronousQueue — a simple rendezvous mechanism that uses the BlockingQueue interface
16.What is Runtime/unchecked exception? what is Compile/Checked Exception?

An unchecked exception is an exception that occurs at the time of execution. These are also called as Runtime Exceptions. These include programming bugs, such as logic errors or improper use of an API. Runtime exceptions are ignored at the time of compilation.
These are the exceptions that are checked at compile time. If some code within a method throws a checked exception, then the method must either handle the exception or it must specify the exception using the throws keyword. In checked exception, there are two types: fully checked and partially checked exceptions. A fully checked exception is a checked exception where all its child classes are also checked, like IOException, InterruptedException. A partially checked exception is a checked exception where some of its child classes are unchecked, like Exception.
17.what is the difference between throw and throws?

The throw and throws are the concepts of exception handling in Java where the throw keyword throws the exception explicitly from a method or a block of code, whereas the throws keyword is used in the signature of the method.
18.Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?

Exception is the parent class of Runtime exceptions and Compiletime exceptions, so we put the Null/Runtime exception before Exception to try to locate the more specific exception, if any.