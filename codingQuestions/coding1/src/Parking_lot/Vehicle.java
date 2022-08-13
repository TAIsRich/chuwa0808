package Parking_lot;

public abstract class Vehicle {
    protected String plateNum;
    protected VehicleSize size;
    protected int spotsNeed;
    protected ParkingSpot parkingSpot;

    public int getSpotsNeed(){
        return spotsNeed;
    }

    public VehicleSize getSize(){
        return size;
    }
    public abstract boolean canFitinSpot(ParkingSpot spot);
}
