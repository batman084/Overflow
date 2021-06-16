package com.minilabs.Arnav;

import java.util.Scanner;


public class Recursion {
    public static void main(String[] args) {


        Scanner Ob = new Scanner (System.in);

        System.out.println("Enter a number");




        backwards(12);
    }
    public static void backwards(int n) {

        if (n == 0) {

            System.out.println("Is that all you got, come on, you can do better than that");

        } else {
            System.out.println(n);
            n--;

            backwards(n);
        }
    } }
