package com.minilabs.jacob.sorts;

public class InsertionSort {
    public void sort(int[] data, boolean asc) {
        for (int i = 0; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;
            while ((j >= 0) && ((asc && data[j] > key) || (!asc && data[j] < key))) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
    }

    public void sort(String[] data, boolean asc) {

        for (int i = 0; i < data.length; i++) {
            String key = data[i];
            int j = i - 1;
            while (((j >= 0) && ((!asc) && (data[j].compareTo(key) > 0))) || (((j >= 0)) && ((asc) && (data[j].compareTo(key) < 0)))) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
    }

    public void sort(Animal[] data, boolean asc) {
        for (int i = 0; i < data.length; i++) {
            Animal key = data[i];
            int j = i - 1;
            while (((j >= 0) && ((!asc) && (data[j].getName().compareTo(key.getName()) > 0))) || (((j >= 0)) && ((asc) && (data[j].getName().compareTo(key.getName()) < 0)))) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
    }
}