package parkingLot.system;

import parkingLot.parkingSpot.*;
import parkingLot.system.CustomerInfoPanel;
import parkingLot.system.ParkingDisplayBoard;
import parkingLot.vehicle.Vehicle;

import java.util.HashMap;

public class ParkingFloor {
    private String name;
    private HashMap<String, CompactSpot> compactSpots;
    private HashMap<String, LargeSpot> largeSpots;
    private HashMap<String, MotorbikeSpot> motorbikeSpots;
    private HashMap<String, ElectricSpot> electricSpots;
    private HashMap<String, HandicappedSpot> handicappedSpots;
    private HashMap<String, CustomerInfoPanel> infoPortals;
    private int freeCompactSpotCount;
    private int freeLargeSpotCount;
    private int freeMotorbikeSpotCount;
    private int freeElectricSpotCount;
    private int freeHandicappedSpotCount;
    private ParkingDisplayBoard displayBoard;

    public ParkingFloor(String name) {
        this.name = name;
    }

    public int getFreeCompactSpotCount() {
        return freeCompactSpotCount;
    }

    public int getFreeLargeSpotCount() {
        return freeLargeSpotCount;
    }

    public int getFreeMotorbikeSpotCount() {
        return freeMotorbikeSpotCount;
    }

    public int getFreeElectricSpotCount() {
        return freeElectricSpotCount;
    }

    public int getFreeHandicappedSpotCount() {
        return freeHandicappedSpotCount;
    }

    public void addParkingSpot(ParkingSpot spot) {
        switch (spot.getType()) {
            case COMPACT:
                compactSpots.put(spot.getNumber(), (CompactSpot) spot);
                break;
            case LARGE:
                largeSpots.put(spot.getNumber(), (LargeSpot) spot);
                break;
            case MOTORBIKE:
                motorbikeSpots.put(spot.getNumber(), (MotorbikeSpot) spot);
                break;
            case ELECTRIC:
                electricSpots.put(spot.getNumber(), (ElectricSpot) spot);
                break;
            case HANDICAPPED:
                handicappedSpots.put(spot.getNumber(), (HandicappedSpot) spot);
                break;
            default:
                System.out.print("Wrong parking spot type!");
        }
    }

    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
        spot.assignVehicle(vehicle);

        switch (spot.getType()) {
            case COMPACT:
                updateDisplayBoardForCompact(spot);
                break;
            case LARGE:
                updateDisplayBoardForLarge(spot);
                break;
            case MOTORBIKE:
                updateDisplayBoardForMotorbike(spot);
                break;
            case ELECTRIC:
                updateDisplayBoardForElectric(spot);
                break;
            case HANDICAPPED:
                updateDisplayBoardForHandicapped(spot);
                break;
            default:
                System.out.print("Wrong parking spot type!");
        }
    }

    private void updateDisplayBoardForCompact(ParkingSpot spot) {
        if (this.displayBoard.getCompactFreeSpot().getNumber() == spot.getNumber()) {
            // find another free compact parking and assign to displayBoard
            for (String key : compactSpots.keySet()) {
                if (compactSpots.get(key).isFree()) {
                    this.displayBoard.setCompactFreeSpot(compactSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    private void updateDisplayBoardForLarge(ParkingSpot spot) {
        if (this.displayBoard.getLargeFreeSpot().getNumber() == spot.getNumber()) {
            // find another free compact parking and assign to displayBoard
            for (String key : compactSpots.keySet()) {
                if (compactSpots.get(key).isFree()) {
                    this.displayBoard.setLargeFreeSpot(largeSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    private void updateDisplayBoardForMotorbike(ParkingSpot spot) {
        if (this.displayBoard.getMotorbikeFreeSpot().getNumber() == spot.getNumber()) {
            // find another free compact parking and assign to displayBoard
            for (String key : compactSpots.keySet()) {
                if (compactSpots.get(key).isFree()) {
                    this.displayBoard.setMotorbikeFreeSpot(motorbikeSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    private void updateDisplayBoardForElectric(ParkingSpot spot) {
        if (this.displayBoard.getElectricFreeSpot().getNumber() == spot.getNumber()) {
            // find another free compact parking and assign to displayBoard
            for (String key : compactSpots.keySet()) {
                if (compactSpots.get(key).isFree()) {
                    this.displayBoard.setElectricFreeSpot(electricSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    private void updateDisplayBoardForHandicapped(ParkingSpot spot) {
        if (this.displayBoard.getHandicappedFreeSpot().getNumber() == spot.getNumber()) {
            // find another free handicapped parking and assign to displayBoard
            for (String key : handicappedSpots.keySet()) {
                if (handicappedSpots.get(key).isFree()) {
                    this.displayBoard.setHandicappedFreeSpot(handicappedSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    public void freeSpot(Vehicle vehicle, ParkingSpot spot) {
        spot.removeVehicle(vehicle);

        switch (spot.getType()) {
            case COMPACT:
                freeCompactSpotCount++;
                break;
            case LARGE:
                freeLargeSpotCount++;
                break;
            case MOTORBIKE:
                freeMotorbikeSpotCount++;
                break;
            case ELECTRIC:
                freeElectricSpotCount++;
                break;
            case HANDICAPPED:
                freeHandicappedSpotCount++;
                break;
            default:
                System.out.print("Wrong parking spot type!");
        }
    }

    public boolean isFull() {
        return freeCompactSpotCount == 0 && freeLargeSpotCount == 0 && freeMotorbikeSpotCount == 0 && freeElectricSpotCount == 0 && freeHandicappedSpotCount == 0;
    }
}
