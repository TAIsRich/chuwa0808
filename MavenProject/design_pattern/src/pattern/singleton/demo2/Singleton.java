package pattern.singleton.demo2;
/**
 * @Description:
 *          饿汉式： 静态成员变量
 *
 */
public class Singleton {
    //1. private constructor
    private Singleton(){

    }

    //声明singleton类型的变量
    private static Singleton instance; //null

    //在静态代码块中进行赋值
    static {
        instance = new Singleton();
    }

    //对外提供获取该类对象的方法
    public static Singleton getInstance(){
        return instance;
    }

}
