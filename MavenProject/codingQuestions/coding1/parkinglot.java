import java.util.HashMap;

public class parkinglot {
    private String name;
    private Location address;
    private ParkingRate parkingRate;
    private int compactSpotCount;
    private int largeSpotCount;
    private int motorbikeSpotCount;
    private int electricSpotCount;
    private final int maxCompactCount;
    private final int maxLargeCount;
    private final int maxMotorbikeCount;
    private final int maxElectricCount;
    private HashMap<String, EntrancePanel> entrancePanels;
    private HashMap<String, ExitPanel> exitPanels;
    private HashMap<String, ParkingFloor> parkingFloors;
    private HashMap<String, ParkingTicket> activeTickets;
    private static ParkingLot parkingLot = null;
    private ParkingLot() {
        //to be initiate
    }
    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }
    public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) throws ParkingFullException {
        if (this.isFull(vehicle.getType())) {
            throw new ParkingFullException();
        }
        ParkingTicket ticket = new ParkingTicket();
        vehicle.assignTicket(ticket);
        ticket.saveInDB();
        this.incrementSpotCount(vehicle.getType());
        this.activeTickets.put(ticket.getTicketNumber(), ticket);
        return ticket;
    }
    public boolean isFull(VehicleType type) {
        if (type == VehicleType.Truck || type == VehicleType.Van) {
            return largeSpotCount >= maxLargeCount;
        }
        if (type == VehicleType.Motorbike) {
            return motorbikeSpotCount >= maxMotorbikeCount;
        }
        if (type == VehicleType.Car) {
            return (compactSpotCount + largeSpotCount) >= (maxCompactCount + maxLargeCount);
        }
        return (compactSpotCount + largeSpotCount + electricSpotCount) >= (maxCompactCount + maxLargeCount
                + maxElectricCount);
    }
    private boolean incrementSpotCount(VehicleType type) {
        if (type == VehicleType.Truck || type == VehicleType.Van) {
            largeSpotCount++;
        } else if (type == VehicleType.Motorbike) {
            motorbikeSpotCount++;
        } else if (type == VehicleType.Car) {
            if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        } else {
            if (electricSpotCount < maxElectricCount) {
                electricSpotCount++;
            } else if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        }
    }
    public boolean isFull() {
        for (String key : parkingFloors.keySet()) {
            if (!parkingFloors.get(key).isFull()) {
                return false;
            }
        }
        return true;
    }
    public void addParkingFloor(ParkingFloor floor) {}
    public void addEntrancePanel(EntrancePanel entrancePanel) {}
    public void addExitPanel(ExitPanel exitPanel) {}
}
    public enum VehicleType {
        CAR, TRUCK, ELECTRIC, VAN, MOTOBIKE
    }
    public enum ParkingSpotType {
        HANDICAPPED, COMPACT, LARGE, MOTORBIKE, ELECTRIC
    }
    public enum AccountStatus {
        ACTIVE, BLOCKED, BANNED, COMPROMISED, ARCHIVED, UNKNOWN
    }
    public enum ParkingTicketStatus {
        ACTIVE, PAID, LOST
    }

    public class Adress {
        private String streetAdress;
        private String city;
        private String state;
        private String zipCode;
        private String country;
    }
    public class Person {
        private String name;
        private Adress address;
        private String email;
        private String phone;
    }
    public abstract class Account{
        private String userName;
        private String password;
        private AccountStatus status;
        private Person person;
        public abstract boolean resetPassword();
    }
    public class Admin extends Account{
        public boolean addParkingFloor(ParkingFloor floor);
        public boolean addParkingSpot(String floorName, ParkingSpot spot);
        public boolean addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayBoard);
        public boolean addCustomerInfoPanel(String floorName, CustomerInfoPanel infoPanel);
        public boolean addEntrancePanel(EntrancePanel entrancePanel);
        public boolean addExitPanel(ExitPanel exitPanel);
        public boolean resetPassword();
    }
    public class ParkingAttendant extends Account {
        public boolean processTicket(String TicketNumber);
        public boolean resetPassword();
    }
    public class ParkingFloor{
        private String name;
        private HashMap<String, HandicappedSpot> handicappedSpots;
        private HashMap<String, CompactSpot> compactSpots;
        private HashMap<String, LargeSpot> largeSpots;
        private HashMap<String, MotorbikeSpot> motorbikeSpots;
        private HashMap<String, ElectricSpot> electricSpots;
        private HashMap<String, CustomerInfoportal> infoPortals;
        private ParkingDisplayBoard displayBoard;

        public  ParkingFloor(String name) {
            this.name = name;
        }
        public void addParkingSpot(ParkingSpot spot) {
            switch (spot.getType()) {
                case ParkingSpotType.HANDICAPPED:
                    handicappedSpots.put(spot.getNumber(), spot);
                    break;
                case ParkingSpotType.COMPACT:
                    compactSpots.put(spot.getNumber(), spot);
                    break;
                case ParkingSpotType.LARGE:
                    largeSpots.put(spot.getNumber(), spot);
                    break;
                case ParkingSpotType.MOTORBIKE:
                    motorbikeSpots.put(spot.getNumber(), spot);
                    break;
                case ParkingSpotType.ELECTRIC:
                    electricSpots.put(spot.getNumber(), spot);
                    break;
                default:
                    System.out.print("wrong type");
            }
        }
        public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
            spot.assignVehicle(vehicle);
            switch (spot.getType()) {
                case ParkingSpotType.HANDICAPPED:
                    updateDisplayBoardForHandicapped(spot);
                    break;
                case ParkingSpotType.COMPACT:
                    updateDisplayBoardForCompact(spot);
                    break;
                case ParkingSpotType.LARGE:
                    updateDisplayBoardForLarge(spot);
                    break;
                case ParkingSpotType.MOTORBIKE:
                    updateDisplayBoardForMotorbike(spot);
                    break;
                case ParkingSpotType.ELECTRIC:
                    updateDisplayBoardForElectric(spot);
                    break;
                default:
                    System.out.print("Wrong parking spot type!");
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
        public void freeSpot(ParkingSpot spot) {
            spot.removeVehicle();
            switch (spot.getType()) {
                case ParkingSpotType.HANDICAPPED:
                    freeHandicappedSpotCount++;
                    break;
                case ParkingSpotType.COMPACT:
                    freeCompactSpotCount++;
                    break;
                case ParkingSpotType.LARGE:
                    freeLargeSpotCount++;
                    break;
                case ParkingSpotType.MOTORBIKE:
                    freeMotorbikeSpotCount++;
                    break;
                case ParkingSpotType.ELECTRIC:
                    freeElectricSpotCount++;
                    break;
                default:
                    System.out.print("Wrong parking spot type!");
            }
        }
    }
    public class ParkingSpot{
        private String number;
        private boolean free;
        private Vehicle vehicle;
        private final ParkingSpotType type;

        public boolean IsFree();
        public ParkingSpot(ParkingSpotType type) {
            this.type = type;
        }

        public boolean assignVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            free = false;
        }
        public boolean removeVehicle() {
            this.vehicle = null;
            free = true;
        }
    }
    public class HandicappedSpot extends ParkingSpot {
        public HandicappedSpot() {
            super(ParkingSpotType.HANDICAPPED);
        }
    }
    public class CompactSpot extends ParkingSpot {
        public CompactSpot() {
            super(ParkingSpotType.COMPACT);
        }
    }
    public class LargeSpot extends ParkingSpot {
        public LargeSpot() {
            super(ParkingSpotType.LARGE);
        }
    }
    public class MotorbikeSpot extends ParkingSpot {
        public MotorbikeSpot() {
            super(ParkingSpotType.MOTORBIKE);
        }
    }
    public class ElectricSpot extends ParkingSpot {
        public ElectricSpot() {
            super(ParkingSpotType.ELECTRIC);
        }
    }
    public class ParkingDisplayBoard{
        private String id;
        private HandicappedSpot handicappedFreeSpot;
        private CompactSpot compactFreeSpot;
        private LargeSpot largeFreeSpot;
        private MotorbikeSpot motorbikeFreeSpot;
        private ElectricSpot electricFreeSpot;
        public void showEmptySpotNumber() {
            String message = "";
            if(handicappedFreeSpot.IsFree()){
                message += "Free Handicapped: " + handicappedFreeSpot.getNumber();
            } else {
                message += "Handicapped is full";
            }
            message += System.lineSeparator();

            if(compactFreeSpot.IsFree()){
                message += "Free Compact: " + compactFreeSpot.getNumber();
            } else {
                message += "Compact is full";
            }
            message += System.lineSeparator();

            if(largeFreeSpot.IsFree()){
                message += "Free Large: " + largeFreeSpot.getNumber();
            } else {
                message += "Large is full";
            }
            message += System.lineSeparator();

            if(motorbikeFreeSpot.IsFree()){
                message += "Free Motorbike: " + motorbikeFreeSpot.getNumber();
            } else {
                message += "Motorbike is full";
            }
            message += System.lineSeparator();

            if(electricFreeSpot.IsFree()){
                message += "Free Electric: " + electricFreeSpot.getNumber();
            } else {
                message += "Electric is full";
            }
            Show(message);
        }
    }
    public abstract class Vehicle {
        private  String licenseNumber;
        private final VehicleType type;
        private ParkingTicket ticket;
        public Vehicle(VehicleType type) {
            this.type = type;
        }
        public void assignTicket(ParkingTicket ticket) {
            this.ticket = ticket;
        }
    }
    public class  Car extends Vehicle {
        public Car() {
            super(VehicleType.CAR);
        }
    }
    public class Van extends Vehicle {
        public Van() {
            super(VehicleType.VAN);
        }
    }
    public class Truck extends Vehicle {
        public Truck() {
            super(VehicleType.TRUCK);
        }
    }
    public class Motorbike extends Vehicle {
        public Motorbike() {
            super(VehicleType.MOTOBIKE);
        }
    }
    public class Electric extends Vehicle {
        public Electric() {
            super(VehicleType.ELECTRIC);
        }
    }
}
