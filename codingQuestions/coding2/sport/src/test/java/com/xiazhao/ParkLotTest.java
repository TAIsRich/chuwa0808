package com.xiazhao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkLotTest {

    private ParkLot parkLot;

    @BeforeEach
    void setup() {
        parkLot = new ParkLot(3, 5, 20);
    }

    @Test
    void getParkLotSummary() {
        System.out.printf(parkLot.getParkLotSummary());
    }

    @Test
    void park() {
    }

    @Test
    void unPark() {
    }

    @Test
    void isFull() {
    }

    @Test
    void availableSpots() {
    }
}