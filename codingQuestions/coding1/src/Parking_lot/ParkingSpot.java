package Parking_lot;

public class ParkingSpot {
   private Vehicle vehicle;
   private VehicleSize size;
   private int spotNo;
   private int spotsInclude;


   public ParkingSpot( int spotNo, Vehicle vehicle, int spotsInclude){
        this.spotNo = spotNo;
        this.vehicle = vehicle;
        this.spotsInclude = spotsInclude;

   }
    protected boolean isAvailable(){
       return vehicle == null;
   }

    protected boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getSize() == size;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void setVehicleSize(VehicleSize size){
       this.size = size;
    }

    protected int getSpotNo(){
       return spotNo;
    }
    protected int getSpotsInclude(){return spotsInclude;}


}
