package parkingLotSimpleVersion;

import parkingLot.parkingSpot.ParkingSpotType;

public abstract class Vehicle {
    final VehicleSize size;

    public Vehicle(VehicleSize size) {
        this.size = size;
    }
    public VehicleSize getSize() {
        return size;
    };
}
