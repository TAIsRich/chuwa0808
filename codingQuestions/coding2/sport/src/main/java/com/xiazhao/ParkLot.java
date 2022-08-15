package com.xiazhao;

import com.xiazhao.spot.CompactSpot;
import com.xiazhao.spot.LargeSpot;
import com.xiazhao.spot.MotorcycleSpot;
import com.xiazhao.spot.Spot;
import com.xiazhao.vehicle.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        size = 0;

        spots = new Spot[LEVEL][][];
        for (int i = 0; i < LEVEL; i++) {
            spots[i] = new Spot[ROW][];
            for (int j = 0; j < ROW; j++) {
                spots[i][j] = new Spot[column];
                int k = 0;
                for (k = 0; k < COLUMN / 4; k++) spots[i][j][k] = new MotorcycleSpot(); // the first quarter is motorcycle spot
                for (; k < COLUMN * 3 / 4; k++) spots[i][j][k] = new CompactSpot(); // the next half is compact spot
                for (; k < COLUMN; k++) spots[i][j][k] = new LargeSpot(); // the last quarter is large spot
            }
        }
    }

    public String getParkLotSummary() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Parking slot with capacity of " + CAPACITY)
                .append("\n  Total level: " + LEVEL)
                .append("\n  Has " + ROW + " rows in each level");

        for (int i = 0; i < LEVEL; i++) {
            int motorcycleSpotCount = 0;
            int compactSpotCount = 0;
            int largeSpotCount = 0;
            for (int j = 0; j < ROW; j++) {
                for (int k = 0; k < COLUMN; k++) {
                    final Spot spot = spots[i][j][k];
                    if (spot instanceof MotorcycleSpot) motorcycleSpotCount++;
                    else if (spot instanceof CompactSpot) compactSpotCount++;
                    else if (spot instanceof LargeSpot) largeSpotCount++;
                }
            }
            sb.append("\n  Level " + (i + 1) + " has " + motorcycleSpotCount + " motorcycle spots, " + compactSpotCount + " compact spots, " + largeSpotCount + " large spots available.");
        }

        return sb.toString();
    }

    public List<Spot> park(Vehicle vehicle) {
        if (vehicle instanceof Motorcycle) return Arrays.asList(parkMotorcycle((Motorcycle) vehicle));
        else if (vehicle instanceof Car) return Arrays.asList(parkCar((Car) vehicle));
        else if (vehicle instanceof Bus) return parkBus((Bus) vehicle);
        else return null;
    }

    private Spot parkMotorcycle(Motorcycle motorcycle) {
        Spot motorcycleSpot = null;
        Spot compactSpot = null;
        Spot largeSpot = null;
        for (int i = 0; i < LEVEL; i++) {
            for (int j = 0; j < ROW; j++) {
                for (int k = 0; k < COLUMN; k++) {
                    if (spots[i][j][k].isAvailable()) {
                        if (spots[i][j][k] instanceof MotorcycleSpot && motorcycleSpot == null) {
                            motorcycleSpot = spots[i][j][k];
                        } else if (spots[i][j][k] instanceof CompactSpot && compactSpot == null) {
                            compactSpot = spots[i][j][k];
                        } else if (spots[i][j][k] instanceof LargeSpot && largeSpot == null) {
                            largeSpot = spots[i][j][k];
                        }
                    }
                }
            }
        }
        if (motorcycleSpot != null) {
            motorcycleSpot.park(motorcycle);
            return motorcycleSpot;
        }
        else if (compactSpot != null) {
            compactSpot.park(motorcycle);
            return compactSpot;
        }
        else if (largeSpot != null) {
            largeSpot.park(motorcycle);
            return largeSpot;
        }
        else return null;
    }

    private Spot parkCar(Car car) {
        Spot compactSpot = null;
        Spot largeSpot = null;
        for (int i = 0; i < LEVEL; i++) {
            for (int j = 0; j < ROW; j++) {
                for (int k = 0; k < COLUMN; k++) {
                    if (spots[i][j][k].isAvailable()) {
                        if (spots[i][j][k] instanceof CompactSpot && compactSpot == null) {
                            compactSpot = spots[i][j][k];
                        } else if (spots[i][j][k] instanceof LargeSpot && largeSpot == null) {
                            largeSpot = spots[i][j][k];
                        }
                    }
                }
            }
        }
        if (compactSpot != null) {
            compactSpot.park(car);
            return compactSpot;
        }
        else if (largeSpot != null) {
            largeSpot.park(car);
            return largeSpot;
        }
        else return null;
    }

    private List<Spot> parkBus(Bus bus) {
        List<Spot> largeSpots = new ArrayList<>();
        for (int i = 0; i < LEVEL; i++) {
            for (int j = 0; j < ROW; j++) {
                for (int k = 0; k < COLUMN; k++) {
                    boolean available = true;
                    if (spots[i][j][k].isAvailable()) {
                        if (spots[i][j][k] instanceof LargeSpot && largeSpots.isEmpty() && k + 5 <= COLUMN) {
                            for (int m = k; i < k + 5; m++) {
                                if (!spots[i][j][m].isAvailable()) {
                                    available = false;
                                    break;
                                } else {
                                    largeSpots.add(spots[i][j][m]);
                                }
                            }
                            if (!available) {
                                largeSpots.clear();
                            }
                        }
                    }
                }
            }
        }
        if (!largeSpots.isEmpty()) {
            for (Spot s : largeSpots) {
                s.park(bus);
            }
            return largeSpots;
        }
        else return null;
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
