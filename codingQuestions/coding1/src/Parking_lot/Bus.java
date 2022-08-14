package Parking_lot;

public class Bus extends Vehicle{
    public Bus(){
        spotsNeed = 5;
        size = VehicleSize.Large;
    }

    @Override
    public boolean canFitinSpot(ParkingSpot spot) {
        return spotsNeed <= spot.getSpotsInclude();
    }
}
