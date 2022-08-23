HW23
1. Read those codes and type it one by one by yourself. the push the code to your branch. 
	1. https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8
2.  practice stream API at least 3 times
	a. https://blog.devgenius.io/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82
3.  Write the Singleton design pattern include eager load and lazy load. 
4.  What is Runtime Exception? could you give me some examples?
	1. Runtime Exception is uncheck exception that occur at run time, can't caught by compilers
	2. Example: Null Pointer Exceptions, Arithmetic Exception
5.  Could you give me one example of NullPointerException?
	1. String str = null;
	2. System.out.println(str);
6.  What is the Optional class?
	1. Optional class creates a optional objects of a type
	2. Can avoid null checks and run time nullPointerExceptions
7. What is the @FunctionalInterface?
	1. functional interface can have only one abstruct method
	2. can have lot of default methods
	3. Lambda is the implementation of the abstract method
8.  what is lamda?
	1. lambda is a short block of code that has parameter and expressions
9.  What is Method Reference?
	1. A way to simpify the lambda expressioon 
	2. Arrays.sort(stringsArray, String::compareToIgnoreCase);
10. What is Java 8 new features?
	1. StreamApi
	2. Functional Interface
	3. Lambda
	4. Optional
11. Lambda can use unchanged variable outside of lambda? what is the details?
	1. Yes, Lambda can use unchanged variable outside of lambda
	2. Final variables and non static variables that has no changed after it created can be use

HW24
    
1. remeber pull the new code from that repo
2. Explain volatile variables in java? (we also use it in Singleton)
    * Using volatile is yet another way (like synchronized, atomic wrapper) of making class thread-safe. Thread-safe means that a method or class instance can be used by multiple threads at the same time without any problem.
3. how to create a new thread(Please also consider Thread Pool case)?
    * Implementing the `java.lang.Runnable` interface.
    * Extending the `java.lang.Thread` class.
4. Difference between Runnable and Callable
    * `Callable` can return the result of the parallel processing of a task, but `Runnable` can't.
    * `Callable` can throw a checked Exception, but `Runnable` can't.
5. what is the diff between t.start() and t.run()?
    * Difference between the start() and run() method in Thread is that start creates a new thread while the run doesn't create any thread and simply executes in the current thread like a normal method call.
6. Which way of creating threads is better: Thread class or Runnable interface?
    * In the first approach, Our class always extends Thread class. There is no chance of extending any other class. Hence we are missing Inheritance benefits. In the second approach, while implementing Runnable interface we can extends any other class. Hence we are able to use the benefits of Inheritance.
7. what is the thread status?
    * New 
    * Runnable 
    * Blocked 
    * Waiting 
    * Timed-waiting 
    * Terminated 
8. difference between wait() and sleep() method
    * The major difference is that wait() releases the lock while sleep() doesn't release any lock while waiting. wait() is used for inter-thread communication while sleep() is used to introduce a pause on execution, generally.
9. What is deadlock?
    * Deadlock is a situation where a set of processes are blocked because each process is holding a resource and waiting for another resource acquired by some other process.
10. how do threads communicate with each other?
    * All the threads in the same program share the same memory space. If an object is accessible to various threads then these threads share access to that object's data member and thus communicate each other. The second way for threads to communicate is by using thread control methods.
11. what is join() method?
    * Join method in Java allows one thread to wait until another thread completes its execution. In simpler words, it means it waits for the other thread to die. It has a void type and throws InterruptedException.
12. what is yield() method
    * A yield() method is a static method of Thread class and it can stop the currently executing thread and will give a chance to other waiting threads of the same priority. If in case there are no waiting threads or if all the waiting threads have low priority then the same thread will continue its execution.
13. Explain thread pool
    * A thread pool reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing. Since the thread is already existing when the request arrives, the delay introduced by thread creation is eliminated, making the application more responsive.
