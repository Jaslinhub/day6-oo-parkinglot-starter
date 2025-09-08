package com.afs.parkinglot;

import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
    public Ticket park(Car car){
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasAvailablePosition()) {
                    return parkingLot.park(car);
            }
        }
        throw new NoAvailablePositionException("No available position.");
    }
    public Car fetch(Ticket ticket) {
        return parkingLots.stream()
                .map(parkingLot -> parkingLot.fetch(ticket))
                .filter(car -> car != null)
                .findFirst()
                .orElseThrow(() -> new UnrecognizedTicketException("Unrecognized parking ticket."));
    }

}
