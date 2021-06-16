package com.minilabs.Arnav;

public class Factorial {
    public static int fact2(int x) {
        int val = x;
        for (int i = x - 1; i > 1; i--) {
            val = val * i;
        }
        return val;
    }

    public static int factorial10() {
        int val = 10;
        for (int i = 9; i > 1; i--) {
            val = val * i;
        }
        return val;
    }

    public static int factorial7() {
        int val = 1;
        for (int i = 2; i < 8; i++) {
            val = val * i;
        }
        return val;
    }
}


