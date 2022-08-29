public class Bus extends Vehicle{
    public Bus(){
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return false;
    }
}
