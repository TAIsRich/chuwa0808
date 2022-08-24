### 1. What is wrapper class in Java and Why we need wrapper class?
```

```

### 2. What is the difference between HashMap and HashTable?
```

```

### 3. What is String pool in Java and why we need String pool
```
String pool is a separate place in the heap memory where the values of all the strings which are defined in the program are stored.
We need it because Strings are immutable and the String Pool helps increase performance and decrease memory overhead.
```

### 4. What is Java garbage collection?
```
Garbage collection in Java is the process by which Java programs perform automatic memory management. The garbage collector finds these unused objects and deletes them to free up memory.
```

### 5. What are access modifiers and their scopes in Java?
```
Access modifiers in Java helps to restrict the scope of a class, constructor, variable, method, or data member. 
There are 4 types of access modifiers:
1. Default - visible only within the package (package private)
2. Private - visible only within the class
3. Protected - visible within the package or all subclasses
4. Public - visible everywhere
```

### 6. What is final key word? (Filed, Method, Class)
```
The final keyword is a non-access modifier that makes object non-changeable
```

### 7. What is static keyword? (Filed, Method, Class). When do we usually use it?
```
The static keyword is a non-access modifier that can be accessed without creating an object of a class.
The static keyword belongs to the class instead of an object, so it is mainly used for memory management. 
```

### 8. What is the differences between overriding and overloading? 
```
Overriding - the method signature (name and parameters) are the same in the superclass and the child class
Overloading - two or more methods in the same class have the same name but different parameters
```

### 9. What is the differences between super and this?
```
this refers to the current class
super refers to the parent class
```

### 10. What is the Java load sequence?
```
static variable/block -> constructo -> non static variable
```

### 11. What is Polymorphism? And how Java implements it?
```
Polymorphism refers to the same object exhibiting different forms and behaviors. 
There are two ways of implements it:
- Static Polymorphism - Overload (same class) - compile time
- Dynamic Polymorphism - Override (child class) - run tim
```

### 12. What is Encapsulation? How Java implements it? And why we need encapsulation?
```
Encapsulation in OOP refers to binding the data and the methods to manipulate that data together in a single unit (class)
We can use access modifiers to impletemnt it
Encapsulation is a way of restricting the access of our data members by hiding the implementation details. Encapsulation also improves the re-usability and is easy to change with new requirements.
```

### 13. What is Interface and what is abstract class? What are the differences between them?
```
An Interface is defined as an abstract type used to specify the behavior of a class. 
An abstract class is a normal class that is declared using the abstract keyword. It permits you to make functionality that subclasses can implement or override

Differences:
1. A class can extend only one abstract class while a class can implement multiple interfaces.
2. Interface can only contains abstract methods, but abstract class can contain both abstract and concrete methods
3. You cannot use access modifiers in Interface, but you can in abstract class
4. An interface can have only public abstract methods.	An abstract class has protected and public abstract methods
```

### 15. What are Queue interface implementations and what are the differences and when to use what?
```
A queue is a linear data structure or a collection that stores elements in a FIFO (First In, First Out) order. 
The two most common implementations are PriorityQueue and LinkedList.

LinkedList is a linear data structure where the elements are not stored in contiguous locations and every element is a separate object with a data part and address part. The elements are linked using pointers and addresses. Each element is known as a node. 

A PriorityQueue is used when the objects are supposed to be processed based on the priority. The PriorityQueue is based on the priority heap. The elements of the priority queue are ordered according to the natural ordering, or by a Comparator provided at queue construction time, depending on which constructor is used.  
```

### 16. What is Runtime/unchecked exception? what is Compile/Checked Exception?
```
Unchecked Exceptions are the exceptions that occurs at the time of execution
Checked Exceptions are the exceptions that are checked at compile time and must be handled
```

### 17. what is the difference between throw and throws?
```
Both throw and throws are concepts of exception handling in Java. 
The throws keyword is used to declare which exceptions can be thrown from a method
The throw keyword is used to explicitly throw an exception within a method or block of code
```

### 18. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception
```
Exception is the parent class for all other kinds of exceptions, which includes the Null/Runtime exception.
If put Exception before the Null/Runtime exception, the Null/Runtime exception will not be reached since Exception will catch all exceptions.
```
