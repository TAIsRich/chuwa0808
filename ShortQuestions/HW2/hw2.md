## hw2

### 1. What is wrapper class in Java and Why do we need wrapper class?

```
A wrapper class wraps (encloses) around a primitive data type and gives it an object appearance. Wrapper classes provide a way to use primitive data types (int, boolean, etc..) as objects. Wrapper classes are final and immutable. 

Two concepts are there in the wrapper classes namely autoboxing and unboxing:
- autoboxing: a procedure of converting a primitive value into an object of the corresponding wrapper class
- ex. Integer i=new Integer(10)
- unboxing: a procedure of converting an object of a wrapper type to its corresponding primitive value
- ex. int a=i.intValue()

Useful features of wrapper classes:
- convert primitive data types into objects (objects are needed if we wish to modify the arguments passed into a method since primitive types are passed by value)
- the classes in java.util package handles only objects and hence wrapper classes help in this case 
- the data structures in the Collection framework, such as ArrayList and Vector, store only objects (reference types) but not the primitive types
- an object is needed to support synchronization in multithreading
```

### 2. What is the difference between HashMap and HashTable?

```
- HashMap is non-synchronized. It is not thread-safe and cannot be shared between many threads without proper synchronization code. Hashtable is synchronized. It is thread-safe and can be shared with many threads.
- We can make the HashMap as synchronized by calling this code
Map m = Collections.synchronizedMap(hashMap); Hashtable is internally synchronized and can't be unsynchronized.
- HashMap inherits AbstractMap class. Hashtable inherits Dictionary class.
- HashMap is a new class introduced in JDK 1.2. 	Hashtable is a legacy class.
- HashMap allows one null key and multiple null values. Hashtable doesn't allow any null key or value.
- HashMap is traversed by Iterator. Hashtable is traversed by Enumerator and Iterator.
- Iterator in HashMap is fail-fast. 	Enumerator in Hashtable is not fail-fast.
- HashMap is fast. Hashtable is slow.
```

### 3. What is String pool in Java and why do we need String pool? 

```
String pool is a storage area in Java heap memory where string literals stores.

Advantages of String pool:
- String allocation, like all object allocation, proves to be a costly affair in both the cases of time and memory. The JVM performs some steps while initializing string literals to increase performance and decrease memory overhead. To decrease the number of String objects created in the JVM, the String class keeps a pool of strings.
- Each time a string literal is created, the JVM checks the string literal pool first. If the string already exists in the string pool, a reference to the pooled instance returns. If the string does not exist in the pool, a new String object initializes and is placed in the pool.
```

### 4. What is Java garbage collection?

```
Garbage Collection (GC):
- In C/C++, a programmer is responsible for both the creation and destruction of objects. Usually, programmer neglects the destruction of useless objects. Due to this negligence, at a certain point, sufficient memory may not be available to create new objects, and the entire program will terminate abnormally, causing OutOfMemoryErrors.
- In Java, the programmer need not care for all those objects which are no longer in use. Garbage collector destroys these objects. The main objective of Garbage Collector is to free heap memory by destroying unreachable objects.

Java Garbage collection (JGC): the process by which Java programs perform automatic memory management. Java programs compile to bytecode that can be run on a Java Virtual Machine (JVM). When Java programs run on the JVM, objects are created on the heap, which is a portion of memory dedicated to the program. Eventually, some objects will no longer be needed. The garbage collector finds these unused objects and deletes them to free up memory.
```

###5. What are access modifiers and their scopes in Java?

```
access modifier: set the access level for classes, constructors, attributes (fields) and methods

scopes of access modifiers:
```
[Access Modifier Scope](./access_modifier_scope)

### 6. What is final keyword? (Filed, Method, Class)

```
There are 48 reserved keywords in Java. 
Java final keyword is a non-access modifier used to restrict a class, variable and method: 
- If we initialize a variable with the final keyword, then we cannot modify its value.
- If we declare a method as final, then it cannot be overridden by any subclasses.
- If we declare a class as final, we restrict the other classes to inherit or extend it. In other words, the final classes can not be inherited by other classes.
```
[Final Keyword](./final_keyword)

