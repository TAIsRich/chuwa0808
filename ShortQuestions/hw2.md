1.  What is wrapper class in Java and Why we need wrapper class? 
    Wrapper class provides a mechanism to convert primitive data types into objects and vise versa;
    Because JAVA is a Object Oriented language, we need to deal with objects in some scenarios, that's when we need wrapper class :
        - change the value in method: java only support call by value, if we pass by primitive type, it won't change.
        - serialization
        - synchronization
        - java.util package
        - Collection Framework: ArrayList, LinkedList, Vector, HashSet, LinkedHashSet, TreeSet, PriorityQueue, ArrayDeque


2.  What is the difference between HashMap and HashTable?
    - Synchronization: HashMap is not synchronized, not thread-safe while HashTable is synchronized, thread-safe and can be shared with many threads; we can call Collections.synchronizedMap() to make the hashmap synchronized while hashtable is internally synchronized and can't be unsynchronized
    - null key: HashMap allows one null key and multiple null values while HashTable don't
    - HashMap is fast while HashTable is slow
    - HashMap inherits AbstractMap class, hashtable inherits Dictionary class

3.  What is String pool in Java and why we need String pool? 
    It's a storage area in Java heap where string literals stores. Whenever created a string it would occupy some space in String Constant Pool.
    A string pool decreases the number of string objects created iin JVM, thereby reducing memory load and inproving performance; Provides reusability : it saves time to create a new string if there is already a string with the same value present, the old one is reused and the reference is returned.


4.  What is Java garbage collection?
    It's a automatic memory management process. when run java programs on JVM, objects are created as a portion of heap memory and eventually they would no longer be needed and GC find them and delete to free up memory.


5.  What are access modifiers and their scopes in Java? 
    1. private: within the same class and not from the outside class
    2. default: within the same package 
    3. protected: within the same package and outside with the help of child class
    4. public: anywhere


6.  What is final key word? (Filed, Method, Class)
    - final variable: to create constant variable
    - final method: prevent method overriding
    - final class: prevent inheritance

7.  What is static keyword? (Filed, Method, Class). When do we usually use it?
    Static means the particular member belongs to a type itself rather than to an instance of that type:
    - static fields(class variables) : when declare a static field, exactly a single copy of that field is created and shared among all instances (store in heap) 
    - static methods :belongs to class, we can call them without creating the object of the class in which they reside. 
            1. static method can't be overridden (static methods are resolved at compile time and method overriding is part of runtime polymorphism)
            2. abstract method can't be static
            3. static method can't use this or super keywords
    - static class: static nested classes only have access to static members of the outer class.  it behave exactly like any other top-level class but are enclosed in the only class that will access it, to provide better packaging convenience.


8.  What is the differences between overriding and overloading?
    overriding : same method signature in both superclass and child class; runtime polymorphism
    overloading : same mathod name but different parameters in the same class; compile time polymorphism

9.  What is the differences between super and this? 
    - this represents current instance of a class, super refers to current instance of parent class
    - this used to call default constructor, super parent class constructor
    - this used to access methods of current class, super:parent
    - this keyword can be referred from static context i.e can be invoked from static instance. For instance we can write System.out.println(this.x) which will print value of x without any compilation or runtime error. System.out.println(super.x) will leads to compile time error.

10.  What is the Java load sequence?
    static block - static variables - constructor 

11.  What is Polymorphism? And how Java implements it? 
    it's the ability of a class to provide different implementations of a method depending on the types of objects passed to the method. allows us to perform the same action in different ways. Java implements it by method overloading and overriding.

12.  What is Encapsulation? 
    it is a mechanism of wrapping the data (variables) and code acting on the data (methods) together as a single unit. In encapsulation, the variables of a class will be hidden from other classes, and can be accessed only through the methods of their current class.

    How Java implements it? 
    - declare the variables of class as private
    - provide public setter and getter methods

    And why we need encapsulation? 
    - make the fields of a class read-only or write-only
    - a class can have total control over what is stored in its fields


13.  What is Interface and what is abstract class? What are the differences between them?
    - Interface: a blueprint that can be used to implement a class. no concrete methods contained. All methods inside are abstract. can not be instantiated.
    - Abstract class: has abstract keyword whem declared, should have at least one abstract method. can have multiple concrete methods. Abstract classes allow you to create blueprints for concrete classes. But the inheriting class should implement the abstract method.

    difference:
    1. interface is slow, abstract class is fast
    2. interface can implement multiple inheritance, only one abstract class can be inherited
    3. interface contains only abstract methods while abstract class contains Abstract & concrete methods
    4. a Class can implement multiple interfaces inherit only one Abstract Class
    5. The interface does not have access modifiers. Everything defined inside the interface is assumed public modifier.Abstract Class can have an access modifier.
    6. interface cannot contain data fields while abstract class can have data fields.
    7. An interface cannot declare constructors or destructors. An abstract class can declare constructors and destructors.
    8. interface can have only public abstract methods while abstract class has protected and public abstract methods.


15.  What are Queue interface implementations and what are the differences and when to use what? 
    - PriorityQueue ：stores its elements internally according to their natural order
    - LinkedList：using Linked List
    - ArrayDeque ：supports insertion and deletion from both the ends，thread-safe


16.  What is Runtime/unchecked exception? what is Compile/Checked Exception?
    - An unchecked exception (also known as an runtime exception) in Java is something that has gone wrong with the program and is unrecoverable. 
        - NullPointerException 
        - BindException
        - IndexOutOfBoundsException
    - A checked exception is caught at compile time so if something throws a checked exception the compiler will enforce that you handle it.
        - ClassNotFoundException
        - InterruptedException
        - IOException
        - InstantiationException
        - SQLException
        - FileNotFoundException
    

17.  what is the difference between throw and throws?
     The throws keyword is used to declare which exceptions can be thrown from a method, while the throw keyword is used to explicitly throw an exception within a method or block of code.


18.  Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?
    Because we need to check more specific one first.
