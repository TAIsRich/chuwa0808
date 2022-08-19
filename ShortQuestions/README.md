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
    

# HW5 # Template
HW24 (HW5)

1.  remeber pull the new code from that repo
2.  Explain volatile variables in java? (we also use it in Singleton)
    The Java volatile keyword guarantees variable visibility across threads, meaning reads and writes are visible across threads.
    
3.  how to create a new thread(Please also consider Thread Pool case)?
    There are three different ways to creat a new thread:
        1. Extends thread class
        2. Implements Runnable
        3. Implements Callable
        (detailed codes under codingQuestion)
        
4.  Difference between Runnable and Callable
    Runnable has no return while callable has return.
    
5.  what is the diff between t.start() and t.run()?
    t.start() starts a new thread to execute the task (defined under run()); 
    t.run() executes the task in the current thread.
    
6.  Which way of creating threads is better: Thread class or Runnable interface?
    Implementing the runnable interface is preferred as it allows more flexibility. While implementing Runnable interface, we can extend any other class; if we extend Thread, then the action we are doing is always going to be in a thread.
    
7.  what is the thread status?
    A thread can be in only one state at a given point of time. The different status of a thread include the following: New, Runnable, Blocked, Waiting, Timed_Waiting, and Terminated.
    
8.  difference between wait() and sleep() method
    For wait() method, thread goes in waiting state and it won’t come back automatically until we call the notify() or notifyAll(); however, sleep() can be used to pause the process for few seconds or the time we want to. The major difference is that wait() releases the lock or monitor while sleep() doesn’t releases the lock or monitor while waiting. wait() is used for inter-thread communication while sleep() is used to introduce pause on execution, generally.

9.  What is deadlock?
    Deadlock is a condition where two or more threads are blocked forever, waiting for each other. This usually happens when multiple threads need the same locks but obtain them in different orders. 
    
10. how do threads communicate with each other?
    If an object is accessible to various threads then these threads share access to that object's data member and thus communicate each other. The second way for threads to communicate is by using thread control methods: 1) wait(); 2)notify(); and 3) notifyAll().

11. what is join() method?
    Join method in Java allows one thread to wait until another thread completes its execution. In simpler words, it means it waits for the other thread to die. It has a void type and throws InterruptedException.
    Example as follows:
    1. Main thread call t.join()
    2. Main thread will stop and wait for thread t complets its task
    3. Main thread will continue after t finished its task
    
12. what is yield() method
    A yield() method is a static method of Thread class, and it can stop the currently executing thread and will give a chance to other waiting threads of the same priority. If in case there are no waiting threads or if all the waiting threads have low priority, then the same thread will continue its execution.
    
13. Explain thread pool
    A thread pool is a collection of pre-initialized threads. Generally, the collection size is fixed, but it is not mandatory. It facilitates the execution of N number of tasks using the same threads. If there are more tasks than threads, then tasks need to wait in a queue like structure (FIFO – First in first out).
    
    A thread pool reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing*.
    
    *Thrashing is a state in which our CPU perform 'productive' work less and 'swapping' more. CPU is busy in swapping pages, so much that it can not respond to user program as much as required. Why it occurs : In our system, Thrashing occurs when there are too much pages in our memory, and each page refers to another page.
    
14. What is Executor Framework in Java, its different types and how to create these executors?
    The Executor Framework contains a bunch of components that are used to efficiently manage multiple threads. Executor service manage thread in asynchronous way. Executor is a very simple interface with a single execute method accepting Runnable instances for execution.
    
    The common classes for implementation of Executor interfaces are as follows:
        1. Fixed Thread Pool : A thread pool with a fixed number of threads. If a thread is not available for the task, the task is put in queue waiting for an other task to ends. Method : Executors.newFixedThreadPool()
        2. Cached Thread Pool : A thread pool that creates as many threads it needs to execute the task in parrallel. The old available threads will be reused for the new tasks. If a thread is not used during 60 seconds, it will be terminated and removed from the pool. Method : Executors.newCachedThreadPool()
        3. Single Thread Executor : A thread pool with only one thread. So all the submitted tasks will be executed sequentially. Method : Executors.newSingleThreadExecutor()
        4. Scheduled Thread Pool : A thread pool made to schedule future task. Method : Executors.newScheduledThreadPool()
        5. Single Thread Scheduled Pool : A thread pool with only one thread to schedule future task. Method : Executors.newSingleThreadScheduledExecutor()

