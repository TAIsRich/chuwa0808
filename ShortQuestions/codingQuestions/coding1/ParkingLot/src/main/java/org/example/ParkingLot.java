package org.example;

public class ParkingLot {
    private int initialCapacity;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot(int initialCapacity){
        this.initialCapacity = initialCapacity;
        this.capacity = initialCapacity;
    }
}
