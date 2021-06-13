package com.minilabs.jacob.sorts;

public class Animal {
    private final int legs;
    private final String name;

    public Animal(int legs, String name) {
        this.legs = legs;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getLegs() {
        return this.legs;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.legs + ")";
    }
}