package AbstractFactory;

public class AmericanDessertFactory implements DessertFactory{
    @Override
    public coffee createCoffee() {
        return new Americano();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
