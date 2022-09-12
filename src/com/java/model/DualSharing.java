package com.java.model;

public class DualSharing extends Room{
    DualSharing(int rent)
    {
        super(2,rent);
    }

    @Override
    void updateRent(int rent) {
        this.rent=rent;
    }

    @Override
    void updateCapacity(int capacity) {
     this.capacity=capacity;
    }
}
