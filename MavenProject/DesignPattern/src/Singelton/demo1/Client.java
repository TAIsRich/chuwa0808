package Singelton.demo1;

public class Client {

    public static void main(String[] args){

        //创建Singelton类的对象
        Singleton instance = Singleton.getInstance();

        Singleton instance1 = Singleton.getInstance();

        //判断获取的两个是否是同一个对象
        System.out.println(instance == instance1);//true - 获取是同一对象
    }
}
