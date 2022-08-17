package bilbili.coding.SingleTon;

public class SingleTon {

    // private keeps variable private
    private SingleTon() {}

    // creatw own instance within the class
    private static SingleTon instance = new SingleTon();

    //public access method
    public static SingleTon getInstance(){
        return instance;
    }

    //
}
