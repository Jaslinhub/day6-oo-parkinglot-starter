package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_a_car_and_parking_lot(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(100);
        assertNotNull(parkingLot.park(car));
    }

    @Test
    void should_return_parked_car_when_given_a_ticket(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(100);
        Car fetchedCar=parkingLot.fetch(parkingLot.park(car));
        assertNotNull(fetchedCar);
        assertSame(car, fetchedCar);


    }
}
