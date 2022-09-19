package creationalDesignPattern.factory.normalFactory;

/**
 * @Author: Flora Zhong
 * @ClassName: CoffeeFactory
 * @Description: 抽象工厂的角色，用来生产咖啡
 * @Date: 8/16/22
 */

public interface CoffeeFactory {
    // 创建咖啡对象的抽象方法
    Coffee createCoffee();
}
