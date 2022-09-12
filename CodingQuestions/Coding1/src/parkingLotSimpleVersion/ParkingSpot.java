package parkingLotSimpleVersion;

public class ParkingSpot {
    public final int index;
    private Vehicle vehicle;
    final VehicleSize size;

    public ParkingSpot(VehicleSize size, Vehicle v, int index) {
        this.index = index;
        this.size = size;
        vehicle = v;
    }

    public boolean fit(Vehicle v) {
        if (v.getSize().sizeInt() <= this.size.sizeInt()) {
            return true;
        }
        return false;
    }

    public void park(Vehicle v) {
        vehicle = v;
    }

    public void leave() {
        vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
