package pattern.factory.simple_factory;


public class CoffeeStore {

    public Coffee orderCoffee(String type){
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        //调用方法生成咖啡
        Coffee coffee = factory.createCoffee(type);

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
