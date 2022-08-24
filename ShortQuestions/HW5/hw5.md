## hw5

### 1. Explain volatile variables in java? (we also use it in Singleton)

- A volatile variable is basically a keyword that is used to ensure and address the visibility of changes to variables in the multi-threaded programming. 
  

- This keyword cannot be used with classes and methods, instead can be used with variables.
  

- It is simply used to achieve thread-safety. If you mark any variable as volatile, then all the threads can read its value directly from the main memory rather than CPU cache (local thread), so that each thread can get an updated value of the variable.
  

- Using volatile keyword, also prevents the compiler from doing any reordering or optimization to the code.

```
- Suppose 2 threads are working on the class below, and both threads are running on the different processors with their own local copy of the variable s. 
- If any thread modifies its value, the change will not be reflected back in the original variable s in the main memory, which leads to a data inconsistency because the other thread is not aware of the modification. 
- To prevent the data inconsistency, we can make the variable s as volatile, then both threads will read and write the variable s from/to the main memory. 
- Using volatile keyword, also prevents the compiler from doing any reordering or optimization to the code.

public class test{
	static String t = "test";
}

public class test{
	static volatile String t = "test";
}
```

### 2. How to create a new thread (please also consider thread Pool case)?
#### https://jenkov.com/tutorials/java-concurrency/creating-and-starting-threads.html

We can simply create a new thread as below:
```
Thread thread = new Thread();
thread.start();
```

Here are two ways to specify what code the thread should execute:
- create a subclass of the Thread class (extend the Thread class) and override the run() method 
- create a class that implements the java.lang.Runnable interface, then a Java object that implements the Runnable interface can be executed by a Java thread

**method 1:**
```
public class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("Start a new thread by extending Thread!");
	}
}

// new creates a thread
// start() call will return as soon as the thread is started, it will not wait until run() is done
// run() is what is executed by the thread after you call start()
// run() will execute as if it is executed by a different CPU, when run() executes, it will print out the text 'Start a new thread by extending Thread!'
Thread thread = new MyThread(); 
thread.start(); 
```

**method 1 by using an anonymous inner subclass of Thread:**
```
Thread thread = new Thread() {
	@Override
	public void run(){
		System.out.println("Thread Running");
	}
};

thread.start(); 
```

**method 2:**
```
public class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("Start a new thread by implementing Runnable!");
	}
} 

Runnable runnable = new MyRunnable();
Thread thread = new Thread(runnable);
thread.start();
```

**method 2 by using a Lambda Expression:**
```
Runnable runnable = () -> System.out.println("Start a new thread by implementing Runnable!");

Thread thread = new Thread(runnable);
thread.start();

or

Runnable runnable = () -> {
	System.out.println("Start a new thread by implementing Runnable!");
};

Thread thread = new Thread(runnable);
thread.start();

or 

Thread thread = new Thread(() -> System.out.println("Start a new thread by implementing Runnable!"););

thread.start();

or

Thread thread = new Thread(() -> {
	System.out.println("Start a new thread by implementing Runnable!");
});

thread.start();
```

```
create a thread pool:

ExecutorService es = Executors.newFixedThreadPool(6);
```

### 3. Which way of creating threads is better: Thread class or Runnable interface?

There are no rules about which one of the two methods is the best. Both methods work.

Personally though, I prefer implementing Runnable, and handing an instance of the implementation to a Thread instance:

- Most people do not work with just Raw Threads, and they use the Executor framework which is provided by Java 5 and separates one task from its execution. We can execute the Runnable instances using execute(Runnable Task) of the Executor interface. Having the Runnable instances executed by a thread pool, it is easy to queue up the Runnable instances until a thread from the pool is idle. This is a little harder to do with a Thread subclasses.
  

- Sometimes you may have to implement Runnable as well as a subclass of Thread. For instance, create a subclass of Thread that can execute more than one Runnable instance. This is typically the case when implementing a thread pool.


- Java does not allow multiple inheritance through classes, so if you creates a subclass extending the Thread class, then you will not be able to make this class extend any other class.


