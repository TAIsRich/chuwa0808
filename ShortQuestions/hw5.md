### 1. remeber pull the new code from that repo

### 2. Explain volatile variables in java? (we also use it in Singleton)
```
A volatile variable is basically a keyword that is used to ensure and address the visibility of changes to variables in multithreaded programming. This keyword cannot be used with classes and methods, instead can be used with variables. It is simply used to achieve thread-safety. If you mark any variable as volatile, then all the threads can read its value directly from the main memory rather than CPU cache, so that each thread can get an updated value of the variable.
```

### 3. how to create a new thread(Please also consider Thread Pool case)?
```
Extend thread class
Implements Runnable
Implements Callable
Use thread pool to submit
Eg: new Thread(new Task(“name”)
Es.submit(new Task(“name”)

```

### 4. Difference between Runnable and Callable
```
In a callable interface that basically throws a checked exception and returns some results. This is one of the major differences between the upcoming Runnable interface where no value is being returned.
```














### 5. what is the diff between t.start() and t.run()?
```
start()	run()
Creates a new thread and the run() method is executed on the newly created thread.	No new thread is created and the run() method is executed on the calling thread itself.
Can’t be invoked more than one time otherwise throws java.lang.IllegalStateException	Multiple invocation is possible
Defined in java.lang.Thread class.	Defined in java.lang.Runnable interface and must be overriden in the implementing class.

```
### 6. Which way of creating threads is better: Thread class or Runnable interface?
```
When we extend Thread class, we can’t extend any other class even we require and When we implement Runnable, we can save a space for our class to extend any other class in future or now.

When we extend Thread class, each of our thread creates unique object and associate with it. When we implements Runnable, it shares the same object to multiple threads.

```
### 7. what is the thread status?
```
A thread state. A thread can be in one of the following states:
•	NEW
A thread that has not yet started is in this state.
•	RUNNABLE
A thread executing in the Java virtual machine is in this state.
•	BLOCKED
A thread that is blocked waiting for a monitor lock is in this state.
•	WAITING
A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
•	TIMED_WAITING
A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
•	TERMINATED
A thread that has exited is in this state.
```

### 8. difference between wait() and sleep() method
```
wait(): As the name suggests, it is a non-static method that causes the current thread to wait and go to sleep until some other threads call the notify () or notifyAll() method for the object’s monitor (lock). It simply releases the lock and is mostly used for inter-thread communication. It is defined in the object class, and should only be called from a synchronized context. 
Example:  
synchronized(monitor) 
{ 
monitor.wait();       Here Lock Is Released by Current Thread  
} 
sleep(): As the name suggests, it is a static method that pauses or stops the execution of the current thread for some specified period. It doesn’t release the lock while waiting and is mostly used to introduce pause on execution. It is defined in thread class, and no need to call from a synchronized context.  
Example:  
synchronized(monitor) 
{ 
Thread.sleep(1000);     Here Lock Is Held by The Current Thread 
//after 1000 milliseconds, the current thread will wake up, or after we call that is interrupt() method 
} 

```

### 9. What is deadlock?
```
Deadlock, as the name suggests, is a situation where multiple threads are blocked forever. It generally occurs when multiple threads hold locks on different resources and are waiting for other resources to complete their task.
 
The above diagram shows a deadlock situation where two threads are blocked forever.  Thread 1 is holding Object 1 but needs object 2 to complete processing whereas Thread 2 is holding Object 2 but needs object 1 first. In such conditions, both of them will hold lock forever and will never complete tasks.
```
### 10. how do threads communicate with each other?
```
Inter-thread communication involves the communication of threads with each other. The three methods that are used to implement inter-thread communication in Java
wait()
This method causes the current thread to release the lock. This is done until a specific amount of time has passed or another thread calls the notify() or notifyAll() method for this object.
notify()
This method wakes a single thread out of multiple threads on the current object’s monitor. The choice of thread is arbitrary.
notifyAll()
This method wakes up all the threads that are on the current object’s monitor.
```

### 11. what is join() method?
```
join() method is generally used to pause the execution of a current thread unless and until the specified thread on which join is called is dead or completed. To stop a thread from running until another thread gets ended, this method can be used. It joins the start of a thread execution to the end of another thread’s execution. It is considered the final method of a thread class.
```
### 12. what is yield() method
```
A yield() method is a static method of Thread class and it can stop the currently executing thread and will give a chance to other waiting threads of the same priority. If in case there are no waiting threads or if all the waiting threads have low priority then the same thread will continue its execution.

```

