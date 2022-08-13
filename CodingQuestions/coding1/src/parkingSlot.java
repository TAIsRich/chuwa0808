public class parkingSlot {
    public int row;
    public int col;
    public int level;
    public vehicle vehicleUsingSlot;

    public parkingSlot (int row, int col, int level){
        this.row = row;
        this.col = col;
        this.level = level;
    }

    public void park (vehicle car){
        this.vehicleUsingSlot = car;
    }
}
