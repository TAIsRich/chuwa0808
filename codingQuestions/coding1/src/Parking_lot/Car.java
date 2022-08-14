package Parking_lot;

public class Car extends Vehicle{
    public Car(){
        spotsNeed = 1;
        size = VehicleSize.Compact;
    }

    @Override
    public boolean canFitinSpot(ParkingSpot spot) {
        return spotsNeed <= spot.getSpotsInclude();
    }
}
