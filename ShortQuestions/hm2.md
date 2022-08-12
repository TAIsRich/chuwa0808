1. What is wrapper class in Java and Why we need wrapper class?
   1. wrapper class is a class containing primitive data type(int, short, byte etc), which provide a way to use primitive data as object.
   2. wrapper class will convert primitive data into  object, so that it is possible to modify the argument passed into the method since primitive data is passed by value. Besides, data structure in Collection framework like ArrayList and Vector only allow object(reference type) not primitive type.
2. What is the difference between HashMap and HashTable?
   1. HashMap is not thread-safe but HashTable is thread-safe. So we can't use HashMap in multithreaded java project without external synchronization. Also, the thread-safety of the hash table is achieved using internal synchronization, which makes it slower than HashMap.
   2. 
3. What is String pool in Java and why we need Stringpool?
   1. String Pool is a storage area in Java heap and Java String Pool allows caching of string objects.
   2. This saves a lot of memory for JVM because it can be used by other objects. 
4. What is Java garbage collection?
   1. java garbage collection is a task in JVM to automatically determine which memory is no longer used by java appliction and recycle this memory.
5. What are access modifiers and their scopes in Java?
   1. Access modifiers (or access specifiers) are keywords in object-oriented languages that set the accessibility of classes, methods, and other members. Access modifiers are a specific part of programming language syntax used to facilitate the encapsulation of components.
   2. ‘public’ is accessible from any class or package in the Java program.
   3. The protected access specifier allows access to entities through subclasses of the class in which the entity is declared.
   4. The ‘private’ access modifier is the one that has the lowest accessibility level. 
   5. A default class is accessible inside the package but it is not accessible from outside the package
6. What is final keyword?(Filed,Method,Class)
   1. a non-access specifier that is used to restrict a class, variable, and method. 
   2. If we initialize a variable with the final keyword, then we cannot modify its value. 
   3. If we declare a method as final, then it cannot be overridden by any subclasses.
   4. If we declare a class as final, we restrict the other classes to inherit or extend it.
7. What is static keyword?(Filed,Method,Class). When do we usually use it?
   1. The static keyword in Java is used to share the same variable or method of a given class. The static keyword is a non-access modifier used for methods and attributes. Static methods/attributes can be accessed without creating an object of a class.
   2. static class cannot be instantiated or inherited and that all of the members of the class are static in nature. In Java, the static keyword is primarily used for memory management. We can use the static keyword with variables, methods, blocks, and classes. Using the static class is a way of grouping classes together. It is also used to access the primitive member of the enclosing class through the object reference.
8. What is the differences between overriding and overloading?
   1. When two or more methods in the same class have the same name but different parameters, it's called Overloading. When the method signature (name and parameters) are the same in the superclass and the child class, it's called Overriding.
9.  What is the differences between super and this?
    1.  “super” in Java is used to refer to methods, static and instance variables, constructors of an immediate parent class. “this” in Java is used to refer to methods, static and instance variables, constructors of a current class.
10. What is the Java load sequence?
    1.  Application ClassLoader->Extension ClassLoader->Bootstrap ClassLoader. The Bootstrap ClassLoader is always given the higher priority, next is Extension ClassLoader and then Application ClassLoader.
11. What is Polymorphism? And how Java implements it?
    1.  Polymorphism means "many forms", and it occurs when we have many classes that are related to each other by inheritance.
    2.  Inheritance lets us inherit attributes and methods from another class. Polymorphism uses those methods to perform different tasks.
    3.  
12. What is Encapsulation? How Java implements it? And why we need encapsulation?
    1.  encapsulation describes the idea of bundling data and methods that work on that data within one unit, like a class in Java. This concept is also often used to hide the internal representation, or state of an object from the outside. This is called information hiding.
    2.  Encapsulation protects an object from unwanted access by clients. 
13. What is Interface and what is abstract class? What are the differences between them?
    1.  An abstract class contains an abstract keyword on the declaration whereas an Interface is a sketch that is used to implement a class.
14. design a parking lot (put the code to codingQuestions/coding1 folder, )
    1. If you have no ability to design it,please find the solution in internet,then understand it,then type it. (Do not just copy and paste)
15. What are Queue interface implementations and what are the differences and when to use what?
    1.  The Queue interface is present in java.util package and extends the Collection interface is used to hold the elements about to be processed in FIFO(First In First Out) order.
    2.  the most common classes are the PriorityQueue and LinkedList in Java.
    3.  PriorityQueue class which is implemented in the collection framework provides us a way to process the objects based on the priority. 
    4.  LinkedList is a class which is implemented in the collection framework which inherently implements the linked list data structure. It is a linear data structure where the elements are not stored in contiguous locations and every element is a separate object with a data part and address part. The elements are linked using pointers and addresses. Each element is known as a node. 
16. What is Runtime/unchecked exception? what is Compile/Checked Exception?
    1.  An unchecked exception is an exception that occurs at the time of execution. These are also called as Runtime Exceptions.
    2.  A checked exception is an exception that occurs at the compile time, these are also called as compile time exceptions. These exceptions cannot simply be ignored at the time of compilation, the programmer should take care of (handle) these exceptions.
17. what is the difference between throw and throws?
    1.  The throws keyword is used to declare which exceptions can be thrown from a method, while the throw keyword is used to explicitly throw an exception within a method or block of code.
18. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?(code is loacted under CodingQuestion/Coding1 folder)
    1.  if we put Exception before Null/Runtime exception, then Null/Runtime exception will be useless since the Exception will catch the error before Null/Runtime exception, so Null/Runtime exception will never be reachable.