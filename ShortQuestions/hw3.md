1. What is the checked exception and unchecked exception in Java, can you give an example?
    1.1 Checked exceptions are checked by the Java compiler. Unchecked exceptions are not checked by the compiler. These are called runtime exceptions.
    1.2 A method must handle checked exceptions in its body or throw to the caller method so the caller method can handle it. A method is not forced by the compiler to declare the unchecked exceptions into the method declaration.
    1.3 Checked exceptions include ClassNotFoundException, IOException and SQLException. Unchecked exceptions include ArithmeticException.

2. Can there be multiple finally blocks?
    Yes, we can.

3. When both catch and finally return values, what is the final result?
    When try and finally block both return value, method will return value returned by finally block.

4. What is optional? why do you use it? write an optional example
    Optional is a container object which may or may not contain a non-null value. The purpose of the class is to provide a type-level solution for representing optional values instead of null references.
    Optional<String> checkEmpty = Optional.empty();

5. Why finally always be executed?
    This ensures that the finally block is executed even if an unexpected exception occurs.

6. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection

7. What is Java 8 new features?
    7.1 Lambda & Functional Interface
    7.2 Optional
    7.3 Method Reference
    7.4 Stream API

8. What are the types of design patterns in Java?
    8.1 Factory Pattern
    8.2 Abstract Factory Pattern
    8.3 Singleton Pattern
    8.4 Prototype Pattern
    8.5 Builder Pattern.

9. What are the SOLID principles?
    S - Single-responsiblity Principle
    O - Open-closed Principle
    L - Liskov Substitution Principle
    I - Interface Segregation Principle
    D - Dependency Inversion Principle

10. How can you achieve thread-safe singleton pattern in Java?
    10.1 Create the instance variable at the time of class loading.
    10.2 Synchronize the getInstance() method.
    10.3 Use synchronized block inside the if loop and volatile variable.

11. What do your understand by the Open Closed Principle (OCP)?
    Objects or entities should be open for extension but closed for modification.This means that a class should be extendable without modifying the class itself.

12. Liskov's substitution principle states that if class B is a subtype of class A, then an object of type A can be replaced by any object of type B. What does this actually mean? (from OA) Choose your answer. 3
    1. This means that if an object of type Acandsomething, an object of type B can also do the same thing
    2. Inits subtype B that indicates that all types of objects can execute all methods exist
    3. It means that if the method appears in class A, it should also appear in class B, such an object Type B can replace objects of type A.
    4. This means that for class B that inherits class A, type object and type object must be the same.
13. Watch the design pattern video, enter the code, and submit it to the MavenProject folder
    Singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
    Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6 d9
    Generator: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6 d9
    Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f 7accf859bf7f6d9