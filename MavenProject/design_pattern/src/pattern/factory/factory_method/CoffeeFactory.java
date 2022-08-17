package pattern.factory.factory_method;

/**
 * @Description: CoffeeFactory： 抽象工厂
 *
 */
public interface CoffeeFactory {
    //创建咖啡对象的方法
    Coffee createCoffee();
}
