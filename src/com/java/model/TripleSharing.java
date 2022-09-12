package com.java.model;

public class TripleSharing extends Room{
    TripleSharing(int rent)
    {
        super(3,rent);
    }
    void updateRent(int rent) {
        this.rent=rent;
    }

    @Override
    void updateCapacity(int capacity) {
        this.capacity=capacity;
    }
}
