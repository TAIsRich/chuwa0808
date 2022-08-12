package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ParkingLot parkingLot = new ParkingLot(100);

        {
            Ticket ticket1 = new Ticket(101, "AB1234", new Date(), true);
            parkingLot.setCapacity(getCapacity() - 1);
        }
    }
}