- When we are working with multi-threading, we are not looking to overwrite any existed functionality of the Thread class, we just want to execute the code with the multiple threads. In that way as well, Runnable is a good choice.

### 4. What are the differences between Runnable and Callable?
Both the interfaces are generally used to encapsulate tasks that are needed to be executed by another thread. But there are some differences between them as given below:

- **Runnable interface:** 
  - This interface is basically available in Java right from the beginning. 
  - It is simply used to execute code on the concurrent thread.
  - No return value.

- **Callable interface:** 
  - This interface is basically a new one introduced as a part of the concurrency package. 
  - It addresses the limitation of runnable interfaces along with some major changes like generics, enum, static imports, variable argument method, etc. 
  - It can use generics to define the return type of object.

[Runnable VS. Callable](./Runnable_Callable.png)

### 5. What are the differences between t.start() and t.run()?

**start():**
- When the start() method is called, a newly created thread is started, then this newly created thread executes the task kept in the run() method. In a word, start() starts a newly created thread to execute the task in run().
  

- One can call the start() method only once.

**run():**
- When the run() method is called, no newly created thread, and this method is executed as a normal method call on the current calling thread. In a word, run() executes the task itself in the current thread.
  

- One can call the run() method multiple times. 

### 6. what are the thread status?

- **New:** the newly created thread that has not run


- **Runnable:** the running thread that is operating the run() code


- **Blocked:** the running thread that is blocked by a particular operation


- **Waiting:** the running thread that is waiting due to some particular operations


- **Timed Waiting:** the running thread is operating sleep() for timed waiting


- **Terminated:** the thread is terminated due to the run() code is done

### 7. What are the differences between the wait() method and sleep() method?
- **wait()** method is non-static, it gets called on an object on which synchronization block is locked (if the thread is currently in a synchronized block/method then no other threads can enter this block/method), while **sleep()** method is static, we call this method like Thread.sleep()

 
- **wait()** method can only be called from a synchronized context, while no need to call **sleep()** method from a synchronized context


- **wait()** is normally called when a condition is fulfilled, such as  the buffer size of queue is full, then producer thread will wait, while **sleep()** method can be called without a condition
 

- **wait()** method releases all locks it holds while waiting, but **sleep()** method does not release any lock it holds while waiting (sleep can lead to a deadlock)


- **waiting thread** can be waked by some other thread calling notify() or notifyAll(), while **sleeping thread** will wake up when the specified sleep time is over or the sleeping thread gets interrupted


- **wait()** method is used for inter-thread communication, while **sleep()** method is used to introduce a pause on execution

```
synchronized(monitor) {
	// the current thread says I will wait, and the lock (monitor) is released by the current thread
	monitor.wait();         
}
```
```
synchronized(monitor) 
	// the current thread says I will sleep and wake up after 1000 milliseconds or some other thread calling the interrupt() method, and the lock (monitor) is held by the current thread
	Thread.sleep(1000);     
} 
```

### 8. What is a deadlock?

**deadlock:** 
- as the name suggests, is a situation where the multiple threads are blocked forever 


- generally occurs when the multiple threads hold locks on the different resources and are waiting for other resources to complete their task

The diagram shows a deadlock situation where two threads are blocked forever: [Deadlock](./deadlock.png)
- Thread 1 is holding Object 1 but needs object 2 to complete processing whereas Thread 2 is holding Object 2 but needs object 1 first. 


- In such conditions, both of them will hold lock forever and will never complete tasks.

### 9. How do threads communicate with each other?

Implement the inner-thread communication using three methods:

**wait():** the current thread releases all locks it holds and goes waiting state until another thread calls the notify() or notifyAll() method for this object

**notify():** wakes a single thread out of the multiple threads on the current object's monitor randomly

**notify():** wakes all the threads on the current object's monitor

### 10. What is the join() method?

- join() method causes the current thread to pause execution unless the specified thread on which join is called is dead or the specified thread on which join is called is completed.


