### 1. What is the checked exception and unchecked exception in Java, could you give one example?
- A checked exception means that exception is checked at compile time. It contains two different types, which are fully checked and partially exceptions. 
- For the fully checked, all the child classes are also checked, like InterruptedException and IOException.
- And the partially checked, it is obvious which refer to some of its child classes are unchecked, like Exception.
- For instance, the program tries to input a file what is not exist under the directory

- The unchecked exceptions refer to certain exceptions that are not checked on compile time. Therefore it depends on the programs' willingness to catch the exception. exceptions under Error and RuntimeException classes are unchecked exceptions, everything else under throwable is checked. 
- For example, some numbers are divided by zero, which run perfectly in compile time but cause ArithmeticException at runtime. Also, we can create some unchecked exceptions by inheriting RuntimeException
### 2. Can there be multiple finally blocks?
- The **finally** keyword is used in association with a **try/catch block** and guarantees that a section of code will be executed, even if an exception is thrown. The final block will be executed after the try and catch blocks, but before control transfers back to its origin.
- It is a good question. We definitely can have multiple finally blocks in java, but only one finally block in each **try/catch** statement. You can determine as many **try** statements the program has as the many **finally** block, yet the **finally** block must be inside the try statement. Like below:
```
try
{
    try
    {

    }
    catch() 
    {

    }
    finally 
    {

    }
}
catch()
{

}
finally
{

}
```
### 3. When both catch and finally return values, what will be the final result?
- The answer will eventually be the value returned by **finally**. It is an excellent question that understands the mechanism of **try/catch/finally**, which no matter the **try/catch/finally** catch the exception and run the return by the **catch** block, the control will be transferred to the **finally** at the end, which means the **finally** return value will write the content over.
### 4. What is optional? why do you use it? write an optional example
- The optional class is to help the program write the code without too many null checks since programmer used to use a lot of null checks to avoid NullPointerException

