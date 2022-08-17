package factory;

public class AmericanCoffeeFactory implements CoffeeFactory {

    public Coffee createCoffee() {
        // TODO Auto-generated method stub
        return new AmericanCoffee();
    }
    
}
