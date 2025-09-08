package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    protected int capacity;
    Map<Ticket,Car> parkCars=new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity=capacity;
    }
    public boolean hasAvailablePosition() {
        return parkCars.size() < capacity;
    }
    public Ticket park(Car car){
        if (!hasAvailablePosition()) {
            throw new NoAvailablePositionException("No available position.");
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
