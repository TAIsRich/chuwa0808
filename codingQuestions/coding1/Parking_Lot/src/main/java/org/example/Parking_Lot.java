package org.example;

public class Parking_Lot {

    Parking_Slot parking_slot;
    Ticket parking_ticket;

    Parking_Lot(int parkingLevel, int LevelCapacity, int total_Capcity){
        parking_slot = new Parking_Slot(parkingLevel, LevelCapacity);
        parking_ticket = new Ticket(total_Capcity);
    }

    public String addCar(int floor, int slotNumber){
        if(parking_slot.addCar(floor, slotNumber)){
            return "Car added to slot";
        }else{
            return "A car is in this slot";
        }
    }

    public String delCar(int floor, int slotNumber){
        if(parking_slot.delCar(floor, slotNumber)){
            return "Car removed to slot";
        }else{
            return "There is no car in this slot";
        }
    }

    public String addTicket(int number){
        if(parking_ticket.addTicket(number)){
            return "ticket added to system";
        }else{
            return "ticket added to system";
        }
    }

    public String delTicket(int number){
        if(parking_ticket.payTicket(number)){
            return "ticket payed";
        }else{
            return "no such ticket";
        }
    }


}