14. What is Executor Framework in Java, its different types and how to create these executors?
    * With the increase in the number of cores available in the processors nowadays, coupled with the ever-increasing need to achieve more throughput, multi-threading APIs are getting quite popular. Java provides its own multi-threading framework called the Java Executor Framework.
    1. A single thread pool can be obtained by calling the static `newSingleThreadExecutor()` method of the Executors class. It is used to execute tasks sequentially. `ExecutorService executor = Executors.newSingleThreadExecutor();`
    2. `FixedThreadPool(n)` As the name indicates, it is a thread pool of a fixed number of threads. The tasks submitted to the executor are executed by the n threads and if there is more task they are stored on a `LinkedBlockingQueue`. It uses Blocking Queue. `ExecutorService fixedPool = Executors.newFixedThreadPool(2);`
    3. `CachedThreadPool` Creates a thread pool that creates new threads as needed, but will reuse previously constructed threads when they are available. Calls to execute will reuse previously constructed threads if available. If no existing thread is available, a new thread will be created and added to the pool. It uses a `SynchronousQueue` queue. `ExecutorService executorService = Executors.newCachedThreadPool();`
    4. Scheduled executors are based on the interface `ScheduledExecutorService` which extends the `ExecutorService` interface. 
    This executor is used when we have a task that needs to be run at regular intervals or if we wish to delay a certain task.`ScheduledExecutorService scheduledExecService = Executors.newScheduledThreadPool(1);`
    
15. Difference between shutdown() and shutdownNow() methods of executor
    * shutdown() will just tell the executor service that it can't accept new tasks, but the already submitted tasks continue to run. shutdownNow() will do the same And will try to cancel the already submitted tasks by interrupting the relevant threads.
16. What is Atomic classes? when do we use it?
    * The atomic classes provide a lock-free and thread-safe environment or programming on a single variable. It also supports atomic operations. All the atomic classes have the get() and set() methods that work on the volatile variable. The method works the same as read and writes on volatile variables.
17. What is the concurrent collections?
    * The concurrent collection APIs, apart from the Java Collection API, are a set of collections APIs that are designed and optimized specifically for synchronized multithreaded access.
18. what kind of locks you know?
    1. ReentrantLock
    2. ReadWriteLock
    3. StampedLock
    4. Synchronized
19. What is the difference between class lock and object lock?
    * Every class in Java has a unique lock which is nothing but a class level lock. If a thread wants to execute a static synchronized method, then the thread requires a class level lock. Once a thread got the class level lock, then it is allowed to execute any static synchronized method of that class. Once method execution completes automatically thread releases the lock.
    * Every object in java has a unique lock. Whenever we are using a synchronized keyword, then only the lock concept will come into the picture. If a thread wants to execute then synchronized method on the given object. First, it has to get a lock-in that object. Once the thread got the lock then it is allowed to execute any synchronized method on that object. Once method execution completes automatically thread releases the lock. Acquiring and release lock internally is taken care of by JVM and the programmer is not responsible for these activities.
20. What is future and completableFuture?
    * In Java, Future is an interface that belongs to java. util. concurrent package. It is used to represent the result of an asynchronous computation. The interface provides the methods to check if the computation is completed or not, to wait for its completion, and to retrieve the result of the computation.
    * CompletableFuture is used for asynchronous programming in Java. Asynchronous programming is a means of writing non-blocking code by running a task on a separate thread than the main application thread and notifying the main thread about its progress, completion or failure.This way, your main thread does not block/wait for the completion of the task and it can execute other tasks in parallel.
21. what is ThreadLocal?
    * The Java ThreadLocal class enables you to create variables that can only be read and written by the same thread. Thus, even if two threads are executing the same code, and the code has a reference to the same ThreadLocal variable, the two threads cannot see each other's ThreadLocal variables.
22. Type the code by your self and try to understand it. (package
    com.chuwa.tutorial.t08_multithreading)
23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print
    2,4,6,8,10.
24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread
    output 21-22. threads run sequence is random.