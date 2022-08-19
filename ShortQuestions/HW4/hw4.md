1. Read those codes and type it one by one by yourself. the push the code to your branch.
   https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8
2. practice stream API at least 3 times
   1. https://blog.devgenius.io/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82
3. Write the Singleton design pattern include eager load and lazy load.
4. What is Runtime Exception? could you give me some examples?
   * The Runtime Exception is the parent class in all exceptions of the Java programming language that are expected to crash or break down the program or application when they occur.
   * NullPointerException, ArrayIndexOutOfBoundsException, ClassCastException, InvalidArgumentException etc.
5. Could you give me one example of NullPointerException?
   * Initializing String variable with null value then using `variable.equals()`.
6. What is the Optional class?
   * The Optional class in Java is a container that can hold, at max, one value and gracefully deals with null values. The class was introduced in the java. util package to remove the need for multiple null checks to protect against the dreaded NullPointerExceptions during run-time.
7. What is the @FunctionalInterface?
   * A functional interface is an interface that contains only one abstract method. They can have only one functionality to exhibit. From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface. A functional interface can have any number of default methods.
8. what is lamda?
   * A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.
9. What is Method Reference?
   * Method references are a special type of lambda expressions. They're often used to create simple lambda expressions by referencing existing methods. There are four kinds of method references: Static methods. Instance methods of particular objects. Instance methods of an arbitrary object of a particular type.
10. What is Java 8 new features?
   * Default method in interface
   * Lambda expression
   * Optional
   * Method Reference
   * Stream API
11. Lambda can use unchanged variable outside of lambda? what is the details?
   * Lambda can use final variable, unchanged variable or a variable not declared in current scope outside of lambda. This is because `The restriction to effectively final variables prohibits access to dynamically-changing local variables, whose capture would likely introduce concurrency problems.`