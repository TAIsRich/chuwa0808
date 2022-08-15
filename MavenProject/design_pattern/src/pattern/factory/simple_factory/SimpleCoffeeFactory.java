package pattern.factory.simple_factory;

//优点是将对象创建和业务分开，避免修改客户的代码
//缺点是还是需要修改工厂类的代码，违背了开闭原则
public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type){
        Coffee coffee = null;
        if("americano".equals(type)){
            coffee = new AmericanCoffee();

        }else if("latte".equals(type)){
            coffee = new LatteCoffee();
        }else {
            throw new RuntimeException("Sorry, we dont have the coffee you ordered");
        }


        return coffee;
    }
}
