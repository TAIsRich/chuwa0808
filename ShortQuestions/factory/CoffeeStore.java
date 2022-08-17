package factory;

public class CoffeeStore {
    public Coffee orderCoffee(String type){
        Coffee coffee = null;
        if("american".equals(type)) {
            coffee = new AmericanCoffee();
        }else if("latte".equals(type)){
            coffee = new LatteCoffee();
        }else {
            throw new RuntimeException("sry,no order");
        }
         coffee.addMilk();
         coffee.addSugar();
         return coffee;

    }
}
