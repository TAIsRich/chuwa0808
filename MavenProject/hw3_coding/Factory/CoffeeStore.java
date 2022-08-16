package bilbili.coding.Factory;

public class CoffeeStore {

    public Coffee orderCoffee(String type){
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.createCoffee(type);

        coffee.addMilk();
        coffee.addsugar();

        return coffee;
    }
}
