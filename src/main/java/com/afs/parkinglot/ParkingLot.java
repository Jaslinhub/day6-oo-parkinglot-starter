package com.afs.parkinglot;

public class ParkingLot {
    protected int capacity;
    public ParkingLot(int capacity) {
        this.capacity=capacity;
    }

    public Ticket park(Car car) {
        return new Ticket(car);

    }
}
