# HW # Template
1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
    1. https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formattin g-on-github/basic-writing-and-formatting-syntax

2. practice git using the platform. list the git commands you learned
    1. https://learngitbranching.js.org/

    git commands:
    1. git commit
    2. git checkout/git switch (in Git version 2.23, still considered experimental)
    3. git branch
    4. git checkout -b [thebranchname] (create a new branch AND check it out at the same time)
    5. git merge
    6. git rebase (if we want to rebase the branch onto main, we should check out the branch and then run the command of git rebase main)
    7. git checkout HEAD^
    8. (TO BE CONTINUED)

3. What is the basic steps to init a git repo in you local?
    1. Create a directory("dir") to contain the project; 2. Go into the new dir; 3. Use the git init command; 4. Use "git add" command to add the files needed; 5. Use "git commit" command.

4. How to clone a repo from Github?
    1. Navigate to main page of the repository on Github; 2. Click on "Code" on the main page and get to the Clone panel; 3. Copy the url (i.e., HTTPS or SSH format); 4. In local terminal, use "cd" command to get into the target work directory, and then use the "git clone" command and paste in the url mentioned in step 3 above.

5. How to create a new branch and checkout to that branch?
    In local terminal, use the following command:
    1. Use "cd" command to get into the target directory for the certain git project;
    2. To create a new branch, use command: git branch <branch_name>/notes
    3. To checkout to that branch, use command: git checkout <branch_name>/notes

6. How to merge the branch_test to master branch in command? show me the commands
    1. git checkout master
    2. git merge branch_test

7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
    Commands way:
        1. git checkout branch_learn_stash
        2. git stash
        (checkout other branches to work on and then commit)
        3. git checkout branch_learn_stash
        4. git stash pop (to get the stashed changes back)

    IntelliJ way: (reference from Yilin's HW)
        1. click shelve changes option
        2. click Unshelve button

8. How do you understand PR is based on Branch?
    A branch is a separate version of the code, and a pull request is when someone takes the repo, makes their own branch, does some changes, then tries to merge that branch in, which is putting their changes in other people's code repository.

9. What is maven role? what it be used to do?
    Maven is a powerful project management tool that is based on POM(project object model), and plays the folowing roles: 1) manage dependencies; 2) build project; 3) documentation (Maven extracts the information from the POM to generate the pages under Project Information. The first step in having a good documentation is to have an accurate and visible basic project information, Maven can provide this for the plugin as long as the information in the POM is complete, descriptive and accurate); 4) reporting (Maven has several reports that you can add to your web site to display the current state of the project. These reports take the form of plugin goals, just like those used to build the project).

10. What is the lifecycle of maven? could you tell me the details ?
    The lifecycle of maven is as follows: clean, prepare resources (resources cioying can be customized in this phase), validate (validate if the project is correct and if all necessary information is available), compile (compilation of source code), test(test if the compiled source code is suitable for testing framework), package(creating the JAR/WAR package as mentioned in the packaging in POM.xml), install(this phase installs the packages in local/remote maven repository), and deploy(copying the final packages to the remote repository). Among all of the above, only the step of test can be skipped. 

11. what is the difference between package and install in maven lifecycle ?
    The package phase is for creating the JAR/WAR package in the packaging in POM.xml, while the install phase is for installing the packages in local/remote maven repository 

12. What is plugins in maven, list some plugins.
    The maven plugins are central part of maven framework, it is used to perform specific goal. 
    Maven has two types of plugins: 
    1) Build – executed during the build process. Examples include Clean(used to delete the target directory in order to clean up the earlier build artifacts), Install, and Surefire(Executes the Junit tests and generate the reports) plugins. These should be configured in the build section of the POM; 
    2) Reporting – executed during site generation to produce various project reports. Examples include Javadoc(	Generates the javadocs of the project) and Checkstyle plugins. These are configured in the reporting section of the project POM.
    Besides, here are some other common maven plugins: 1) compiler : to compile java source files; 2) jar : build the jar file of the project; 3) war : build the war file of the project; 4) antrun: runs a set of ant tasks specified in any stage/phase of the build.

13. In chuwa0808, MavenProject directory, create a maven Module using Intellij, named it as belows:
    1. groupID:com.chuwa.learn
    2. artifactID:java-core
    Done separately in MavenProject directory.

14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it.

# HW2 # Template
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

# HW3 # Template
1.  What is the checked exception and unchecked exception in Java, could you give one example?
    A checked exception is caught at compile time whereas a runtime or unchecked exception is, as it states, at runtime. A checked exception must be handled either by re-throwing or with a try catch block, whereas an unchecked isn't required to be handled.
    
    Examples:
    Checked exception: IOException(e.g. FileNotFound) and SQLException(e.g. id/data does not exist)
    Unchecked Exception: NullPointerException and IndexOutOfBoundException
    
2.  Can there be multiple finally blocks?
    No
 
3.  When both catch and finally return values, what will be the final result?
    The returned value from the finally block.

4.  What is optional? why do you use it? write an optional example
    Finally is optional in the try-catch block. The finally block always executes when the try block exits. This ensures that the finally block is executed even if an unexpected exception occurs.Finally is useful for more than just exception handling — it allows the programmer to avoid having cleanup code accidentally bypassed by a return , continue , or break . Putting cleanup code in a finally block is always a good practice, even when no exceptions are anticipated.
    Example:
    try{
    
    }catch(Exception e){

    }finally{

    }
    
