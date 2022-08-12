### 1. What is wrapper class in Java and Why we need wrapper class?
A Wrapper class is a class which contains the primitive data types (int, char, short, byte, etc). In other words, wrapper classes provide a way to use primitive data types (int, char, short, byte, etc) as objects. These wrapper classes come under java.util package.

- Wrapper Class will convert primitive data types into objects. The objects are necessary if we wish to modify the arguments passed into the method (because primitive types are passed by value).
- The classes in java.util package handles only objects and hence wrapper classes help in this case also.
- Data structures in the Collection framework such as ArrayList and Vector store only the objects (reference types) and not the primitive types.
- The object is needed to support synchronization in multithreading.
### 2. What is the difference between HashMap and HashTable?
- HashMap is non-syncronized and is not thread safe while HashTable is thread safe and is synchronized.
- HashMap allows one null key and values can be null whereas HashTable doesn't allow null key or value.
- HashMap is faster than HashTable.
- HashMap iterator is fail-safe where HashTable iterator is not fail-safe.
- HashMap extends AbstractMap class where HashTable extends Dictionary class.
### 3. What is String pool in Java and why we need String pool?
String Pool is a storage area in Java heap. String allocation, like all object allocation, proves to be a costly affair in both the cases of time and memory. The JVM performs some steps while initializing string literals to increase performance and decrease memory overhead.

It is created to decrease the number of string objects created in the memory. Whenever a new string is created, JVM first checks the string pool. If it encounters the same string, then instead of creating a new string, it returns the same instance of the found string to the variable.
### 4. What is Java garbage collection?
Java garbage collection is the process by which Java programs perform automatic memory management. Java programs compile to bytecode that can be run on a Java Virtual Machine, or JVM for short. When Java programs run on the JVM, objects are created on the heap, which is a portion of memory dedicated to the program. Eventually, some objects will no longer be needed. The garbage collector finds these unused objects and deletes them to free up memory.
### 5. What are access modifiers and their scopes in Java?
Access modifiers are keywords that can be used to control the visibility of fields, methods, and constructors in a class. The four access modifiers in Java are public, protected, default, and private.

- Default: declarations are visible only within the package (package private)
- Private: declarations are visible within the class only
- Protected: declarations are visible within the package or all subclasses
- Public: declarations are visible everywhere
### 6. What is final key word? (Filed, Method, Class)
The final keyword can be applied with the variables, a final variable that have no value it is called blank final variable or uninitialized final variable. It can be initialized in the constructor only. The blank final variable can be static also which will be initialized in the static block only. We will have detailed learning of these. Let's first learn the basics of final keyword.

- If you make any variable as final, you cannot change the value of final variable(It will be constant).
- If you make any method as final, you cannot override it.
- If you make any class as final, you cannot extend it.
### 7. What is static keyword? (Filed, Method, Class). When do we usually use it?
The static keyword in Java is mainly used for memory management. The static keyword in Java is used to share the same variable or method of a given class. The users can apply static keywords with variables, methods, blocks, and nested classes. The static keyword belongs to the class than an instance of the class. The static keyword is used for a constant variable or a method that is the same for every instance of a class.

Use the static variable for the property that is common to all objects. For example, in class Student, all students share the same college name. Use static methods for changing static variables.

You should consider making a method static in Java : 1) If a method doesn't modify the state of the object, or not using any instance variables. 2) You want to call the method without creating an instance of that class.
### 8. What is the differences between overriding and overloading?
1. Overloading happens at compile-time while Overriding happens at runtime: The binding of overloaded method call to its definition has happens at compile-time however binding of overridden method call to its definition happens at runtime.
2. Static methods can be overloaded which means a class can have more than one static method of same name. Static methods cannot be overridden, even if you declare a same static method in child class it has nothing to do with the same method of parent class.
3. The most basic difference is that overloading is being done in the same class while for overriding base and child classes are required. Overriding is all about giving a specific implementation to the inherited method of parent class.
4. Static binding is being used for overloaded methods and dynamic binding is being used for overridden/overriding methods.
5. Performance: Overloading gives better performance compared to overriding. The reason is that the binding of overridden methods is being done at runtime.
6. private and final methods can be overloaded but they cannot be overridden. It means a class can have more than one private/final methods of same name but a child class cannot override the private/final methods of their base class.
7. Return type of method does not matter in case of method overloading, it can be same or different. However in case of method overriding the overriding method can have more specific return type (refer this).
8. Argument list should be different while doing method overloading. Argument list should be same in method Overriding.
### 9. What is the differences between super and this?
- Represent and Reference: this keyword mainly represents the current instance of a class. On other hand super keyword represents the current instance of a parent class.
- Interaction with class constructor: this keyword used to call default constructor of the same class. super keyword used to call default constructor of the parent class.
- Method accessibility: this keyword used to access methods of the current class as it has reference of current class. One can access the method of parent class with the help of super keyword.
- Static context: this keyword can be referred from static context i.e can be invoked from static instance. For instance we can write System.out.println(this.x) which will print value of x without any compilation or runtime error. On other hand super keyword can't be referred from static context i.e can't be invoked from static instance. For instance we cannot write System.out.println(super.x) this will leads to compile time error.
### 10. What is the Java load sequence?
A Java Classloader is of three types:
1. BootStrap ClassLoader: A Bootstrap Classloader is a Machine code which kickstarts the operation when the JVM calls it. It is not a java class. Its job is to load the first pure Java ClassLoader. Bootstrap ClassLoader loads classes from the location rt.jar. Bootstrap ClassLoader doesn't have any parent ClassLoaders. It is also called as the Primodial ClassLoader.
2. Extension ClassLoader: The Extension ClassLoader is a child of Bootstrap ClassLoader and loads the extensions of core java classes from the respective JDK Extension library. It loads files from jre/lib/ext directory or any other directory pointed by the system property java.ext.dirs.
3. System ClassLoader: An Application ClassLoader is also known as a System ClassLoader. It loads the Application type classes found in the environment variable CLASSPATH, -classpath or -cp command line option. The Application ClassLoader is a child class of Extension ClassLoader.