- To stop a thread from running until another thread gets ended, this method can be used. It joins the start of a thread execution to the end of another thread’s execution.


- join() method can be used to execute the threads sequentially or in some specific order.


- join(long milliseconds, long nanoseconds) : when this method is called, then the current thread will wait at most for the specified milliseconds plus nanoseconds.


- join() method is dependent on the underlying operating system for timing. So you should not assume that join() will wait exactly as long as you specify.


- Join is a final method in java.lang.Thread class and you cannot override it.

[join()](./join().png)

### 11. What is the yield() method?

- The yield() method is a static method of the Thread class.


- It can stop the currently executing thread and will give a chance to other waiting threads of the same priority.


- If in case there are no waiting threads or if all the waiting threads have low priority, then the same thread will continue its execution.


- The advantage of yield() method is to get a chance to execute other waiting threads so if the current thread takes more time to execute and allocate the processor to some other thread.


- When the yielded thread will get the chance for execution is decided by the thread scheduler whose behavior is vendor-dependent. The yield() method does not guarantee that the current thread will pause or stop but guarantees that CPU will be relinquished by the current thread as a result of a call to Thread.yield() method in java.

### 12. Explain the thread pool.

- A thread pool is simply a collection of pre-initialized or worker threads (i.e. a group of fixed-size threads) created at the start-up, which can be used to execute tasks and put back in the pool when completed.


- One can mitigate the performance issue using a thread pool by reducing the number of application threads and managing their lifecycle.


- Using thread pool, a better system stability can occur as well.


- To create a thread pool, java.util.concurrent.Executors class usually provides the factory methods.

### 13. What is the Executor framework in Java? What types does it have? How to create these executors?

**Executor Framework:**
- Java executor framework (java.util.concurrent.Executor which is a utility interface), released with the JDK 5 is used to run the Runnable objects without creating new threads every time and mostly reusing the already created threads.
- It is an abstraction to managing the multiple threads by yourself.
- It decouple the execution of a task and the actual task itself. Now, we just have to focus on the task itself which only implements the Runnables and submit them to the executor. Then these Runnables will be managed by the executor framework.

**ExecutorService** interface: 
- a sub-interface of Executor interface with some additional methods or features to help in managing and controlling the execution of threads
- enable us to execute tasks asynchronously on threads

**SingleThreadExecutor:** 
```
ExecutorService excutorService = Excutors.newSingleThreadExecutor();
```

**FixedThreadPoolExecutor:** 
- As its name suggests, this is an executor with a fixed-number of threads. 
- The tasks submitted to this executor are executed by the specified number of threads.  
- If there are more tasks than the number of threads, then those tasks will be added in a queue.
```
ExecutorService executorService = Executors.newFixedThreadPool(5);
```

**CachedThreadPool:** 
- Creates a thread pool that creates some new threads as needed. 
- Calls to be executed will reuse the previously constructed threads if these previously constructed threads are available. 
- If no existing thread is available, a new thread will be created and added to the pool. It uses a SynchronousQueue queue.
```
ExecutorService executorService = Executors.newCachedThreadPool();
```

**ScheduledExecutor:**
- Use this executor when you want to schedule your tasks, like run them at the regular intervals or run them after a given delay. 
- There are 2 methods used for scheduling tasks: 
  - scheduleAtFixedRate: execute a task with a fixed interval irrespective of when the previous task ended
  - scheduleWithFixedDelay: start the delay countdown only after the current task completes
```
ExecutorService executorService = Executors.newScheduledExecutor();
executorService.scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
executorService.scheduleWithFixedDelay(Runnable command, long initialDelay, long period, TimeUnit unit)
```

### 14. What are the Differences between the shutdown() method and shutdownNow() method of an executor object?

- An executor will not shut down automatically even there is no task to process. It will stay alive and wait for new works. It will keep the JVM running.


- When **shutdown()** method is called on an executor, the executor will not accept new tasks and will wait the current executing tasks to be finished then shutdown.


