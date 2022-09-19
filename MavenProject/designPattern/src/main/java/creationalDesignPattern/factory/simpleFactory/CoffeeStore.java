package creationalDesignPattern.factory.simpleFactory;

/**
 * @Author: Flora Zhong
 * @ClassName: CoffeeStore
 * @Description: 抽象产品(Coffee)：定义了产品的规范，描述了产品的主要特性和功能
 *               具体产品(AmericanCoffee or LatteCoffee)：实现或者继承抽象产品的子类
 *               具体工厂(SimpleCoffeeFactory)：提供了创建产品的方法，调用者通过该方法来获取产品
 *
 *               这里decouple了CoffeeStore和具体产品对象之间的dependency: 不用new AmericanCoffee() or new LatteCoffee() in CoffeeStore class了
 *               但产生了新的couplings between CoffeeStore and SimpleCoffeeFactory对象，between SimpleCoffeeFactory and 产品对象：再加新品种的咖啡，势必要求修改SimpleCoffeeFactory中的code, 违反了open-closed principle
 *
 *               优点：封装了创建对象的过程，可通过参数直接获取对象；把对象的创建和业务逻辑层分开，这样以后要实现新产品直接修改工厂类、而不需修改客户(CoffeeStore)代码，降低修改客户代码的可能性就使得客户更容易扩展
 *               缺点：增加新产品时还需要修改工厂类的代码，违背了open-closed principle
 * @Date: 8/16/22
 */

public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        // 声明简单工厂类变量
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        // 调用生产咖啡的方法来根据不同的input type创建不同的咖啡子类object
        Coffee coffee1 = factory.createCoffee(type);

        // 调用简单静态类工厂类的生产咖啡方法来根据不同的input type创建不同的咖啡子类object
        // Coffee coffee2 = SimpleStaticCoffeeFactory.createCoffee(type);

        // 加配料
        coffee1.addSugar();
        coffee1.addMilk();

        // coffee2.addSugar();
        // coffee2.addMilk();

        return coffee1;
        // return coffee2;
    }
}
