1. remember pull the new code from that repo

2. Explain volatile variables in java? (we also use it in Singleton)

   The Java volatile keyword is used to mark a Java variable as "being stored in main memory". More precisely that means, that every read of a volatile variable will be read from the computer's main memory, and not from the CPU cache, and that every write to a volatile variable will be written to main memory, and not just to the CPU cache.

3. how to create a new thread(Please also consider Thread Pool case)? 

   - Extends Thread Class
   - Implements Runnable
   - Implements Callable
   - Executors.newFixedThreadPool
   - Lambda function

4. Difference between Runnable and Callable

   runnable has no return; callable has return;

5. what is the diff between t.start() and t.run()? 

   t.start starts a new thread to excute the task（run()） 

   t.run() excute the task in the current thread.

6. Which way of creating threads is better: Thread class or Runnable interface? 

   Runnable, because you can have multiple inheritance.

7. what is the thread status? 

   1. New
   2. Runnable
   3. Blocked
   4. Waiting
   5. Timed Waiting
   6. Terminated

8. difference between wait() and sleep() method

   The major difference is that **wait() releases the lock while sleep() doesn't release any lock while waiting**. wait() is used for inter-thread communication while sleep() is used to introduce a pause on execution, generally.

9. What is deadlock? 

   Deadlock in Java is **a condition where two or more threads are blocked forever, waiting for each other**. This usually happens when multiple threads need the same locks but obtain them in different orders. 

10. how do threads communicate with each other? 

    There are three ways for threads to communicate with each other. The first is through commonly shared data. All the threads in the same program share the same memory space. If an object is accessible to various threads then these threads share access to that object's data member and thus communicate each other.

    The second way for threads to communicate is by using thread control methods. There are such three methods by which threads communicate for each other :

    **suspend ( )**: A thread can suspend itself and wait till other thread resume it.
    **resume ( )**: A thread can wake up other waiting thread (which is waiting using suspend() ) through its resume() method and then can run concurrently.
    **join ( )** :This method can be used for the caller thread to wait for the completion of called thread.

    The third way for threads to communicate is the use of three methods; **wait(), notify(), and notifyAll();**

11. what is join() method? 

    This method can be used for the caller thread to wait for the completion of called thread.

12. what is yield() method

    yield() provides a mechanism to inform the “scheduler” that the current thread is willing to relinquish its current use of processor but it'd like to be scheduled back soon as possible.

13. Explain thread pool

    a thread pool is **a software design pattern for achieving concurrency of execution in a computer program**. Often also called a replicated workers or worker-crew model, a thread pool maintains multiple threads waiting for tasks to be allocated for concurrent execution by the supervising program.

14. What is Executor Framework in Java, its different types and how to create these executors? 

    FixedThreadPool：线程数固定的线程池； CachedThreadPool：线程数根据任务动态调整的线程池； SingleThreadExecutor：仅单线程执⾏的线程池。

15.  Difference between shutdown() and shutdownNow() methods of executor

    shutdown wait for threads to end before exiting while shutdownNow doesn't wait.

16. What is Atomic classes? when do we use it? 

    原⼦操作实现了⽆锁的线程安全； 适⽤于计数器，累加器等。

17. What is the concurrent collections? 

    针对各种集合，我们⽇常接触的都是non-thread-safe的集合。 Java提供了对应的thread-safe的集合，⽅便我们直接使⽤。

    常见的有CopyOnWriteArrayList, ConcurrentHashMap, CopyOnWriteArraySet

18. what kind of locks you know? 

    ReentrantLock, ReadWriteLock, StampedLock

19. What is the difference between class lock and object lock? 

    Object Level Locks − It can be used when you want non-static method or non-static block of the code should be accessed by only one thread. Class Level locks − It can be used when we want to prevent multiple threads to enter the synchronized block in any of all available instances on runtime.

20. What is future and completableFuture? 

    ExecutorService.submit()⽅法，可以看到，它返回了⼀个Future类型，⼀ 个Future类型的实例代表⼀个未来能获取结果的对象. 从Java 8开始引⼊了CompletableFuture，它针对Future做了改进，可以传⼊回调对象， 当异步任务完成或者发⽣异常时，⾃动调⽤回调对象的回调⽅法。

21. what is ThreadLocal? 

    顾名思义它是local variable（线程局部变量）。它的功⽤⾮常简单，就是为每⼀个使⽤该变量的线程都提供⼀个变量值的副本，是每⼀个线程都可以独⽴地改变⾃⼰的副本，⽽不会和其它线程的副本冲突。从线程的⾓度看，就好像每⼀个线程都完全拥有该变量。

22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. 

    Plz check ./multithreading/src/main/java/wait_notify/

24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random.
25. 