- When **shutdownNow()** is called, it tries to interrupt the running threads and shutdown the executor immediately. However, there is no guarantee that all the running threads will be stopped at the same time.


- One good way to shutdown an executor is to use both of these methods along with awaitTermination(). With this approach, the executor will stop accepting new tasks and wait up to the specified duration for all the running tasks to be completed. But it will shutdown immediately even it has not completed all the running tasks if the time expires.
```
try{
    executor.shutdown();
    if(executor.awaitTermination(5, TimeUnit.MINUTES)){
        excutor.shoutdownNow();
    }
} 
catch(InterruptedException e){
    System.err.println("tasks interrupted"); 
}
```

### 15. What are the atomic classes? When do we use it?

- The java.util.concurrent.atomic package defines the classes that support the atomic operations on single variables.


- A variable of any atomic class, assists in **writing lock and wait-free** algorithms with the Java language.


- Java provides the atomic classes such as AtomicInteger, AtomicLong, AtomicBoolean and AtomicReference. The objects of these classes represent the atomic variable of int, long, boolean, and object reference respectively.


- All classes have the get and set methods that work like reads and writes on the volatile variables. That is, a set call has a happen-before relationship with any subsequent get call on the same variable.


- These atomic classes have the methods as below:
  - set(int value): set to the given value
  - get(): get the current value
  - lazySet(int value): eventually sets to the given value
  - compareAndSet(int expect, int update): atomically sets the value to the given updated value if the current value == the expected value
  - addAndGet(int delta): atomically adds the given value to the current value
  - decrementAndGet(): atomically decrements by one the current value

### 16. What are the concurrent collections?

- Since many collections like ArrayList or LinkedList is non-synchronized during multi-threading, which means multiple threads can perform on an object at a time simultaneously leading to thread-safety.


- On the other hand, some objects of Vector, Stack and HashTable are synchronized in nature, but the performance is low because at a single time when some thread executes an object, the rest threads have to wait.


- SUN microSystem introduced a new feature in JDK 1.5Version, which is nothing but the Concurrent Collections. There are a few important Concurrent Collections, such as CopyOnWriteArrayList, CopyOnWriteArraySet and ConcurrentHashMap.

### 17. What kinds of locks do you know?

- **ReentrantLock:**
  - ReentrantLock class implements the Lock interface.
  - It offers the same concurrency and memory semantics as the implicit monitor lock accessed using synchronized methods and statements.


- **ReentrantReadWriteLock:**
  - ReentrantReadWriteLock class implements the ReadWriteLock interface.
  - It only allowed one thread to write in. Meanwhile, the other threads could not write in or read. When without writing in, the multiple threads can synchronously read.
  - Though ReadWriteLock can solve multi-threaded read simultaneously and only one thread can write. But a big problem with ReadWriteLock is that the writing thread has to wait for the reading thread to release the lock to acquire the writing lock.


- **StampedLock:**
  - To improve the performance, Java brings a new lock, StampedLock that allows the thread to acquire a writing lock while the other threads are reading.
  - Therefore, it needs more code to determine whether there is a writing during the reading process.

### 18. What are the differences between the class lock and object lock?

**Class Lock:** 
- In java, each class has a unique lock usually referred to as a class-level lock. 
- These locks are achieved using the keyword ‘static synchronized’ and can be used to make the static data thread-safe. 
- It is generally used when one wants to prevent multiple threads from entering a synchronized block in any of all available instances on runtime.

**Object Lock:** 
- In java, each object has a unique lock usually referred to as an object-level lock. 
- These locks are achieved using the keyword ‘synchronized’ and can be used to protect the non-static data. 
- It is generally used when one wants to synchronize a non-static method or block so that only the current thread will be able to execute the code block on a given instance of a class.

### 19. What are the future and completableFuture?

