package EarlyInitialization;

public class Singleton1 {

    private Singleton1() {
    }

    private static Singleton1 instance1;

    static {
        instance1 = new Singleton1();
    }

    public static Singleton1 getInstance() {
        return instance1;
    }
}
