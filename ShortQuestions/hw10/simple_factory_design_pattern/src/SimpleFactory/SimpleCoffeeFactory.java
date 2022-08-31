package SimpleFactory;

public class SimpleCoffeeFactory {

    public coffee createCoffee(String type){
        coffee coffee = null;

        if(type.equals("Americano")){
            coffee = new Americano();
        }else if(type.equals("Latte")){
            coffee = new Latte();
        }else{
            throw new RuntimeException("Sorry, no such drink");
        }

        return coffee;
    }
}
