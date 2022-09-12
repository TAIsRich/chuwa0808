package parkingLotSimpleVersion;

public class ParkingLot {
    final Level[] levels;

    public ParkingLot(int levelNum, int spotsPerLevel) {
        this.levels = new Level[levelNum];
        for (int i = 0; i < levelNum; i++) {
            this.levels[i] = new Level(spotsPerLevel);
        }
    }

    public boolean hasSpot(Vehicle v) {
        for (Level level : levels) {
            if (level.hasSpot(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean park(Vehicle v) {
        for (Level level : levels) {
            if (level.park(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean leave(Vehicle v) {
        for (Level level : levels) {
            if (level.leave(v)) {
                return true;
            }
        }
        return false;
    }
}
