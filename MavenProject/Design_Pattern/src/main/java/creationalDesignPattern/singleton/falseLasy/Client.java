package creationalDesignPattern.singleton.falseLasy;

public class Client {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        // 判断两次获取到的Singleton object是否是同一个object: return false
        System.out.println(instance1 == instance2);
    }
}
