package factory.simple_factory;


public class Client {

    public static void main(String[] args){
        //1. 创建咖啡店类
        CoffeeStore store = new CoffeeStore();
        //2. 点咖啡
        Coffee coffee = store.orderCoffee("latte");

        System.out.println(coffee.getName());

        //需要解耦咖啡店和具体咖啡类
        //如果我们使用工厂来生产对象，则只需要和工厂打交道
    }
}
