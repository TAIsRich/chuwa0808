1.  remeber pull the new code from that repo
2.  Explain volatile variables in java? (we also use it in Singleton)
	1. volatile variable are written to and read from the main mamory, 
	2. doesn't store it's data in cache.
3.  how to create a new thread(Please also consider Thread Pool case)?
	1. Create a new thread object
		1. Thread thread = new myThread();
		2. Thread thread = new Thread(new Runnable())
		3. Thread thread = new Thread( () ->  System.out.println("lambda"));
	2. Use thread pool
		1. ExecutorService executor = Executors.newFixedThreadPool(4);
		2. executor.submit(new task());
4.  Difference between Runnable and Callable
	1. Runnable has no return
	2. Callable has return
5.  what is the diff between t.start() and t.run()?
	1. t.start starts a new threads to execute the task
	2. t.run execute the task in current thread
6.  Which way of creating threads is better: Thread class or Runnable interface?
	1. Depend on case,
	2. if return is required callable is better than runnable
	3. if no return is require, runnable is absolutely fine
	4. Overall callable is better, it handles return cases.
7. what is the thread status?
	1. New - created, but not yet start
	2. Runnable - can be run, two status
		1. Running - running threads
		2. Ready - waiting for cpu time slice
	3. Blocked - Synchronized, waiting for resource to be release
	4. Waiting - waiting for other thread to notify or join to get back to runnable
	5. Timed_waiting - sleep, or long wait, back to runnable after certain period of time
	6. Terminated - thread end when tasks finished
8.  difference between wait() and sleep() method
	1. Wait release the lock, sleep doesn't
	2 .Wait can be woken up by another thread with notify, sleep can not  
9.  What is deadlock?
	1. deadlock is when two thread wants the same resources, but one thread only holding parts of it, both not letting go of resources
	2. Example: Two person and two chopstick, each person holding only one copsticks and no one can eat without another one.
10. how do threads communicate with each other?
	1. Syncronized 
		1. wait
		2. notify
		3. notifyAll
	2. ReentrantLock
		1. condition.await()
		2. condition.signal()
		3. condition.signalAll()
11. what is join() method?
	1. stop and wait for the other threads to finish
12. what is yield() method
	1. yield() method give some cpu time to other threads so other threads have a chance to run.
13. Explain thread pool
	1. Thread pool creates a fix amount of threads before the request arrived
	2. Use ExecutorService to create thread pool
	3. Runs threads by submit(new thread)
14. What is Executor Framework in Java, its different types and how to create these executors?
	1. SingleThreadExecutor 
		1. ExecutorService executor = Executors.newSingleThreadExecutor();
	2. FixedThreadPool(n)
		1. ExecutorService fixedPool = Executors.newFixedThreadPool(2);
	3. CachedThreadPool
		1. ExecutorService executorService = Executors.newCachedThreadPool();
	4. ScheduledExecutor
		1. ScheduledExecutorService scheduledExecService = Executors.newScheduledThreadPool(1);
15. Difference between shutdown() and shutdownNow() methods of executor
	1. shutdown() - not accepting new tasks, but existing tasks can still run
	2. shutdownNow() - not accepting new tasks and also try to cancel current tasks
16. What is Atomic classes? when do we use it?
	1. Atomic classes is a class that provide lock free and thread-safe variables and operations 
	2. use atomic classes when using threads to handle reading old version of data
17.  What is the cocurrent collections?
	1. Is the thread-safe version of collections
18. what kind of locks you know? 
	1. ReadWriteLock - allow read when no write, speed up 
	2. StampedLock - can read when write, but might cause problem
19. What is the difference between class lock and object lock?
	1. Object lock -> use object itself as a lock - synchronized(this)
	2. Class lock -> use class as a lock - synchronized(someClass.class)
20. What is future and completableFuture?
	1. future - a value might be return in the future, when some operations are done
	2. completableFuture  -  use thenAccept to receive data, better than checking isDone from future class
21. what is ThreadLocal?
	1. ThreadLocal are private static final variable that belong to the thread itself
	2. it doesn't share among the threads
22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
a. One solution use synchronized and wait notify 
b. One solution use ReentrantLock and await, signal
24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)