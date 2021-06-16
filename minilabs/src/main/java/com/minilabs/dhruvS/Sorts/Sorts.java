package com.minilabs.dhruvS.Sorts;

public class Sorts {

    public Sorts(int num1, int num2, int num3, int num4, int num5, int num6) {

    }

    public int[] bubbleSort(int a, int b, int c, int d, int e, int f) {
        int arr[] = {a, b, c, d, e, f};
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        return arr;
    }

    public int[] insertionSort(int a, int b, int c, int d, int e, int f)
    {
        int arr[] = {a, b, c, d, e, f};
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;


            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public int[] selectionSort(int a, int b, int c, int d, int e, int f)
    {
        int arr[] = {a, b, c, d, e, f};
        int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
