package factory.simple_factory;

public class CoffeeStore {

    public Coffee orderCoffee(String type){

        //现在并不需要依赖具体产品了，实现与具体咖啡类的解耦合

        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.createCoffee(type);

        //add toppings
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
    
}
