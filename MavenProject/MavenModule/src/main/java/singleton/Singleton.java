package singleton;

public class Singleton {
    private Singleton(){};
    static Singleton s = new Singleton();

    public static Singleton getInstance(){
        return s;
    }
}
