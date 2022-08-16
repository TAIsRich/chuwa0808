package bilbili.coding.SingleTon;

public class SingleTon2 {

    private SingleTon2(){

    }

    private static SingleTon2 instance;

    public static synchronized SingleTon2 getInstance(){
        //single thread lock
        if(instance == null){
            instance = new SingleTon2();
        }

        return instance;
    }

}
