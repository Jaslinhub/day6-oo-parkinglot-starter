package com.afs.parkinglot;

public class UnrecognizedTicketException extends RuntimeException {
    public UnrecognizedTicketException(String s) {
        super(s);
    }
}
