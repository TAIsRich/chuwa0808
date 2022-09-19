package creationalDesignPattern.factory.beforeFactory;

/**
 * @Author: Flora Zhong
 * @ClassName: CoffeeStore
 * @Description: 在Java中万物皆对象，这些对象都需要创建。
 *               如果创建的时候直接new该对象，就会对该对象coupling严重，假如需要更换对象，new对象的地方需要修改一遍，这显然违背了design pattern的open-closed principle.
 *               如果使用工厂来生产对象，只需要和工厂打交道即可，不需要和对象直接打交道，和对象decoupling. 如果要更换对象，直接在工厂里更换该对象即可，达到了和对象decoupling的目的。
 *               factory pattern的最大好处：decoupling
 * @Date: 8/16/22
 */

public class CoffeeStore {
    public Coffee orderCoffee(String type) {
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

        // 加配料
        coffee.addSugar();
        coffee.addMilk();

        return coffee;
    }
}
