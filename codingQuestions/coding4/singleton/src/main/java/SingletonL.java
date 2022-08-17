public class SingletonL {
    private static volatile SingletonL instance;

    private SingletonL(){}

    public static SingletonL getInstance() {
        if (instance == null) {
            synchronized (SingletonL.class) {
                if (instance == null) {
                    instance = new SingletonL();
                }
            }
        }
        return instance;
    }
}
