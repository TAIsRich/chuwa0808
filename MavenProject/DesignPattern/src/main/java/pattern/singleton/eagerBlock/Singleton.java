package pattern.singleton.eagerBlock;
/*
eager: 静态代码块
 */
public class Singleton {
    private Singleton(){

    }

    //声明一个该类的成员变量，不赋值
    private static Singleton instance;          //没有赋值，是null

    //在静态代码块中赋值
    static {
        instance = new Singleton();
    }

    //对外提供获取对象的方法
    public static Singleton getInstance(){
        return instance;
    }
}
