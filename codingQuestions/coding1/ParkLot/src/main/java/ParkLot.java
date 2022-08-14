import com.xiazhao.spot.Spot;
import com.xiazhao.vehicle.Vehicle;

public class ParkLot {
    private final int LEVEL;
    private final int ROW;
    private final int COLUMN;
    private final int CAPACITY;
    private Spot[][][] spots; // Use 3d array to persist the spots, 1d for level, 2d for row, 3d for the spots.
    private int size;


    public ParkLot(int level, int row, int column) {
        LEVEL = level;
        ROW = row;
        COLUMN = column;
        CAPACITY = LEVEL * ROW * COLUMN;
    }

    public String getParkLotSummary() {
        return null;
    }

    public Spot park(Vehicle vehicle) {
        return null;
    }

    public boolean unPark(Spot spot) {
        return false;
    }

    public boolean isFull() {
        return size >= CAPACITY;
    }

    public int availableSpots() {
        return CAPACITY - size;
    }
}
