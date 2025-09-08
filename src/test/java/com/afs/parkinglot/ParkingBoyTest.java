package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_parking_ticket_when_park_given_a_parking_boy_and_a_car(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(100);
        ParkingBoy parkingBoy=new ParkingBoy(Arrays.asList(parkingLot));
        assertNotNull(parkingBoy.park(car));
    }
    @Test
    void should_return_parked_car_when_fetch_given_a_parking(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(100);
        ParkingBoy parkingBoy=new ParkingBoy(Arrays.asList(parkingLot));
        Car fetchedCar=parkingBoy.fetch(parkingBoy.park(car));
        assertNotNull(fetchedCar);
        assertSame(car, fetchedCar);
    }
    //Given two parked cars, a standard parking boy, and two tickets When fetch the car twice, Then return the right car with each ticket
    @Test
    void should_return_each_parked_car_when_given_two_tickets(){
        Car car1=new Car();
        Car car2=new Car();
        ParkingLot parkingLot=new ParkingLot(100);
        ParkingBoy parkingBoy=new ParkingBoy(Arrays.asList(parkingLot));
        Ticket ticket1=parkingBoy.park(car1);
        Ticket ticket2=parkingBoy.park(car2);
        Car fetchedCar1=parkingBoy.fetch(ticket1);
        Car fetchedCar2=parkingBoy.fetch(ticket2);
        assertNotNull(fetchedCar1);
        assertNotNull(fetchedCar2);
        assertSame(car1, fetchedCar1);
        assertSame(car2, fetchedCar2);
    }
    //Given a parking lot with a parked car, a wrong ticket to fetch the car then return error message
    @Test
    void should_return_nothing_when_wrong_ticket_given(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(100);
        ParkingBoy parkingBoy=new ParkingBoy(Arrays.asList(parkingLot));
        parkingBoy.park(car);
        Ticket wrongTicket=new Ticket();
        assertThrows(UnrecognizedTicketException.class, () -> {
            parkingBoy.fetch(wrongTicket);
        });
    }
    //Given a parking lot with a parked car, a used ticket to fetch the car then return error message
    @Test
    void should_return_nothing_when_used_ticket_given(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(100);
        ParkingBoy parkingBoy=new ParkingBoy(Arrays.asList(parkingLot));
        Ticket usedTicket=parkingBoy.park(car);
        parkingBoy.fetch(usedTicket);
        assertThrows(UnrecognizedTicketException.class, () -> {
            parkingBoy.fetch(usedTicket);
        });
    }
    //a parking lot without capacity, a car to park then return error message
    @Test
    void should_return_nothing_when_parking_lot_is_full(){
        Car car1=new Car();
        Car car2=new Car();
        ParkingLot parkingLot=new ParkingLot(1);
        ParkingBoy parkingBoy=new ParkingBoy(Arrays.asList(parkingLot));
        parkingBoy.park(car1);
        assertThrows(NoAvailablePositionException.class, () -> {
            parkingBoy.park(car2);
        });
    }
    @Test
    void should_park_car_in_first_parking_lot_when_both_parking_lots_have_available_position(){
        Car car=new Car();
        ParkingLot parkingLot1=new ParkingLot(1);
        ParkingLot parkingLot2=new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Ticket ticket=parkingBoy.park(car);
        assertSame(car, parkingBoy.fetch(ticket));
    }
}
