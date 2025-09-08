package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ParkingBoyTest {
    @Test
    void should_return_parking_ticket_when_park_given_a_parking_boy_and_a_car(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(100);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        assertNotNull(parkingBoy.park(car));
    }
    @Test
    void should_return_parked_car_when_fetch_given_a_parking(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(100);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        Car fetchedCar=parkingBoy.fetch(parkingBoy.park(car));
        assertNotNull(fetchedCar);
        assertSame(car, fetchedCar);
    }
}
