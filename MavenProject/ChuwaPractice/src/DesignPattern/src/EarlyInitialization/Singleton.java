package EarlyInitialization;

public class Singleton {

    // private constructor
    private Singleton() {}

    // create a private object
    // static make sure that only one object is created
    private static Singleton instance = new Singleton();

    // create a public method for the others to use
    public static Singleton getInstance(){
        return instance;
    }
}

