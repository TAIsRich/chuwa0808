package parkingLot.parkingSpot;

import parkingLot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private String number;
    private boolean free;
    private Vehicle vehicle;
    private final ParkingSpotType type;

    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }
    public ParkingSpotType getType() {
        return type;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicle = null;
        free = true;
    }
    public boolean isFree() {
        return free;
    }
}
