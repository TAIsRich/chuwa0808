### 2. Explain volatile variables in java? (we also use it in Singleton)
- Volatile is a keyword in java, that can be applied only to variables. You cannot apply volatile keyword to classes and methods. Applying volatile to a shared variable that is accessed in a multi-threaded environment ensures that threads will read this variable from the main memory instead of their own local cache.
- Now, let¡¯s suppose 2 threads are working on this class and both threads are running on different processors having their own local copy of variable x. if any thread modifies its value, the change will not be reflected back in the original variable x in the main memory leading to data inconsistency because the other thread is not aware of the modification. So, to prevent data inconsistency, we can make variable x as volatile:
Now, all the threads will read and write the variable x from/to the main memory. Using volatile, also prevents compiler from doing any reordering or any optimization to the code.
```
public class test{
	static String t = "test";
}
```
So, to prevent data inconsistency, we can make variable t as volatile:
```
public class test{
	static volatile String t = "test";
}
```
- Now, all the threads will read and write the variable x from/to the main memory. Using volatile, also prevents compiler from doing any reordering or any optimization to the code.
- The volatile keyword does not cache the value of the variable and always read the variable from the main memory.
### 3. how to create a new thread(Please also consider Thread Pool case)?
- In java we can simply create a new thread by below:
```
Thread thread = new Thread;
thread.start();
```
- here are two ways to specify what code the thread should execute. The first is to create a subclass of Thread and override the run() method. The second method is to pass an object that implements Runnable (java.lang.Runnable to the Thread constructor. Both methods are covered below.
```
//create a subclass of Thread and override the run() method
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}



// implement Runnable
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}


// Also we can use lambda expression in main thread while creating the thread
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("start new thread!");
        });
        t.start(); 
    }
}


//Create thread pool
ExecutorService es = Executors.newFixedThreadPool(4);
```

### 4. Difference between Runnable and Callable
- Runnable tasks can be executed by using Thread class or ExecutorService interface whereas Callable tasks can be executed by using ExecutorService interface only
- Return type of Runnable¡¯s run() method is void whereas Callable¡¯s call() method returns Future object

- Runnable¡¯s run() method does not throw 

- checked exceptions whereas Callable¡¯s call() method can throw checked exceptions

### 5. what is the diff between t.start() and t.run()?
- When a program calls the start() method, a new thread is created and then the run() method is executed. But if we directly call the run() method then no new thread will be created and run() method will be executed as a normal method call on the current calling thread itself and no multi-threading will take place.
- t.start starts a new thread to excute the task£¨run()£©
- t.run() excute the task in the current thread.
### 6. Which way of creating threads is better: Thread class or Runnable interface?
- As you know, Java does not allow multiple inheritance through classes, so if you are creating threads by extending Thread class then you will not be able to extend any other class.
- When we are working with multi-threading, we are not looking to overwrite any existing functionality of Thread class, we just want to execute the code with multiple threads, so in that way also, Runnable is a good choice.
- One more reason to choose Runnable is that, most people don¡¯t work with just Raw Threads, they use the Executor framework that is provided from Java 5, that separates the task from its execution and we can execute Runnables using execute(Runnable Task) method of Executor interface
- By implementing Runnable we can reuse the task to execute it on different threads. Also it could be run by other means like Executor.
### 7. what is the thread status?
- New: the newly created thread that hasn't run 
- Runnable: the running thread that is operating run() code 
- Blocked: running thread that is blocked by a particular operation
- Waiting: running thread that is waiting due to some particular operations
- Timed Waiting: running thread is operating sleep() for timed waiting.
- Terminated: the thread is terminated duet o the run() code is done.
### 8. difference between wait() and sleep() method
- wait() method can only be called from a synchronized context while sleep() method can be called without synchronized context
- wait() method releases the lock on the object while waiting but sleep() method does not release the lock it holds while waiting, it means if the thread is currently in a synchronized block/method then no other thread can enter this block/method
- wait() method is used for inter-thread communication while sleep() method is used to introduce a pause on execution
- waiting thread can be waked by calling notify() or notifyAll(), while sleeping thread will wake up when the specified sleep time is over or the sleeping thread gets interrupted
- wait() method is non-static, it gets called on an object on which synchronization block is locked while sleep() is a static method, we call this method like Thread.sleep(), that means it always affects the currently executing thread
- wait() is normally called when a condition is fulfilled like if the buffer size of queue is full then producer thread will wait, whereas sleep() method can be called without a condition

### 9. What is deadlock?
- **Deadlock** is a situation where a set of processes are blocked because each process is holding a resource and waiting for another resource acquired by some other process. 
- Consider an example when two trains are coming toward each other on the same track and there is only one track, none of the trains can move once they are in front of each other. A similar situation occurs in operating systems when there are two or more processes that hold some resources and wait for resources held by other(s).
### 10. how do threads communicate with each other?
- by using three method to implement inter-thread communication in java
- wait(): This method causes the current thread to release the lock. This is done until a specific amount of time has passed or another thread calls the notify() or notifyAll() method for this object.
- notify(): This method wakes a single thread out of multiple threads on the current object¡¯s monitor. The choice of thread is **arbitrary**.
- notify(): This method wakes up all the threads that are on the current object¡¯s monitor.
### 11. what is join() method?
- join() method causes the current thread to pause execution until the thread which has called join() method is dead.
- join() method can be used to execute the threads sequentially or in some specific order.
- join(long milliseconds, long nanoseconds) : when this method is called, then the current thread will wait at most for the specified milliseconds plus nanoseconds.
- These join methods are dependent on the underlying Operating system for timing. So, you should not assume that join() will wait exactly as long as you specify.

### 12. what is yield() method
- A yield() method is a static method of Thread class and it can stop the currently executing thread and will give a chance to other waiting threads of the same priority.
- If in case there are no waiting threads or if all the waiting threads have low priority then the same thread will continue its execution. The advantage of yield() method is to get a chance to execute other waiting threads so if our current thread takes more time to execute and allocate processor to other thread
- When the yielded thread will get the chance for execution is decided by the thread scheduler whose behavior is vendor dependent. Yield method doesn¡¯t guarantee that the current thread will pause or stop but it guarantees that CPU will be relinquished by current Thread as a result of a call to Thread.yield() method in java.

### 13. Explain thread pool
- A yield() method is a static method of Thread class and it can stop the currently executing thread and will give a chance to other waiting threads of the same priority. If in case there are no waiting threads or if all the waiting threads have low priority then the same thread will continue its execution. The advantage of yield() method is to get a chance to execute other waiting threads so if our current thread takes more time to execute and allocate processor to other threads.
### 14. What is Executor Framework in Java, its different types and how to create these executors?
- Executor Framework is an abstraction to managing multiple threads by yourself. So, it decouples the execution of a task and the actual task itself. Now, we just have to focus on the task that means, only implement the Runnables and submit them to executor. Then these runnables will be managed by the executor framework
- Java executor framework (java.util.concurrent.Executor), released with the JDK 5 is used to run the Runnable objects without creating new threads every time and mostly re-using the already created threads.
- SingleThreadExecutor: Executors is a utility class which contains many factory methods to create different types of ExecutorService, like the one called SingleThreadExecutor
```
ExecutorService excutor = Excutors.newSingleThreadExecutor();
```

- FixedThreadPoolExecutor: As its name suggests, this is an executor with a fixed number of threads. The tasks submitted to this executor are executed by the specified number of threads and if there are more tasks than the number of threads, then those tasks will be added in a queue
```
ExecutorService executor = Executors.newFixedThreadPool(5);

```

- CachedThreadPool: Creates a thread pool that creates new threads as needed, but will reuse previously constructed threads when they are available. Calls to execute will reuse previously constructed threads if available. If no existing thread is available, a new thread will be created and added to the pool. It uses a SynchronousQueue queue.
```
ExecutorService executorService = Executors.newCachedThreadPool();
```

- ScheduledExecutor: Use this executor, when you want to schedule your tasks, like run them at regular intervals or run them after a given delay. There are 2 methods which are used for scheduling tasks: scheduleAtFixedRate and scheduleWithFixedDelay
    - scheduleAtFixedRate: Executes the task with a fixed interval, irrespective of when the previous task ended.
    - scheduleWithFixedDelay: This will start the delay countdown only after the current task completes.

```
scheduledExecService.scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
scheduledExecService.scheduleWithFixedDelay(Runnable command, long initialDelay, long period, TimeUnit unit)
```
### 15. Difference between shutdown() and shutdownNow() methods of executor
- An executor will not shut down automatically even when there is no task to process. It will stay alive and wait for new work. It will keep the JVM running. When shutdown() method is called on an executor, then the executor will not accept new tasks and it will wait for the currently executing tasks to finish. When shutdownNow() is called, it tries to interrupt the running threads and shutdown the executor immediately. However, there is no guarantee that all the running threads will be stopped at the same time.
- One good way to shutdown an executor is to use both of these methods along with awaitTermination(). With this approach, the executor will stop accepting new tasks and waits up to the specified duration for all running tasks to be completed. If the time expires, it will shutdown immediately.
```
executor.shutdown();
try{
    if(executor.awaitTermination(5, TimeUnit.MINUTES)){
        excutor.shoutdownNow();
    }

} catch(InterruptedException e){
    excutor.shutdownNow();
}
```
### 16. What is Atomic classes? when do we use it?
- The java.util.concurrent.atomic package defines classes that support atomic operations on single variables. All classes have get and set methods that work like reads and writes on volatile variables. That is, a set call has a happens-before relationship with any subsequent get call on the same variable.
- Java provides atomic classes such as AtomicInteger, AtomicLong, AtomicBoolean and AtomicReference. Objects of these classes represent the atomic variable of int, long, boolean, and object reference respectively. 
- These class include the methods below:
    - set(int value): Sets to the given value
    - get(): Gets the current value
    - lazySet(int value): Eventually sets to the given value
    - compareAndSet(int expect, int update): Atomically sets the value to the given updated value if the current value == the expected value
    - addAndGet(int delta): Atomically adds the given value to the current value
    - decrementAndGet(): Atomically decrements by one the current value
### 17. What is the cocurrent collections?
- Since many collections like ArrayList or LinkedList is non-synchronized during multiple threading, which means multiple threads can perform on an object at a time simultaneously. Therefore objects are not thread-safe. On the other hand, some class objects (like Vector, Stack, HashTable) are synchronized in nature, but performance is low because at a single time thread executes an object, and rest thread has to wait. So SUN microSystem introduced a new feature in JDK 1.5Version, which is nothing but Concurrent Collections. There are a few Concurrent Collections that are important, such as CopyOnWriteArrayList, ConcurrentHashMap, and CopyOnWriteArraySet.
### 18. what kind of locks you know?
- ReentrantLock: ReentrantLock class implements the Lock interface. It offers the same concurrency and memory semantics as the implicit monitor lock accessed using synchronized methods and statements, with extended capabilities.
- ReentrantReadWriteLock: ReentrantReadWriteLock class implements the ReadWriteLock interface. It only allowed one thread to write in; Meanwhile, other threads could not write in or read. Then, when without writing in, multi-threads can synchronously read. Even ReadWriteLock can solve multi-thread read simultaneously, but only one thread can write. Yet, a big problem with ReadWriteLock is that the writing thread has to wait for the reading thread to release the lock to acquire the writing lock.
- StampedLock: To improve the performance, java brings a new lock, StampedLock, that allows the thread to acquire a writing lock while reading. Therefore it needs more code to determine whether there is writing during the reading process.
### 19. What is the difference between class lock and object lock?
- Every object in java has a unique lock. Whenever we are using a ¡®synchronized¡® keyword then only the lock concept will come into the picture.
- Object Level Lock is a mechanism where every object in java has a unique lock which is nothing but an object¨Clevel lock. If a thread wants to execute a synchronized method on the given object then the thread first required the object level lock once the thread gets object level lock then it is allowed to execute any synchronized method on the given object and once the method execution completed automatically thread releases the lock of that object.
- Class Level Lock is a mechanism where every class in java has a unique lock which is nothing but a class level lock. If a thread wants to execute a static synchronized method then the thread requires a class level lock once the thread gets a class level lock then it is allowed to execute any static synchronized method of that class. Once method execution completes automatically thread releases the lock. While a thread executing a static synchronized method the remaining thread is not allowed to execute any static synchronized method of that class simultaneously.
```
//class lock
public class GFG {

  public void m1( ) {

     synchronized (GFG.class) {

    // some line of code 

  }

}




//object lock
public class GFG {

  public void m1( ) {

     synchronized (this) {

        // some line of code

     }

  }

}
```
### 20. What is future and completableFuture?
- Futures were introduced in Java 5 (2004). They're basically placeholders for a result of an operation that hasn't finished yet. Once the operation finishes, the Future will contain that result. For example, an operation can be a Runnable or Callable instance that is submitted to an ExecutorService. The submitter of the operation can use the Future object to check whether the operation isDone(), or wait for it to finish using the blocking get() method.
```
/**
* A task that sleeps for a second, then returns 1
**/
public static class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 1;
    }

}

public static void main(String[] args) throws Exception{
    ExecutorService exec = Executors.newSingleThreadExecutor();
    Future<Integer> f = exec.submit(new MyCallable());

    System.out.println(f.isDone()); //False

    System.out.println(f.get()); //Waits until the task is done, then prints 1
}
```
- CompletableFutures were introduced in Java 8 (2014). They are in fact an evolution of regular Futures, inspired by Google's Listenable Futures, part of the Guava library. They are Futures that also allow you to string tasks together in a chain. You can use them to tell some worker thread to "go do some task X, and when you're done, go do this other thing using the result of X". Using CompletableFutures, you can do something with the result of the operation without actually blocking a thread to wait for the result.
```
/**
* A supplier that sleeps for a second, and then returns one
**/
public static class MySupplier implements Supplier<Integer> {

    @Override
    public Integer get() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //Do nothing
        }
        return 1;
    }
}

/**
* A (pure) function that adds one to a given Integer
**/
public static class PlusOne implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer x) {
        return x + 1;
    }
}

public static void main(String[] args) throws Exception {
    ExecutorService exec = Executors.newSingleThreadExecutor();
    CompletableFuture<Integer> f = CompletableFuture.supplyAsync(new MySupplier(), exec);
    System.out.println(f.isDone()); // False
    CompletableFuture<Integer> f2 = f.thenApply(new PlusOne());
    System.out.println(f2.get()); // Waits until the "calculation" is done, then prints 2
}
```
### 21. what is ThreadLocal?
- This class provides thread-local variables. These variables differ from their normal counterparts in that each thread that accesses one (via its get or set method) has its own, independently initialized copy of the variable. Basically, it is another way to achieve thread safety apart from writing immutable classes. Since the Object is no more shared there is no requirement for Synchronization which can improve the scalability and performance of the application. ThreadLocal provides thread restriction which is an extension of a local variable. ThreadLocal is visible only in a single thread. No two threads can see each other¡¯s thread-local variable. These variables are generally private static fields in classes and maintain their state inside the thread.
### 22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
- 
### 23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
    a. One solution use synchronized and wait notify
	b. One solution use ReentrantLock and await, signal
### 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)