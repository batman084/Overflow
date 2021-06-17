package com.minilabs.jacob.inheritence;

public class Truck extends Vehicle {
    private int trailer; //this instance variable is not part of the Car class

    public Truck() {
        super(); //accesses constructor of Car class
        trailer = 0; //must give trailer value of 0
    }

    public Truck(int initialWheels, int initialSpeed, int initialTrailer) {
        super(initialWheels, initialSpeed); //executing a constructor with two args, computer goes to bicycle class and gives gear and speed a specific value; super keyowrd in first line
        // can't say gear = startFear becuase gear instance variable is private, subclass doesn't have direct access
        setWheels(initialWheels); //setter and getter accesses private instance variables implicitly
        this.trailer = initialTrailer; //seatHeight not a value of super class and must give value
    }

    public int gSetTrailer() {
        return this.trailer;
    }

    public void setTrailer(int trailer) {
        this.trailer = trailer;
    }

    public void decreaseSpeed(int value) //we have exact same methods in superclass, method overrriding, subclass replacing exisitng method in bicycle class
    {
        setSpeed(getSpeed() - (value / 3));
    }

    public void increaseSpeed(int value) {
        setSpeed(getSpeed() + (value / 3));
    }
}