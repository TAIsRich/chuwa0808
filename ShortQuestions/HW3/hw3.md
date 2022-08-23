1. What is the checked exception and unchecked exception in Java could you give one example?
   1. Checked exception are checked at compile time. If some code within a method throws a checked exception, then the method must either handle the exception or it must specify the exception using the throws keyword. a checked exception is an exception condition within your codes logic and can be recovered or retried from. For example, NullPointerException, ClassCastException, ArithmeticException, DateTimeException, ArrayStoreException.
   2. An unchecked exception is the one which occurs at the time of execution. These are also called as Runtime Exceptions. These include programming bugs, such as logic errors or improper use of an API. Runtime exceptions are ignored at the time of compilation. For example,ClassNotFoundException, SocketException, SQLException, IOException, FileNotFoundException
2. Can there be multiple finally blocks?
   1. No, you can only have one finally clause per try/catch/finally statement, but you can have multiple such statements, either in the same method or in multiple methods.
3. When both catch and finally return values, what will be the final result?
   1. When catch and finally block both return value, method will ultimately return value returned by finally block irrespective of value returned by catch block.
4. What is optional? why do you use it? write an optional example
   1. Optional is a container object used to contain not-null objects.
   2. Optional is primarily intended for use as a method return type where there is a clear need to represent 'no result,' and where using null is likely to cause errors.
   3. for example:
   ```
    Person p = new Person(); 
    Optional<Person> op = Optional.of(p);
    Optional<Person> op = Optional.ofNullable(p);
    Optional<Address> op = p.getAddress();
    if(!op.isPresent()){ System.out.println(p);}
   ```
5. Why finally always be executed?
   1. The purpose of the finally clause is to have a single location for relinquishing resources (such as file handles or database connections) that were acquired in the try clause, whether or not an exception occurred. If the try block is successful and return true is executed, the finally clause follows.
6. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection
7. What is Java8 new features?
   1. Functional Interfaces and Lambda Expressions
   2. forEach() method in Iterable interface
   3. Optional class,
   4. default and static methods in Interfaces
   5. Method references
   6. Java Stream API for Bulk Data Operations on Collections
   7. Java Date Time API
   8. Collection API improvements
   9. Concurrency API improvements
   10. Java IO improvements
   11. Nashorn JavaScript engine
   12. Base64 Encode Decode
   13. Miscellaneous Core API improvements
8. What are the types of design patterns in Java?
   1. There are mainly three types of design patterns: 
   2. Creational: These design patterns are all about class instantiation or object creation. These patterns can be further categorized into Class-creational patterns and object-creational patterns. While class-creation patterns use inheritance effectively in the instantiation process, object-creation patterns use delegation effectively to get the job done. Creational design patterns are the Factory Method, Abstract Factory, Builder, Singleton, Object Pool, and Prototype. 
   3. Structural: These design patterns are about organizing different classes and objects to form larger structures and provide new functionality. Structural design patterns are Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Private Class Data, and Proxy. 
   4. Behavioral: Behavioral patterns are about identifying common communication patterns between objects and realizing these patterns. Behavioral patterns are Chain of responsibility, Command, Interpreter, Iterator, Mediator, Memento, Null Object, Observer, State, Strategy, Template method, Visitor 
9.  What are the SOLID Principles?
    1.  S - Single-responsiblity Principle. A class should have one and only one reason to change, meaning that a class should have only one job.
    2.  O - Open-closed Principle. Objects or entities should be open for extension but closed for modification.
    3.  L - Liskov Substitution Principle. Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T.
    4.  I - Interface Segregation Principle. A client should never be forced to implement an interface that it doesn’t use, or clients shouldn’t be forced to depend on methods they do not use.
    5.  D - Dependency Inversion Principle. Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions.
10.  How can you achieve thread-safe singleton patterns in Java ?
     1. first, make the constructor as private, so that the instance can only be created by static function, inside the static function the instance will be created and returned. and synchronized will be added in fornt of the function, which will make sure the method is simultaneous.
11.  What do you understand by the Open-Closed Principle (OCP) ?
     1.   the open–closed principle states "software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification"
12.  Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer. （3/C）
    6. It mean that if the object of type A can do something,the object of type B could also be able to perform the same thing
    7.  It means that all the objects of typeA could execute all the methods present in its sub typeB
    8.  It means if a method is present in classA it should also be present in classB so that the object of type B could substitute object of type A.
    9.  It means that for the classB to inherit classA,objects of typeB and objects of typeA must be same.
13.  Watch the design pattern video, and type the code, submit it to MavenProject folder
singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9
Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9
Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9