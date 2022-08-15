package factory.before;

public class CoffeeStore {

    public Coffee orderCoffee(String type){
        //声明coffee类型的变量，根据不同类型创建不同的咖啡子类对象

        Coffee coffee = null;
        if("americano".equals(type)){
            coffee = new AmericanCoffee();
        }else if("latte".equals(type)){
            coffee = new LatteCoffee();
        }else{
            throw new RuntimeException("Sorry, the coffee you ordered is not available");
        }

        //add toppings
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
    
}
