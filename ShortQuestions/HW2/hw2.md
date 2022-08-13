####1. What is wrapper class in Java and Why we need wrapper class?

A wrapper class is a class that can **convert** primitive data types including (int, char, short, byte, etc) into objects.

We need wrapper class because we need to use those data types as objects. For example, the ArrayList can only store objects so wrapper would be used.

####2. What is the difference between HashMap and HashTable?

| HashMap                    | HashTable |
|----------------------------|----------|
| No method is synchronized.	 |Every method is synchronized.|
|Multiple threads can operate simultaneously and hence hashmap’s object is not thread-safe.|At a time only one thread is allowed to operate the Hashtable’s object. Hence it is thread-safe.|
|Threads are not required to wait and hence relatively performance is high.	|It increases the waiting time of the thread and hence performance is low.|
|Null is allowed for both key and value.	|Null is not allowed for both key and value. Otherwise, we will get a null pointer exception.|
|It is introduced in the 1.2 version.	|It is introduced in the 1.0 version.|
|It is non-legacy.	|It is a legacy.|

(Reference: https://www.geeksforgeeks.org/differences-between-hashmap-and-hashtable-in-java/)


####3. What is String pool in Java and why we need String pool?

String pool contains the Strings we already initiated. The reason we need string pool is that string is immutable.

####4. What is Java garbage collection?

GC of Java can clean the unused object (ex. Strings in String pool) from time to time.

####5. What are access modifiers and their scopes in Java?

Access modifiers are keywords in object-oriented languages that set the accessibility of classes, methods, and other members including:
1. public - in the project
2. private - in the same method
3. protected - in the same package or subclass
4. default - in the same package

####6. What is final key word? (Filed, Method, Class)

After initiated/defined, it can't be changed

####7. What is static keyword? (Filed, Method, Class). When do we usually use it?

It doesn't work for Object but for Class.

####8. What is the differences between overriding and overloading?

1. overriding - override the method that is defined in parent class
2. overloading - overload the method in same class with same name, for readability

####9. What is the differences between super and this?

1. super - parent class of the current class
2. this - the current class

####10. What is the Java load sequence?

1. loading
2. verification
3. preparation
4. parsing
5. initialization
6. use
7. unloading

####11. What is Polymorphism? And how Java implements it?

Child class override the method in parent class

####12. What is Encapsulation? How Java implements it? And why we need encapsulation?

Encapsulation in Java is a mechanism of wrapping the data (variables) and code acting on the data (methods) together as a single unit.

####13. What is Interface and what is abstract class? What are the differences between them?

1. interface - An interface is an empty shell. There are only the signatures of the methods, which implies that the methods do not have a body. The interface can't do anything. It's just a pattern.
2. abstract class - Abstract classes, unlike interfaces, are classes. They are more expensive to use, because there is a look-up to do when you inherit from them.

####14. design a parking lot (put the code to codingQuestions/coding1 folder, )

see coding

####15. What are Queue interface implementations and what are the differences and when to use what?

1. add - add to tail of queue
2. remove - remove from the head of queue
3. peek - take a peek of the head of queue
4. size -  get the size of queue
5. iterator - iterate the queue

####16. What is Runtime/unchecked exception? what is Compile/Checked Exception?

1. compile(checked) - error during the compile phase 
2. runtime(unchecked) - error during running

####17. what is the difference between throw and throws?

1. throw - throw an exception within a method with a throwable class object
2. throws - throws is used to declare exceptions that can occur during the execution of a program.

####18. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?

Exception is the parent class for all kinds of exceptions (ie. runtime exception and compile exception). 
If we put the subclass before parent class, then we first catch a specific error and the rests will be catch by Exception.
