package creationalDesignPattern.singleton.falseLasy;

/**
 * @name: Singleton
 * @description: False Lazy Load (类加载不会导致该单实例对象被创建，而是首次使用该对象时才会创建): call getInstance() once, create a new Singleton object
 * @author: Flora Zhong
 * @date: 8/16/22
 */

public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    // false point: call this method once, create a new Singleton object
    public static Singleton getInstance() {
        instance = new Singleton();
        return instance;
    }
}
