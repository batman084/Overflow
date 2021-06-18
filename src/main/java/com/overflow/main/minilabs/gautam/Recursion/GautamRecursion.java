package com.overflow.main.minilabs.gautam.Recursion;

public class GautamRecursion {
    public static int gfactorial(int i) {
        if (i == 0) {
            return 1;
        } else if (i == 1) {
            return 1;
        } else {
            return i * gfactorial(i - 1);
        }
    }
}