package bike;

public abstract class Builder {

    protected Bike  bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract Bike createBike();
}
