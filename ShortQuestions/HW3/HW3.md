### 1. What is the checked exception and unchecked exception in Java, could you give one example?
The checked exception are the exceptions that are checked at compile time. If some code within a method throws a checked exception, then the method must either handle the exception or it must specify the exception using the throws keyword. In checked exception, there are two types: fully checked and partially checked exceptions. A fully checked exception is a checked exception where all its child classes are also checked, like IOException, InterruptedException. A partially checked exception is a checked exception where some of its child classes are unchecked, like Exception.

For example, consider the following Java program that opens the file at location "C:\test\a.txt" and prints the first three lines of it. The program doesn't compile, because the function main() uses FileReader() and FileReader() throws a checked exception FileNotFoundException. It also uses readLine() and close() methods, and these methods also throw checked exception IOException.

The unchecked exception are the exceptions that are not checked at compile time. In C++, all exceptions are unchecked, so it is not forced by the compiler to either handle or specify the exception. It is up to the programmers to be civilized, and specify or catch the exceptions. In Java, exceptions under Error and RuntimeException classes are unchecked exceptions, everything else under throwable is checked. 

Consider the following Java program. It compiles fine, but it throws ArithmeticException when run. The compiler allows it to compile because ArithmeticException is an unchecked exception.
### 2. Can there be multiple finally blocks?
You can only have one finally clause per try/catch/finally statement, but you can have multiple such statements, either in the same method or in multiple methods.

Basically, a try/catch/finally statement is:
- try
- catch (0 or more)
- finally (0 or 1)
### 3. When both catch and finally return values, what will be the final result?
In a try-catch-finally block that has return statements, only the value from the finally block will be returned. When returning reference types, be aware of any updates being done on them in the finally block that could end up in unwanted results.
### 4. What is optional? why do you use it? write an optional example
Every Java Programmer is familiar with NullPointerException. It can crash your code. And it is very hard to avoid it without using too many null checks. So, to overcome this, Java 8 has introduced a new class Optional in java.util package. It can help in writing a neat code without using too many null checks. By using Optional, we can specify alternate values to return or alternate code to run. This makes the code more readable because the facts which were hidden are now visible to the developer.

```java
// Java program with Optional Class
 
import java.util.Optional;
 
public class OptionalDemo {
    public static void main(String[] args)
    {
        String[] words = new String[10];
        Optional<String> checkNull
            = Optional.ofNullable(words[5]);
        if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.print(word);
        }
        else
            System.out.println("word is null");
    }
}
```
### 5. Why finally always be executed ?
The purpose of the finally clause is to have a single location for relinquishing resources (such as file handles or database connections) that were acquired in the try clause, whether or not an exception occurred.

The finally block is always get executed unless there is an abnormal program termination either resulting from a JVM crash or from a call to System.exit():
- A finally block is always get executed whether the exception has occurred or not.
- If an exception occurs like closing a file or DB connection, then the finally block is used to clean up the code.
- We cannot say the finally block is always executes because sometimes if any statement like System.exit() or some similar code is written into try block then program will automatically terminate and the finally block will not be executed in this case.
- A finally block will not execute due to other conditions like when JVM runs out of memory when our java process is killed forcefully from task manager or console when our machine shuts down due to power failure and deadlock condition in our try block.
### 6. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection
### 7. What is Java 8 new features ?
- Default method and static method in interface
- Lambda & Functional Interface
- Optional
- Method Reference
```java
Arrays.sort(stringsArray,(s1,s2)->s1.compareToIgnoreCase(s2));
Arrays.sort(stringsArray, String::compareToIgnoreCase);
```
- Stream API
### 8. What are the types of design patterns in Java ?
1. Creational Design Pattern
- Factory Pattern
- Abstract Factory Pattern
- Singleton Pattern
- Prototype Pattern
- Builder Pattern
2. Structural Design Pattern
- Adapter Pattern
- Bridge Pattern
- Composite Pattern
- Decorator Pattern
- Facade Pattern
- Flyweight Pattern
- Proxy Pattern
3. Behavioral Design Pattern
- Chain Of Responsibility Pattern
- Command Pattern
- Interpreter Pattern
- Iterator Pattern
- Mediator Pattern
- Memento Pattern
- Observer Pattern
- State Pattern
- Strategy Pattern
- Template Pattern
- Visitor Pattern
### 9. What are the SOLID Principles ?
- S - Single-responsiblity Principle: A class should have one and only one reason to change, meaning that a class should have only one job.
- O - Open-closed Principle: Objects or entities should be open for extension but closed for modification.
- L - Liskov Substitution Principle: Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T.
- I - Interface Segregation Principle: A client should never be forced to implement an interface that it doesn't use, or clients shouldn't be forced to depend on methods they do not use.
```java
public interface BearKeeper {
    void washTheBear();
    void feedTheBear();
    void petTheBear();
}
// above change to below
public interface BearCleaner {
    void washTheBear();
}

public interface BearFeeder {
    void feedTheBear();
}

public interface BearPetter {
    void petTheBear();
}
// only implement what we need
public class BearCarer implements BearCleaner, BearFeeder {

    public void washTheBear() {
        //I think we missed a spot...
    }

    public void feedTheBear() {
        //Tuna Tuesdays...
    }
}
```
- D - Dependency Inversion Principle: Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions.
```java
public class Windows98Machine{

    private final Keyboard keyboard;
    private final Monitor monitor;

    // Here, we're using the dependency injection pattern to facilitate adding the Keyboard dependency into the Windows98Machine class without NEW keyword.
    public Windows98Machine(Keyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }
}
public class StandardKeyboard implements Keyboard { }
```
### 10. How can you achieve thread-safe singleton patterns in Java ?
Thread Safe Singleton: A thread safe singleton is created so that singleton property is maintained even in multithreaded environment. To make a singleton class thread safe, getInstance() method is made synchronized so that multiple threads can't access it simultaneously.
```java
// Java program to create Thread Safe
// Singleton class
public class GFG
{
  // private instance, so that it can be
  // accessed by only by getInstance() method
  private static GFG instance;
 
  private GFG()
  {
    // private constructor
  }
 
 //synchronized method to control simultaneous access
  synchronized public static GFG getInstance()
  {
    if (instance == null)
    {
      // if instance is null, initialize
      instance = new GFG();
    }
    return instance;
  }
}
```
Pros:
- Lazy initialization is possible.
- It is also thread safe.
- getInstance() method is synchronized so it causes slow performance as multiple threads can't access it simultaneously.

Lazy initialization with Double check locking: In this mechanism, we overcome the overhead problem of synchronized code. In this method, getInstance is not synchronized but the block which creates instance is synchronized so that minimum number of threads have to wait and that's only for first time.
### 11. What do you understand by the Open-Closed Principle (OCP) ?
This means that a class should be extendable without modifying the class itself. In doing so, we stop ourselves from modifying existing code and causing potential new bugs in an otherwise happy application.
```java
public class Guitar {

    private String make;
    private String model;
    private int volume;

    //Constructors, getters & setters
}
public class SuperCoolGuitarWithFlames extends Guitar {

    private String flameColor;

    //constructor, getters + setters
}
```
### 12. Liskov's substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
1. It mean that if the object of type A can do something, the object of type B could also be able to perform the same thing
2. It means that all the objects of type A could execute all the methods present in its subtype B
3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

If class A is a subtype of class B, we should be able to replace B with A without disrupting the behavior of our program. choose 1.
### 13. Watch the design pattern video, and type the code, submit it to MavenProject folder
singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9
Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9
Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d