**Future:**
- It was introduced by Java 5 (2004).
- They are basically the placeholders for a result of an operation that has not finished yet. Once the operation finishes, the Future will contain that result.
- For example, an operation can be that a Runnable or Callable instance is submitted to an ExecutorService object. The submitter can use a Future object to check whether the operation isDone(), or wait it to finish using the blocked get() method directly.
```
/**
* a task that sleeps for 1 second (1000 milliseconds), then returns 1
**/
public static class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 1;
    }
}

public static void main(String[] args) throws Exception{
    ExecutorService es = Executors.newSingleThreadExecutor();
    Future<Integer> f = es.submit(new MyCallable());

    // False
    System.out.println(f.isDone()); 
    // wait until the task is done, then print 1
    System.out.println(f.get()); 
}
```

**CompletableFuture:**
- It was introduced by Java 8 (2014).
- It is in fact an evolution of the regular Future, inspired by Google's Listenable Future which is part of the Guava library.
- Allow to string the tasks together in a chain. Be used to tell some worker thread to "go to do Task x, and when you are done, go to do this other thing using the result of Task x". Using CompletableFuture, you can do something with the result of the operation without  blocking a thread actually to wait for the result.
```
/**
* a task sleeps for 1 second (1000 millisecond), then returns 1
**/
public static class MySupplier implements Supplier<Integer> {
    @Override
    public Integer get() {
        try {
            Thread.sleep(1000);
        } 
        catch (InterruptedException e) {
            //Do nothing
        }
        
        return 1;
    }
}

/**
* A (pure) function that adds 1 to a given Integer
**/
public static class PlusOne implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer x) {
        return x + 1;
    }
}

public static void main(String[] args) throws Exception {
    ExecutorService es = Executors.newSingleThreadExecutor();
    CompletableFuture<Integer> f = CompletableFuture.supplyAsync(new MySupplier(), es);
    
    // False
    System.out.println(f.isDone()); 
    CompletableFuture<Integer> f2 = f.thenApply(new PlusOne());
    // waits until the calculation is done, then prints 2
    System.out.println(f2.get()); 
}
```

### 20. What is ThreadLocal?

- ThreadLocal variables are a special kind of variables created and provided by the Java ThreadLocal class, and generally uses the keywords private and static in a class.


- ThreadLocal variables are only allowed to be read (get method) and written (set method) by one single thread, i.e. no two threads can see each other's ThreadLocal variables since each thread has its own copy of the variables initialized independently.


- Two threads cannot be able to see each other’s ThreadLocal variable, so even if they will execute the same code, there will not be any race condition and the code will be thread-safe.


- Since the variables (objects) are no more shared, there is no requirement for synchronization, which can improve the scalability and performance of the application.


- Basically, it is another way to achieve thread-safety apart from writing immutable classes.

### 21. Type the code by yourself and try to understand it. 
#### https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t08_multithreading

[CODE](https://github.com/TAIsRich/chuwa0808/tree/Flora_Zhong/notes/CodingQuestions/Coding_Exercise/src/multithreading/basicOperations)

### 22. Write the code to create 2 threads, one thread prints 1, 3, 5, 7, 9, and the other thread prints 2, 4, 6, 8, 10.

#### a. One solution uses synchronized and wait, notify. 
##### https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t08_multithreading/c05_waitNotify/OddEventPrinter.java)

[CODE](https://github.com/TAIsRich/chuwa0808/tree/Flora_Zhong/notes/CodingQuestions/Coding_Exercise/src/multithreading/praticalExercises/TwoThreads1.java)

#### b. One solution use ReentrantLock and await, signal.

[CODE](https://github.com/TAIsRich/chuwa0808/tree/Flora_Zhong/notes/CodingQuestions/Coding_Exercise/src/multithreading/praticalExercises/TwoThreads2.java)

### 23. Create 3 threads, one thread outputs 1 ~ 10, another thread outputs 11 ~ 20, and the rest thread output 21 ~ 22. Threads run in a random sequence. 
#### https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/t08_multithreading/PrintNumber1.java

[CODE](https://github.com/TAIsRich/chuwa0808/tree/Flora_Zhong/notes/CodingQuestions/Coding_Exercise/src/multithreading/praticalExercises/ThreeThreads.java)