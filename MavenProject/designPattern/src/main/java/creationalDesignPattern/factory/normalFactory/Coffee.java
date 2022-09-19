package creationalDesignPattern.factory.normalFactory;

/**
 * @Author: Flora Zhong
 * @ClassName: Coffee
 * @Description: 抽象产品的角色
 * @Date: 8/16/22
 */

public abstract class Coffee {
    public abstract String getName();

    public void addSugar() {
        System.out.println("Add sugar.");
    }

    public void addMilk() {
        System.out.println("Add milk.");
    }
}
