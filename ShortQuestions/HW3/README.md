## Homework 3

1. What is the checked exception and unchecked exception in Java, could you give one example?

   	1. These are the exceptions that are checked at compile time. If some code within a method throws a checked exception, then the method must either handle the exception or it must specify the exception using the throws keyword.
   	1. These are the exceptions that are not checked at compile time. In C++, all exceptions are unchecked, so it is not forced by the compiler to either handle or specify the exception. It is up to the programmers to be civilized, and specify or catch the exceptions. In Java, exceptions under *Error* and *RuntimeException* classes are unchecked exceptions, everything else under throwable is checked. 
    	3. Examples
        - Checked exceptions : IOException, InterruptedException.
        - Unchecked exception : Null Pointer Exception, IndexOutOfBound Exception, Numberformat Exception.

2. Can there be multiple finally blocks? 

   	- Per try/catch/finally statement only can have one finally clause. But there can be multiple such statements.

3. When both catch and finally return values, what will be the final result?

   	- The finally block will still execute, even if the catch block has a return statement. If both catch and finally return, the receiving method will get the returned value from the finally block.

4. What is optional? why do you use it? write an optional example

   	1. Optional is **a container object used to contain not-null objects**. Optional object is used to represent null with absent value. 
   	1. This class has various utility methods to facilitate code to handle values as 'available' or 'not available' instead of checking null values.
    	3. Example :
        - Optional<Person> op = Optional.ofNullable(p);
        - In case the Person object is null, the resulting Optional object would be empty, but it won't throw the NullPointerException.

5. Why finally always be executed ?

   	- This is useful **if you need to run cleanup code regardless of what happens**. For example, as a cleanup, you should always close a file no matter what.

6. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/
   src/main/java/com/chuwa/exercise/collection 

7.  What is Java 8 new features ?

   | Feature Name               | Description                                                  |
   | -------------------------- | ------------------------------------------------------------ |
   | Lambda expression          | A function that can be shared or referred to as an object.   |
   | Functional Interfaces      | Single abstract method interface.                            |
   | Method References          | Uses function as a parameter to invoke a method.             |
   | Default method             | It provides an implementation of methods within interfaces enabling 'Interface evolution' facilities. |
   | Stream API                 | Abstract layer that provides pipeline processing of the data. |
   | Date Time API              | New improved joda-time inspired APIs to overcome the drawbacks in previous versions |
   | Optional                   | Wrapper class to check the null values and helps in further processing based on the value. |
   | Nashorn, JavaScript Engine | An improvised version of JavaScript Engine that enables JavaScript executions in Java, to replace Rhino. |

8. What are the types of design patterns in Java ?

    	1. Design patterns can be classified in three categories: Creational, Structural and Behavioral patterns.
        - **Creational Patterns** - These design patterns provide a way to create objects while hiding the creation logic, rather than instantiating objects directly using new opreator. This gives program more flexibility in deciding which objects need to be created for a given use case.
        - **Structural Patterns** - These design patterns concern class and object composition. Concept of inheritance is used to compose interfaces and define ways to compose objects to obtain new functionalities.
        - **Behavioral Patterns** - These design patterns are specifically concerned with communication between objects.

9. What are the SOLID Principles ?

   	1. SOLID refers to five design principles in object-oriented programming, designed to reduce code rot and improve the value, function, and maintainability of software. The SOLID principles help the user develop less coupled code. If code is tightly coupled, a group of classes are dependent on one another. This should be avoided for better maintainability and readability.
    	2. SOLID design is an acronym for the following five principles:
        - [Single Responsibility Principle](https://www.jrebel.com/blog/solid-principles-in-java#srp)
        - [Open-Closed Principle](https://www.jrebel.com/blog/solid-principles-in-java#ocp)
        - [Liskov Substitution Principle](https://www.jrebel.com/blog/solid-principles-in-java#lsp)
        - [Interface Segregation Principle](https://www.jrebel.com/blog/solid-principles-in-java#isp)
        - [Dependency Inversion Principle](https://www.jrebel.com/blog/solid-principles-in-java#dip)

10. How can you achieve thread-safe singleton patterns in Java ?

    	- Create the private constructor to avoid any new object creation with new operator. 
    	- Declare a private static instance of the same class. 
    	- Provide a public static method that will return the singleton class instance variable.

11. What do you understand by the Open-Closed Principle (OCP) ?

    	- The Open-Closed Principle (OCP) states that software entities (classes, modules, methods, etc.) should be open for extension, but closed for modification. 
    	- In practice, this means creating software entities whose behavior can be changed without the need to edit and recompile the code itself.

12. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be 
    substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

    1. It mean that if the object of type A can do something, the object of type B could also be able tp 
       perform the same thing
    2. It means that all the objects of type A could execute all the methods present in its subtype B
    3. It means if a method is present in class A, it should also be present in class B so that the object of 
       type B could substitute object of type A.
    4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
    ### Answer is 1

13. Watch the design pattern video, and type the code, submit it to MavenProject folder
       singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
       Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6
    d9
       Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6
    d9
       Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f
    7accf859bf7f6d9