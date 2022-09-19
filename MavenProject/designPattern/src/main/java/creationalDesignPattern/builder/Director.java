package creationalDesignPattern.builder;

/**
 * @Author: Flora Zhong
 * @ClassName: Director
 * @Description: 指挥者的角色
 * @Date: 8/16/22
 */

public class Director {
    // 声明Builder类型的变量
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    // 构造自行车：organize部件构建的order
    public Bike construct() {
        builder.buildFrame();
        builder.buildSeat();
        return builder.buildBike();
    }
}
