# Homework 4  

1. Read those codes and type it one by one by yourself. the push the code to your 
   branch.
   https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/mai
   n/java/com/chuwa/tutorial/t06_java8
2. practice stream API at least 3 times
   a. https://blog.devgenius.io/15-practical-exercises-help-you-master-java-
   stream-api-3f9c86b1cf82
3. Write the Singleton design pattern include eager load and lazy load. 
   - see coding4/singleton
4. What is Runtime Exception? could you give me some examples?
   - The Runtime Exception is **the parent class in all exceptions of the Java programming language that are expected to crash or break down the program or application when they occur**. 
   - ArithmeticException.
   - NullPointerException.
   - ClassCastException.
   - DateTimeException.
   - ArrayIndexOutOfBoundsException.
   - NegativeArraySizeException.
   - ArrayStoreException.
   - UnsupportedOperationException.
5. Could you give me one example of NullPointerException?
   - Person person;
   - person.getName();
6. What is the Optional class?
   - Optional is a container object used to contain not-null objects. Optional object is used to represent null with absent value. This class has various utility methods to facilitate code to handle values as 'available' or 'not available' instead of checking null values.
7. What is the @FunctionalInterface?
   - A functional interface is **an interface that contains only one abstract method**. They can have only one functionality to exhibit. From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface. A functional interface can have any number of default methods.
8. what is lamda?
   - A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.
9. What is Method Reference?
   - Method references are a special type of lambda expressions.
   - They're often used to create simple lambda expressions by referencing existing methods. 
   - There are four kinds of method references: 
     - Static methods. 
     - Instance methods of particular objects. 
     - Instance methods of an arbitrary object of a particular type.
     - Reference to a constructor
10. What is Java 8 new features?
    - forEach() method in Iterable interface
    - default and static methods in Interfaces
    - Functional Interfaces and Lambda Expressions
    - Java Stream API for Bulk Data Operations on Collections
    - Java Time API
    - Collection API improvements
    - Concurrency API improvements
    - Java IO improvements
11. Lambda can use unchanged variable outside of lambda? what is the details?
    - A **lambda** **expression** can capture variables like **local** and **anonymous** classes. In other words, they have the same access to local variables of the enclosing scope. We need to follow some rules in case of **local** **variables** in lambda expressions.
      - A lambda expression can't define any new scope as an anonymous inner class does, so we can't declare a local variable with the same which is already declared in the enclosing scope of a lambda expression.
      - Inside lambda expression, we can't assign any value to some local variable declared outside the lambda expression. Because the **local variables** declared outside the lambda expression can be **final** or **effectively** **final**.
      - The rule of **final** or **effectively** **final** is also applicable for method parameters and exception parameters.
      - The **this** and **super** references inside a lambda expression body are the same as their enclosing scope. Because lambda expressions can't define any new scope.