package com.minilabs.Arnav.LinkedList;

import java.util.*;
public class ArnavLinks {
    public static void main(String [] args) {

        String[] Stuff = {"Arnav", "Jacob", "Johnny", "Human", "Albert"};
        List<String> list1 = Arrays.asList(Stuff);
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println(list1);
        Collections.sort(list1, Collections.reverseOrder());
        System.out.printf("%s\n",list1);

    }

}
