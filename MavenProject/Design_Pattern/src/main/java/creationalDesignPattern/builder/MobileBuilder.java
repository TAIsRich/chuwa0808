package creationalDesignPattern.builder;

/**
 * @Author: Flora Zhong
 * @ClassName: MobileBuilder
 * @Description: 具体构建者的角色，用来构建摩拜单车部件
 * @Date: 8/16/22
 */

public class MobileBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("carbon fiber frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("leather seat");
    }

    @Override
    public Bike buildBike() {
        return bike;
    }
}
