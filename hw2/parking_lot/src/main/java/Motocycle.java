public class Motocycle  extends Vehicle{
    public Motocycle(){
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }
    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return false;
    }
}
