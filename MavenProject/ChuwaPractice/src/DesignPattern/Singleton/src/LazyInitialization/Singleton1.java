package LazyInitialization;

public class Singleton1 {
    private Singleton1() {}

    private static volatile Singleton instance;

    private static class SignletonHolder{
        private static final Singleton1 INSTANCE = new Singleton1();
    }

    public static Singleton1 getInstance(){
        return SignletonHolder.INSTANCE;
    }
}
