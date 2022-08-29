public class Car extends Vehicle{
    public Car(){
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }
    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return false;
    }
}