### 7. What is static keyword? (Filed, Method, Class). When do we usually use it?

```
Java static keyword is a non-access modifier and is mainly used for memory management. The users can apply static keywords with:
- variables
- methods, 
- blocks
- nested classes

Static attributes and methods means they belongs to a class but not an object / instance, and can be shared in all instances:
- a static / class variable or method means that it can be accessed without creating an object / instance of the class, and a member / instance variable or method means that it must be accessed with creating an object of the class

A static / class method:
- can access the static / class variables (in the same class) directly
- can call the other static / class methods (in the same class) directly
- need to create an object / instance of the class, then access the object identifier.member / instance variables
- need to create an object / instance of the class, then call the object identifier.member / instance methods

A member / instance method:
 - can access the member / instance variables (in the same class) directly, 
 - and call the other member / instance methods (in the same class) directly
 - can access the static / class variables (in the same class) directly
 - can call the static / class methods (in the same class) directly


When to use:
- Use the static variable for the property which is common to all objects. For example, in class Student, all students share the same college name. 
- Use static methods for changing static variables.
- A class can be made static only if it is a nested class. We cannot declare a top-level class with a static modifier but can declare nested classes as static. Such types of classes are called Nested static classes. Nested static class does not need a reference of Outer class. In this case, a static class cannot access non-static members of the Outer class. 
```

### 8. What is the differences between overriding and overloading?

```
overload: in the same class, two or more methods have the same name but different
parameters, the return types could be same or different

override: the method signature (name and parameters) are same in the superclass and the subclass

difference:
- overload occurs between the methods in the same class, but override occurs between superclass and subclass
- overload implements compile-time polymorphism, override implements runtime polymorphism
- with overload, the method to call is determined at the compile-time; with override, the method to call is determined at the runtime
```

### 9. What is the differences between super and this?

[Difference Between this and super Keyword](./this_super)
[Difference Between this() and super() Keyword](./this()_super())

### 10. What is the Java load sequence?

```
With inheritance:
1. static code block or static variable from the parent class 
2. static code block or static variable from the child class 
3. variable or code block from the parent class 
4. Constructor from the parent class
5. variable or code block from the child class 
6. Constructor from the child class 

Without inheritance:
1. static code block  or static variable
2. variable or block of code
3. Constructor
```

### 11. What is Polymorphism? How does Java implement it?

```
polymorphism: inheritance lets us inherit attributes and methods from one class to another, and polymorphism uses the same method to perform different tasks, that means we can perform a single action in different ways

Example: think of a superclass called Animal, it has a method called animalSound(), the subclasses could be Pig, Cat, Dog, Birds and so on, and they can have their own implementations for the method animalSound(), the pig oinks, and the cat meows, etc.

class Animal {
    public void animalSound() { 
        System.out.println("The animal makes a sound");
    } 
}
class Pig extends Animal { 
    public void animalSound() {
        System.out.println("The pig says: wee wee"); 
    }
}
class Dog extends Animal { 
    public void animalSound() {
        System.out.println("The dog says: bow wow"); 
    }
}

class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal(); // Create a Animal object 
        Animal myPig = new Pig(); // Create a Pig object
        Animal myDog = new Dog(); // Create a Dog object myAnimal.animalSound();
        myPig.animalSound();
        myDog.animalSound(); 
    }
}

The animal makes a sound 
The pig says: wee wee 
The dog says: bow wow
```

### 12. What is Encapsulation? How does Java implement it? Why do we need encapsulation?

```
encapsulation: make sure "sensitive" data is hidden from users

How does Java implement：
- declare attributes as private, we cannot access it from outside of this class
- provide public get and set methods to access and update a private variable value
- this keyword is used to refer to the current object

benifits:
- better class control
- attributes can be made read-only (if you only use the get method), or write-only (if you only use the set method)
- the programmer can change one part of the code, but it does not affect other parts
- data security
```