### 13. Explain thread pool
```
A Thread pool is simply a collection of pre-initialized or worker threads at the start-up that can be used to execute tasks and put back in the pool when completed. It is referred to as pool threads in which a group of fixed-size threads is created.  By reducing the number of application threads and managing their lifecycle, one can mitigate the issue of performance using a thread pool. Using threads, performance can be enhanced and better system stability can occur. To create the thread pools, java.util.concurrent.Executors class usually provides factory methods.
```

### 14. What is Executor Framework in Java, its different types and how to create these
executors?
```
ExecutorService interface is basically a sub-interface of Executor interface with some additional methods or features that help in managing and controlling the execution of threads. It enables us to execute tasks asynchronously on threads.
Types of Executors
There are mainly 4 types of Executors available. They are namely:
•	SingleThreadExecutor 
ExecutorService executor = Executors.newSingleThreadExecutor()  
•	FixedThreadPool
ExecutorService executor = Executors.newFixedThreadPool(4);  

•	CachedThreadPool
ExecutorService executor = Executors.newCachedThreadPool();  
•	ScheduledExecutor
scheduledExecService.scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)  
Pls refer to https://www.javatpoint.com/executor-framework-java for details

```
### 15. Difference between shutdown() and shutdownNow() methods of executor
```
Two different methods are provided for shutting down an ExecutorService. The shutdown() method will allow previously submitted tasks to execute before terminating, while the shutdownNow() method prevents waiting tasks from starting and attempts to stop currently executing tasks.

```

### 16. What is Atomic classes? when do we use it?
```
The atomic classes provide a lock-free and thread-safe environment or programming on a single variable. It also supports atomic operations. All the atomic classes have the get() and set() methods that work on the volatile variable. The method works the same as read and writes on volatile variables.

The multi-threading environment leads to a problem when concurrency is unified. The shared entity such as objects and variables may be changed during the execution of the program. Hence, they may lead to inconsistency of the program. So, it is important to take care of the shared entity while accessing concurrently. In such cases, the atomic variable can be a solution to it.  Eg: in counter

```

### 17. What is the cocurrent collections?
```
INTERFACE 		NON-THREAD-SAFE 		THREAD-SAFE
List 			ArrayList 			CopyOnWriteArrayList
Map 			HashMap 			ConcurrentHashMap
Set 			HashSet / TreeSet 		CopyOnWriteArraySet
Queue 	ArrayDeque / LinkedList 	ArrayBlockingQueue / LinkedBlockingQueue
Deque 	ArrayDeque / LinkedList	 LinkedBlockingDeque
```
### 18. what kind of locks you know?
```
ReentrantLock
ReadWrite Lock (pessimistic lock)
StampedLock (optimistic lock)

```

### 19. What is the difference between class lock and object lock?
```
Sr. No.	Key	Object Level Lock	Class Level Lock
1	Basic 	It can be used when you want non-static method or non-static block of the code should be accessed by only one thread	It can be used when we want to prevent multiple threads to enter the synchronized block in any of all available instances on runtime
2	Static/Non Static 	It should always be used to make non-static data thread safe. 	It should always be used to make static data thread safe. 

3	Number of Locks 	Every object the class may have their own lock	Multiple objects of class may exist but there is always one class’s class object lock available

```

### 20. What is future and completableFuture?
```
The Callable object returns a Future object which provides methods to monitor the progress of a task being executed by a thread. The future object can be used to check the status of a Callable and then retrieve the result from the Callable once the thread is done. It also provides timeout functionality.
A CompltableFuture is used for asynchronous programming. Asynchronous programming means writing non-blocking code. It runs a task on a separate thread than the main application thread and notifies the main thread about its progress, completion or failure.
In this way, the main thread does not block or wait for the completion of the task. Other tasks execute in parallel. Parallelism improves the performance of the program.
```

### 21. what is ThreadLocal?
```
ThreadLocal variables are special kinds of variables created and provided by the Java ThreadLocal class. These variables are only allowed to be read and written by the same thread. Two threads cannot be able to see each other’s ThreadLocal variable, so even if they will execute the same code, then there won't be any race condition and the code will be thread-safe.  

```

### 22. Type the code by your self and try to understand it. (package
com.chuwa.tutorial.t08_multithreading)

### 23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print
2,4,6,8,10. (solution is in
com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
a. One solution use synchronized and wait notify
b. One solution use ReentrantLock and await, signal

### 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread
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
