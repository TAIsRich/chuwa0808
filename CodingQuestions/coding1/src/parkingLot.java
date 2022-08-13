import java.util.List;

public class parkingLot {
    public List<level> levels;

    public parkingLot(List<level> levels){
        this.levels = levels;
    }

    public boolean park(vehicle car){
        for (level level : levels){
            if (level.park(car)) return true;
        }
        return false;
    }
}
