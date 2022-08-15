package factory;

public class CoffeeStore {
    private CoffeeFactory cf;
    public void setCoffeeFactory(CoffeeFactory cf){
        this.cf = cf;
    }

    public Coffee orderCoffee(){
        Coffee c = cf.createCoffee();
        return c;
    }
}
