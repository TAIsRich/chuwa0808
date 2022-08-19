package Lazy;

public class Singleton {
    private Singleton(){
        System.out.println("Constructor Called");
    }

    private static volatile Singleton instance;

    public static Singleton getInstance(){
        if(instance == null){ // performance
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