### 13. What is Interface and what is abstract class? What are the differences between them?

```
abstraction: 
- hiding certain details and showing only essential information to the user for achieving security
- we can achieve abstraction with either abstract classes or interfaces, an abstract class cannot be used to create objects (to access an abstract class, it must be inherited by another concrete class), and an interface also cannot be used to create objects

abstract class: 
- a class that contains at least one abstract method, an abstract class can have abstract methods and / or non-abstract methods
- a non-abstract class can only have non-abstract methods
- an abstract method does not have a body, the body is provided by the subclass inheriting from the abstract class

interface: 
- a completely abstract class, an interface can only have abstract methods, and it is used to group related methods with empty bodies; but in Java 8, interface can contain default methods (default is explicit) or default static methods (static and default are explicit)
- the body of the interface method is provided by the "implement" class
- implement multiple interfaces, separate them with a comma

difference between an abstract class and an interface:
- an interface is abstract by default, then the modifier abstract is optional for an interface; the abstract modifier is necessary for an abstract class
- an interface cannot contain a constructor (as it cannot be used to create objects);
an abstract class can contain a constructor as a regular class
- all interface attributes are public, static and final by default, then the modifier public, static and final are optional (as an interface can only declare constants but not instance variables); for all abstract class attributes, the modifier public, default, protected, private, static and final must be shown explicitly if required
- in Java 8, all non-default methods of interface are public and abstract by default, then the modifier public and abstract are optional, but default methods or static default methods are not abstract but concrete methods; for all abstract class methods, the modifier public, protected, private and abstract must be shown explicitly if required
- we cannot define non-abstract methods in an interface, as all interface methods do not have a body, and the body is provided by the "implement" class; we can define abstract and / or non-abstract methods in an abstract class
- an interface can extend single or multiple interfaces using the keyword entends; a (abstract or non-abstract) class can only extend a single abstract class using the keyword extends
- an interface cannot implement single or multiple abstract classes; a (abstract or non-abstract) class can implement single or multiple interfaces with the
keyword implements
```

### 14. Design a parking lot (put the code to codingQuestions/coding1 folder). If you have no ability to design it, please find the solution in the internet, then **understand** it, then **type** it, **do not just copy and paste**.

