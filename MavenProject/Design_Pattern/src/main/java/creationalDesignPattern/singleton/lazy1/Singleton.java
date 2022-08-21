package creationalDesignPattern.singleton.lazy1;

/**
 * @name: Singleton
 * @description: Lazy Load (类加载不会导致该单实例对象被创建，而是首次使用该对象时才会创建) 1: thread-unsafe
 * @author: Flora Zhong
 * @date: 8/16/22
 */

public class Singleton {
    // 声明一个Singleton类型的变量instance
    private static Singleton instance;

    // 私有构造方法
    private Singleton() {
    }

    // 对外提供公共访问方式
    public static Singleton getInstance() {
        // check the variable instance是否为null: 如果为null, 说明还没有创建Singleton类的object, 则需要创建一个并返回；如果不为null, 直接返回
        if (instance == null) {
            // thread 1 gets the execution right of CPU进入到该check里，then stops here and waits
            // 此时thread 1还没有创建一个Singleton object，instance依然为null
            // 那么如果此时thread 2 gets the execution right of CPU也能进入到该check里，并创建一个Singleton object
            // 之后execution right回到thread 1手中，thread 1 wake后也会创建一个Singleton object
            // 这violate the singleton definition
            instance = new Singleton();
        }
        return instance;
    }
}
