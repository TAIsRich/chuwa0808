package pattern.singleton.lazyThreadSafe;
/*
lazy: thread safe

 */
public class Singleton {
    private Singleton(){

    }
    //声明变量，但没有创建对象
    public static Singleton instance;

    //对外提供访问方式
    public static synchronized Singleton getInstance(){
        //判断instance是否为null，如果为null，那就表明还没有创建
        if(instance == null){
            //线程1等待，线程2进不来
            instance = new Singleton();
        }
        return instance;
    }
}
