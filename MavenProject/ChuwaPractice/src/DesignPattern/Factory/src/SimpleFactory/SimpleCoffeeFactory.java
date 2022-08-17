package SimpleFactory;

public class SimpleCoffeeFactory {

    public coffee createCoffee(String type){
        coffee coffee = null;

        if (type.equals("americano")){
            coffee = new Americano();
        }else if (type.equals("latte")){
            coffee = new LatteCoffee();
        }else {
            throw new RuntimeException("Sorry, no such drink.");
        }

        return coffee;
    }
}
