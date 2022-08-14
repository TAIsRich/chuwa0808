1. What is wrapper class in Java and Why we need wrapper class?
    Wrapper classes provide a way to use primitive data types as objects. Such as int to Integer. Sometimes we must use wrapper classes, like using Collection objects.

2. What is the difference between HashMap and HashTable?
    1.HashMap is non synchronized. HashTable is synchronized and hence it can be shared with many threads.
    2.HashMap allows one null key and multiple null values. HashTable does not allow any null key or value.
    3.HashMap supports order of insertion, while order of insertion is not guaranteed in HashTable.

3. What is String pool in Java and why we need String pool?
    String pool is a storage area in Java heap where string stores. String Pool is possible only because String is immutable in Java. String pool helps in saving a lot of space 

4. What is Java garbage collection?
    Java garbage collection is the process by which Java programs perform automatic memory management. Automatic garbage collection is the process of looking at heap memory, identifying which objects are in use and which are not, and deleting the unused objects. 

5. What are access modifiers and their scopes in Java?
   Access modifiers are keywords that restrict the scope of a class, constructor, variable, method, or data member.
    1.Default: has accessibility from same class and same package
    2.Private: only has accessibility from same class
    3.Protected: has accessibility from same class, same package and subclass
    4.Public: has accessibility from world

6. What is final keyword?(Filed,Method,Class)
    final is a non-access modifier keyword that can used to a variable, a method, or a class.
    1. final variable can't change its value once assigned. 
    2. final method can't be overridden.
    3. final class can't be inherited.

7. What is static keyword?(Filed,Method,Class).When do we usually use it?
    The static keyword is used to share the same variable or method of a given class. The static keyword belongs to the class than an instance of the class. The static keyword is used for a constant variable or a method that is the same for every instance of a class.

8. What is the differences between overriding and overloading?
    Overloading is two or more methods having the same name but different parameters or signature. It resolved during compile-time.
    Overriding is child class redefining methods present in the base class with the same parameters/ signature. It resolved during runtime.

9. What is the differences between super and this?
    this keyword refers instance variable of current class or invokes or initiates current class constructor.
    super keyword is used to refer super-class's instance as well as static members. super keyword is also used to invoke super-class's method or constructor.

10. What is the Java load sequence?
    1. First load the static field or static statement block of the parent class
    2. Static fields or static statement blocks of subclasses
    3. Parent class ordinary variables and statement blocks
    4. The parent class constructor is loaded
    5. The subclass variable or statement block is loaded
    6. The subclass constructor is loaded

11. What is Polymorphism? And how Java implements it?
    Polymorphism refers to the ability to exist in multiple forms. Java implements polymorphism by method overloading and overriding.

12. What is Encapsulation? How Java implements it? And why we need encapsulation?
    Encapsulation refers to binding the data and the code in a single unit. Encapsulation is implemented in java through the access modifier keywords private, protected and public. Encapsulation is a protective barrier that prevents the code and data of the class from being freely accessed by the code of the outer class.

13. What is Interface and what is abstract class? What are the differences between them?
    Abstract class is a restricted class that cannot be used to create objects.
    An interface is a completely "abstract class" 
    1. Abstract class can have abstract as well as non-abstract methods, Interface can only abstract methods
    2. Abstract class may contain can have final, non-final, static and non-static variables, Interface can only has static and final variables.
    3. Abstract class can provide the implementation of the interface. Interface can’t provide the implementation of an abstract class.

14. design a parking lot (put the code to codingQuestions/coding1 folder, )
     1. If you have no ability to design it, please find the solution in internet, then understand it, then type it. (Do not just copy and paste)

15. What are Queue interface implementations and what are the differences and when to use what?
    PriorityQueue, LinkedList, LinkedBlockingQueue, ArrayBlockingQueue, PriorityBlockingQueue, DelayQueue, SynchronousQueue, TransferQueue, LinkedTransferQueue.
    PriorityQueue and LinkedList are not thread-safe. Concurrent Queue Implementations are LinkedBlockingQueue, ArrayBlockingQueue, PriorityBlockingQueue, DelayQueue, SynchronousQueue, TransferQueue, LinkedTransferQueue.

16. What is Runtime/unchecked exception? what is Compile/Checked Exception?
    1. An unchecked exception (also known as an runtime exception) in Java is something that has gone wrong with the program and is unrecoverable.
    2. a checked exception (also called a logical exception) in Java is something that has gone wrong in your code and is potentially recoverable. A checked exception is caught at compile time so if something throws a checked exception the compiler will enforce that you handle it.

17. what is the difference between throw and throws?
    Both throw and throws are concepts of exception handling in Java. The throws keyword is used to declare which exceptions can be thrown from a method, while the throw keyword is used to explicitly throw an exception within a method or block of code.

18. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?
    Because you have to throw first then catch.
