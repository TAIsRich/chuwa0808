package parkingLot.parkingTicket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkingTicket {
    private String number;
    private LocalDateTime issuedAt;
    private LocalDateTime payedAt;
    private double payedAmount;
    private ParkingTicketStatus status;

    public ParkingTicket() {

    }

    public String getNumber() {
        return number;
    }

    public void saveInDB() {

    }
}
