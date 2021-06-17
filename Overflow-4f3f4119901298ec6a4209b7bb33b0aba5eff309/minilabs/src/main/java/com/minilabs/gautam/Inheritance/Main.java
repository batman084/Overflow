package com.minilabs.gautam.Inheritance;

public class Main {
    public static void main (String[] args) {
        Editor mike = new Editor(11, "Tech editor", 80);
        Staffer john = new Staffer("Staffer - Photo", 4);

        System.out.println(mike.getRole() + "'s weekly moto is: " + mike.getWeeklyMoto());
        System.out.println(john.getRole() + " had to do " + john.todo() + " pages");
    }

}
