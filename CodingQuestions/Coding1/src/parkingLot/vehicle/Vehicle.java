package parkingLot.vehicle;

import parkingLot.parkingTicket.ParkingTicket;
import parkingLotSimpleVersion.VehicleSize;

public abstract class Vehicle {
    private String licenseNumber;
    private final VehicleType type;
    private ParkingTicket ticket;

    public Vehicle(VehicleSize type) {
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public void assignTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
}
