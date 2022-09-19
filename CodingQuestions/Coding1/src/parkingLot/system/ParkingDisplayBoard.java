package parkingLot.system;

import parkingLot.parkingSpot.*;

public class ParkingDisplayBoard {
    private String id;
    private CompactSpot compactFreeSpot;
    private LargeSpot largeFreeSpot;
    private MotorbikeSpot motorbikeFreeSpot;
    private ElectricSpot electricFreeSpot;
    private HandicappedSpot handicappedFreeSpot;

    public ParkingDisplayBoard(String id) {
        this.id = id;
    }

    public CompactSpot getCompactFreeSpot() {
        return compactFreeSpot;
    }

    public void setCompactFreeSpot(CompactSpot compactFreeSpot) {
        this.compactFreeSpot = compactFreeSpot;
    }

    public LargeSpot getLargeFreeSpot() {
        return largeFreeSpot;
    }

    public void setLargeFreeSpot(LargeSpot largeFreeSpot) {
        this.largeFreeSpot = largeFreeSpot;
    }

    public MotorbikeSpot getMotorbikeFreeSpot() {
        return motorbikeFreeSpot;
    }

    public void setMotorbikeFreeSpot(MotorbikeSpot motorbikeFreeSpot) {
        this.motorbikeFreeSpot = motorbikeFreeSpot;
    }

    public ElectricSpot getElectricFreeSpot() {
        return electricFreeSpot;
    }

    public void setElectricFreeSpot(ElectricSpot electricFreeSpot) {
        this.electricFreeSpot = electricFreeSpot;
    }

    public HandicappedSpot getHandicappedFreeSpot() {
        return handicappedFreeSpot;
    }

    public void setHandicappedFreeSpot(HandicappedSpot handicappedFreeSpot) {
        this.handicappedFreeSpot = handicappedFreeSpot;
    }

    public void showEmptySpotNumber() {
        String message = "";

        if(compactFreeSpot.isFree()){
            message += "Free compact: " + compactFreeSpot.getNumber();
        } else {
            message += "Compact is full";
        }
        message += System.lineSeparator();

        if(largeFreeSpot.isFree()){
            message += "Free Large: " + largeFreeSpot.getNumber();
        } else {
            message += "Large is full";
        }
        message += System.lineSeparator();

        if(motorbikeFreeSpot.isFree()){
            message += "Free Motorbike: " + motorbikeFreeSpot.getNumber();
        } else {
            message += "Motorbike is full";
        }
        message += System.lineSeparator();

        if(electricFreeSpot.isFree()){
            message += "Free Electric: " + electricFreeSpot.getNumber();
        } else {
            message += "Electric is full";
        }

        if(compactFreeSpot.isFree()){
            message += "Free Compact: " + compactFreeSpot.getNumber();
        } else {
            message += "Compact is full";
        }
        message += System.lineSeparator();

        System.out.println(message);
    }
}
