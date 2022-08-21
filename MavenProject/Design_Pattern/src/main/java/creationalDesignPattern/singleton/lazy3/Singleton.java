package creationalDesignPattern.singleton.lazy3;

/**
 * @name: Singleton
 * @description: Lazy Load (类加载不会导致该单实例对象被创建，而是首次使用该对象时才会创建) 3: double-checked locking
 *               double-checked locking是一种非常好的singleton实现模式：singleton, thread-safe, good performance
 *               但在multi-thread时可能会出现null pointer exception, 出现问题的原因是JVM在实例化对象的时候会进行优化和指令重排序操作，要解决这个问题需要对instance使用keyword volatile
 *               volatile makes sure instance这个variable是线程同步的
 * @author: Flora Zhong
 * @date: 8/16/22
 */

public class Singleton {
    // 声明一个Singleton类型的变量instance
    // volatile: the volatile attribute value is always read from and write to the main memory (Random Access Memory) but not the local thread cache.
    // (1) a volatile variable is shared between multiple threads, all reader threads will see the updated value after completing the write operation
    // (2) when a variable is not shared between multiple threads, you do not need to use the volatile keyword, then different reader threads may see different values
    // (3) For example, assume you define a static variable in a class, and two threads are working on the same class, they run on the different processors, then each thread has its local copy.
    //     If one thread modifies its value, there is no change in the original one in the main memory, and the other thread does not see the modified value.
    //     But assume you define a static volatile variable in a class, all read and write will be done in the main memory, the multiple threads will see the same value.
    private static volatile Singleton instance;

    // 私有构造方法
    private Singleton() {
    }

    // 对外提供公共访问方式
    public static Singleton getInstance() {
        // 第一个check: 如果instance不为null, 则不需要抢占锁，而是直接return instance, 这样就improve了performance
        if (instance == null) {
            // 上锁：标记当前类的自解码对象作为需要持有的锁
            // synchronized相当于门，Singleton.class相当于锁，thread要进门、锁门、拿资源，再解锁、出门
            synchronized(Singleton.class) {
                // 第二个check: 拿到锁的那个thread需要再次check instance是否为null, 因为在第一个check后、拿到锁之前，别的thread有可能已经创建了一个Singleton object了
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
