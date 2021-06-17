package com.minilabs.jacob.inheritence;

public class Main {

    public static void main(String[] args) {
        testInheritence();
    }

    public static void testInheritence() {
        Truck truck = new Truck(8, 25, 1); //polymorphism ex w/ method overloading
        Truck differentTruck = new Truck();
        Vehicle car = new Vehicle(4, 10);

        System.out.println(truck.getSpeed()); // 25
        System.out.println(car.getSpeed()); // 10

        truck.increaseSpeed(15);
        car.increaseSpeed(10);

        System.out.println(truck.getSpeed()); // 30
        System.out.println(car.getSpeed()); // 20
    }
}