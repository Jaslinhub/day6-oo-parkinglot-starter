package com.afs.parkinglot;

public class NoAvailablePositionException extends RuntimeException {
    public NoAvailablePositionException(String s) {
        super(s);
    }
}
