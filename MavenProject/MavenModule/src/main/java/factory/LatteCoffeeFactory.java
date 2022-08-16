package factory;

public class LatteCoffeeFactory implements CoffeeFactory {

    public Coffee createCoffee() {
        // TODO Auto-generated method stub
        return new LatteCoffee();
    }
    
}
