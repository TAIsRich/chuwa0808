package factory.simple_factory;

public class SimpleCoffeeFactory {

    public Coffee createCoffee(String type){

        Coffee coffee = null;
        if("americano".equals(type)){
            coffee = new AmericanCoffee();
        }else if("latte".equals(type)){
            coffee = new LatteCoffee();
        }else{
            throw new RuntimeException("Sorry, the coffee you ordered is not available");
        }

        return coffee;

    }
}
