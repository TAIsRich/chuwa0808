package FactoryMethod;

public class AmericanoFactory implements CoffeeFactory{

    @Override
    public coffee createCoffee() {
        return new Americano();
    }
}
