package bilbili.coding.SingleTon;

public class SingleTon3 {

    private SingleTon3(){}

    private static volatile SingleTon3 instance;

    public static SingleTon3 getInstance(){
        //double lock
        if(instance == null){
            synchronized (SingleTon3.class){
                if(instance == null){
                    instance = new SingleTon3();
                }
            }
        }
        return instance;
    }
}
