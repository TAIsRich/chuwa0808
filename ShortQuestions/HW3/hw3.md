## hw3

### 1. What is the checked exception and unchecked exception in Java, could you give one example?

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
[Exception](./exception.png)

### 2. Can there be multiple finally blocks?

```
finally: 
- can be used in association with a try-catch block
- the finally block will be executed after the try-catch block (could be one try following multiple catches), but before the control transfers back to its origin
- guarantee that a section of code will be executed, even if an exception is thrown
- there is only one finally clause following a try-catch statement, but you can have a nested combination formed by many try-catch-finally blocks, ie. the try blocks are as many as the finally blocks as below:
```
```
try {
    try {

    } 
    catch() { // could be more than one

    } 
    finally {

    }
} 
catch() { // could be more than one

} 
finally {

}
```

### 3. When both catch and finally return values, what will be the final result?

```
- eventually be the value returned by finally block
- no matter catch the exception and run the return a value by the catch block or not, the control will be transferred to the finally block, which means the value returned in finally block will write the content over
```

### 4. Why does finally always be executed ?

```
- when the System.exit() method is called in the try block before the execution of finally block, finally block will not be executed
- there are two conditions in which the statements in the finally block will not be executed: 
    * when the return statement is defined in the finally block, the control of execution is transferred to the calling routine, and statements after the return statement in finally block are not executed
    * When an exception occurs in the code written in the finally block, the finally block does not complete normally.
    

- except the case mentioned above in the 1st point, the finally block will always be executed
- the finally block will get executed if a try block exists by using return, break, or continue statements
- when an exception occurs within the try block of a program, the rest of the statements in the try block are not executed, and the control of execution directly passes to the subsequent catch block
- when the programmer has handled the exception in the catch block thrown by the corresponding try block, or when no matching catch is found for the exception thrown by the corresponding try block, the finally block always gets executed
- assume some certain statements in a program need to be executed, whether the exception has occurred or not and whether the exception has been catched or not, which explains why Java provides the keyword finally
```

### 5. What is optional? Why do you use it? Write an optional example.

```
public final class Optional<T> extends Object: 
- a container object which may or may not contain a non-null value
- If a value is present, isPresent() will return true and get() will return the value

why to use it:
- it is very hard to avoid NullPointerException without using too many null checks
- to overcome it, Java 8 has introduced a new class Optional in java.util package
- it can help to write a neat code without using too many null checks to avoid NullPointerException 
- we can specify alternate values to return or alternate code to run for null, which makes the code more readable because the facts which were hidden are now visible to the developer

example:
public class OptionalDemo {
    public static void main(String[] args) {
        String[] words = new String[10];
        Optional<String> checkNull = Optional.ofNullable(words[5]);
            
        if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.print(word);
        }
        else {
            System.out.println("word is null");
        } 
    }
}
```

### 6. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection

