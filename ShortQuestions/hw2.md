# 1 What is wrapper class in Java and why we need wrapper class

A wrapper class is a wrapper of the corresponding primitive type. And the object will represent the value of the primitive type.

Generic type can’t be primitive type, so we need corresponding wrapper class to do this. 

# 2. What is the difference between HashMap and HashTable?

HashTable does not allow null key, but HashMap allow one null key.

# 3. What is String pool in Java and why we need String pool?

String pool contains all the String objects that we have already instantiated, it will maintain an intern area in Heap.

We need string pool because String is immutable. 

# 4 What is GC

GC will automatically delete the unused objects that are maintained on Heap.

# 5 What are access modifiers and their scopes in Java 
Access modifiers are used to limit the access to the current method or fields from other method or fields or user.

public — everyone
private — only myself
protected — in the same package and my subclass
default — only the same package

# 6 final
The current field, method or class can’t be changed once defined

# 7 Static
The fields are belong to the whole class, not for objects. 

# 8 overriding vs overloading
overriding — override the method that already been defined.
overloading — method with same name but with different signatures

# 9 super vs. this
super — parent class regarding the current class
this — refer to current class

# 10. load sequence
loading, verification, preparation, parsing, initialization, use and unloading.

# 11. Polymorphism
Subclass use methods that defined in it’s super class and override the method. 

# 12. Encapsulation
Add modifier to limit the access to current method, or field.

# 13 Interface and abstract class

Interface:
- can only have abstract methods that are not defined
- all methods must be public
- can be implements by a class
- can’t have constructor
- When a class implements an interface:
- it have to define each abstract class, like how should I use this method
- it will inheritance all the abstract classes in the interface
- a class can implements multiple interface


Abstract class:
- has one or more abstract methods, can also have non-abstract methods
- abstract methods only have heading, but not defined


# 15. Queue interface implementations  (FIFO)
- offer(), enqueue
- poll(), poll the top
- peek(), look at the top but not pull

#16. runtime(unchecked) vs. compile(checked)
- compile(checked), haven’t run the code yet, but has compile error that can be fixed
- runtime(unchecked), error during running

#17. Throw and throws
- throw: throw an exception within a method with a throwable class object
- throws: put in the heading of the method, means there might be an error, and the method who invoke this method should catch the exception and deal with it.

#18 Exception class
Exception is the parent class for all other kinds of exceptions. If put Exception before the subclasses, the subclasses will not be reached since Exception will catch all exceptions. 

When we put the subclass before parent class, then we can define how to catch a specific error and the rests will be catch by Exception.
