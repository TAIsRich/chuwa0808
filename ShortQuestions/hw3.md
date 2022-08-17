### 1.What is the checked exception and unchecked exception in Java, could you give one example?
1.Checked Exception - 必须用catch or throws
2.IOException (e.g. FileNotFound)
3.SQLException (e.g. Id/data does not exits)
4.Unchecked Exception - Runtime Exception

### 2.Can there be multiple finally blocks?
1.You can only have one finally clause per try/catch/finally statement, but you can have multiple such statements, either in the same method or in multiple methods.

### 3. When both catch and finally return values, what will be the final result?
1.If both catch and finally return, the receiving method will get the returned value from the finally block;

### 4.What is optional? why do you use it? write an optional example
1.Optional is a container object used to contain not-null objects. Optional object is used to represent null with absent value. This class has various utility methods to facilitate code to handle values as 'available' or 'not available' instead of checking null values.
2.Optional<Person> p = Optional.empty();
3.Person p = new Person();
Optional<Person> op = Optional.of(p);

### 5. Why finally always be executed ?
The finally block always executes when the try block exits. This ensures that the finally block is executed even if an unexpected exception occurs.

### 6. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/
    src/main/java/com/chuwa/exercise/collection

### 7. What is Java 8 new features ?
1.forEach() method in Iterable interface. 
2.default and static methods in Interfaces.
3.Functional Interfaces and Lambda Expressions. 
4.Java Stream API for Bulk Data Operations

### 8. What are the types of design patterns in Java ?
1.Creational Design Patterns
2.Singleton Pattern
3.Factory Pattern
4.Abstract Factory Pattern
5.Builder Pattern
6.Prototype Pattern
7.Structural Design Patterns
8.Adapter Pattern
9.Composite Pattern
10.Proxy Pattern
11.Flyweight Pattern
12.Facade Pattern
13.Bridge Pattern
14.Decorator Pattern
15.Behavioral Design Patterns
16.Template Method Pattern
17.Mediator Pattern
18.Chain of Responsibility Pattern
19.Observer Pattern
20.Strategy Pattern
21.Command Pattern
22.State Pattern
23.Visitor Pattern
24.Interpreter Pattern
25.Iterator Pattern
26.Memento Pattern

### 9. What are the SOLID Principles ?
SOLID design is an acronym for the following five principles:
1.Singleton Responsibility Principle.
2.Open-Closed Principle.
3.Liskov Substitution Principle.
4.Interface Segregation Principle.
5.Dependency Inversion Principle

### 10. How can you achieve thread-safe singleton patterns in Java ?
1.Create the private constructor to avoid any new object creation with new operator. Declare a private static instance of the same class. Provide a public static method that will return the singleton class instance variable
2.The point that you need to remember is Locks are the best option to handle the singleton instance, Using locks we can synchronize the method

### 11. What do you understand by the Open-Closed Principle (OCP) ?
The Open/Closed Principle states that software entities (classes, modules, etc.) should be open for extension, but closed for modification

12. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be
     substituted with any object of type B. What does this actually mean? (from OA ) choose your answer. 
1.It mean that if the object of type A can do something, the object of type B could also be able tp
     perform the same thing
2.It means that all the objects of type A could execute all the methods present in its subtype B
3.It means if a method is present in class A, it should also be present in class B so that the object of
     type B could substitute object of type A.
4.It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
1.The answer is C
2.Simply put, the Liskov Substitution Principle (LSP) states that objects of a superclass should be replaceable with objects of its subclasses without breaking the application. In other words, what we want is to have the objects of our subclasses behaving the same way as the objects of our superclass.

### 13.Watch the design pattern video, and type the code, submit it to MavenProject folder
     singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
     Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6
     d9
     Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6
     d9
     Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f
     7accf859bf7f6d9
 