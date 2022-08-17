package bike;

public class ofoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("plastic");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("foam");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
