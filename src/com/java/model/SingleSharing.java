package com.java.model;

public class SingleSharing extends Room{
    SingleSharing(int rent)
    {
        super(1,rent);
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
