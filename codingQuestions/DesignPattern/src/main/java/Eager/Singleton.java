package Eager;

public class Singleton {
    private Singleton(){
        System.out.println("Constructor Called");
    }
    private static final Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }

}
