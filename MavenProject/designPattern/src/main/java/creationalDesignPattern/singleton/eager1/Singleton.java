package creationalDesignPattern.singleton.eager1;

/**
 * @name: Singleton
 * @description: Eager Load (类加载就会导致该单实例对象被创建) 1: declaring and assigning a static member variable at the same time
 * @author: Flora Zhong
 * @date: 8/16/22
 */

public class Singleton {
    // 在本类中create一个本类对象then assign to a private and static variable of Singleton type
    private static Singleton instance = new Singleton();

    // private constructor: 外界无法access this constructor, 就无法create a new object
    private Singleton() {
    }

    // 提供一个public, static的访问方式，让外界access这个本类对象: 外界无法create a new object, 只能call a class/static method
    // 既然method是static，variable instance也必须是static，这样static method才能用这个variable
    public static Singleton getInstance() {
        return instance;
    }

    /*
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        instance = new Singleton();
        return instance;
    }
    */
}