[CODE](https://github.com/TAIsRich/chuwa0808/tree/Flora_Zhong/hw3_updater/CodingQuestions/Coding_Exercise/src/collection)

### 7. What are Java 8 new features?

```
1. forEach() method in Iterable interface
2. default and static methods in interfaces
3. Functional Interfaces and Lambda Expressions
4. method references
5. Optional<T>
6. Java Stream API for bulk data operations on Collections
7. Java Time API
```

### 8. What are the types of design patterns in Java?

```
In core java, there are mainly three types of design patterns, which are further divided into their sub-parts:

1. Creational Design Patterns: 
- These design patterns are all about a class instantiation or an object creation. 
- These patterns can be further categorized into the class-creation patterns and object-creation patterns. 
- The class-creation patterns use inheritance effectively in the instantiation process, and the object-creation patterns use delegation effectively to get the job done. 

(1). Singleton Pattern
(2). Factory Pattern
(3). Abstract Factory Pattern
(4). Builder Pattern
(5). Prototype Pattern

2. Structural Design Patterns: 
- These design patterns are about organizing different classes and objects to form a larger structure, and provide a new functionality. 
- We can establish 2 interfaces a relationship which are not compatible with each other using an adapter design pattern. The adapter pattern converts an interface of a class into another interface or class that the client expects. In short, an adapter makes incompatible interfaces or classes work together.

(1). Adapter Pattern
(2). Composite Pattern
(3). Proxy Pattern
(4). Bridge Pattern
(5). Facade Pattern
(6). Decorator Pattern
(7). Flyweight Pattern

3. Behavioral Design Patterns:
- The template pattern defines the skeleton of an algorithm in an operation deferring some steps to sub-classes. The template method lets the subclasses redefine certain steps of an algorithm without changing the algorithm structure. 
- For example, in a project, we want the module behavior to be extended, such that we can make the module behavior in some new and different ways satisfy the changed application requirements.
- No one is allowed to change the source code, and we can add but cannot modify the structure. In such case, a developer can approach the template design pattern.

(1). Chain of Responsibility Pattern
(2). Template Method Pattern
(3). Iterator Pattern
(4). State Pattern
(5). Memento Pattern
(6). Strategy Pattern
(7). Command Pattern
(8). Observer Pattern
(9). Visitor Pattern
(10). interpreter Pattern
(11). Mediator Pattern

4. Miscellaneous Design Patterns:
   (1). DAO Design Pattern
   (2). Dependency Injection Pattern
   (3). MVC Pattern
```

### 9. What are the SOLID Principles?
#### https://www.digitalocean.com/community/conceptual_articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design
```
 S - Single Responsibility Principle: 
- A class should only have one reason to change, which means each class should be responsible for a single part or functionality of the system.
- As many as you can to break the classes into smaller classes to add new features.
 
O - Open-closed Principle: 
- The software entities (classes, modules, and functions, etc.) should be open for extension, but closed for modification, which means a class should be extendable without modifying the class itself.

L - Liskov's Substitution Principle: 
- The principle was introduced by Barbara Liskov in 1987. According to this principle, each derived class or subclass must be substitutable for its base or parent class. 
- This principle ensures that any subclass which has a parent class should be usable in place of its parent without any unexpected behavior.

I - Interface Segregation Principle: 
- A client should never be forced to implement an interface that it does not use, or clients should not be forced to depend on the methods they do not use.

D - Dependency Inversion Principle: 
- Entities must depend on abstractions (interfaces or abstract classes) but not concrete implementations (classes). 
- High-level modules must not depend on the low-level modules, but they should depend on abstractions.
- Abstractions should not depend on details, and instead, details should depend on abstractions.
```

### 10. How can you achieve the thread-safe singleton pattern in Java?
#### https://www.baeldung.com/java-singleton-double-checked-locking

- Eager initialization (eager load) declare getInstance() synchronized directly, only one thread can access getInstance(), but may decrease the performance.
```
public class Singleton {
    private static Singleton instance;
 
    private test() {
    }
 
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        
        return instance;
    }
}
```

- Lazy initialization (lazy load) uses double check locking, multiple threads can access getInstance(), the performance overhead gets reduced because of synchronized().
```
public class Singleton {

    // use keyword: static, volatile
    private static volatile Singleton instance;
 
    // make constructor private: make sure this class cannot be instantiated using new(), because once it can be instantiated, there will be many objects, which violates the definition of singleton
    private Singleton() {
    }
  
    // static synchronized getInstance() method: static makes sure this method can be called without an object, which leads to the variable instance must be static as well, because getInstance() will use the variable instance
    public static Singleton getInstance() {
        if (instance == null) { // 可能是多个thread, 一旦确定其中某个thread已经让instance不为null了(keyword volatile makes sure instance这个variable是线程同步的)，就不必再进入下一步的synchronized()了，synchronized()消耗很大，这样可以improve performence, 可以说这个if-statement是为了check要不要让另一个thread进门并上锁来拿资源
            synchronized(Singleton.class or this){ // 保证一个thread进门并上锁来拿资源：synchronized是门，Singleton.class or this是锁，门里有资源
                                              
                if(instance == null){ // 这个if-statement是真正为了assign variable instance a non-null value
                    instance = new Singleton();
                }
            }
        }
        
        return instance;
    }
}
```

```
note: synchronized(Singleton.class)与synchronized(this)有何不同？

this: current object of this class
Singleton.class: 
- .class is a built-in language feature (a class literal) that looks like a public static final field.
- Singleton.class is an object that represents the class Singleton on runtime, and it is the same object that is returned by the getClass() method of any (direct) instance of Singleton.
    Singleton sgt = new Singleton();
    System.out.println(Singleton.class.getName());
    System.out.println(sgt.getClass().getName());
```

### 11. What do you understand by the Open-Closed Principle (OCP)?

```
- An inheritance, interface, or abstract class can achieve a different form without changing anything inside the origin class. 
- It should not crash or break out of the current code due to some specific tiny changes, which means the code should use inheritance, interface or abstract as many and flexible as it can reach out. 
- In inheritance, we should use a class without any possible modifications. We define a set of methods in an interface or abstract class, and the interface or abstract class defines a contract that itself is closed for any modification.
```

### 12. Liskov's Substitution Principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (OA problem) 

```
answer: 1

1. It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.
2. It means that all the objects of type A could execute all the methods present in its subtype B.
3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A. (not must be present explicitly, can inherit implicitly)
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
```

### 13. Watch the design pattern video, type the code, and submit it to the MavenProject folder.
#### singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
#### Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9
#### Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9
#### Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9

[CODE](https://github.com/TAIsRich/chuwa0808/tree/Flora_Zhong/hw3_updater/MavenProject/Design_Pattern/src/main/java/creationalDesignPattern)

