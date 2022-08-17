package pattern.singleton.demo3;
/**
 * @Description:
 *          懒汉式： 静态成员变量
 *
 */
public class Singleton {
    //1. private constructor
    private Singleton(){}

    //声明singleton类型的变量
    private static Singleton instance;//只是声明，没有赋值

    //对外提供访问方式
    //需要线程1结束，线程2才能进去
    public static synchronized Singleton getInstance(){
        //判断instance是否为null， 如果为null，说明还没有创建singleton类的对象
        //如果没有，创建一个并返回，反之直接返回
        if(instance == null){
            //线程1等待， 线程2获取到cpu的执行权，也会进入到该判断里面
            instance = new Singleton();
        }

        return instance;
    }


}
