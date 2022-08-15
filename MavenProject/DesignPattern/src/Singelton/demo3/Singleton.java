package Singelton.demo3;

//懒汉式：线程不安全

public class Singleton {

    //私有构造方法
    private Singleton(){}

    //声明Singleton类型的变量instance
    private static Singleton instance;//只是声明了该类型的变量而未进行赋值

    //对外提供访问方式
    public static synchronized Singleton getInstance(){//懒汉式：第一次使用时才会创建, 加锁使线程安全

        if(instance == null){ //没有创建才需要去new，涉及多线程concern
            //线程1等待，线程2获取到cpu的执行权，也会进入到该判断里
            instance = new Singleton();
        }

        return instance;
    }
}
