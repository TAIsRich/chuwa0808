public class ParkingSpot {
    // fields
    private Vehicle cur;
    private final Type type;

    // methods
    public ParkingSpot(Type type) {
        this.type = type;
        cur = null;
    }

    public boolean canPark(Vehicle v) {
        // corner case
        return cur == null && this.type == v.getType();
    }
    public synchronized boolean goPark(Vehicle v) {
        // corner case
        if (canPark(v)) {
            cur = v;
            return true;
        }
        return false;
    }

    public Vehicle leavePark() {
        // corner case
        Vehicle temp = cur;
        cur = null;
        return temp;
    }
}
