package AbstractFactory;

public class ItalianDessertFactory implements DessertFactory{
    @Override
    public coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Tiramisu();
    }
}
