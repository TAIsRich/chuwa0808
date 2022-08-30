#### 1. What is wrapper class in Java and Why we need wrapper class?

A Wrapper class is **a class which contains the primitive data types (int, char, short, byte, etc)**. In other words, wrapper classes provide a way to use primitive data types (int, char, short, byte, etc) as objects.

####  2. What is the difference between HashMap and HashTable?

**HashMap is non-syncronized and is not thread safe while HashTable is thread safe and is synchronized**. HashMap allows one null key and values can be null whereas HashTable doesn't allow null key or value. HashMap is faster than HashTable.

#### 3. What is String pool in Java and why we need String pool?

String Pool is **a storage area in Java heap**. String allocation, like all object allocation, proves to be a costly affair in both the cases of time and memory. The JVM performs some steps while initializing string literals to increase performance and decrease memory overhead.

#### 4. What is Java garbage collection?

Java garbage collection is **the process by which Java programs perform automatic memory management**.

#### 5. What are access modifiers and their scopes in Java?

- **Private**: We can access the **private modifier** only within the same class and not from outside the class.
- **Default:** We can access the **default modifier** only within the same package and not from outside the package. And also, if we do not specify any access modifier it will automatically consider it as default.
- Protected: We can access the protected modifier within the same package and also from outside the package with the help of the child class. If we do not make the child class, we cannot access it from outside the package. So inheritance is a must for accessing it from outside the package.
- Public: We can access the public modifier from anywhere. We can access public modifiers from within the class as well as from outside the class and also within the package and outside the package.

#### 6. What is final key word? (Field, Method, Class)

Variable 

- `public static final String APP_NAME=“testApp”` 
- Purpose: define constants 

Method 

- `public final int add(int a, int b){ return a + b; } `
- Purpose: prevent override 

Class 

- `final class MyClass(){} `

- Purpose: 1) prevent inheritance, like Integer, String etc; 2) Make class immutable

#### 7. What is static keyword? (Field, Method, Class). When do we usually use it?

The **static keyword** in Java is mainly used for memory management. The static keyword in Java is used to share the same variable or method of a given class. The users can apply static keywords with variables, methods, blocks, and nested classes. The static keyword belongs to the class than an instance of the class. The static keyword is used for a constant variable or a method that is the same for every instance of a class.

- Static fields will be shared among all objects of the class. When a variable is declared as static, then a single copy of the variable is created and shared among all objects at the class level. Static variables are, essentially, global variables. All instances of the class share the same static variable.

- Static methods can be called without creating a new object, using class name.

- Static blocks: If you need to do the computation in order to initialize your **static variables**, you can declare a static block that gets executed exactly once, when the class is first loaded. 
- Static class: A class can be made **static** only if it is a nested class. We cannot declare a top-level class with a static modifier but can declare [nested classes](https://www.geeksforgeeks.org/nested-classes-java/) as static. Such types of classes are called Nested static classes. Nested static class doesn’t need a reference of Outer class. In this case, a static class cannot access non-static members of the Outer class. 

#### 8. What is the differences between overriding and overloading?

There are two types of polymorphism. When two or more methods in the same class have the same name but different parameters, it's called Overloading. When the method signature (name and parameters) are the same in the superclass and the child class, it's called Overriding.

#### 9. What is the differences between super and this?

**this keyword mainly represents the current instance of a class.** On other hand super keyword represents the current instance of a parent class. this keyword used to call default constructor of the same class.

#### 10. What is the Java load sequence?

1. load class viables
2. excute static block
3. call constructor

####  11. What is Polymorphism? And how Java implements it?

Polymorphism(多态) refers to the same object exhibiting different forms and behaviors.

- Static Polymorphism - Overload (same class) - compile time 
- Dynamic Polymorphism - Override (child class) - run time In programming, 

#### 12. What is Encapsulation? How Java implements it? And why we need encapsulation?

Encapsulation in OOP refers to binding the data and the methods to manipulate that data together in a single unit (class). It prevents outer classes from accessing and changing fields and methods of a class. This also helps to achieve data hiding.

#### 13. What is Interface and what is abstract class? What are the differences between them?

**Abstract class:** is a restricted class that cannot be used to create objects.

An `interface` is a completely "**abstract class**" that is used to group related methods with empty bodies.

**Similarities**
Both forces classes extending or implementing them to override base methods.

**Differences**

1. A class can implement multiple interfaces.
2. A class can only extend from one abstract class.
3. Fields declared in interfaces must be **static** and **final** because all objects that created from such implementation share same values.
4. In Abstract classes, fields can be named and not assigned. subclasses can override them.

**Use cases**

1. Abstract classes are used in subclasses that are closely related, or have almost same functionalities and behaviors.
2. Interfaces are used for unrelated classes that you want to force a certain thing or behavior, because its Just a contract without implementation.

**An abstract class allows you to create functionality that subclasses can implement or override.** **An interface only allows you to define functionality, not implement it**. And whereas a class can extend only one abstract class, it can take advantage of multiple interfaces.

#### 14. design a parking lot (put the code to codingQuestions/coding1 folder )

See ./parking_lot

#### 15. What are Queue interface implementations and what are the differences and when to use what?

PriorityQueue and LinkedList. The difference between PriorityQueue and Linkedlist is at the time of insertion PriorityQueue will be sorted as well as ordered as per the natural order but we can add a Commparator also in order to define the particular order of sorting for a record, while as LinkedList will be just ordered.

#### 16. What is Runtime/unchecked exception? what is Compile/Checked Exception?

**A checked exception is caught at compile time whereas a runtime or unchecked exception is, as it states, at runtime**. A checked exception must be handled either by re-throwing or with a try catch block, whereas an unchecked isn't required to be handled.

#### 17. what is the difference between throw and throws?

**The throws keyword is used to declare which exceptions can be thrown from a method, while the throw keyword is used to explicitly throw an exception within a method or block of code**. The throws keyword is used in a method signature and declares which exceptions can be thrown from a method.

#### 18. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?

Runtime exception is a type of Exception. If it is put before Runtime exception, the Runtime exception will be dealt by Exception not corresponding specific exception, which is not what we want. We put Exception at the end so it just deal with any other exceptions.

