package creationalDesignPattern.singleton.eager1;

public class Client {
    public static void main(String[] args) {
        // create Singleton objects with Singleton.getInstance()
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        // check instance1 and instance2 are the same object or not: true就证明这个singleton只能保存一个对象
        System.out.println(instance1 == instance1);
    }
}
