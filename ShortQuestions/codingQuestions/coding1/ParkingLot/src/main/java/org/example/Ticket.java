package org.example;

import java.util.Date;

public class Ticket {
    private int tId;
    private String licensePlate;
    private Date inTime;
    private Date outTime;
    private boolean payOrNot;

    public Ticket(int tId, String licensePlate, Date inTime, boolean payOrNot){
        this.tId = tId;
        this.licensePlate = licensePlate;
        this.inTime = inTime;
        this.payOrNot = payOrNot;

    }
}
