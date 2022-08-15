package builder;

public class OfoBuilder extends Builder{
    public void buildFrame() {
        bike.setFrame("lvhejin");
    }

    public void buildSeat() {
        bike.setSeat("xiangjiao");
    }

    public Bike createBike() {
        return bike;
    }
}
