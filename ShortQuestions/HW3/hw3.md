####1. What is the checked exception and unchecked exception in Java, could you give one example?

1. Checked Exception - IO or Compile time Exception 
2. Unchecked Exeption - Runtime or Null Pointer Exception

####2. Can there be multiple finally blocks?

You can only have one finally clause per try/catch/finally statement, but you can have multiple such statements, either in the same method or in multiple methods.

####3. When both catch and finally return values, what will be the final result?

When catch and finally block both return value, method will ultimately return value returned by finally block irrespective of value returned by catch block.

####4. What is optional? why do you use it? write an optional example

The purpose of the Optional class is to provide a type-level solution for representing optional values instead of null references.  Optional object is used to represent null with absent value.

####5. Why finally always be executed ?

When an unexpected exception occurs, the finally block always ensures that it is executed.

####6. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection



####7. What is Java 8 new features ?

Important: Functional Interface, Lambda, Optional, Stream API
Unimportant: Default method, Method Reference

####8. What are the types of design patterns in Java ?

Singleton, Factory, Builder, Abstract Factory

####9. What are the SOLID Principles ?

S - Single-responsiblity Principle
O - Open-closed Principle
L - Liskov Substitution Principle
I - Interface Segregation Principle
D - Dependency Inversion Principle

####10. How can you achieve thread-safe singleton patterns in Java ?

Using eager load or lazy load

####11. What do you understand by the Open-Closed Principle (OCP) ?

Objects or entities should be open for extension but closed for modification. This means that a class should be extendable without modifying the class itself.

####12. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
1. It mean that if the object of type A can do something, the object of type B could also be able tp perform the same thing
2. It means that all the objects of type A could execute all the methods present in its subtype B
3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

Choice 1 is correct

####13. Watch the design pattern video, and type the code, submit it to MavenProject folder