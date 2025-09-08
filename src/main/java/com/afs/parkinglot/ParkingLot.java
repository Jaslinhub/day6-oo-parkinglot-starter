package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    protected int capacity;
    Map<Ticket,Car> parkCars=new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity=capacity;
    }

    public Ticket park(Car car) {
        if (parkCars.size() >= capacity) {
            throw new IllegalStateException("Unrecognized parking ticket.");
        }
        Ticket ticket=new Ticket();
        parkCars.put(ticket,car);
        return ticket;

    }

    public Car fetch(Ticket carTicket) {
        if(parkCars.containsKey(carTicket))
           return parkCars.remove(carTicket);
        throw new UnrecognizedTicketException("Unrecognized parking ticket.");
    }
}
