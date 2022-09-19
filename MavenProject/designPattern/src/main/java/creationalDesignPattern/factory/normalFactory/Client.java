package creationalDesignPattern.factory.normalFactory;

public class Client {
    public static void main(String[] args) {
        // 创建具体工厂对象
        CoffeeFactory factory = new AmericanCoffeeFactory();
        // 将创建的具体工厂对象传参入咖啡店类的constructor, 创建咖啡店对象
        CoffeeStore store = new CoffeeStore(factory);
        // 点咖啡
        Coffee coffee = store.orderCoffee();
        System.out.println(coffee.getName());

        // update CoffeeStore's member variable factory
        CoffeeFactory anotherFactory = new LatteCoffeeFactory();
        store.setFactory(anotherFactory);
        Coffee anotherCoffee = store.orderCoffee();
        System.out.println(anotherCoffee.getName());
    }
}
