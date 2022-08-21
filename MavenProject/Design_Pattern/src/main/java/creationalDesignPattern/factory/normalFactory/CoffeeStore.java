package creationalDesignPattern.factory.normalFactory;

import creationalDesignPattern.factory.simpleFactory.SimpleCoffeeFactory;

/**
 * @Author: Flora Zhong
 * @ClassName: CoffeeStore
 * @Description: 定义一个用于创建工厂对象的接口，让子类决定实例化哪个产品类对象，使得一个产品类的实例化延迟到其子类工厂
 *               抽象工厂(CoffeeFactory)：提供了创建产品的接口，或者通过它访问具体工厂的方法来创建产品
 *               具体工厂(AmericanCoffeeFactory or LatteCoffeeFactory)：主要是实现抽象工厂中的抽象方法，完成具体产品的创建
 *               抽象产品(Coffee)：定义了产品的规范，描述了产品的主要特性和功能
 *               具体产品(AmericanCoffee or LatteCoffee)：实现了抽象产品角色所定义的接口，由具体工厂来创建，它与具体工厂之间一一对应
 *
 *               要增加产品类时只要相应地增加工厂类，而不需修改工厂类的代码，这样就解决了简单工厂模式的缺点，工厂模式是简单工厂模式的进一步抽象
 *
 *               优点：用户只需要知道具体工厂的名称就可得到所需的产品，无需知道产品的具体创建过程；系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无需对原工厂进行任何修改，满足open-closed principle
 *               缺点：每增加一个新产品就要增加一个具体产品类和一个对应的具体工厂类，增加了系统的复杂度
 * @Date: 8/16/22
 */

public class CoffeeStore {
    private CoffeeFactory factory;

    public CoffeeStore(CoffeeFactory factory) {
        this.factory = factory;
    }

    // avoid了前面提到的在constructor里进行CoffeeStore和CoffeeFactory object的coupling: this.factory = new CoffeeFactory()
    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    // 点咖啡
    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();

        // 加配料
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
