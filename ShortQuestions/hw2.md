### 1.  What is wrapper class in Java and Why we need wrapper class?
1.Java is an object-oriented language that converts a primitive data type into a class object; hence, wrapper class objects enable us to convert the original passed value.
2.wrapper classes support the multithreading and synchronisation process.

### 2.What is the difference between HashMap and HashTable?
1.HashMap is non-syncronized and is not thread safe while HashTable is thread safe and is synchronized.
2.HashMap allows one null key and values can be null whereas HashTable doesn't allow null key or value.
3.HashMap is faster than HashTable. HashMap iterator is fail-safe where HashTable iterator is not fail-safe.

### 3. What is String pool in Java and why we need String pool?
1.String Pool is a storage area in Java heap. String allocation, like all object allocation, proves to be a costly affair in both the cases of time and memory. The JVM performs some steps while initializing string literals to increase performance and decrease memory overhead.
2.t is created to decrease the number of string objects created in the memory. Whenever a new string is created, JVM first checks the string pool. If it encounters the same string, then instead of creating a new string, it returns the same instance of the found string to the variable

### 4. What is Java garbage collection?
1.Java garbage collection is the process by which Java programs perform automatic memory management
2.ava programs compile to bytecode that can be run on a Java Virtual Machine, or JVM for short. When Java programs run on the JVM, objects are created on the heap, which is a portion of memory dedicated to the program

### 5. What are access modifiers and their scopes in Java?
1.Access modifiers are keywords that can be used to control the visibility of fields, methods, and constructors in a class. The four access modifiers in Java are public, protected, default, and private.

### 6. What is final key word? (Filed, Method, Class)
1.Java final keyword is a non-access specifier that is used to restrict a class, variable, and method. If we initialize a variable with the final keyword, then we cannot modify its value. If we declare a method as final, then it cannot be overridden by any subclasses

### 7. What is static keyword? (Filed, Method, Class). When do we usually use it?
1.the static keyword in Java is mainly used for memory management. The static keyword in Java is used to share the same variable or method of a given class. The users can apply static keywords with variables, methods, blocks, and nested classes. The static keyword belongs to the class than an instance of the class.

### 8. What is the differences between overriding and overloading?
1.When two or more methods in the same class have the same name but different parameters, it's called Overloading. When the method signature (name and parameters) are the same in the superclass and the child class, it's called Overriding.
2.Method overloading is a compile-time polymorphism,Method overriding is a run-time polymorphism.
3.Method overloading may or may not require inheritance. Method overriding always needs inheritance.

### 9. What is the differences between super and this?
1.this used for invoking the current class method.
2.super used for invoking parent class methods.
3.this can be used anywhere in the parameterized constructor.
4.super always the first line in the child class constructor.

### 10.What is the Java load sequence?
1.The Java Virtual Machine dynamically loads, links and initializes classes and interfaces. Loading is the process of finding the binary representation of a class or interface type with a particular name and creating a class or interface from that binary representation.

### 11.What is Polymorphism? And how Java implements it?
1.polymorphism means that an object can exist in different crystalline forms. For example, carbon can exist in three common types. Coal, graphite, and diamond are the three different crystalline forms of carbon.

### 12. What is Encapsulation? How Java implements it? And why we need encapsulation?
1.Encapsulation is one of the key features of object-oriented programming. Encapsulation refers to the bundling of fields and methods inside a single class. It prevents outer classes from accessing and changing fields and methods of a class. This also helps to achieve data hiding.

### 13. What is Interface and what is abstract class? What are the differences between them?
1.An abstract class allows you to create functionality that subclasses can implement or override. An interface only allows you to define functionality, not implement it. And whereas a class can extend only one abstract class, it can take advantage of multiple interfaces.

### 14. design a parking lot (put the code to codingQuestions/coding1 folder, )
1.Ok

### 15.If you have no ability to design it, please find the solution in internet, then understand it, then type it.
     (Do not just copy and paste)
1.OK
### 16.What are Queue interface implementations and what are the differences and when to use what?
1.A queue is a linear data structure or a collection in Java that stores elements in a FIFO (First In, First Out) order.
2.The queue collection has two ends i.e. front & rear. The elements are added at the rear and removed from the front.
3.As the Queue is an interface, it cannot be instantiated. We need some concrete classes to implement the functionality of the Queue interface. Two classes implement the Queue interface i.e. LinkedList and PriorityQueue.

### 17.What is Runtime/unchecked exception? what is Compile/Checked Exception?
1.A checked exception is caught at compile time whereas a runtime or unchecked exception is, as it states, at runtime. A checked exception must be handled either by re-throwing or with a try catch block, whereas an unchecked isn't required to be handled

### 18. what is the difference between throw and throws?
1.The throws keyword is used to declare which exceptions can be thrown from a method, while the throw keyword is used to explicitly throw an exception within a method or block of code. The throws keyword is used in a method signature and declares which exceptions can be thrown from a method

### 19. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime
1.because Null/Runtime Exception is subclass of Exception.