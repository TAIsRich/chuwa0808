package creationalDesignPattern.factory.normalFactory;

/**
 * @Author: Flora Zhong
 * @ClassName: AmericanCoffeeFactory
 * @Description: 具体工厂的角色，美式咖啡工厂，专门用来生产美式咖啡
 * @Date: 8/16/22
 */

public class AmericanCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