5.  Why finally always be executed?
    The finally block executes regardless of whether an exception is thrown or caught. The finally block is usually used for clean-up purpose.
    
6.  Practice collection problems here: 
    https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection

    （Done separately)
 
7.  What is Java 8 new features?
    （Reference link: https://www.softwaretestinghelp.com/java/prominent-java-8-features/)
    
    Among the major changes, the following are the notable features that were added to this release.

        Functional Interfaces and Lambda Expressions
        forEach() method in Iterable interface
        Optional class,
        default and static methods in Interfaces
        Method references
        Java Stream API for Bulk Data Operations on Collections
        Java Date Time API
        Collection API improvements
        Concurrency API improvements
        Java IO improvements
        Nashorn JavaScript engine
        Base64 Encode Decode
        Miscellaneous Core API improvements

8.  What are the types of design patterns in Java ?
    （Further reference link: https://springframework.guru/gang-of-four-design-patterns/)
    There are three common types of design patterns in Java: 
        1. Creational: These design patterns are all about class instantiation or object creation; 
        2. Structural: These design patterns are about organizing different classes and objects to form larger structures and provide new functionality; and 
        3. Behavioral: These patterns are designed depending on how one class communicates with others.

9.  What are the SOLID Principles ?
    SOLID principles are object-oriented design concepts relevant to software development.
    1. Single Responsibility Principle
    2. Open-Closed Principle
    3. Liskov Substitution Principle
    4. Interface Segregation Principle
    5. Dependency Inversion Principle
    
10.  How can you achieve thread-safe singleton patterns in Java ?
    We can use the "Synchronized" keyword to apply the lock to the constructor of the singleton instance to achieve a thread-safe singleton pattern.
    
11.  What do you understand by the Open-Closed Principle (OCP) ?
    In object-oriented programming, the open–closed principle states "software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification"; that is, such an entity can allow its behaviour to be extended without modifying its source code.
    
12.  Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be 
substituted with any object of type B. What does this actually mean? (from OA ) choose your answer. （3）
    1.  It mean that if the object of type A can do something, the object of type B could also be able to 
    perform the same thing
    2.  It means that all the objects of type A could execute all the methods present in its subtype B
    3.  It means if a method is present in class A, it should also be present in class B so that the object of 
    type B could substitute object of type A.
    4.  It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
    
13.  Watch the design pattern video, and type the code, submit it to MavenProject folder
   singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
   Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6
d9
   Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6
d9
   Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f
7accf859bf7f6d9


# HW4 # Template
HW23 (HW4)
1.  Read those codes and type it one by one by yourself. the push the code to your branch.
https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8

    Done separately under CodingQuestions.
    
2.  practice stream API at least 3 times
a. https://blog.devgenius.io/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82

    Done separately under CodingQuestions.
    
3.  Write the Singleton design pattern include eager load and lazy load. 
        Eager Load:
        public class Singleton{
            private static Singleton instance = new Singleton();
            
            private Singleton(){}
            
            public static Singleton getInstance(){
                return instance;
            }
        }

        Lazy Load:
        public class Singleton{
            private static volatile Singleton instance;
                
            private Singleton(){}
                
            public static Singleton getInstance(){
            
                if(instance == null){
                    synchronized(Singleton.class){
                        if(instance == null){
                            instance = new Singleton();
                        }
                    }
                }
                return instance;
            }
        }
4.  What is Runtime Exception? could you give me some examples?
    A runtime or unchecked exception is caught at runtime.More specifically, RuntimeException is the superclass of those exceptions that can be thrown during the normal operation of the Java Virtual Machine. Some common Runtime exceptions are as follows: NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException, ClassCastException, DateTimeException, NegativeArraySizeException, and etc. (reference link: https://www.theserverside.com/tip/Fix-these-10-common-examples-of-the-RuntimeException-in-Java)

5.  Could you give me one example of NullPointerException?
    When we are iterating an LinkedList and reached the end node, which is null, we will get the NPE if we try to call node.next as the current node is a null.  
6.  What is the Optional class?
    Optional class is a new feature introduced in Java 8. It is a container that can hold, at max, one value and gracefully deals with null values, and it is used to avoid Null checks and runtime NPEs.
    
7. What is the @FunctionalInterface?
    A functional interface in Java is an interface that contains only a single abstract (unimplemented) method. A functional interface can contain default and static methods which do have an implementation, in addition to the single unimplemented method. Lambda is the implementation of the abstract method.
    
8.  What is lambda?
    A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method. Lambda enables to treat functionality as a method argument, or code as data.
    
    Lambda expressions can replace many usage of anonymous inner class, and they are mainly used with functional interfaces. 
    
9.  What is Method Reference?
    Method references are a special type of lambda expressions. They are used to refer method of functional interface, and they are compact and easy form of lambda expression. (Further reference link: https://www.baeldung.com/java-method-references)

10. What is Java 8 new features?
    Below are the major Java 8 new features: 1) Default methods and static methods in interface; 2) Lambda and Functional Interface; 3) Optional Class; 4) Method Reference; 5) Stream APIs.

11. Lambda can use unchanged variable outside of lambda? what is the details?
    Yes, lambda can use unchanged variable outside of lambda, as long as the variable is final or effectively final (non-final variables however never changed); for object variable, if it is changed, it cannot be used in lambda. 
