public class ParkingFloor {
    private List<ParkingSpot> listOfParkingSpot;
    private int numberOfFloor;

    public void setlistOfParkingSpot(List<ParkingSpot> listOfParkingSpot){
        this.listOfParkingSpot = listOfParkingSpot;
    }
    public List<ParkingSpot> getlistOfParkingSpot(){
        return this.listOfParkingSpot;
    }

    public void floorSetter(){}
    public int floorGetter(){
        return this.numberOfFloor;
    }
}
