package org.example;

public class Ticket {

    private boolean[] ticketNumber;

    Ticket(int number){
        ticketNumber = new boolean[number];
    }

    //true -> ticket is valid/not pay
    //false -> not a valid ticket/ no such ticket
    private boolean checkTicket(int number){
        return ticketNumber[number];
    }

    public boolean payTicket(int number){
        if(checkTicket(number)){
            ticketNumber[number] = false;
            return true; // ticket pay
        }else{
            return false; //no such ticket
        }
    }

    public boolean addTicket(int number){
        if(!checkTicket(number)){
            ticketNumber[number] = true;
            return true;
        }else{
           return false;
        }
    }

}
