public class ParkingLot {
    // fields
    private final Level[] levels;

    // methods
    public ParkingLot(int[][] design) { //the design item will be an input indicating the
        //number of levels, and contains the details of numbers of vehicles info for each level
        int num = design.length;
        levels = new Level[num];
        for (int i = 0; i < num; i++) {
            levels[i] = new Level(i, design[i][1], design[i][2], design[i][3] );
            //design[i][1] through design[i][3] are the busCap, carCap, and motoCap
        }
    }

    public boolean canPark(Vehicle v) {
        for (Level lev : levels) {
            if (lev.canPark(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean goPark(Vehicle v) {
        if (!canPark(v)) return false;
        for (Level lev : levels) {
            if (lev.canPark(v)) {
                lev.goPark(v);
                return true;
            }
        }
        return false;
    }

}
