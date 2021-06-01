package com.nighthawk.csa.Minilab.dhruvS.Array;

public class main {

    public static void main(String[] args) {

        int[][] arrInt = { { 1, 2 }, { 3, 4, 5 } };
        for (int i = 0; i < arrInt.length; i++) {
            for (int j = 0; j < arrInt[i].length; j++) {
                System.out.print(arrInt[i][j] + " ");
            }
            System.out.println("");
        }

        int[][] arrMulti = new int[2][];

        arrMulti[0] = new int[2];
        arrMulti[1] = new int[3];

        arrMulti[0][0] = 1;
        arrMulti[0][1] = 2;
        arrMulti[1][0] = 3;
        arrMulti[1][1] = 4;
        arrMulti[1][2] = 5;
        for (int i = 0; i < arrInt.length; i++) {
            for (int j = 0; j < arrInt[i].length; j++) {
                System.out.print(arrInt[i][j] + " ");
            }
            System.out.println("");
        }
    }
}