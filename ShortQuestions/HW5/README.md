# Homework 5

1. remeber pull the new code from that repo

2. Explain volatile variables in java? (we also use it in Singleton)

   - Volatile is a keyword in java, that can be applied only to variables. You cannot apply volatile keyword to classes and methods. Applying volatile to a shared variable that is accessed in a multi-threaded environment ensures that threads will read this variable from the main memory instead of their own local cache.

3. how to create a new thread(Please also consider Thread Pool case)?

   - Extends Thread Class
   - Implement Runnable
   - Implement Callable

4. Difference between Runnable and Callable

   	- runnable has no return
   	- Callable has return

5. what is the diff between t.start() and t.run()?

   	- t.start() start a new thread to excite the task (run())
   	- t.run() excute the task in the current thread

6. Which way of creating threads is better: Thread class or Runnable interface?

    - implementing runnable is always the preferred choice, see the resons below:
      	- As you know, Java does not allow multiple inheritance through classes. so if you are creating  threads by extending thread class then you will not be able to extend any other class.
      	- When we are working wtih multi-threading, we are not looking to overwrite any existing functionality of thread class, we just want to excuse the code with multiple threads, so in that way also, Runnable is a good choice.
      	- One more reason to choose runnable is that, most people don't work with just Raw Threads, they use the Executor framework that is provided from java 5, that separates the task from its execution and we can execute runnable using execute(runnable task) method of Executor interface.

7. what is the thread status?

   - **NEW ** a newly created thread that has not yet started the execution
   - **RUNNABLE ** either running or ready for execution but it's waiting for resource allocation
   - **BLOCKED ** waiting to acquire a monitor lock to enter or re-enter a synchronized block/method
   - **WAITING ** waiting for some other thread to perform a particular action without any time limit
   - **TIMED_WAITING ** waiting for some other thread to perform a specific action for a specified period
   - **TERMINATED ** has completed its execution

8. difference between wait() and sleep() method

   	- wait() method can only be called from a synchronized context while sleep() method can be called without synchronized context.
   	- Wait() method releases the lock ont he object while waiting but sleep() method does not release the lock it holds while waiting, it means if the thread is currently in a synchronized block/method then no other thread can enter this block/method.
   	- Wait() method is used for inter-thread communication while sleep() method is used to introduce a pause on execution.
   	- Waiting thread can be waked by calling notify() of notifyAll(), while sleeping thread will wake up when the specified sleep time is over or the sleeping thread gets interrupted.
   	- Wait() method is not-static, it gets called on an object on which synchronization block is locked while sleep() is a static method, we call this method like thread.sleep(), that means it always affects the currently executing thread.
   	- Wait() id normally called when a condition is fulfilled like if the buffer size of queue is full then producer thread will wait, whereas sleep() method can be called without a condition.

9. What is deadlock?

   	- eadlock in Java is **a condition where two or more threads are blocked forever, waiting for each other**. This usually happens when multiple threads need the same locks but obtain them in different orders. Multithreaded Programming in Java suffers from the deadlock situation because of the synchronized keyword.

10. how do threads communicate with each other?

    - **wait():** It tells the calling thread to give up the lock and go to sleep until some other thread enters the same monitor and calls notify().
    - **notify():** It wakes up one single thread called wait() on the same object. It should be noted that calling notify() does not give up a lock on a resource.
    - **notifyAll():** It wakes up all the threads called wait() on the same object.

11. what is join() method?

    - Join() method causes the current thread to pause exexution until the thread which has called join() method is dead.
    - Join() method can be used to execute the threads sequentially or in the some specific order.

12. what is yield() method

    	- yield() method pauses the currently extcuting thread themporarily for giving a chance to remaining waitting threads of the same priority to execute. if there is no waiting thread or all the waiting threads have a lower priority then the same thread will continue its execution.
    	- When the yielded thread will get the chance ofr execution is decided by the thread scheduler whose behavior is vendor dependent. yield method doesn't guarantee that the current thread will pause or stop but it guarantees that cpu will be relinquished by current thread as result of a call to thread.yield() method in java.

13. Explain thread pool

     -  **A thread pool reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing.** Since the thread is already existing when the request arrives, the delay introduced by thread creation is eliminated, making the application more responsive.
        - Java provides the Executor framework which is centered around the Executor interface, its sub-interface –**ExecutorService** and the class-**ThreadPoolExecutor**, which implements both of these interfaces. By using the executor, one only has to implement the Runnable objects and send them to the executor to execute.
        - They allow you to take advantage of threading, but focus on the tasks that you want the thread to perform, instead of thread mechanics.
        - To use thread pools, we first create a object of ExecutorService and pass a set of tasks to it. ThreadPoolExecutor class allows to set the core and maximum pool size.The runnables that are run by a particular thread are executed sequentially.

