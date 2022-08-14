### Homework 2
1. What is wrapper class in Java and Why we need wrapper class? 

   	1. A wrapper class is a class whose object wraps or contains primitive types.
    	2. Need of warpper classes.
        	- They convert primitive data types into objects.
        	- The classes in java.util package handles only objects and hence wrapper classes help in this case too.
        	- Data structure in the Collection framework store only objects and not primitive types.
        	- An object is needed to support synchronization in multithreading.

2. What is the difference between HashMap and HashTable?

   |              | HahTable                                           | HashMap                                              |
   | ------------ | :------------------------------------------------- | ---------------------------------------------------- |
   | Synchronized | HashTable is synchronized                          | HashMap is not synchronized                          |
   | Thread Safe  | HashTable is thread safe                           | HashMap is not thread safe                           |
   | Null objects | HashTable does not allows null keys or null values | HashMap allows one null key and multiple null values |
   | performace   | HashTable is faster                                | HashMap is slower than HashTable                     |

3. What is String pool in Java and why we need String pool? 

   	1. String pool is a pool of Strings stored in Java Heap Memory.
    	2. The purpose of String pool
        - String is immutable in Java.
        - String pool helps in saving a lot of sapce for Java to create a string.

4. What is Java garbage collection?

   	- Java garbage collection is the process by which Java programs perform automatic memory management.
   	- Java programs compile to bytecode that can be run on a Java Virtual Machine or JVM for short.
   	- When Java programs run on the JVM, objects are created on the heap, which is a portion of memory dedicated to the program.
   	- Eventually, some objects will no longer be needed. The garbage collector finds these unused objects and deletes when them to free up memory.

5. What are access modifiers and their scopes in Java?

    1. Access modifiers are keywords that can be used to control the visibility of fields, methods, and constructors in a class.

    2. The four access mofiers in Java are public, protected, default, and private.

    3. Their scopes

       | Members of Java   | Private     | Default | Protected | Public |
       | ----------------- | ----------- | ------- | --------- | ------ |
       | Class             | No          | Yes     | No        | Yes    |
       | Variable          | Yes         | Yes     | Yes       | Yes    |
       | Method            | Yes         | Yes     | Yes       | Yes    |
       | Constructor       | Yes         | Yes     | Yes       | Yes    |
       | Interface         | No          | Yes     | No        | Yes    |
       | Initializer Block | Not Allowed |         |           |        |

6. What is **final** key word? (Filed, Method, Class)

   	1. If we initialize a variable with the final keyword, then we cannot modify its values.
   	1. If we declare a class as final, the final classes can not be inherited by others classes.
   	1. If we declare a method as final, then it cannot be ovrridden by any subclasses.

7. What is **static** keyword? (Filed, Method, Class). When do we usually use it?

    1. In Java, static keyword is a non-access modifier and can be used for the following:

       - Static Block

         ​    If you need to do the computation in order to initialize your **static variables**, you can declare a static block that gets executed exactly once, when the class is first loaded. 

       - Static Variable

         ​	When you declare a variable as static, then a single copy of the variable is created and divided among all objects at the class level.  Static variables are, essentially, global variables. Basically, all the instances of the class share the same static variable. Static variables can be created at class-level only.

       - Static Method

         ​	When a method is declared with the *static* keyword, it is known as a static method. The most common example of a static method is the main( ) method. Methods declared as static can have the following restrictions:

         - They can directly call other static methods only.
         - They can access static data directly.

       - Static Classes

         ​	A class can be made static only if it is a nested class. Nested static class doesn’t need a reference of Outer class. In this case, a static class cannot access non-static members of the Outer class.

8. What is the differences between **overriding** and **overloading**?

    	1.  what is Overriding and Overloading.
         - When two or more methods in the same class have the same name but different parameters, it’s called Overloading. When the method signature (name and parameters) are the same in the superclass and the child class, it’s called Overriding.

   2. Differences
      - Overriding implements Runtime Polymorphism whereas Overloading implements Compile time polymorphism.
      - The method Overriding occurs between superclass and subclass. Overloading occurs between the methods in the same class.
      - Overriding methods have the same signature i.e. same name and method arguments. Overloaded method names are the same but the parameters are different.
      - With Overloading, the method to call is determined at the compile-time. With overriding, the method call is determined at the runtime based on the object type.
      - If overriding breaks, it can cause serious issues in our program because the effect will be visible at runtime. Whereas if overloading breaks, the compile-time error will come and it’s easy to fix.

