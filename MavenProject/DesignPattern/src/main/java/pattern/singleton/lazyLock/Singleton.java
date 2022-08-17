package pattern.singleton.lazyLock;
/*
lazy -- 没必要每个线程都有锁，我们调整锁的位置就可以了
 */
public class Singleton {
    private Singleton(){

    }
    private static volatile Singleton instance;

    //提供调用方式
    public static Singleton getInstance(){
        //第一次判断，如果不为Null,不需要抢占锁，直接返回对象
        if(instance == null){
            synchronized (Singleton.class){
                //第二次判断
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
