package Parking_lot;

import java.util.ArrayList;

public class ParkingLot {
    private int avaNumofSlots;
    protected ParkingSpot parkingSpot;
    public ParkingLot(int ava, int level){
        this.avaNumofSlots = ava;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    private ArrayList<ParkingSpot> slots = new ArrayList<>(avaNumofSlots);
    public void setParkingSpots(ParkingSpot p){
        slots.add(p);
    }

    public void removeSpot(ParkingSpot p){
        slots.remove(p);
    }
    public boolean isPark(ParkingSpot p){
        return slots.contains(p);
    }


}
