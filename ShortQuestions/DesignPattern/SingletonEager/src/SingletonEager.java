public class SingletonEager {

    private SingletonEager(){
        System.out.println("SingletonEager Constructor Called");
    }
    private static final SingletonEager instance = new SingletonEager();

    public static SingletonEager getInstance(){
        return instance;
    }


}
