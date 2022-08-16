1. What is the checked exception and unchecked exception in Java could you give one example?
   * Checked Exceptions are the exceptions that are checked at compile time.
   * Unchecked Exceptions are the exceptions 
2. Can there be multiple finally blocks?
    * NO.
3. When both catch and finally return values, what will be the final result?
    * When catch and finally block both return value, method will ultimately return value returned by finally block irrespective of value returned by catch block.
4. What is optional? why do you use it? write an optional example
   * Optional is a container object used to contain not-null objects.
   * Optional is primarily intended for use as a method return type where there is a clear need to represent 'no result,' and where using null is likely to cause errors.
5. Why finally always be executed?
   * A finally block is always get executed whether the exception has occurred or not. If an exception occurs like closing a file or DB connection, then the finally block is used to clean up the code.
6. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection
7. What is Java8 new features?
   1. forEach() method in Iterable interface
   2. default and static methods in Interfaces
   3. Functional Interfaces and Lambda Expressions
   4. Java Stream API for Bulk Data Operations on Collections
   5. Java Time API
   6. Collection API improvements
   7. Concurrency API improvements
   8. Java IO improvements
8. What are the types of design patterns in Java?
   * Creational
   * Structural
   * Behavioral
9. What are the SOLID Principles?
   1. Single-responsiblity Principle. A class should have one and only one reason to change, meaning that a class should have only one job.
   2. Open-closed Principle. Objects or entities should be open for extension but closed for modification.
   3. Liskov Substitution Principle. Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T.
   4. Interface Segregation Principle. A client should never be forced to implement an interface that it doesn’t use, or clients shouldn’t be forced to depend on methods they do not use.
   5. Dependency Inversion Principle. Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions.
10. How can you achieve thread-safe singleton patterns in Java ?
    *To make a singleton class thread safe, getInstance() method is made synchronized so that multiple threads can't access it simultaneously.
11. What do you understand by the Open-Closed Principle (OCP) ?
12. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
    * 3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
13. Watch the design pattern video, and type the code, submit it to MavenProject folder singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22 Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9 Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9 Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9