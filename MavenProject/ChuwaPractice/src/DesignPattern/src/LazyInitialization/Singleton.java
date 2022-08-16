package LazyInitialization;

public class Singleton {
    private Singleton() {}

    private static volatile Singleton instance;

    public static Singleton getInstance(){
        // if without the "if" everytime you use the method, a new instance is created
        if (instance == null) {
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}