Note: The ClassLoader Delegation Hierarchy Model always functions in the order Application ClassLoader->Extension ClassLoader->Bootstrap ClassLoader. The Bootstrap ClassLoader is always given the higher priority, next is Extension ClassLoader and then Application ClassLoader.
### 11. What is Polymorphism? And how Java implements it?
polymorphism refers to the ability of a class to provide different implementations of a method, depending on the type of object that is passed to the method. To put it simply, polymorphism in Java allows us to perform the same action in many different ways.

Compile-Time Polymorphism:Occurs during Method Overloading
Run-Time Polymorphism: Occurs during Method Overriding
### 12. What is Encapsulation? How Java implements it? And why we need encapsulation?
Encapsulation refers to the bundling of fields and methods inside a single class. It prevents outer classes from accessing and changing fields and methods of a class. This also helps to achieve data hiding.

Using encapsulation we can allow the programmer to decide on the access to data and methods operating on that data. For example, if we want a particular piece of data to be inaccessible to anyone outside the class, then we make that data private.
### 13. What is Interface and what is abstract class? What are the differences between them?
- Type of methods: Interface can have only abstract methods. An abstract class can have abstract and non-abstract methods. From Java 8, it can have default and static methods also.
- Final Variables: Variables declared in a Java interface are by default final. An abstract class may contain non-final variables.
- Type of variables: Abstract class can have final, non-final, static and non-static variables. The interface has only static and final variables.
- Implementation: Abstract class can provide the implementation of the interface. Interface can't provide the implementation of an abstract class.
- Inheritance vs Abstraction: A Java interface can be implemented using the keyword "implements" and an abstract class can be extended using the keyword "extends".
- Multiple implementations: An interface can extend one or more Java interfaces, an abstract class can extend another Java class and implement multiple Java interfaces.
- Accessibility of Data Members: Members of a Java interface are public by default. A Java abstract class can have class members like private, protected, etc.
### 14. design a parking lot (put the code to codingQuestions/coding1 folder, )
    - 1. If you have no ability to design it, please find the solution in internet, then understand it, then type it.(Do not just copy and paste)
### 15. What are Queue interface implementations and what are the differences and when to use what?
The Queue interface is present in java.util package and extends the Collection interface is used to hold the elements about to be processed in FIFO(First In First Out) order. It is an ordered list of objects with its use limited to inserting elements at the end of the list and deleting elements from the start of the list, (i.e.), it follows the FIFO or the First-In-First-Out principle.
### 16. What is Runtime/unchecked exception? what is Compile/Checked Exception?
An unchecked exception is an exception that occurs at the time of execution. These are also called as Runtime Exceptions. These include programming bugs, such as logic errors or improper use of an API. Runtime exceptions are ignored at the time of compilation.

A checked exception is an exception that occurs at the compile time, these are also called as compile time exceptions. These exceptions cannot simply be ignored at the time of compilation, the programmer should take care of (handle) these exceptions.
### 17. what is the difference between throw and throws?
The throws keyword is used to declare which exceptions can be thrown from a method, while the throw keyword is used to explicitly throw an exception within a method or block of code.

The throws keyword is used in a method signature and declares which exceptions can be thrown from a method. The throws keyword can be useful for propagating exceptions in the call stack and allows exceptions to not necessarily be handled within the method that declares these exceptions.

On the other hand, the throw keyword is used within a method body, or any block of code, and is used to explicitly throw a single exception. The throw keyword can be useful for throwing exceptions based on certain conditions within a code block and for throwing custom exceptions.
### 18. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?
```java
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3
        String s = null;
        try {
            System.out.println(b / a);
            System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("End ...");
    }
}
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3
        String s = null;
        try {
            // System.out.println(b / a);
            System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("End ...");
    }
}
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3
        String s = null;
        try {
            // System.out.println(b / a);
            // System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("End ...");
    }
}
```