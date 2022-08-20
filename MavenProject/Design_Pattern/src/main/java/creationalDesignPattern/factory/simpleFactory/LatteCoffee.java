package creationalDesignPattern.factory.simpleFactory;

/**
 * @Author: Flora Zhong
 * @ClassName: LatteCoffee
 * @Description: 具体产品的角色
 * @Date: 8/16/22
 */

public class LatteCoffee extends Coffee {
    @Override
    public String getName() {
        return "Latte Coffee";
    }
}
