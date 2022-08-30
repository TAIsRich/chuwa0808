public class Level {
    private int floor;
    private ParkingSpot[ ] spots;
    private int availableSpots = 0; // number of free spots
    private static final int SPOTS_PER_ROW = 10;

    public Level(int flr, int numberSpots){}

    public int availableSpots() { return availableSpots; }

    /* Find a place to park this vehicle. Return false if failed. */
    public boolean parkVehicle(Vehicle vehicle){
        return false;
    }

    /* Park a vehicle starting at the spot spotNumber, and continuing until vehicle.spotsNeeded. */
    private boolean parkStartingAtSpot(int num, Vehicle v) {
        return false;
    }

    private int findAvailableSpots(Vehicle vehicle){
        return -1;
    }

    public void spotFreed() { availableSpots++; }
}
