public class SingletonEager {
//    INSTANCE;

    private SingletonEager(){
        System.out.println("SingletonEager Constructor Called");
    }
    //private static final SingletonEager instance = new SingletonEager();
    private static class SingletonHolder{
        private static final SingletonEager INSTANCE = new SingletonEager();
    }

    public static SingletonEager getInstance(){
        return SingletonHolder.INSTANCE;
    }

   /* private static volatile SingletonEager INSTANCE;

    public static SingletonEager getInstance(){
        if(INSTANCE == null){
            synchronized(SingletonEager.class){
                if(INSTANCE == null){
                    INSTANCE = new SingletonEager();

                }
            }

        }
        return INSTANCE;*/
    }


