package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    //a parking lot with two parked cars, two tickets to fetch the cars	return each right parked car
    @Test
    void should_return_each_parked_car_when_given_two_tickets(){
        Car car1=new Car();
        Car car2=new Car();
        ParkingLot parkingLot=new ParkingLot(100);
        Ticket ticket1=parkingLot.park(car1);
        Ticket ticket2=parkingLot.park(car2);
        Car fetchedCar1=parkingLot.fetch(ticket1);
        Car fetchedCar2=parkingLot.fetch(ticket2);
        assertNotNull(fetchedCar1);
        assertNotNull(fetchedCar2);
        assertSame(car1, fetchedCar1);
        assertSame(car2, fetchedCar2);

    }
    //a parking lot with a car,no ticket to fetch the car then return nothing
    @Test
    void should_return_nothing_when_no_ticket_given(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(100);
        parkingLot.park(car);
        Car fetchedCar=parkingLot.fetch(null);
        assertSame(null, fetchedCar);
    }
    //a parking lot with a car, a wrong ticket to fetch the car then return error message
    @Test
    void should_return_nothing_when_wrong_ticket_given(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(100);
        parkingLot.park(car);
        Ticket wrongTicket=new Ticket();
        assertThrows(UnrecognizedTicketException.class, () -> {
            parkingLot.fetch(wrongTicket);
        });
    }
    //a parking lot with a car, a used ticket to fetch the car then return error message
    @Test
    void should_return_nothing_when_used_ticket_given(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(100);
        Ticket ticket=parkingLot.park(car);
        parkingLot.fetch(ticket);
        assertThrows(UnrecognizedTicketException.class, () -> {
            parkingLot.fetch(ticket);
        });
    }

    //a parking lot without capacity, a car to park then return error message
    @Test
    void should_return_nothing_when_parking_lot_is_full(){
        Car car1=new Car();
        Car car2=new Car();
        ParkingLot parkingLot=new ParkingLot(1);
        parkingLot.park(car1);
        assertThrows(NoAvailablePositionException.class, () -> {
            parkingLot.park(car2);
        });
    }

}
