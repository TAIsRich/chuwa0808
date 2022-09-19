package creationalDesignPattern.factory.simpleFactory;

/**
 * @Author: Flora Zhong
 * @ClassName: SimpleStaticCoffeeFactory
 * @Description: 具体工厂的角色，用来生产咖啡
 * @Date: 8/16/22
 */

public class SimpleStaticCoffeeFactory {
    public static Coffee createCoffee(String type) {
        // 声明咖啡类变量，根据不同的input type创建不同的咖啡子类object
        Coffee coffee = null;

        if (type.equals("Americano")) {
            coffee = new AmericanCoffee();
        }
        else if (type.equals("Latte")) {
            coffee = new LatteCoffee();
        }
        else {
            throw new RuntimeException("Your order type does not exist.");
        }

        return coffee;
    }
}