14. What is Executor Framework in Java, its different types and how to create these 
    executors?

    - Executor Framework is an abstraction to managing multiple threads by yourself. So, it decouples the execution of a task and the actual task itself. Now, we just have to focus on the task that means, only implement the Runnables and submit them to executor. Then these runnables will be managed by the executor framework.
    - Executors is a factory that provides the methods to return ExecutorService, ScheduledExecutorService, ThreadFactory. Find some method details.
      - **newFixedThreadPool()**: It returns the pool with fixed number of size. We need to pass the number of threads to this method. If concurrently task are submitted more than the pool size, then rest of task need to wait in queue. It returns ExecutorService.
      - **newScheduledThreadPool**: This also creates a fixed size pool but it can schedule the thread to run after some defined delay. It is useful to schedule the task. It returns ScheduledExecutorService.
      - **newCachedThreadPool()**: There is no fixed size of this pool. Thread will be created at run time and if there is no task it will alive for 60 second and then die. For short lived threads this pool works good. It returns ExecutorService.

15. Difference between shutdown() and shutdownNow() methods of executor

    - shutdown() and shutdownNow() methods belongs to ExecutorService. shutdown() method tries to stop the threads and do not accept new task to execute but it completes the execution which has been submitted. shutdownNow() methods also tries to stop the running threads and will not execute any task which has been submitted but not started.

16. What is Atomic classes? when do we use it?

    - Atomic in Java is a very important concept in a [multithreading](https://www.tutorialcup.com/java/multithreading-java.htm) environment. It is one of the concurrent utilities that ensure multiple threads use the shared resources effectively without leading to any issues. This is because these shared resources can change their values during execution in a multithreaded environment. We can implement atomicity in classes, operations, and variables.
    - The atomic classes are present in the `java.util.concurrent.atomic` package. It provides lock-free and thread-safe implementation on a shared variable. It also supports atomic operations. The atomic classes have `get()` and `set()` methods that are used to read and write the volatile variables.

17. What is the cocurrent collections?

    - Concurrent collections in Java are designed with the goal of allowing many threads to access the same data in a synchronized manner.
    - If you’re familiar with Java Collections you’re probably aware that most Collection classes aren’t thread-safe by default. Take, for example, Java’s ArrayList, LinkedList, HashMap  classes. We must manually make the collection thread-safe if we want it to be thread-safe.

18. what kind of locks you know? 

    	- ReentrantLock
    	- ReadWriteLock
    	- StampedLock

19. What is the difference between class lock and object lock?

    	- Object Level Lock is a mechanism where every object in java has a unique lock which is nothing but an object**–**level lock. If a thread wants to execute a synchronized method on the given object then the thread first required the object level lock once the thread gets object level lock then it is allowed to execute any synchronized method on the given object and once the method execution completed automatically thread releases the lock of that object.
    	- Class Level Lock is a mechanism where every class in java has a unique lock which is nothing but a class level lock. If a thread wants to execute a static synchronized method then the thread requires a class level lock once the thread gets a class level lock then it is allowed to execute any static synchronized method of that class. Once method execution completes automatically thread releases the lock. While a thread executing a static synchronized method the remaining thread is not allowed to execute any static synchronized method of that class simultaneously.

20. What is future and completableFuture?

    - A CompletableFuture is **an extension to Java's Future API which was introduced in Java 8**. A Future is used for asynchronous Programming. It provides two methods, isDone() and get(). The methods retrieve the result of the computation when it completes.

21. what is ThreadLocal?

    	- The ThreadLocal class is **used to create thread local variables which can only be read and written by the same thread**. For example, if two threads are accessing code having reference to same threadLocal variable then each thread will not see any modification to threadLocal variable done by other thread.

22. Type the code by your self and try to understand it. (package 
    com.chuwa.tutorial.t08_multithreading)

23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 
    2,4,6,8,10. (solution is in 
    com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)

    ​	a. One solution use synchronized and wait notify 

​		   b. One solution use ReentrantLock and await, signal

24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread 
    output 21-22. threads run sequence is random. (solution is in 
    com.chuwa.exercise.t08_multithreading.PrintNumber1)