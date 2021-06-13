package com.minilabs.jacob.sorts;

public class SelectionSort {
    public void sort(int[] data, boolean asc) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if ((data[j] < data[minIndex]) && asc || (data[j] > data[minIndex]) && !asc) {
                    int temp = data[minIndex];
                    data[minIndex] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

    public void sort(String[] data, boolean asc) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (((asc) && (data[j].compareTo(data[minIndex]) < 0)) || ((data[j].compareTo(data[minIndex]) > 0) && (!asc))) {
                    String temp = data[minIndex];
                    data[minIndex] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

    public void sort(Animal[] data, boolean asc) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (((asc) && (data[j].getName().compareTo(data[minIndex].getName()) < 0)) || ((data[j].getName().compareTo(data[minIndex].getName()) > 0) && (!asc))) {
                    Animal temp = data[minIndex];
                    data[minIndex] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
}