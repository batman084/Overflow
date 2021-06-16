package com.minilabs.Arnav.LinkedList;
import java.util.*;
import java.util.ArrayList;

public class LinkedList {
    public static void main(String[] args) {

        LinkedList Arnav = new LinkedList();

        Arnav.add("JFK");
        Arnav.add("RFK");
        Arnav.add("Ted Kennedy");
        Arnav.add("Franklin Roosevet");
        printthis(Arnav);
        System.out.println("Wait");
        removeStuff(Arnav, 3, 4);
        System.out.println("Wait");
        printthis(Arnav);


    }

    private void getFirst() {
    }

    private void add(String jfk) {
    }


    private static void removeStuff(LinkedList x, int from, int to) {

        x.subList(from, to);
    }

    private void subList(int from, int to) {
    }

    private static void printthis(LinkedList<String> x) {

        for (String y : x) {
            System.out.printf("%s", y);
            System.out.println();
        }
    }
}