```
String test = null;
Optional<String> opt = Optional.ofNullableof(test);
if(opt.isPresent()){
    System.out.println("the test is not null.");
}else {
    System.out.println("the test is null.");
}


Optional<String> opt = Optional.of("baeldung");
opt.ifPresent(value -> {System.out.println("test");});
```
### 5. Why finally always be executed ?
- First of all,  the finally block may not always execute if the JVM exits while the try or catch code is being executed, like some code System.exit() or some similar code is written into try block then the program will automatically terminate and the finally block will not be executed in this case. 
- Without the incident above, the finally will always be executed inside any try/catch statement; when an exception occurs within the try block in a program, the rest of the statements in the try block are not executed and the control of execution directly gets passed to the subsequent catch block. However, certain statements in a program need to be executed, whether the exception has occurred or not. For this, Java provides a keyword named **finally**. On the other hand, if no matching catch block is found with an exception object thrown by the try block, finally block is executed by JVM after the execution of the try block and the program terminates.
### 6. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection
[CODE](https://github.com/TAIsRich/chuwa0808/tree/zhiyu_li/hw3/codingQuestions/collections/src/collection)
### 7. What is Java 8 new features ?
- forEach() 
- default and static method in interface
- Lambda expressions
- Stream API
- Time API
### 8. What are the types of design patterns in Java ?
1. Creational Design Patterns
- These design patterns are all about class instantiation or object creation. These patterns can be further categorized into Class-creational patterns and object-creational patterns. While class-creation patterns use inheritance effectively in the instantiation process, object-creation patterns use delegation effectively to get the job done. 
  1. Singleton Pattern
  2. Factory Pattern
  3. Abstract Factory Pattern
  4. Builder Pattern
  5. Prototype Pattern

2. Structural Design Patterns
- These design patterns are about organizing different classes and objects to form larger structures and provide new functionality. 
- When 2 interfaces are not compatible with each other and want to establish a relationship between them through an adapter it¡¯s called an adapter design pattern. The adapter pattern converts the interface of a class into another interface or class that the client expects, i.e adapter lets classes work together that could not otherwise because of incompatibility. so in these types of incompatible scenarios, we can go for the adapter pattern. 
  1. Adapter Pattern
  2. Composite Pattern
  3. Proxy Pattern
  4. Flyweight Pattern
  5. Facade Pattern
  6. Bridge Pattern
  7. Decorator Pattern

3. Behavioral Design Patterns
- The template pattern defines the skeleton of an algorithm in an operation deferring some steps to sub-classes. The template method lets subclasses redefine certain steps of an algorithm without changing the algorithm structure. For example, in your project, you want the behavior of the module to be able to extend, such that we can make the module behave in new and different ways as the requirements of the application change, or to meet the needs of new applications. However, no one is allowed to make source code changes to it, i.e you can add but can¡¯t modify the structure in those scenarios a developer can approach template design pattern.
  1. Template Method Pattern
  2. Mediator Pattern
  3. Chain of Responsibility Pattern
  4. Observer Pattern
  5. Strategy Pattern
  6. Command Pattern
  7. State Pattern
  8. Visitor Pattern
  9. Interpreter Pattern
  10. Iterator Pattern
  11. Memento Pattern

4. Miscellaneous Design Patterns
   1. DAO Design Pattern
   2. Dependency Injection Pattern
   3. MVC Pattern
### 9. What are the SOLID Principles ?
- Single Responsibility Principle: It means a class should only have one reason to change, which means each class should be responsible for a single part or functionality of the system. As many as you can to break classes into smaller classes to add new features.
- Open/Closed Principle: This principle states that ¡°software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification¡± which means you should be able to extend a class behavior, without modifying it.
- Liskov¡¯s Substitution Principle: The principle was introduced by Barbara Liskov in 1987 and according to this principle ¡°Derived or child classes must be substitutable for their base or parent classes¡°. This principle ensures that any class that is the child of a parent class should be usable in place of its parent without any unexpected behavior.
- Interface Segregation Principle: The Interface Segregation Principle (ISP) states that clients should not be forced to depend upon interface members they do not use. In other words, do not force any client to implement an interface that is irrelevant to them.
- Dependency Inversion Principle: we should depend on abstractions (interfaces and abstract classes) instead of concrete implementations (classes). The abstractions should not depend on details; instead, the details should depend on abstractions.
### 10. How can you achieve thread-safe singleton patterns in Java ?
- make getInstance() synchronized, only one thread can access getInstance(), but may decrease the performance of your program
```
public class test
{

  private static test instance;
 
  private test()
  {
    // private constructor
  }
 
 
  synchronized public static test getInstance()
  {
    if (instance == null)
    {
      
      instance = new test();
    }
    return instance;
  }
}
```
- Lazy initialization with Double check locking, performance overhead gets reduced because of synchronized keyword.

```
public class test
{

  private static test instance;
 
  private test()
  {
    // private constructor
  }
 
 
  public static test getInstance()
  {
    if (instance == null)
    {
      synchronized(test.class){
        if(instance == null){
            instance = new test();
        }
      }
      
    }
    return instance;
  }
}
```
### 11. What do you understand by the Open-Closed Principle (OCP) ?
- I consider the OCP as the principle that an inheritance, interface, or abstract class can achieve a different form without changing anything inside the origin class. My understanding of OCP is the code should not crash or break out of the current code due to specific tiny changes, which means the code should use inheritance or interface or abstract as many as it can reach out flexible. In inheritance, we should use a class without any possible modifications. Toward the interface or abstract class, We define an interface with a set of methods, and the interface defines a contract that is closed for modifications.
### 12. Liskov¡¯s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
1. It means that if the object of type A can do something, the object of type B could also be able tp
perform the same thing
2. It means that all the objects of type A could execute all the methods present in its subtype B
3. **Answer: It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.**
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
### 13. Watch the design pattern video, and type the code, submit it to MavenProject folder
[CODE](https://github.com/TAIsRich/chuwa0808/tree/zhiyu_li/hw3/MavenProject/design_pattern/src/pattern)
