# HW # Template
1.  What is wrapper class in Java and Why we need wrapper class? 
    A Wrapper class is a class which contains the primitive data types (int, char, short, byte, etc). In other words, wrapper classes provide a way to use primitive data types (int, char, short, byte, etc) as objects.

    We need Wrapper objects to function with collections which is only possible with the help of Wrapper classes. As the wrapper classes have objects we can store null as a value. We could not store null in variables of primitive datatype.

2.  What is the difference between HashMap and HashTable?
    (Reference link: https://www.tutorialspoint.com/Difference-between-HashMap-and-HashTable-in-Java)
    1. HashMap is non-syncronized and is not thread safe while HashTable is thread safe and is synchronized.
    2. HashMap allows one null key and values can be null whereas HashTable doesn't allow null key or value.
    3. HashMap is faster than HashTable.
    4. HashMap iterator is fail-safe where HashTable iterator is not fail-safe.Fail-safe iterators allow modifications of a collection while iterating over it. These iterators don't throw any Exception if a collection is modified while iterating over it. They use copy of original collection to traverse over the elements of the collection.
    5. HashMap extends AbstractMap class where HashTable extends Dictionary class.

3.  What is String pool in Java and why we need String pool? 
    (Further reference link: https://www.baeldung.com/java-string-pool)
    String Pool is a storage area in Java heap where string literals stores. It is also known as String Intern Pool or String Constant Pool. It is just like object allocation. With the immutability of Strings in Java, the JVM can optimize the amount of memory allocated for them by storing only one copy of each literal String in the pool. This process is called interning.

    String pool helps increase performance and decrease memory overhead. When we create a String variable and assign a value to it, the JVM searches the pool for a String of equal value. If found, the Java compiler will simply return a reference to its memory address, without allocating additional memory; if not found, it'll be added to the pool (interned) and its reference will be returned.

4.  What is Java garbage collection?
    Java garbage collection ("GC") is the process by which Java programs perform automatic memory management; it is process of reclaiming the runtime unused memory automatically. In other words, it is a way to destroy the unused objects. GC makes java memory efficient because garbage collector removes the unreferenced objects from heap memory, and it is automatically done by the garbage collector(a part of JVM) so the user don't need to make extra efforts.

5.  What are access modifiers and their scopes in Java? 
    In Java, there are four access modifiers: public, private, protected, and default/friendly; these access modifiers are used to set the scope and accessibility (visibility) of classes, interfaces, variables, methods, constructors, data members, and the setter methods.  
    Scope of access modifiers:
        public: available and visible to the same class, same package, subclasses/derived classes, and other classes;
        protected: available and visible to the same class, same package, and subclasses/derived classes;
        default/friendly: available and visible to the same class and same package;
        private: available and visible to the same class.

6.  What is final key word? (Filed, Method, Class)
    The final keyword is a non-access modifier used for classes, attributes and methods, which makes them non-changeable (impossible to inherit or override). 

7.  What is static keyword? (Filed, Method, Class). When do we usually use it?
    The static keyword is a non-access modifier used for methods and attributes. Static methods/attributes can be accessed without creating an object of a class.

    The static keyword in Java is mainly used for memory management. The static keyword in Java is used to share the same variable or method of a given class. The users can apply static keywords with variables, methods, blocks, and nested classes. The static keyword belongs to the class than an instance of the class. The static keyword is used for a constant variable or a method that is the same for every instance of a class.

8.  What is the differences between overriding and overloading?
    When the method signature (name and parameters) are the same in the superclass and the child class, it's called Overriding. When two or more methods in the same class have the same name but different parameters, it's called Overloading. 

9.  What is the differences between super and this?
    The this keyword points to a reference of the current class, while the super keyword points to a reference of the parent class.

10. What is the Java load sequence?
    (Reference link: https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-5.html#:~:text=The%20Java%20Virtual%20Machine%20dynamically,interface%20from%20that%20binary%20representation.)
    
    The Java Virtual Machine dynamically loads, links and initializes classes and interfaces. The loading, linking, and initialization are the initial processes that JVM commences as soon as a byte code, called the class file, is loaded into JVM for execution.
    
        1. Loading is the process of finding the binary representation of a class or interface type with a particular name and creating a class or interface from that binary representation. 
        2. Linking is the process of taking a class or interface and combining it into the run-time state of the Java Virtual Machine so that it can be executed. 
        3. Initialization of a class or interface consists of executing the class or interface initialization method.

11. What is Polymorphism? And how Java implements it? 
    Polymorphism means "many forms", and it occurs when we have many classes that are related to each other by inheritance.

    Polymorphism in Java can be achieved in two ways (i.e., method overloading and method overriding), and Polymorphism in Java is mainly divided into two types. 
        1. Compile-time polymorphism can be achieved by method overloading;
        2. Runtime polymorphism can be achieved by method overriding.

12. What is Encapsulation? How Java implements it? And why we need encapsulation?
    Encapsulation in Java refers to integrating data (variables) and code (methods) into a single unit. In encapsulation, a class's variables are hidden from other classes and can only be accessed by the methods of the class in which they are found.

    In Java, Data Encapsulation is implemented by using access modifiers that defines the scope and visibility of a class member.

    Encapsulation helps in isolating implementation details from the behavior exposed to clients of a class (other classes/functions that are using this class), and gives the programmer more control over coupling in their code. Using encapsulation, we can allow the programmer to decide on the access to data and methods operating on that data.
    
13.  What is Interface and what is abstract class? What are the differences between them?

    Both abstract class and interface are used for abstraction.

    Interface: An interface is a reference type in Java. It is similar to class. It is a collection of abstract methods. A class implements an interface, thereby inheriting the abstract methods of the interface. Along with abstract methods, an interface may also contain constants, default methods, static methods, and nested types. Method bodies exist only for default methods and static methods.

    Abstract class: an abstract class is nothing but a class that is declared using the abstract keyword. It also allows us to declare method signatures using the abstract keyword (abstract method) and forces its subclasses to implement all the declared methods. Suppose if a class has a method that is abstract, then the class itself must be abstract.

    Abstract class VS Interface:
    (Reference link: https://www.infoworld.com/article/2077421/abstract-classes-vs-interfaces-in-java.html)

    1. From an object-oriented programming perspective, the main difference between an interface and an abstract class is that an interface cannot have state, whereas the abstract class can have state with instance variables. More specifically, interfaces can only have final static variables and can never change their own state, and interfaces can only use static final fields, parameters, or local variables for methods; while abstract classes can have any kind of instance or static variables, mutable or immutable.
    2. Classes can implement more than one interface, but they can extend only one abstract class. This is a design decision based on the fact that multiple inheritance (extending more than one class) can cause code deadlocks. Java's engineers decided to avoid that.
    3. Interfaces can be implemented by classes or extended by interfaces, but classes can be only extended.
    4. Lambda expressions can only be used with a functional interface (meaning an interface with only one method), while abstract classes with only one abstract method cannot use lambdas.
    5. Interfaces cannot have constructors, but abstract classes can.
    6. Abstract classes can have any kind of methods; interfaces can have abstract methods, default and static methods (introduced in Java 8), and private methods with the implementation (introduced in Java 9).

14.  Design a parking lot (put the code to codingQuestions/coding1 folder, )
    1.  If you have no ability to design it, please find the solution in internet, then understand it, then type it.
    (Do not just copy and paste)
    Please find it in codingQuestions folder.

15. What are Queue interface implementations and what are the differences and when to use what?
    Two classes implement the Queue interface i.e. LinkedList and PriorityQueue. They are different in terms of the time cost for the CRUD operations(i.e., insert, read, update, and delete). For both classes, the time cost of read operation is O(1); however, for a Doubly LinkedList, the time cost for insert and delete operations are both O(1) while for PriorityQueue it will be O(logN) for insert, delete, and update operations. For LinkedList, the time cost update operation is O(1). 

16.  What is Runtime/unchecked exception? what is Compile/Checked Exception?
    In Java, exceptions under Error and RuntimeException classes are unchecked exceptions, everything else under throwable is checked.

    An unchecked exception is an exception that occurs at the time of execution. These are also called as Runtime Exceptions. These include programming bugs, such as logic errors or improper use of an API. Runtime exceptions are ignored at the time of compilation.

    A checked exception is an exception that occurs at the compile time, these are also called as compile time exceptions. These exceptions cannot simply be ignored at the time of compilation, the programmer should take care of (handle) these exceptions.

17. what is the difference between throw and throws?
    The throws keyword is used to declare which exceptions can be thrown from a method, while the throw keyword is used to explicitly throw an exception within a method or block of code. The throws keyword is used in a method signature and declares which exceptions can be thrown from a method.
    
18.  Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime 
exception before Exception?
    Exception is the parent class of Runtime exceptions and Compiletime exceptions, so we put the Null/Runtime exception before Exception to try to locate the more specific exception, if any.

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
62