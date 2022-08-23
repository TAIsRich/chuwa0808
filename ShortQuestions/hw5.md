1. remeber pull the new code from that repo
2. Explain volatile variables in java? (we also use it in Singleton)
   1. volatile variable can make sure the variable updated in time, it is used in multithread scenario, if one thread changed it, it can make sure other threads can read the changes immediatly.
3. how to create a new thread(Please also consider Thread Pool case)?
   1. create a class extending Thread class, 
   2. create a class implementing runnable interface, and new thread by passing the class.
   3. build thread pool(ExecutorService es = Executors.newFixedThreadPool(4);), and create a class implementing runnable interface, then submit the class into thread pool(es.submit(task)). 
4. Difference between Runnable and Callable
   1. callable have return type and throws exception, but runnable not
   
5. what is the diff between t.start() and t.run()?
   1. start() will start a new thread and will execute run() function.
   2. run will not start a thread and the funciton inside run will be called in the main thread.
6. Which way of creating threads is better: Thread class or Runnable interface?
   1. runnable interface is better, because class implementing runnable interface can extend other class but class extends thread class can not extend other class in the future.
7. what is the thread status?
   1. new, runnable, waiting, blocked,terminated 
8. difference between wait() and sleep() method
   1. wait() will release lock, which will help communication between threads while sleep will not release lock, which is just a pause for inner thread.
9.  What is deadlock?
    1.  when one thread need a resource but it was locked by other thread, the second thread also need a resource that was locked by first thread, this will cause deadlock.
10. how do threads communicate with each other?
    1.  notify, wait and join
11. what is join() method?
    1.  join() method will let main thread to wait for other thread terminated. main thread's status is waiting.
12. what is yield() method
    1.  yield means this thread dont have very important things to run, if other threads need to run, they can run, otherwise this thread continues .
13. Explain thread pool
    1.  thread pool will create pool to contain many threads, it can reuse the previously created threads to execute current tasks
14. What is Executor Framework in Java, its different types and how to create these executors?
    1.  executor framework provide multi-thread framework, it can reuse previously created threads
    2.  different types: SingleThreadExecutor, newFixedThreadPool, CachedThreadPool, ScheduledExecutor.
    3.  ExecutorService executor = Executors.newSingleThreadExecutor();
    4.  ExecutorService fixedPool = Executors.newFixedThreadPool(2);
    5.  ExecutorService executorService = Executors.newCachedThreadPool();
    6.  ScheduledExecutorService scheduledExecService = Executors.newScheduledThreadPool(1);
    7.  
15. Difference between shutdown() and shutdownNow() methods of executor
    1.  The shutdown() method will allow previously submitted tasks to execute before terminating, while the shutdownNow() method prevents waiting tasks from starting and attempts to stop currently executing tasks.
16. What is Atomic classes? when do we use it?
    1.  The atomic classes provide a lock-free and thread-safe environment or programming on a single variable. like AtomicInteger.
    2.  when we want it to be thread safe
17. What is the cocurrent collections?
    1.  concurent collections are thread safe compared with normal collection
    2.  for example, ArrayList -> CopyOnWriteArrayList; HashMap -> ConcurrentHashMap; HashSet -> CopeOnWriteArraySet; LinkedList -> LinkedBlockingQueue
18. what kind of locks you know?
    1.  sychronized(obj){}
    2.  ReentrantLock: private final Lock lock = new ReentrantLock(); lock.lock(); lock.unlock(); use condition to communicate with different threads: private final Condition condition = lock.newCondition(); condition.await() & condition.signal() & condition.signalAll()
    3.  ReadWriteLock: only one thread can write and when it write other threads can't write and read it. if other threads can read if no thread write it. 
        1.  private final ReadWriteLock rwlock = new ReentrantReadWriteLock(); 
        2.  private final Lock wlock = rwlock.readLock();
        3.  private final Lock rlock = rwlock.writeLock();
    4.  StampedLock: other threads can read when one thread is writing it.
        1.  private final StampedLock stampedLock = new StampedLock();
        2.  long stamp = stampedLock.writeLock(); // 获取写锁
        3.  stampedLock.unlockWrite(stamp); 
19. What is the difference between class lock and object lock?
    1.  object lock is implemented by using sychronized(this), while class lock using sychronized(someClass.class)
    2.  if sychronized a object, only threads which wanna access this object will blocked, other threads which access same object with different address/referene will not be blocked, but if it is class lock, all threads accessing this object will be blocked.
20. What is future and CompletableFuture?
    1.  after we use callable to create a thread, we will get a future object. we can use future.get() to get result, it can be blocked. we can use isDone() to check if it is done. every time when submit a callable to thread pool, we will get a future object.
    2.  CompletableFuture improved future. it can excute asynchronized task. the main thread will not be blocked.
        1.  CompletableFuture<Double> cf = CompletableFuture.supplyAsync(Main::fetchPrice);
        2.  thenAccept() will handle noraml result. it can pass a callback function to do some functionality.
        3.  exceptional() will handle exceptional result.
        4.  
21. what is ThreadLocal?
    1.  threadLoacal provide a way to store object in parent method, then all the method called in the parent method can access this object.
    2.  static ThreadLocal<User> tl = new ThreadLocal<>();
    3.  tl.set(user);// in parent method, you dont have to pass user as parameter
    4.  User u = tl.get(); // in other functions, you can directly use it by using get()
    5.  tl.remove();//remove the user.
22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
a. One solution use synchronized and wait notify
  b. One solution use ReentrantLock and await, signal
  1 2 3 4 5 6 7 8 9
10 11 12
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
 1 2 3 4 5 6 7 8 9
10
11
12
13
14
15
16
17
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
 
 18 Thread-2: 18 19 Thread-2: 19 20 Thread-2: 20 21 Thread-1: 21 22 Thread-1: 22 23 Thread-1: 23 24 Thread-1: 24 25 Thread-1: 25 26 Thread-1: 26 27 Thread-1: 27 28 Thread-1: 28 29 Thread-1: 29 30 Thread-1: 30