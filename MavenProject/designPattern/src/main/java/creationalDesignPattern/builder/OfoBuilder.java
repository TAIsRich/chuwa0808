package creationalDesignPattern.builder;

/**
 * @Author: Flora Zhong
 * @ClassName: OfoBuilder
 * @Description: 具体构建者的角色，用来构建ofo单车部件
 * @Date: 8/16/22
 */

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("aluminum alloy frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("rubber seat");
    }

    @Override
    public Bike buildBike() {
        return bike;
    }
}
