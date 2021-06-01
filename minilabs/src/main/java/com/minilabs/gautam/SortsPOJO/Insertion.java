package com.minilabs.gautam.SortsPOJO;

public class Insertion {
    public NameG[] sortArr(NameG[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            NameG key = arr[i];
            int j = i - 1;
            while (j >= 0 && (arr[j].compareTo(key) > 0)) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
