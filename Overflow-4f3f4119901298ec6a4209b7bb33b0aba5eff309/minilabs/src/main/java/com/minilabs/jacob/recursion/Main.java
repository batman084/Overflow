package com.minilabs.jacob.recursion;

import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("What number would you like to select?");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.println(recursiveFactorial(number));
    }

    public static int factorial(int number) {
        int value = number;
        for (int i = 1; i < number; i++) {
            value = i * value;
        }
        return value;
    }

    public static int recursiveFactorial(int number) {
        if (number == 0) {
            return 1;
        }
        else {
            int value = number * recursiveFactorial(number - 1);
            return value;
        }
    }
}