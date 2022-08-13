### 1. What is wrapper class in Java and Why we need wrapper class?
- The wrapper class is a class containing primitive data types. It provides a field that stores primitive data types as an object
- We need the wrapper class because we want to convert primitive data types into objects. Also, some collections like ArrayList only store objects; therefore, we need a wrapper class to pass in.

### 2. What is the difference between HashMap and HashTable?
- HashMap is non-synchronized, and HashTable is synchronized that can be shared between many threads.
- HashMap allows one null key and multiple null values, whereas HashTable doesn't allow null key or value;
- HashMap is faster than HashTable because HashTable includes the waiting time for the thread, but HashMap does not.
### 3. What is String pool in Java and why we need String pool?
- String pool is a collection of Strings which are stored in heap memory
- A string pool is a place in the heap memory where the value of all strings defined in the program is stored. When we declare a string, the object of it is created in the heap, and the instance with the value is stored in the string pool. We can use the keyword "new" to skip the memory allocation placed outside the string pool but inside the heap memory.
### 4. What is Java garbage collection?
- First, java heap space is used by the java runtime to allocate memory. So whenever we create an object, it is always created in the heap space. And garbage collection runs on the heap memory to free the memory used by an object that doesn't have any reference.
- The garbage collection is an automatic process, which is the process of looking for any object without reference in the heap space and deleting it.
### 5. What are access modifiers and their scopes in Java?
- Access modifiers are Default, Private, Protected, and Public

- Default: Only within the same package
- Private: Only within the same class where they are declared
- Protected: Within same package or subclass in different package
- Public: Everywhere
### 6. What is final key word? (Filed, Method, Class)
- A variable with a final keyword means the value cannot be modified; referring to the final variable cannot be re-bound to reference another object.
- the final variable must be initialized; otherwise, it will throw a compile-time error.
- The final method cannot be overridden. The object class is one of the methods, some methods of its method are final.
- The final class cannot be inherited. Usually, it's to prevent inheritance or create an immutable class.
### 7. What is static keyword? (Filed, Method, Class). When do we usually use it?
- The static keyword is used for memory management mainly.
- The static keyword is belongs to the class than an instance of the class
- When a variable is declared as static, the single cop of the variable is created and shred among all objects are the class level.
- Static local variables are not allowed in java
- One of the examples of a static method is __main()__, any static member can be accessed before any objects of its class are created, and without reference to any object.
- A class can be made static only if it is a nested class. We cannot declare a top-level class with a static modifier but can declare nested classes as static.
- When a member is declared static, it can be accessed before any objects of its class are created, and without reference to any object.
- Use the static variable and method when the property that is common to all objects.
### 8. What is the differences between overriding and overloading?
- Override is dynamic polymorphism and implemented in run time
- Overload is static polymorphism and implemented in compile time
- The overriding method must have the same name and signatures
- The overloading method must have the same name and different signatures
- In method overloading, the return type can or can not be the same, but we have to change the parameter.
- In method overriding, the return type must be the same or co-variant
- Method overriding always needs inheritance.
- Method overloading may or may not require inheritance.
### 9. What is the differences between super and this?
- the keyword **this** represents the current instance of a class
- the keyword **super** represents the current instance of parent class
- **this** keyword used to call default constructor of the same class.
- **super** keyword used to call default constructor of the parent class.
### 10. What is the Java load sequence?
With inheritance:
1. static block of code or static variable from the parent class 
2. static block of code or static variable from the child class 
3. variable or block of code from the parent class 
4. Constructor from the parent class
5. variable or block of code from the child class 
6. Constructor from the child class 

Without inheritance:
1. static block of code or static variable
2. variable or block of code
3. Constructor
### 11. What is Polymorphism? And how Java implements it?
- Polymorphism simply means it can have many different shapes.
- Ppolymorphism refers to the same object exhibiting different forms and behaviors.
- It allows the program to define one interface and have multiple implementations.
- It contains two types that compile time and run time.
- The representation of compile time is overloading; for run time,  which is overriding
### 12. What is Encapsulation? How Java implements it? And why we need encapsulation?
- Encapsulation in OOP refers to binding the data and the methods to manipulate that data together in a single unit (class).
- It is a way to restrict the access of the data members by hiding the implementation details.
- Increased Flexibility which we can determine which variable is read-only or write-only
- Encapsulation also improves the re-usability and is easy to change with new requirements.
- Easy to test the code
### 13. What is Interface and what is abstract class? What are the differences between them?
- Abstract class and interface both are used to achieve abstraction where we can declare the abstract methods. Abstract class and interface both can't be instantiated.
- Interfaces are a kind of code contract, which must be implemented by a concrete class.
- Abstract classes are similar to normal classes, with the difference that they can include abstract methods, which are methods without a body. Abstract classes cannot be instantiated.
- Abstract class can have abstract and non-abstract methods.
- Interface can have only abstract methods. Since Java 8, it can have default and static methods also.
- Abstract class can have final, non-final, static and non-static variables.
- Interface has only static and final variables.
- Abstract class can provide the implementation of interface.
- Interface can't provide the implementation of abstract class.
- An abstract class can extend another Java class and implement multiple Java interfaces.
- An interface can extend another Java interface only.
### 14. design a parking lot (put the code to codingQuestions/coding1 folder, )
	If you have no ability to design it, please find the solution in internet, then understand it, then type it.(Do not just copy and paste)
### 15. What are Queue interface implementations and what are the differences and when to use what?
- The Queue interface is present in java.util package and extends the Collection interface is used to hold the elements about to be processed in FIFO(First In First Out) order. It is an ordered list of objects with its use limited to inserting elements at the end of the list and deleting elements from the start of the list, (i.e.), it follows the FIFO or the First-In-First-Out principle.
- PriorityQueue: PriorityQueue class which is implemented in the collection framework provides us a way to process the objects based on the priority.
- LinkedList: LinkedList is a class which is implemented in the collection framework which inherently implements the linked list data structure
- PriorityBlockingQueue: It is to be noted that both the implementations, the PriorityQueue and LinkedList are not thread-safe. PriorityBlockingQueue is one alternative implementation if thread-safe implementation is needed.
### 16. What is Runtime/unchecked exception? what is Compile/Checked Exception?
- a checked exception (also called a logical exception) in Java is something that has gone wrong in your code and is potentially recoverable.
- An unchecked exception (also known as an runtime exception) in Java is something that has gone wrong with the program and is unrecoverable. 
- the difference between a checked and unchecked exception is that a checked exception is caught at compile time whereas a runtime or unchecked exception is, as it states, at runtime. A checked exception must be handled either by re-throwing or with a try catch block, a runtime isn¡¯t required to be handled. An unchecked exception is a programming error and are fatal, whereas a checked exception is an exception condition within your codes logic and can be recovered or retried from.
### 17. what is the difference between throw and throws?
- The throw keyword is used inside a function. It is used when it is required to throw an Exception logically.
- The throws keyword is used in the function signature. It is used when the function has some statements that can lead to exceptions.
- The throw keyword is used to throw an exception explicitly. It can throw only one exception at a time.
- The throws keyword can be used to declare multiple exceptions, separated by a comma.
### 18. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?
- On the other hand, we put both ArithmeticException and NullPointerException ahead of RuntimeException; that is for the same reason as putting Exception ahead of RuntimeException, which, once the parent class run, won't reach out to the subclass. It leads to we cannot determine the specific Exception that the program occurs.