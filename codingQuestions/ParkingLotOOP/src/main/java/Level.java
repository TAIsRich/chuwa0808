public class Level {
    // fields
    private final int floor;
    private final ParkingSpot[] spots;

    // methods
    public Level(int floor, int BusCap, int CarCap, int MotoCap) {
        this.floor = floor;
        spots = new ParkingSpot[BusCap + CarCap + MotoCap];
        for(int i = 0; i < spots.length; i++) {
            if (i < BusCap) {
                spots[i] = new ParkingSpot(Type.BUS);
            }
            else if (i >= BusCap && i < BusCap + CarCap) {
                spots[i] = new ParkingSpot(Type.CAR);
            }
            else {
                spots[i] = new ParkingSpot(Type.MOTO);
            }
        }
    }

    public boolean canPark(Vehicle v) {
        // cc
        for (ParkingSpot spot : spots) {
            if (spot.canPark(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean goPark(Vehicle v) {
        if (!canPark(v)) {
            return false;
        }
        for (ParkingSpot spot: spots) {
            if (spot.canPark(v)) {
                spot.goPark(v);
                return true;
            }
        }
        return false;
    }

    public int numOfAvilableSpot(Vehicle v) {
        int count = 0;
        for (ParkingSpot spot : spots) {
            if (spot.canPark(v)) {
                count++;
            }
        }
        return count;
    }

}
