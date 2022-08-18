package SingleTonLoads;

// volatile is needed
// need to secure thread safe
public class Singleton_Lazy {
    private static volatile Singleton_Lazy instance;

    private Singleton_Lazy(){

    }

    public static Singleton_Lazy getInstance(){

        if(instance == null) {
            synchronized (Singleton_Lazy.class) {
                if (instance == null) {
                    instance = new  Singleton_Lazy();
                }
            }
        }
        return instance;
    }
}
