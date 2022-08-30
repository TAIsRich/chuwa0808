package SimpleFactory;

public class AmericanCoffee extends Coffee {

    @Override
    public void addMilk() { System.out.println("给咖啡加奶"); }

    @Override
    public void addSugar() { System.out.println("给咖啡加糖"); }

    @Override
    public String getName() { return "美式咖啡"; }
}