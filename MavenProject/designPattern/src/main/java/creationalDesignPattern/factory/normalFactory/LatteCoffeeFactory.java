package creationalDesignPattern.factory.normalFactory;

/**
 * @Author: Flora Zhong
 * @ClassName: LatteCoffeeFactory
 * @Description: 具体工厂的角色，拿铁咖啡工厂，专门用来生产拿铁咖啡
 * @Date: 8/16/22
 */

public class LatteCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
