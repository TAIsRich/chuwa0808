import java.util.List;

public class level {
    public int levelNumber;
    public int row;
    public List<parkingSlot> takenSlots;
    public int slotPerRow = 2;

    public parkingSlot findAvailableSpot(){
        int totalNumberSlots = row * slotPerRow;
        if (takenSlots.size() >= totalNumberSlots) return null;
        else if (takenSlots.isEmpty()) return new parkingSlot(0,0,levelNumber);
        else{
            parkingSlot lastCar = takenSlots.get(takenSlots.size()-1);
            if (lastCar.col < slotPerRow){
                return new parkingSlot(lastCar.row, lastCar.col+1, levelNumber);
            }else{
                return new parkingSlot(lastCar.row+1, 0, levelNumber);
            }
        }
    }

    public boolean park(vehicle car){
        parkingSlot freeSpace = findAvailableSpot();
        if (freeSpace == null) return false;
        else{
            freeSpace.park(car);
            takenSlots.add(freeSpace);
            return true;
        }
    }
}
