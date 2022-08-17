package pattern.singleton.demo1;

public class Client {
    public static void main(String[] args) {
        //创建singleton类的对象
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        //判断两个是否同一个对象
        //true的话就证明这个singleton只能保存一个对象
        System.out.println(instance == instance2);
    }
}
