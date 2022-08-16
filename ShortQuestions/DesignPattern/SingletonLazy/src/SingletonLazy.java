public class SingletonLazy {

    private SingletonLazy(){
        System.out.println("SingletonLazy Constructor Called");
    }

    private static volatile SingletonLazy instance;

    public static SingletonLazy getInstance(){
        if(instance == null){
            synchronized (SingletonLazy.class){
                if(instance == null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

}