15. Difference between shutdown() and shutdownNow() methods of executor
    The shutdown() method will allow previously submitted tasks to execute before terminating, while the shutdownNow() method prevents waiting tasks from starting and attempts to stop currently executing tasks.

16. What is Atomic classes? when do we use it?
    The atomic classes provide a lock-free and thread-safe environment or programming on a single variable. It also supports atomic operations.Atomic operations are those operations that always execute together. All the atomic classes have the get() and set() methods that work on the volatile variable. The method works the same as read and writes on volatile variables.
    
17. What is the cocurrent collections?
    Concurrent package includes a number of additions to the Java Collections Framework. Using the concurrent collections can achieve thread-safety by dividing their data into segments. 

18. what kind of locks you know? 
    1. ReentrantLock
    2. ReadWriteLock
    3. StampedLock
    
19. What is the difference between class lock and object lock?
    Object Level Locks − Object level lock is mechanism when we want to synchronize a non-static method or non-static code block such that only one thread will be able to execute the code block on given instance of the class. This should always be done to make instance level data thread safe. It can be used when you want non-static method or non-static block of the code should be accessed by only one thread. 
    Class Level locks − Class level lock prevents multiple threads to enter in synchronized block in any of all available instances of the class on runtime. Class level locking should always be done to make static data thread safe. It can be used when we want to prevent multiple threads to enter the synchronized block in any of all available instances on runtime.J

20. What is future and completableFuture?

    A Future represents the result of an asynchronous computation. The Future interface is an interface that represents a result that will eventually be returned in the future. After we submit a callable task, we will get a Future object. When we call the get() method of the Future object, we can get the result of asynchronous computation. If the asynchronous task has been completed, we will get the result; otherwise, the get() method would be blocked and will only return the result when the task is completed.

    A CompletableFuture class is also a Future class. It implements the Future interface. CompletableFuture is used for asynchronous programming in Java. Asynchronous programming is a means of writing non-blocking code by running a task on a separate thread than the main application thread and notifying the main thread about its progress, completion or failure. ComletableFuture reduces blocking operations because you don't have to wait for the completion explicitly at each stage. When the asynchronous task is completed or encounter any exception, the CompletableFuture class can automatically call the callback method of the callback object. 
    

21. what is ThreadLocal?

    The ThreadLocal class is used to create thread local variables which can only be read and written by the same thread. For example, if two threads are accessing code having reference to same threadLocal variable then each thread will be independent from the other and will not see any modification to threadLocal variable done by other thread.
    
    When using ThreadLocal, we will need to use the try-finally blocks and execute a clean-up in the finally block.

22. Type the code by your self and try to understand it. (package: com.chuwa.tutorial.t08_multithreading)
        Done separately under  codingQuestions.

23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in 
com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
    
        Done separately under  codingQuestions.
    
    a. One solution use synchronized and wait notify 
    b. One solution use ReentrantLock and await, signal
        Thread-0: 1
        Thread-1: 2
        Thread-0: 3
        Thread-1: 4
        Thread-0: 5
        Thread-1: 6
        Thread-0: 7
        Thread-1: 8
        Thread-0: 9
        Thread-1: 10
        Process finished with exit code 0
    
24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)

        Done separately under  codingQuestions.

    Thread-0: 1
    Thread-0: 2
    Thread-0: 3
    Thread-0: 4
    Thread-0: 5
    Thread-0: 6
    Thread-0: 7
    Thread-0: 8
    Thread-0: 9
    Thread-0: 10
    Thread-2: 11
    Thread-2: 12
    Thread-2: 13
    Thread-2: 14
    Thread-2: 15
    Thread-2: 16
    Thread-2: 17
    Thread-2: 18
    Thread-2: 19
    Thread-2: 20
    Thread-1: 21
    Thread-1: 22
    Thread-1: 23
    Thread-1: 24
    Thread-1: 25
    Thread-1: 26
    Thread-1: 27
    Thread-1: 28
    Thread-1: 29
    Thread-1: 30

