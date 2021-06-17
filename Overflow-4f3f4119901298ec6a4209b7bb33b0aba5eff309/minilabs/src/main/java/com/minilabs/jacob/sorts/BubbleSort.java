package com.minilabs.jacob.sorts;

public class BubbleSort {
    public void sort(int[] data, boolean asc) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if ((data[j] > data[j + 1]) && asc || (data[j] < data[j + 1]) && !asc) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public void sort(String[] data, boolean asc) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if ((data[j].compareTo(data[j + 1]) < 0) && asc || (data[j].compareTo(data[j + 1]) > 0) && !asc) {
                    String temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public void sort(Animal[] data, boolean asc) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if ((data[j].getName().compareTo(data[j + 1].getName()) < 0) && asc || (data[j].getName().compareTo(data[j + 1].getName()) > 0) && !asc) {
                    Animal temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}