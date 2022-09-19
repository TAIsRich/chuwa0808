package creationalDesignPattern.singleton.lazy1;

import creationalDesignPattern.singleton.eager1.Singleton;

public class Client {
    public static void main(String[] args) {
        // create Singleton objects with Singleton.getInstance()
        creationalDesignPattern.singleton.eager1.Singleton instance1 = creationalDesignPattern.singleton.eager1.Singleton.getInstance();
        creationalDesignPattern.singleton.eager1.Singleton instance2 = Singleton.getInstance();

        // check instance1 and instance2 are the same object or not: true就证明这个singleton只能保存一个对象
        System.out.println(instance1 == instance1);
    }
}
