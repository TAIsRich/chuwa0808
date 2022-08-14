public class ParkingSpot {
    private String spotId;
    private int floor;
    private String areaCode;
    private int seqNumber;
    private Vehicle currentVehicle = null;
    private boolean isEmpty;
    
    public void park(Vehicle v){
        this.currentVehicle = v;
        this.isEmpty = true;
    }

    public void releaseParkingSpot(){
        this.currentVehicle = null;
        this.isEmpty = false;
    }

    public String idGetter(){
        return this.spotId;
    }
    public void idSetter(){}
    public void floorSetter(){}
    public int floorGetter(){
        return this.floor;
    }
    public void areaSetter(){}
    public String areaGetter(){
        return this.areaCode;
    }
    public void seqNumSetter(){}
    public int seqNumGetter(){
        return this.seqNumber;
    }
}
