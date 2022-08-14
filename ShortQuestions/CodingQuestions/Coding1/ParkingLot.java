public enum VehicleType{
    CAR, TRUCK, ELECTRIC, VAN, MOTOBIKE
}

public enum ParkingSpotType {
    HANDICAPPED, COMPACT, LARGE, MOTOBIKE, ELECTRIC
}

public enum AccountStatus {
    ACTIVE, BLOCKED, BANNED, COMPROMISED, ACHIVED, UNKNOWN
}

public enum ParkingTicketStatus {
    ACTIVE, PAID, LOST
}

public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}

public class person {
    private String name;
    private Address address;
    private String email;
    private String phone;
}

// For simplicity, we are not defining getter and setter functions. The reader can
// assume that all class attributes are private and accessed through their respective
// public getter methods and modified only through their public methods function.

public abstract class Account {
    private String username;
    
}