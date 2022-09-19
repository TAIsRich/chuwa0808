package creationalDesignPattern.singleton.eager2;

/**
 * @name: Singleton
 * @description: Eager Load (类加载就会导致该单实例对象被创建) 2: declaring a static member variable, and assigning in a static code block
 * @author: Flora Zhong
 * @date: 8/16/22
 */

public class Singleton {
    // declare a private and static variable of Singleton type, which is null by default
    private static Singleton instance;

    // private constructor
    private Singleton() {
    }

    // in a static code block: 在本类中create一个本类对象then assign to the variable
    static {
        instance = new Singleton();
    }

    // 提供一个public, static的访问方式，让外界access这个本类对象: 外界无法create a new object, 只能call a class/static method
    // 既然method是static，variable instance也必须是static，这样static method才能用这个variable
    public static Singleton getInstance() {
        return instance;
    }
}
