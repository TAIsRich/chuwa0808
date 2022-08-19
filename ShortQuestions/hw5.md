# 2. Volatile
可以使修改值立刻更新到main function

# 3. Create a new thread
by extending thread class
by implementing Runnable
by implementing callable
create thread with lambda
create multiple threads with threadPool

# 4. runnable vs. callable
runnable – no return value
callable – has return value

# 5. t.start() vs. t.run()
t.start() – 直接在current thread run已经定义好的task,没有实现多线程
t.run() – 需要先new一个新的thread, then run the task in the new thread

# 6.
 thread class is better, since runnable does not have return value

# 7. thread status
new 
runnable
blocked
waiting
timed waiting
terminated

# 8. wait() vs. sleep()
wait()
- be called from a synchronized context
- release the lock on the object while waiting
- used for inter-thread communication
- can be waked by notify() or notifyAll()
- non-static
sleep() 
- can be called without a synchronized context
- does not release the lock while waiting
- just a pause on execution
- can be wake only when the specific sleep time is over
- static

# 9. deadlock
too many locks, for each of the tasks that has a lock,  can run only if other tasks have completed. AKA, the running of tasks depends on each other’s tasks’ complete.

# 10. 

use wait()  and notify()

# 11. join()

main thread call joint
main thread wait for t thread to complete t’s tasks
main thead’s status is Timed Waiting

# 12. yield()

yield() method pauses the currently executing thread temporarily for giving a chance to the remaining waiting threads of the same priority to execute. If there is no waiting thread or all the waiting threads have a lower priority then the same thread will continue its execution.

# 13. 

No need to create new threads every time, we can use executor framework to new multiple threads at a time, and the threads will be stored in Thread Pool

# 14. 
Executor Framework is an abstraction to managing multiple threads by yourself. So, it decouples the execution of a task and the actual task itself. 

# 15. shutdown() vs. shuntdownNow()

shutdown:
called on an executor, then the executor will not accept new tasks and it will wait for the current executing task to complete
executor上call, 再当前task跑完之前不会再接受新的task
shutdownNow():
try to interrupt the running threads and shutdown the executor immediately. However, there is no guarantee that all the running thread will be stopped at the same time.
中止正在跑的threads,并且立马shutdown.不能保证所有的线程是同时停下的

# 16. 

support atomic operation on a single variable
all calses have get and set methods that work like reads and writes on volatile variables


# 17. 
collections that are thread-safe

# 18. 

reentrantLock
先获取锁，然后在finally中正确释放锁
可重入锁，一个线程可以多次获取同一个锁
readwriteLock
只允许一个线程写入，其他线程不允许写or读
没有写入时，多个线程允许同时读
适合读多写少的situation
悲观锁，因为读的过程中不允许写
读锁和写锁是分开的
stampedLock
乐观锁，读的过程中允许写
但可能造成数据不一致的问题

# 19. 

object lock
can be used to make non-static data thread safe
should be access by only one thread
every object in the class can have their own lock

class lock
can be used when want to prevent multiple threads to enter the synchronized block in any of all available instance on runtime
used to make static data thread safe
Multiple objects of class may exist but there is always one class’s class object lock available

# 20. 

future 
代表一个未来能获取结果的对象
通过调用callable，可以获得一个future对象
future.get()会得到异步执行的结果
如果异步完成，直接获得结果
如果没有完成，get()会阻塞，知道任务完成后才会返回

completable Future
可以传入回调对象
当异步任务完成或发生异常时，自动调用回调对象的回调方式
可以指定异步处理流程

# 21. 
ThreadLocal
表示线程的”局部变量“，确保每个线程的threadLocal变量都是各自独立的
适合在一个thread的处理流程中保持上下文
要用try .. finally
