package singletondemo1;

public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        //判断是否是同一个对象
        System.out.println(instance == instance1);
    }
}
