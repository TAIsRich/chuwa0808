### 1. What is the checked exception and unchecked exception in Java, could you give one example?
```
Unchecked Exceptions are the exceptions that occurs at the time of execution e.g. NullPointerException
Checked Exceptions are the exceptions that are checked at compile time and must be handled e.g. IOException
```

### 2. Can there be multiple finally blocks?
```
You can only have one finally clause per try/catch/finally statement
but you can have multiple such statements, either in the same method or in multiple methods.
```

### 3. When both catch and finally return values, what will be the final result?
```
Returned value from the finally block will be the final result
```

### 4. What is optional? why do you use it? write an optional example
```
To avoid abnormal termination, we use the Optional class, which is a container object which may or may not contain a non-null value. 
It can help in writing a neat code without using too many null checks. 
By using Optional, we can specify alternate values to return or alternate code to run. 
This makes the code more readable because the facts which were hidden are now visible to the developer.

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

Output:
word is null
```

### 5. Why finally always be executed ?
```
A finally block is always get executed to clean up the code or close any open file . 
```

### 7. What is Java 8 new features ?
```
Lambda expression - A function that can be shared or referred to as an object.
Functional Interfaces - Single abstract method interface.
Method References - Uses function as a parameter to invoke a method.
Default method - It provides an implementation of methods within interfaces enabling 'Interface evolution' facilities.
Stream API - Abstract layer that provides pipeline processing of the data.
Date Time API - New improved joda-time inspired APIs to overcome the drawbacks in previous versions
Optional - Wrapper class to check the null values and helps in further processing based on the value.
Nashorn, JavaScript Engine - An improvised version of JavaScript Engine that enables JavaScript executions in Java, to replace Rhino.
```

### 8. What are the types of design patterns in Java ?
```
A design patterns are well-proved solution for solving the specific problem/task and every design pattern has some specification or set of rules for solving the problems.

There are mainly three types of design patterns, which are further divided into their sub-parts:

1. Creational Design Pattern
These design patterns are all about class instantiation or object creation. 
These patterns can be further categorized into Class-creational patterns and object-creational patterns. 
While class-creation patterns use inheritance effectively in the instantiation process, object-creation patterns use delegation effectively to get the job done. 
Creational design patterns are the Factory Method, Abstract Factory, Builder, Singleton, Object Pool, and Prototype. 

2. Structural Design Pattern
These design patterns are about organizing different classes and objects to form larger structures and provide new functionality. 
Structural design patterns are Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Private Class Data, and Proxy. 

3. Behavioral Design Pattern
Behavioral patterns are about identifying common communication patterns between objects and realizing these patterns. 
Behavioral patterns are Chain of responsibility, Command, Interpreter, Iterator, Mediator, Memento, Null Object, Observer, State, Strategy, Template method, Visitor 
```

### 9. What are the SOLID Principles ?
```
SOLID is an acronym for the first five object-oriented design (OOD) principles. SOLID stands for:

S - Single-responsiblity Principle -> A class should have one and only one reason to change, meaning that a class should have only one job.
O - Open-closed Principle -> Objects or entities should be open for extension but closed for modification.
L - Liskov Substitution Principle -> Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T.
I - Interface Segregation Principle -> A client should never be forced to implement an interface that it doesn’t use
D - Dependency Inversion Principle -> Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions.
```

### 10. How can you achieve thread-safe singleton patterns in Java ?
```
A thread safe singleton is created so that singleton property is maintained even in multithreaded environment. To make a singleton class thread safe, getInstance() method is made synchronized so that multiple threads can’t access it simultaneously.
```

### 11. What do you understand by the Open-Closed Principle (OCP) ?
```
Open/closed principle states that software entities like class, modules, functions, etc.; should be able to extend a class behavior without modifying it. 
This principle separates the existing code from modified mode to provide better stability, maintainability and minimizes the changes in the code. 
In a nutshell, the developer must need to change only a specific part of the code (a class or a function) every time a requirement changes.
```

### 12.  Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
1.  It mean that if the object of type A can do something, the object of type B could also be able tp 
perform the same thing
2.  It means that all the objects of type A could execute all the methods present in its subtype B
3.  It means if a method is present in class A, it should also be present in class B so that the object of 
type B could substitute object of type A.
4.  It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
```
1
```
