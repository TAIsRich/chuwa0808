package SimpleFactory;

public class CoffeeStore {
    public coffee orderCoffee(String type){

        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();

        coffee coffee = factory.createCoffee(type);

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
