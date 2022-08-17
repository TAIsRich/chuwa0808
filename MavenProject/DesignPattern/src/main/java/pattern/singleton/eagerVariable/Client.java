package pattern.singleton.eagerVariable;

public class Client {
    public static void main(String[] args){
        //创建singleton类的对象
        Singleton instance = Singleton.getInstance();

        Singleton instance1 = Singleton.getInstance();

        System.out.println(instance == instance1);
    }

}
