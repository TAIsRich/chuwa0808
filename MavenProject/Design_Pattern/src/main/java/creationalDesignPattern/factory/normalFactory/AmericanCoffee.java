package creationalDesignPattern.factory.normalFactory;

/**
 * @Author: Flora Zhong
 * @ClassName: AmericanCoffee
 * @Description: 具体产品的角色
 * @Date: 8/16/22
 */

public class AmericanCoffee extends Coffee {
    @Override
    public String getName() {
        return "American Coffee";
    }
}
