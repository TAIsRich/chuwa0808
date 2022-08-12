public abstract class Vehicle {
    protected String name;
    protected String plateNo;
    private final VehicleType type;

    public Vehicle(VehicleType type) {
        this.type = type;
    }
}
