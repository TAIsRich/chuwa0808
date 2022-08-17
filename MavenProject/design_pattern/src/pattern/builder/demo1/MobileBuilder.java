package pattern.builder.demo1;

//构建摩拜单车对象
public class MobileBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("炭纤维");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("真皮");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
