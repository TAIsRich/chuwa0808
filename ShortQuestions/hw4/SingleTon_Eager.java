package SingleTonLoads;
//eager -> new object is done at compile time
//lazy -> new after function is called
public class SingleTon_Eager {

    private static SingleTon_Eager instance = new SingleTon_Eager();

    private SingleTon_Eager(){

    }

    public static SingleTon_Eager getInstance(){
        return instance;
    }
}
