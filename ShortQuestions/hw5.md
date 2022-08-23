1.  remeber pull the new code from that repo
2.  Explain volatile variables in java? (we also use it in Singleton)
    The volatile keyword will cause the modified value of the variable to be updated to the main program immediately.

3.  how to create a new thread(Please also consider Thread Pool case)?
    1. Extends Thread Class
    2. Implements Runnable
    3. Implements Callable
    4. Thread Pool

4.  Difference between Runnable and Callable
    Callable interface returns the result, Runnable interface does not.

5.  what is the diff between t.start() and t.run()?
    t.start() creates a new thread, t.run() just run the code in the current thread like a normal method call.

6.  Which way of creating threads is better: Thread class or Runnable interface?


7. what is the thread status?
    NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING,TERMINATED

8.  difference between wait() and sleep() method
    wait() need notify() to wake the thead, sleep() is not.
    wait() and notify() must be in synchronized block, sleep() is not.

9.  What is deadlock?
    t0 occupies resource A and applies for resource B for execution; at the same time, t1 occupies resource B and applies for resource A to execute. At this time, t0 and t1 are in deadlock.

10. how do threads communicate with each other?
    wait(), notifu(), join()

11. what is join() method?
    join() allows one thread to wait until another thread completes its execution. 

12. what is yield() method
    A yield() method is a static method of Thread class and it can stop the currently executing thread and will give a chance to other waiting threads of the same priority.

13. Explain thread pool
    The thread pool is to create several threads in advance. If there are tasks to be processed, the threads in the thread pool will process the tasks. After processing, the threads will not be destroyed, but will wait for the next task. Since creating and destroying threads consumes system resources, you can consider using thread pools to improve system performance when you want to create and destroy threads frequently.

14. What is Executor Framework in Java, its different types and how to create these 
executors?
    A framework having a bunch of components that are used for managing worker threads efficiently is referred to as Executor Framework. The Executor API reduces the execution of the task from the actual task to be executed through the Executors.
    1. SingleThreadExecutor is a special type of executor that has only a single thread.
    2. FixedThreadPool is an executor that is a thread pool having a fixed number of threads.
    3. CachedThreadPool is a thread pool that is used to execute short-lived parallel tasks. 
    4. ScheduledExecutor is an executor which we use to run a certain task at regular intervals.

15. Difference between shutdown() and shutdownNow() methods of executor
    1. shutDown()
         When the thread pool calls this method, the state of the thread pool immediately changes to the SHUTDOWN state. At this point, you cannot add any more tasks to the thread pool, otherwise a RejectedExecutionException will be thrown. However, at this time, the thread pool will not exit immediately, and the tasks that are being executed will continue to be executed, and those that are not executed will be interrupted. It will not exit until the tasks added to the thread pool have been processed.
    2. shutdownNow()
        When this method is executed, the state of the thread pool immediately changes to the STOP state, and attempts to stop all executing threads, no longer process tasks still waiting in the pool queue, and return tasks that have not been executed.

16. What is Atomic classes? when do we use it?
    Atomic operations achieve lock-free thread safety. We usually use it in counter and accumulator scenarios.

17. What is the cocurrent collections?
    cocurrent collections are thread-safe collections

18. what kind of locks you know? 
    1. Synchronized
    2. ReentrantLock
    3. ReadWriteLock
    4. StampedLock

19. What is the difference between class lock and object lock?
    1. class lock can be used when we want to prevent multiple threads to enter the synchronized block in any of all available instances on runtime. It should always be used to make static data thread safe. 
    2. object lock can be used when you want non-static method or non-static block of the code should be accessed by only one thread. It should always be used to make non-static data thread safe. 

20. What is future and completableFuture?
    CompletableFuture<T> class implements Future<T> interface in Java.
    Future<T> interface have some limitations:
    1. It cannot be manually completed
    2. cannot perform further action on a Future’s result without blocking
    3. Multiple Futures cannot be chained together
    4. can not combine multiple Futures together
    5. No Exception Handling

21. what is ThreadLocal?
    ThreadLocal is another way to ensure thread safety when multiple threads access variables in addition to the synchronization method of locking.
    
22. Type the code by your self and try to understand it. (package 
com.chuwa.tutorial.t08_multithreading)
23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 
2,4,6,8,10. (solution is in 
com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
a. One solution use synchronized and wait notify 
b. One solution use ReentrantLock and await, signal
24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread 
output 21-22. threads run sequence is random. (solution is in 
com.chuwa.exercise.t08_multithreading.PrintNumber1)
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
1
2
3
4
5
6
7
8
9
10
11
12
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
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
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
18
19
20
21
22
23
24
25
26
27
28
29
30