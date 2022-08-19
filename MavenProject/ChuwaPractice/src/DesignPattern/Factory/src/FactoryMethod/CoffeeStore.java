package FactoryMethod;

import StaticFactory.SimpleCoffeeFactory;

public class CoffeeStore {

    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory){
        this.factory = factory;
    }

    public coffee orderCoffee(){

        coffee coffee = factory.createCoffee();

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
