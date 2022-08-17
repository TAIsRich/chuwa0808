package pattern.singleton.demo1;

/**
 * @Description:
 *          饿汉式： 静态成员变量
 *
 */
public class Singleton {
    //1. private constructor
    private Singleton(){

    }

    //2. 本类中创建本类对象
    private static Singleton instance = new Singleton();

    //3. 提供一个公共的访问方式，让外界获取该对象
    public static Singleton getInstance(){
        return instance;
    }

}
