package pattern.singleton.eagerVariable;


/*
eager: 静态成员变量
 */
public class Singleton {
    //1. private instantiation -- 私有构造方法，外界无法访问
    private Singleton(){

    }

    //2. 因为是private,外界无法通过调用我的constructor去instantiation, 所以我自己内部要建立一个对象
    private static Singleton instance = new Singleton();

    //3. 提供一个公共的访问方式，让外界获取对象
    public static Singleton getInstance(){
        return instance;
    }

}