9. What is the differences between **super** and **this**?

   | Key                                | this                                                         | super                                                        |
   | ---------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
   | Represent and Reference            | this keyword mainly represents the current instance of a class. | On other hand super keyword represents the current instance of a parent class. |
   | Interaction with class constructor | this keyword used to call default constructor of the same class. | super keyword used to call default constructor of the parent class. |
   | Method accessibility               | this keyword used to access methods of the current class as it has reference of current class. | One can access the method of parent class with the help of super keyword. |
   | Static context                     | this keyword can be referred from static context i.e can be invoked from static instance. For instance we can write System.out.println(this.x) which will print value of x without any compilation or runtime error. | On other hand super keyword can't be referred from static context i.e can't be invoked from static instance. For instance we cannot write System.out.println(super.x) this will leads to compile time error. |

10. What is the Java load sequence?

    	 - The ClassLoader Delegation Hierarchy Model always functions in the order 
    	 - **Application ClassLoader->Extension ClassLoader->Bootstrap ClassLoader**. 
    	 - The Bootstrap ClassLoader is always given the higher priority, next is Extension ClassLoader and then Application ClassLoader.

11. What is Polymorphism? And how Java implements it? 

    	1. In simple words, we can define polymorphism as **the ability of a message to be displayed in more than one form**.
     	2. Java implements polymorphism in two ways: 
         	-  Static or compile-time polymorphism is done by method overloading (more then one methods sharing the same name but different number/types/order of parameters) 
         	-  Dynamic or runtime polymorphism is done by method overriding (defining a method in the child class which has the same name and same number/types/order of parameters as that in parent class)

12. What is Encapsulation? How Java implements it? And why we need encapsulation? 

    	1. encapsulation describes the idea of bundling data and methods that work on that data within one unit, like a class in Java. 
    	1. Encapsulation can be used **to hide both data members and data functions or methods associated with an instantiated class or object**.

13. What is Interface and what is abstract class? What are the differences between them?

     1. An Interface in Java programming language is defined as **an abstract type used to specify the behavior of a class**. An interface in Java is a blueprint of a class. 

     2. An abstract class is **a class that is declared abstract —it may or may not include abstract methods**. Abstract classes cannot be instantiated, but they can be subclassed.

     3. Differences

        | Key                  | Abstract Class                                               | Interface                                                    |
        | -------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
        | Supported Methods    | Abstract class can have both an abstract as well as concrete methods. | Interface can have only abstract methods. Java 8 onwards, it can have default as well as static methods. |
        | Multiple Inheritance | Multiple Inheritance is not supported.                       | Interface supports Multiple Inheritance.                     |
        | Supported Variables  | final, non-final, static and non-static variables supported. | Only static and final variables are permitted.               |
        | Implementation       | Abstract class can implement an interface.                   | Interface can not implement an interface, it can extend an interface. |
        | Keyword              | Abstract class declared using abstract keyword.              | Interface is declared using interface keyword.               |
        | Inheritance          | Abstract class can inherit another class using extends keyword and implement an interface. | Interface can inherit only an inteface.                      |
        | Inheritance          | Abstract class can be inherited using extends keyword.       | Interface can only be implemented using implements keyword.  |
        | Access               | Abstract class can have any type of members like private, public. | Interface can only have public members.                      |

14. design a parking lot (put the code to **codingQuestions**/coding1 folder, )

    ​	1. See code on codingQuestions/coding1

15. If you have no ability to design it, please find the solution in internet, then understand it, then type it.
    (**Do not just copy and paste**)

16. What are Queue interface implementations and what are the differences and when to use what? 

    | LinkedList                                                   | PriorityQueue                                                |
    | ------------------------------------------------------------ | ------------------------------------------------------------ |
    | Due to the dynamicity and ease of insertions and deletions, they are preferred over the arrays or queues | provides us a way to process the objects based on the priority. |

17. What is Runtime/unchecked exception? what is Compile/Checked Exception?

     	1. An unchecked exception is an exception that occurs at the time of execution. These are also called as Runtime Exceptions. These include programming bugs, such as logic errors or improper use of an API. Runtime exceptions are ignored at the time of compilation. 
         		-  For example, if you have declared an array of size 5 in your program, and trying to call the 6th element of the array then an *ArrayIndexOutOfBoundsExceptionexception* occurs.
    	1. A checked exception is an exception that occurs at the compile time, these are also called as compile time exceptions. These exceptions cannot simply be ignored at the time of compilation, the programmer should take care of (handle) these exceptions.

18. what is the difference between throw and throws?

    	1. Both throw and throws are concepts of exception handling in Java. 
    	1. The throws keyword is used to declare which exceptions can be thrown from a method.
    	1. While the throw keyword is used to explicitly throw an exception within a method or block of code.

19. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime 
    exception before Exception?
    - Exception is the parent class of null/runtime exceptions.
    - If we put exception before null / runtime exception. All excepetions will be exception catch.
    Then those exceptions will not get specfic deal with.
