### 2. Explain volatile variables in java? (we also use it in Singleton)
```
Volatile is a way of making class thread-safe
The volatile instance can be used by multiple threads at the same time without any problem
```

### 3. how to create a new thread(Please also consider Thread Pool case)?
```
public class MyThread extends Thread{
    @override
    public void run() {
        System.out.println("New thread");
    }
}

Thread t = new MyThread();
t.start();
```

```
public class MyRunnable implements Runnable{
    @override
    public void run(){
        System.out.println("New thread");
    }
}

Thread t = new Thread(MyRunnable());
t.start();
```

```
public class MyCallable implements Callable<String>{
    @override
    public String call() throw Exception{
        "New thread";
    }
}
```

```
// create a thread pool with four threads
ExecutorService es = Executors.newFixedThreadPool(4);
```

### 4. Difference between Runnable and Callable
```
Runnable has no returns, while Callable has return
```

### 5. what is the diff between t.start() and t.run()?
```
t.start() starts a new thread, while t.run() only runs it at the current thread
```

### 6. Which way of creating threads is better: Thread class or Runnable interface?
```
Implementing Runnable is better because it allows us to extend any other class
```

### 7. what is the thread status?
```
There are six different thread status:
- New (thread object has been created but haven't used the start method)
- Runnable (thread is running or it's ready to take task)
- Blocked (blocked at lock)
- Waiting (thread is waiting)
- Timed-waiting (return after certain time of waiting)
- Terminated (thread is terminated)
```

### 8. difference between wait() and sleep() method 
```
Wait() releases the lock while sleep() does NOT release the lock
```

### 9. What is deadlock?
```
Deadlock is a status when the two locks are accquired by two different thread, which leads to no thread is able to use the method
```

### 10. how do threads communicate with each other?
```
All the threads in the same program share the same memory space. 
If an object is accessible to various threads then these threads share access to that object's data member and thus communicate each other. 
The second way for threads to communicate is by using thread control methods.
```

### 11. what is join() method?
```
When main thread calls t.join(), it stops and waits for t thread end. The main thread is in Timed-Waiting status.
```

### 12. what is yield() method
```
The yield() means that the thread is not doing anything particularly important and if any other threads or processes need to be run, they should run. 
Otherwise, the current thread will continue to run.
```

### 13. Explain thread pool
```
A thread pool reuses previously created threads to execute current tasks 
and offers a solution to the problem of thread cycle overhead and resource thrashing. 
Since the thread is already existing when the request arrives, the delay introduced by thread creation is eliminated, 
making the application more responsive.
```

### 14. What is Executor Framework in Java, its different types and how to create these executors?
```
Executor Framework provides factory methods that are being used to create ThreadPools and efficiently manage multiple threads.

Some types of Executor Framework:
- FixedThreadPool：线程数固定的线程池；
- CachedThreadPool：线程数根据任务动态调整的线程池；
- SingleThreadExecutor：仅单线程执行的线程池。

to create a executor:
ExecutorService executor = Executors.newFixedThreadPool(2);
ExecutorService executor = Executors.newSingleThreadExecutor();
ExecutorService executor = Executors.newCachedThreadPool();
```

### 15. Difference between shutdown() and shutdownNow() methods of executor
```
shutdown() will allow previously submitted tasks to execute before terminating and will not accept new tasks
shutdownNow() does what shutdown() doese and also attempts to stop currently executing tasks.
```

### 16. What is Atomic classes? when do we use it?
```
Objects of Atomic classes represent the atomic variable and this ensures the multithread safety.
We can use it on number counter and accumulator
```

### 17. What is the cocurrent collections?
```
All the classes present in Concurrent Collections are synchronized in nature, so we don't have to take care about Thread-safety.

List  ArrayList             CopyOnWriteArrayList
Map   HashMap               ConcurrentHashMap
Set   HashSet/TreeSet       CopyOnWriteArraySet
Queue ArrayDeque/LinkedList ArrayBlockingQueue/LinkedBlockingQueue
Deque ArrayDeque/LinkedList LinkedBlockingDeque
```

### 18. what kind of locks you know?
```
- ReentrantLock: allows threads to enter into the lock on a resource more than once
- ReadWriteLock: allows only one thread to write, but when several threads request to read, it will allow if no thread is writing
- StampedLock: perform optimistic reads - allows writing when reading
```

### 19. What is the difference between class lock and object lock?
```
Object Locks − It can be used when you want non-static method or non-static block of the code should be accessed by only one thread. 
Class locks − It can be used when we want to prevent multiple threads to enter the synchronized block in any of all available instances on runtime.
```

### 20. What is future and completableFuture?
```
When the call() method completes, answer must be stored as a Future object for the main thread to use further
CompletableFuture is used for asynchronous programming which is a means of writing non-blocking code by running a task on a separate thread 
than the main application thread and notifying the main thread about its progress, completion, or failure.
```

### 21. what is ThreadLocal?
```
The TheadLocal construct allows us to store data that will be accessible only by a specific thread.
```