[CODE](https://github.com/TAIsRich/chuwa0808/tree/Flora_Zhong/hw2/CodingQuestions/Coding1/parkingLlot)

### 15. What are Queue interface implementations and what are the differences and when to use what?

```
There are many concrete classes that implement Queue interface.

General-Purpose Queue Implementations:
ArrayDeque: 
- provide first in, first out (FIFO) queue operations for offer, poll
- deletion at the front or back is O(1)
- insertion at the front or back takes amortized constant time
- the Java Collection Framework (JCF) implementation does not allow insertion/deletion by index (if it was allowed, it would be worst-case O(n) because of shifting)
- does not support null elements
- faster than a linked list implementing the queue or deque data structure

LinkedList: 
- doubly-linked list
- provide first in, first out (FIFO) queue operations for offer, poll
- insertion/deletion at the front or back is O(1) 
- insertion/deletion by index is worst-case O(n) because you have to traverse the list to find the correct spot (if you have an iterator at the correct spot, insertion/deletion is O(1))
- support null elements
- require more storage than ArrayDequen since each node in a linked list includes links to other nodes

PriorityQueue: 
- based on the heap data structure
- order elements according to the order specified at construction time, which can be the elements' natural ordering or the ordering imposed by an explicit Comparator

Concurrent Queue Implementations: 
- ArrayBlockingQueue: a thread-safe fixed size FIFO blocking queue backed by an array
- LinkedBlockingQueue: an optionally bounded FIFO blocking queue backed by linked nodes
- LinkedBlockingDeque: the concurrent implementation of the Deque interface
- LinkedTransferQueue: an unbounded TransferQueue based on linked nodes
- ConcurrentLinkedQueue — an unbounded thread-safe queue based on linked nodes
- ConcurrentLinkedDeque: an unbounded concurrent deque based on linked nodes
- PriorityBlockingQueue: an unbounded blocking priority queue backed by a heap
- SynchronousQueue: a blocking queue where each insert operation must wait for a corresponding remove operation by another thread, and vice versa
- DelayQueue: a time-based scheduling queue backed by a heap
```
[Java Queue Implementations1](./queue_interface_implementation1)
[Java Queue Implementations2](./queue_interface_implementation2)


### 16. What is Runtime/unchecked exception? what is Compile/Checked Exception?

```
Exception is an unwanted or unexpected event, which occurs during the execution of a program, i.e. at run time, that disrupts the normal flow of the program’s instructions. In Java, there are two types of exceptions:

Checked Exception: 
- something has gone wrong in your code and is recoverable
- are checked and handled during the compile-time
- handle either by re-throwing (别人的method declare with keyword "throws", 你的method需要调用别人的method, 那么你的method signiture那里也declare with keyword "throws") or a try-catch block (catch后决定怎么处理，也可以就单纯的打印出来这个exception)
- directly inherit Throwable class except RuntimeException and Error, and extend Exception class

include:
- SQLException
- IOException
- ClassNotFoundException
- InvocationTargetException
- FileNotfound Exception

Unchecked Exception: 
- something has gone wrong with the program logic and is unrecoverable
- are checked during the runtime and occurs during the execution of a program
- the cause of unchecked exceptions is mostly due to programming errors like attempting to access an element with an invalid index, and calling the method with illegal arguments, etc.
- unlike the checked exceptions, the compiler generally ignores the unchecked exceptions during compilation, and the compiler does not check whether the user program contains the code to handle them or not
- directly inherit RuntimeException, and extend Exception class

include:
- ArithmeticException
- NullPointerException
- ArrayIndexOutOfBoundsException
- NumberFormatException
- InputMismatchException
- IllegalArgumentException
- IllegalStateException
- ClassCastException
- Missing Resource Exception
- No Such Element Exception
- Undeclared Throwable Exception
- Empty Stack Exception

note: 
keyword "throw": 
- produce a exception
- can be used in checked/unchecked exception

try-catch balock: 
- handle a exception: produce, print or solve
- can be used in checked/unchecked exception
```
[Exception](./exception)

### 17. what is the difference between throw and throws?

```
throws: 
- used in a method signature
- can declare multiple exceptions separated by a comma
- when the nethod has some statement(s) that can lead to the exception(s)

throw: 
- used in the method body (code block)
- can throw only one exception at a time
- when it is required to throw an explicit exception logically
```

### 18. Run the below three pieces codes, noticed the printed exceptions. Why do we put the Null/Runtime exception before Exception? (code is located under CodingQuestion/Coding1 folder)

```
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3
        String s = null; 
        try {
            System.out.println(b / a); 
            System.out.println(s.equals("aa")); throw new RuntimeException();
        } catch (ArithmeticException e) { 
            e.printStackTrace();
        } catch (NullPointerException e) { 
            e.printStackTrace();
        } catch (RuntimeException e) { 
            e.printStackTrace();
        } catch (Exception e) { 
            e.getMessage();
        }
        
        System.out.println("End ..."); 
    }
}

public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3
        String s = null; 
        try {
            // System.out.println(b / a);
            System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace(); 
        } catch (Exception e) {
            e.getMessage(); 
        }
        
        System.out.println("End ..."); 
    }
}

public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3
        String s = null; 
        try {
            // System.out.println(b / a);
            // System.out.println(s.equals("aa")); 
            throw new RuntimeException();
        } catch (ArithmeticException e) { 
            e.printStackTrace();
        } catch (NullPointerException e) { 
            e.printStackTrace();
        } catch (RuntimeException e) { 
            e.printStackTrace();
        } catch (Exception e) { 
            e.getMessage();
        }

        System.out.println("End ..."); 
    }
}
```
