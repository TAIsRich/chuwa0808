package com.xiazhao.spot;

import com.xiazhao.vehicle.Vehicle;

public class Spot {
    private SpotType spotType;
    private Vehicle vehicle;

    public Spot(SpotType spotType) {
        this.spotType = spotType;
    }

    public boolean park(Vehicle vehicle) {
        return false;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }
}
