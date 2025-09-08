package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_a_car_and_parking_lot(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(100);
        /*Ticket ticket=new Ticket();*/
        assertNotNull(parkingLot.park(car));

    }
}
