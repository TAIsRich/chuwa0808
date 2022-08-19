public class SingletonE {
    private static SingletonE instance = new SingletonE();

    private SingletonE() {
    }

    public static SingletonE getInstance() {
        return instance;
    }
}
