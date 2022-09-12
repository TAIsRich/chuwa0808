package parkingLot.payment;

import java.time.LocalDate;

public class Payment {
    private LocalDate creationDate;
    private double amount;
    private PaymentStatus status;

    public boolean initiateTransaction() {
        return true;
    }
}
