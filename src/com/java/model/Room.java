package com.java.model;

import java.sql.SQLOutput;
import java.util.Scanner;

 public abstract class Room {

     public int capacity;
    public int rent;
    public int occupiedBy;
    public Room()
    {

    }
   public Room(int cap,int rent)
    {
        capacity=cap;
        this.rent=rent;
    }
    abstract void updateRent(int rent);
    abstract void updateCapacity(int capacity);
    public void maintainanceCall()
    {
        System.out.println("Calling Maintainance...They will come soon");
    }
}
