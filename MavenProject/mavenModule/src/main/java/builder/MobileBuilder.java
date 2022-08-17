package builder;

public class MobileBuilder extends Builder{
    public void buildFrame() {
        bike.setFrame("taihejin");
    }

    public void buildSeat() {
        bike.setSeat("zhenpi");
    }

    public Bike createBike() {
        return bike;
    }
}
