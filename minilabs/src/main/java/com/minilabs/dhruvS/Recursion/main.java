package com.minilabs.dhruvS.Recursion;

import static com.minilabs.dhruvS.Recursion.Euclid.gcd;

public class main {
    public static void main(String[] args)
    {
        int a = 10, b = 15, g;
        g = gcd(a, b);
        System.out.println("GCD(" + a + ", " + b + ") = " + g);

        a = 35;
        b = 10;
        g = gcd(a, b);
        System.out.println("GCD(" + a + ", " + b + ") = " + g);

        a = 31;
        b = 2;
        g = gcd(a, b);
        System.out.println("GCD(" + a + ", " + b + ") = " + g);
    }
}
