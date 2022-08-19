package bike;

public class MobikeBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("carbon");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("leather");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
