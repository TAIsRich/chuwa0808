package Parking_lot;

public class Motorcycle extends Vehicle{
    public Motorcycle(){
        spotsNeed = 1;
        size = VehicleSize.Motorcycle;
    }

    @Override
    public boolean canFitinSpot(ParkingSpot spot) {
        return spotsNeed <= spot.getSpotsInclude();
    }
}
