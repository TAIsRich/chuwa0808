package parkingLot.parkingSpot;

import java.time.LocalDateTime;

public class ElectricPanel {
    private LocalDateTime chargingStartTime;
    private int payedForMinutes;

    public boolean cancelCharging() {
        return true;
    }
}
