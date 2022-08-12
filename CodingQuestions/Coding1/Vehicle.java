public enum vehicleType { Motorcycle, Compact,Large }

public class Vehicle {
    protected String vehiclePlateNumber;
    protected vehicleType vehicleType;
    protected String color;
    protected String parkingTicketId;
    protected boolean isParked;
    protected ParkingSpot ps;
    private double currentCost;
    private inAndOutRecord entryRecord;
    private inAndOutRecord exitRecord;

    public void createParkingTicket(String id, ParkingSpot ps){
        this.parkingTicketId = id;
        this.ps = ps;
        this.isParked = true;
        this.entryRecord();
    }
    public void releaseParkingTickets(){
        this.currentCost = calculateCost();
        this.ps = null;
        this.isParked = false;
        this.exitRecord();
    }

    public double calculateCost(int pricePerMin){
        double cost = 10.0;
        
        // use this vehicle to get entry time and price per minite, and calculate the price
        // cost = pricePerMin*(this.exitRecord.getTimeStamp() - this.entryRecord.getTimeStamp())
        return cost;
    }

    public void entryRecord(inAndOutRecord entryRecord){
        this.entryRecord = entryRecord;
    }

    public void exitRecord(inAndOutRecord exitRecord){
        this.exitRecord = exitRecord;
    }

    // setter and getter functions

}
