package parkingLotSimpleVersion;

public enum VehicleSize {
    Compact(0),
    Large(1);

    private final int size;
    VehicleSize (int value) {
        size = value;
    }

    public int sizeInt() {
        return size;
    }
}
