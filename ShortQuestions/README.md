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
    
# HW6 # Template    
Part I : SQL Practice
(commands reference: http://g2pc1.bu.edu/~qzpeng/manual/MySQL%20Commands.htm)
1. Create oms_company_address table
Commands on terminal:
    mysql -u root -p
    mysql> create database test1;
    mysql> use test1
    Database changed
    mysql> CREATE TABLE oms_company_address(id int(50) auto_increment primary key, address_name varchar(200),send_status int(1),receive_status int(1),name varchar(64),phone varchar(64),province varchar(64),city varchar(64),region varchar(64),detail_address varchar(200));
    Query OK, 0 rows affected, 3 warnings (0.16 sec)
    mysql> describe oms_company_address;
+----------------+--------------+------+-----+---------+----------------+
| Field          | Type         | Null | Key | Default | Extra          |
+----------------+--------------+------+-----+---------+----------------+
| id             | int          | NO   | PRI | NULL    | auto_increment |
| address_name   | varchar(200) | YES  |     | NULL    |                |
| send_status    | int          | YES  |     | NULL    |                |
| receive_status | int          | YES  |     | NULL    |                |
| name           | varchar(64)  | YES  |     | NULL    |                |
| phone          | varchar(64)  | YES  |     | NULL    |                |
| province       | varchar(64)  | YES  |     | NULL    |                |
| city           | varchar(64)  | YES  |     | NULL    |                |
| region         | varchar(64)  | YES  |     | NULL    |                |
| detail_address | varchar(200) | YES  |     | NULL    |                |
+----------------+--------------+------+-----+---------+----------------+
10 rows in set (0.09 sec)

2. Insert some random data to oms_company_address table
mysql> INSERT INTO oms_company_address VALUES(1, 'add1', 1, 1, 'xuan', '1231231234','CA','Santa Clara', 'CA', '888 Main St');
Query OK, 1 row affected (0.14 sec)

mysql> INSERT INTO oms_company_address VALUES(2, 'add2', 1, 1, 'yu', '12313454','CA','Santa Clara', 'CA', '556 Main St');
Query OK, 1 row affected (0.02 sec)

mysql> INSERT INTO oms_company_address VALUES(3, 'add3', 1, 1, 'jeremy', '15689234','CA','Santa Clara', 'CA', '888 Oakload AV');
Query OK, 1 row affected (0.03 sec)

mysql> INSERT INTO oms_company_address VALUES(4, 'add4', 1, 1, 'lin', '788113454','CA','Cupertino', 'CA', '1000 Cherry St');
Query OK, 1 row affected (0.04 sec)

mysql> INSERT INTO oms_company_address VALUES(5, 'add5', 1, 1, 'rosie', '78567980','NY','New York', 'CA', '666 Broadway');
Query OK, 1 row affected (0.01 sec)


3. Write a SQL query to fetch all data from oms_company_address`table
SELECT * FROM oms_company_address oca;
+----+--------------+-------------+----------------+--------+------------+----------+-------------+--------+----------------+
| id | address_name | send_status | receive_status | name   | phone      | province | city        | region | detail_address |
+----+--------------+-------------+----------------+--------+------------+----------+-------------+--------+----------------+
|  1 | add1         |           1 |              1 | xuan   | 1231231234 | CA       | Santa Clara | CA     | 888 Main St    |
|  2 | add2         |           1 |              1 | yu     | 12313454   | CA       | Santa Clara | CA     | 556 Main St    |
|  3 | add3         |           1 |              1 | jeremy | 15689234   | CA       | Santa Clara | CA     | 888 Oakload AV |
|  4 | add4         |           1 |              1 | lin    | 788113454  | CA       | Cupertino   | CA     | 1000 Cherry St |
|  5 | add5         |           1 |              1 | rosie  | 78567980   | NY       | New York    | CA     | 666 Broadway   |
+----+--------------+-------------+----------------+--------+------------+----------+-------------+--------+----------------+
5 rows in set (0.00 sec)


4. Write a SQL query to fetch top 3 records from oms_company_address table
mysql> SELECT * FROM oms_company_address LIMIT 3;
+----+--------------+-------------+----------------+--------+------------+----------+-------------+--------+----------------+
| id | address_name | send_status | receive_status | name   | phone      | province | city        | region | detail_address |
+----+--------------+-------------+----------------+--------+------------+----------+-------------+--------+----------------+
|  1 | add1         |           1 |              1 | xuan   | 1231231234 | CA       | Santa Clara | CA     | 888 Main St    |
|  2 | add2         |           1 |              1 | yu     | 12313454   | CA       | Santa Clara | CA     | 556 Main St    |
|  3 | add3         |           1 |              1 | jeremy | 15689234   | CA       | Santa Clara | CA     | 888 Oakload AV |
+----+--------------+-------------+----------------+--------+------------+----------+-------------+--------+----------------+
3 rows in set (0.01 sec)

5. Update oms_company_address table to set all phoneto 666-6666-8888
mysql> UPDATE oms_company_address
    -> SET phone = '666-6666-8888';
Query OK, 5 rows affected (0.02 sec)
Rows matched: 5  Changed: 5  Warnings: 0

6. Delete one entry from oms_company_address table
mysql> DELETE FROM oms_company_address
    -> WHERE id = 4;
Query OK, 1 row affected (0.01 sec)

7. (Optional) You can also try to create other tables that listed above

Part II:
take below examples, 
Each example with 404, 401,500 and any http status codes you know

1. 5 GET APIs with different response type
    https://reqres.in/api/users?page=2 (200 OK)
    https://reqres.in/api/users/2 (200 OK)
    https://reqres.in/api/users/27 (404 Not Found)
    https://reqres.in/api/unknown (200 OK)
    https://reqres.in/api/unknown/30 (404 Not Found)
    
2. 5 Post API with json request body, please also paste the response here
    https://reqres.in/api/users (201 Created)
    Body: (raw -> JSON)
    {
        "name": "theresa",
        "job": "leader"
    }
    Response:
    {
        "name": "theresa",
        "job": "leader",
        "id": "63",
        "createdAt": "2022-08-22T18:54:57.541Z"
    }
    
    
    https://reqres.in/api/register (200 OK)
    Body: (raw -> JSON)
    {
        "email": "eve.holt@reqres.in",
        "password": "pistol"
    }
    Response:
     {
        "id": 4,
        "token": "QpwL5tke4Pnpja7X4"
    }  
    
    https://reqres.in/api/register (400 Bad Request)
        Body: (raw -> JSON)
    {
        "email": "happy@gmail.com",
        "password": "123456"
    }
    Response:
     {
        "error": "Note: Only defined users succeed registration"
    }
    
    https://reqres.in/api/register (400 Bad Request)
        Body: (raw -> JSON)
    {
        "email": "happy@gmail.com",
    }
    Response:
     {
        "error": "Missing password"
    }
    
    https://reqres.in/api/register (200 OK)
        Body: (raw -> JSON)
    {
        "email": "eve.holt@reqres.in",
        "password": "cityslicka"
    }
    Response:
     {
        "token": "QpwL5tke4Pnpja7X4"
    }
    
3. 3 PUT API with json request body, please also paste the response here
    https://reqres.in/api/users/2 (200 OK)
        Body: (raw -> JSON)
    {
        "name": "morpheus",
        "job": "zion resident"
    }
    Response:
     {
        "name": "morpheus",
        "job": "zion resident",
        "updatedAt": "2022-08-22T19:06:58.934Z"
    }
    
    https://reqres.in/api/users/63 (200 OK)
        Body: (raw -> JSON)
    {
        "name": "theresa",
        "job": "senior"
    }
    Response:
     {
        "name": "theresa",
        "job": "senior",
        "updatedAt": "2022-08-22T19:08:31.988Z"
    }
    
    https://reqres.in/api/users/67 (200 OK)
        Body: (raw -> JSON)
    {
        "name": "happy",
        "job": "manager"
    }
    Response:
     {
        "name": "happy",
        "job": "manager"
        "updatedAt": "2022-08-22T19:09:34.547Z"
    }
    
4. 2 DELETE API
    https://reqres.in/api/users/63 (204 No Content)
    https://reqres.in/api/users/2 (204 No Content)



Part III: API Pratice
1.  Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范
1.1 Twitter: https://developer.twitter.com/en/docs/api-reference-index#twitter-api-v2
    https://api.twitter.com/
    Tweets
        Bookmarks
        DELETE /2/users/:id/bookmarks/:tweet_id
        GET /2/users/:id/bookmarks
        POST /2/users/:id/bookmarks
        COVID-19 stream
        GET /labs/1/tweets/stream/compliance
        GET /labs/1/tweets/stream/covid19
        Filtered stream
        GET /2/tweets/search/stream
        GET /2/tweets/search/stream/rules
        POST /2/tweets/search/stream/rules
        Hide replies
        PUT /2/tweets/:id/hidden
        Likes
        DELETE /2/users/:id/likes/:tweet_id
        GET /2/tweets/:id/liking_users
        GET /2/users/:id/liked_tweets
        POST /2/users/:id/likes
        Manage Tweets
        DELETE /2/tweets/:id
        POST /2/tweets
        Quote Tweets
        GET /2/tweets/:id/quote_tweets
        Retweets
        DELETE /2/users/:id/retweets/:source_tweet_id
        GET /2/tweets/:id/retweeted_by
        POST /2/users/:id/retweets
        Search Tweets
        GET /2/tweets/search/all
        GET /2/tweets/search/recent
        Timelines
        GET /2/users/:id/mentions
        GET /2/users/:id/timelines/reverse_chronological
        GET /2/users/:id/tweets
        Tweet counts
        GET /2/tweets/counts/all
        GET /2/tweets/counts/recent
        Tweets lookup
        GET /2/tweets
        GET /2/tweets/:id
        Volume streams
        GET /2/tweets/sample/stream
    Users
        Blocks
        DELETE /2/users/:source_user_id/blocking/:target_user_id
        GET /2/users/:id/blocking
        POST /2/users/:id/blocking
        Follows
        DELETE /2/users/:source_user_id/following/:target_user_id
        GET /2/users/:id/followers
        GET /2/users/:id/following
        POST /2/users/:id/following
        Mutes
        DELETE /2/users/:source_user_id/muting/:target_user_id
        GET /2/users/:id/muting
        POST /2/users/:id/muting
        Users lookup
        GET /2/users
        GET /2/users/:id
        GET /2/users/by
        GET /2/users/by/username/:username
        GET /2/users/me
    Spaces
        Search Spaces
        GET /2/spaces/search
        Spaces lookup
        GET /2/spaces
        GET /2/spaces/:id
        GET /2/spaces/:id/buyers
        GET /2/spaces/:id/tweets
        GET /2/spaces/by/creator_ids
    Lists
        List Tweets lookup
        GET /2/lists/:id/tweets
        List follows
        DELETE /2/users/:id/followed_lists/:list_id
        GET /2/lists/:id/followers
        GET /2/users/:id/followed_lists
        POST /2/users/:id/followed_lists
        List lookup
        GET /2/lists/:id
        GET /2/users/:id/owned_lists
        List members
        DELETE /2/lists/:id/members/:user_id
        GET /2/lists/:id/members
        GET /2/users/:id/list_memberships
        POST /2/lists/:id/members
        Manage Lists
        DELETE /2/lists/:id
        PUT /2/lists/:id
        POST /2/lists
        Pinned Lists
        DELETE /2/users/:id/pinned_lists/:list_id
        GET /2/users/:id/pinned_lists
        POST /2/users/:id/pinned_lists
    Compliance
        Batch compliance
        GET /2/compliance/jobs
        GET /2/compliance/jobs/:id
        POST /2/compliance/jobs

2.2 Paypal: https://developer.paypal.com/api/rest/
Orders: https://developer.paypal.com/docs/api/orders/v2/

    Create order: POST /v2/checkout/orders
    Update order: PATCH /v2/checkout/orders/{id}
    Show order details: GET /v2/checkout/orders/{id}
    Authorize payment for order: POST /v2/checkout/orders/{id}/authorize
    Capture payment for order: POST /v2/checkout/orders/{id}/capture
    Confirm the Order: POST /v2/checkout/orders/{id}/confirm-payment-source

2.  Design a collection of APIS for a Blog Website, please specify GET POST PUT DELETE
    Basic use modules under the mock blog website: user, blogs, posts, and comments
    
    https://www.mockblog.com/api
    
    User:
        Create a user account: POST /v1/users
        Update user info: PUT /v1/users/{user_id}
        Delete an user account: DELETE /v1/users/{user_id}
    
    Blogs:
        
        Create a new blog: POST /v1/users/{user_id}/blogs
        Retrieve a list of blogs under sites accessable to the user: GET /v1/users/{user_id}/sites/{site_id}/blogs
        Retrive a specific blog: GET /v1/users/{user_id}/sites/{site_id}/blogs/{blog_id}
    
    Posts:
        Retrieve a list of posts under a blog: GET /v1/users/{user_id}/sites/{site_id}/blogs/{blog_id}/posts
        Retrive a specific blog: GET /v1/users/{user_id}/sites/{site_id}/blogs/{blog_id}/posts/{post_id}
        Add a post: POST /v1/users/{user_id}/sites/{site_id}/blogs/{blog_id}/posts
        Update a post: PATCH /v1/sites/users/{user_id}/{site_id}/blogs/{blog_id}/posts/{post_id}
        Delete a post: DELETE /v1/sites/users/{user_id}/{site_id}/blogs/{blog_id}/posts/{post_id}
    
    Comments:
        Retrieve a list of posts under a post: GET /v1/users/{user_id}/sites/{site_id}/blogs/{blog_id}/posts/{post_id}/comments
        Retrive a specific comments: GET /v1/users/{user_id}/sites/{site_id}/blogs/{blog_id}/posts/{post_id}/comments/{comment_id}
        Add a comment: POST /v1/users/{user_id}/sites/{site_id}/blogs/{blog_id}/posts/{post_id}/comments
        Update a post: PATCH /v1/users/{user_id}/sites/{site_id}/blogs/{blog_id}/posts/{post_id}/comments/{comment_id}
        Delete a post: DELETE /v1/users/{user_id}/sites/{site_id}/blogs/{blog_id}/posts/{post_id}/comments/{comment_id}
    

# HW7 # Template

1.  create a file to list all of the annotaitons you learned and known, and explain the 
usage and how do you understand it. you need to update it when you learn a new 
annotation. Please organize those annotations well, like annotations used by 
entity, annotations used by controller.
    a. File name: annotations.md
    b. you'd better also list a code example under the annotations.
    
    Please see the separate file Annotations.md under ShortQuestions
    
2.  Explain how the below annotaitons specify the table in database?
    @Column(columnDefinition = "varchar(255) default 'John Snow'") //The "name" column has a input limitation of 255 for characters, and its default value is John Snow.
    private String name;
      
    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false) //The "studentName" field will be mapped to a column named "STUDENT_NAME"; the length limitation of the input is 50, and it cannot be null and does not have to be unique. 
    private String studentName;

    
3.  What is the default column names of the table in database for  @Column?

    The field names.

    @Column
    private String firstName;
    @Column
    private String operatingSystem;

4.  What are the layers in springboot application? what is the role of each layer?
    
    Presentation layer: 
        The presentation layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business layer. In short, it consists of views i.e., frontend part.
    Business layer: 
        The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers. It also performs authorization and validation.
    Persistent layer: The persistence layer contains all the storage logic and translates business objects from and to database rows. (e.g., Data Access Object("DAO"))
    Database: 
        It is where the data is ultimately stored. In the database layer, CRUD (create, retrieve, update, delete) operations are performed.
        
        (reference link: https://www.javatpoint.com/spring-boot-architecture)

5.  Describe the flow in all of the layers if an API is called by Postman.

        When an API is called by Postman, it will first reach the controller(i.e., presenrtation layer), and based on the request type and parameter(s), the controller will direct it to the correct method (for further process) defined under the service layer (i.e., business layer), which will then call the methods provided by the persistent layer (i.e., DAO) to properly perform the respective CRUD operation to the database. Once done, based on the status, the service layer will also return a request response back to the controller and ultimtately to the client.


6.  What is the application.properties? do you know application.yml?

    Spring Boot Framework comes with a built-in mechanism for application configuration using a file called application. properties. It is located inside the src/main/resources folder. Properties files are used to keep ‘N’ number of properties in a single file to run the application in a different environment. In Spring Boot, properties are kept in the application.properties file under the classpath.
    
    YAML is a configuration language and is heavily used for configuring the various properties while developing the applications. Spring Boot supports YAML based properties configurations to run the application. Instead of application.properties, we can use application.yml file. This YAML file also should be kept inside the classpath.
    
    One advantage that you may see out of using the YAML(.yml) file is if you are using more than one application that read the same configuration file. you may see better support in other languages for YAML(.yml) as opposed to .properties.

7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;
    a. https://www.mongodb.com/compatibility/spring-boot
    
    Done - saved under project "mongo-blog".
    
8.  In your redbook application, write the code for RUD APIs. 

    Done - saved under folder "redbook2-mysql-blog".
    
    a. https://github.com/TAIsRich/springboot-redbook.git
    i.  Branch: 02_post_RUD
    b. you need to call the new APIs in your postman.
    @Column(columnDefinition = "varchar(255) default 
    'John Snow'")
    private String name;
      
    @Column(name="STUDENT_NAME", length=50, 
    nullable=false, unique=false)
    private String studentName;

    c.  You need to type it line by line and try your best to understand it. DO 
    NOT COPY PASTE
    

# HW8 # Template
（HW41)

1.  List all of the new annotations to your annotaitons.md and explain its role.
    Updated in Annotation file.
    
2.  how do you do the debug?
    If encounter issue when starting the application, we will need to check the logs in the console for the error information, and we will need to pay attention to some lines highlighted in blue that indicate the specific lines that caused the failure.
    For a more general debugging operation, we can add break points to our code to further examine line by line.
     
3.  What is DTO, VO, Payload, DO?
    
    A data transfer object (DTO) is an object that carries data between processes. 
    A Value Object or VO is an object such as java.lang.Integer that hold values (hence value objects). A VO should always override the equals() and hashCode() methods. VOs generally encapsulate small objects such as numbers, dates, strings, and more. They follow the value semantics, i.e., they directly change the object's value and pass copies around instead of references. It's a good practice to make Value Objects immutable. 
    In computer networking, data to be transmitted is the payload. 
    Java Data Objects (JDO) is a specification of Java object persistence. Java Data Objects (JDO) is an application program interface (API) that enables a Java programmer to access a database implicitly - that is, without having to make explicit Structured Query Language (SQL) statements.
    
4.  What is @JsonProperty("description_yyds")?
    The content of the field with this annotion will be mapped from the "description_yyds" field passed by the JSON.

5.  Do you know what is jackson?
    Jackson is a very popular and efficient java based library to serialize or map java objects to JSON and vice versa. It is one such Java Json library used for parsing and generating Json files. It has built in Object Mapper class which parses json files and deserializes it to custom java objects. It helps in generating json from java objects.

6.  What is spring-boot-starter?
    
    Spring Boot Starters are dependency descriptors that can be added under the <dependencies> section in pom. xml. There are around 50+ Spring Boot Starters for different Spring and related technologies. These starters give all the dependencies under a single name. Spring Boot starters can help to reduce the number of manually added dependencies just by adding one dependency. So instead of manually specifying the dependencies just add one starter.
    
    In the Spring Boot Framework, all the starters follow a similar naming pattern: spring-boot-starter-*, where * denotes a particular type of application. For example, if we want to use Spring and JPA for database access, we need to include the spring-boot-starter-data-jpa dependency in our pom.xml file of the project.

    a. what dependecies in the below starter? do you know any starters?
    
        <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        The single spring-boot-starter-web dependency can pull in all dependencies related to web development. 
        
        Some other common startes we use for web application development are as folows:
            spring-boot-starter-test
            spring-boot-starter-data-jpa
            spring-boot-starter-data-redis
            spring-boot-starter-web-services
            spring-boot-starter-data-elasticsearch
            spring-boot-starter-websocket

7. Do you know  @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

    The @PathMapping annotation is the specialized version of the @RequestMapping annotation which acts as a shortcut for @RequestMapping(method=RequestMethod=POST).
    
    CRUD of this style:
        @PostMapping
        @PutMapping
        @DeleteMapping
        @GetMapping

8.  What is ResponseEntity? why do we need it?

        new ResponseEntity<>(postResponse, HttpStatus.OK);
        new ResponseEntity<>(postResponse, HttpStatus.CREATED);
        ResponseEntity.ok(postService.getPostById(id));
        
    ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response. If we want to use it, we have to return it from the endpoint; Spring takes care of the rest. ResponseEntity is a generic type.
      
    ResponseEntity<> is a generic class with a type parameter, you can specify what type of object to be serialized into the response body. @ResponseBody is an annotation, indicates that the return value of a method will be serialized into the body of the HTTP response.  
        

9.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC

    A ResultSet object is a table of data representing a database result set, which is usually generated by executing a statement that queries the database. For example, the CoffeeTables. viewTable method creates a ResultSet , rs , when it executes the query through the Statement object, stmt .
    (TODO)

10. What is the ORM framework?
    Object Relational Mapping (ORM) is a technique (Design Pattern) of accessing a relational database from an object-oriented language. Basically, the ORM framework/software generates objects (as in OOP) that virtually map (like the map of a city) the tables in a database. Then we as a programmer, would use these objects to interact with the database. So the main idea, is to try and shield the programmer from having to write optimized SQL code – the ORM generated objects take care of that for us.

11. Learn how to use ObjectMapper by this example.
    a. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java
    
    FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
    String s = objectMapper.writeValueAsString(foodOutlet);
    objectMapper.readTree() // learn how to use it?
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.13.3</version>
      <scope>compile</scope>
    </dependency>


12. What is the serialization and desrialization?
    a. https://hazelcast.com/glossary/serialization/
    
    Serialization and deserialization work together to transform/recreate data objects to/from a portable format.
    
    Serialization is the process of converting a data object—a combination of code and data represented within a region of data storage—into a series of bytes that saves the state of the object in an easily transmittable form. In this serialized form, the data can be delivered to another data store (such as an in-memory computing platform), application, or some other destination.
    
    The reverse process—constructing a data structure or object from a series of bytes—is deserialization. The deserialization process recreates the object, thus making the data easier to read and modify as a native structure in a programming language.
    
13. Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
    
    public class Test{
        
        public static void main(String[] args){
        
            Integer[] array = new Integer[]{20, 3, 78, 9, 6, 53, 73, 99, 24, 32}; //error reported if we use int[] instead of Integer[]
            List<Integer> list = Arrays.asList(array);
            double res = list
                .stream()
                .mapToDouble(Integer::intValue)
                .average()
                .getAsDouble();
            
            System.out.println(res);
        
        }
    }

14. 抄写，https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable，你也可以像我一样分branch添加新代码。

    Added to redbook2 project.

15. (Optional) 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comment你也可以像我一样分branch添加新代码。

16. (Optional) Try to write the CRUD api for a new application Cassandra-Blog
    a. spring 提供了相关dependency,(https://start.spring.io/)
    i.  Spring Data for Apache Cassandra
    b. Cassandra十分流行，且面试问的多。
    
    
# HW9 # Template

1.  List all of the annotations you learned from class and homework to annotaitons.md
    Updated in Annotation file.
    
2.  Type the Comment feature for the class project.
    Alreadt committed in HW8.
    
3.  In postman, call of the APIs in PostController and CommentController.
    Successfully done.

4.  What is JPA? and what is Hibernate?
    JPA is a standard of Object Relational Mapping. It is an interface that defines a set of annotations for creating the object relational mapping.JPA use JDBC to CRUD database, and also transfer result from database to Java Entities. 

    The most popular ORM framework is Hibernate.
    
5.  What is Hiraki? what is the benefits of connection pool?
    Hikari connection pool("CP") is a reliable, high-performance JDBC connection pool. It is much faster, lightweight and have better performance as compare to other connection pool API. Because of all these compelling reasons, HikariCP is now the default pool implementation in Spring Boot 2.
    
    Using the connection pool can have the following benefits: 1)reduces the number of times new connection objects are created; 2)promotes connection object reuse; 3)quickens the process of getting a connection; and 4)reduces the amount of effort required to manually manage connection objects.
    
6.  What is the  @OneToMany, @ManyToOne, @ManyToMany? write some examples.
    To establish a dependency between related entities, JPA provides javax. persistence. CascadeType enumerated types that define the cascade operations. These cascading operations can be defined with any type of mapping i.e. One-to-One, One-to-Many, Many-to-One, Many-to-Many.

    1:1
    e.g., Player(1):PlayerProfile(1)//PlayerProfile will be a field under Player class
    @OneToOne(cascade = CascadeType.All)
    @JoinColumn(name = "profile_id", referenceColumnName = "id")
    private PlayerProfile playerProfile;

    1:M, M:1
    e.g., Post (1): Comments(M)
        In 1(Post) class, we define a collectiom to store M(comments).
        @OneToMany(mappedBy = "post", cascade = CascadeType.All, orphanRemoval = true)
        private Set<Comment> comment = new HashSet<>();
        
        In M, it has 1's class, however, in database, it is a foreign key, and Jpa will do it for us.
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "post_id", nullable = false)
        private Post post;
    
    M:N
    For a pair of M:N relational tables, there will be a joint table.
    e.g., pms_inventory(M) : pms_SKU(i.e., stock keeping unit*)(N)
    
    @ManyToMany(fetch = FetechType.LAZY)
    @JoinTable(name = "sku_inventory", 
                joinColumns = @JoinColumn(name = "sku_id"), 
                inverseJoinColumns = @JoinColumn(name = "inventory_id"))
    private Set<PmsInventory> pmsInventories = new HashSet<>();
    
    *SKU stands for "stock keeping unit" and is a number that retailers use to differentiate products and track inventory levels. An SKU is typically eight alphanumeric digits long. Products are assigned different SKU numbers based on various characteristics, such as price, manufacturer, color, style, type, and size.

7. What is the  cascade = CascadeType.ALL, orphanRemoval = true? 
and what are the other CascadeType and their features? 
In which situation we choose which one?

    The meaning of CascadeType. ALL is that the persistence will propagate (cascade) all EntityManager operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH) to the relating entities. 
    When we remove the relationship between a parent and child, the child record becomes an orphan record meaning that it does not have a parent record. OrphanRemoval attribute marks "child" entity to be removed when it's no longer referenced from the "parent" entity, e.g. when you remove the child entity from the corresponding collection of the parent entity.
    
    CascadeTypes:
        PERSIST: (Owning entity saved => realted entity saved) The persist operation makes a transient instance persistent. Cascade Type PERSIST propagates the persist operation from a parent to a child entity. 
        MERGE: (Owning entity merged => realted entity merged)The merge operation copies the state of the given object onto the persistent object with the same identifier. CascadeType.MERGE propagates the merge operation from a parent to a child entity.
        REMOVE: (Owning entity removed => realted entity removed)Remove operation removes the row corresponding to the entity from the database and also from the persistent context. CascadeType.REMOVE propagates the remove operation from parent to child entity. Similar to JPA's CascadeType.REMOVE, we have CascadeType.DELETE, which is specific to Hibernate. There is no difference between the two.
        REFRESH: (Owning entity refreshed => realted entity refreshed)Refresh operations reread the value of a given instance from the database. In some cases, we may change an instance after persisting in the database, but later we need to undo those changes. In that kind of scenario, this may be useful. When we use this operation with Cascade Type REFRESH, the child entity also gets reloaded from the database whenever the parent entity is refreshed.
        DETACH: (Owning entity manually detached => realted entity detached)The detach operation removes the entity from the persistent context. When we use CascadeType.DETACH, the child entity will also get removed from the persistent context.
        
8.  What is the  fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

    Lazy fetch and eager fetch are two ways in which data is loading. Eager fetch means that when a record is fetched from the database, all the associated records from related tables are also fetched. So if we fetch a tournament record, all the registrations for the tournament are also fetched. Eager fetch is the default fetch type used by Hibernate but it is not always the most efficient. Lazy fetch on the other hand, fetches the records only when they are needed.
    
    For our post and comment collections, if we don't need data from comment, under the lazy loading, JPA only fecth data from post and doesn't fecth data from comments; under the eager loading, JPA will also fetch comment at the same time when we fetch the post.

9.  What is the rule of JPA naming convention? 
Shall we implement the method by ourselves? 
Could you list some examples?

    JPA can help us implement methods based on the column names in a table, on the premise that we will need to follow the JPA naming convension when we create the method names.
    
    The first parameter will be mapped to the first column name in the method name, and the second one will be mapped to the second column name in the method name. e.g., for method name “findByLastnameOrFirstname(a, b)", the table need to have column "Lastname" and "Firstname", and then parameter a will be mapped to the Lastname column and b will be mapped to Firstname column to locate the search target. 

10. Add 2 more api  /api/v1/posts/search?keyword=value in your class project. 
In the repository layer, you need to use the naming convention to use the method provided by JPA.

    Updated.

11. Check out a new branch(hw1_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.
    

12. watch those videos(看一遍，能理解多少是多少。千万千万不要看其它的视频，会走火入魔晕乎乎的)
    a. Spring 简介： https://www.youtube.com/watch?v=l0MqsOADAUE&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=64
    b. IOC/DI: https://www.youtube.com/watch?v=PyMxNr2p0C0&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=65
    c. IOC container: https://www.youtube.com/watch?v=pLa77Tw-yyI&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=66
    d.  Bean:
        i.   https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=67

        ii. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=68
        iii.  https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=69
    e.  DI: 
        i.  https://www.youtube.com/watch?v=MgTpBST9onM&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=70
        ii. https://www.youtube.com/watch?v=yhEWZx2i1BA&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=71
    
13. (Optional) use JDBC to read the data from database.




