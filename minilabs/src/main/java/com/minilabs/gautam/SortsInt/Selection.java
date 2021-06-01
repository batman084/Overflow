package com.minilabs.gautam.SortsInt;

public class Selection {
    public int[] sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;//searching for lowest index
                }
            }
            int num1 = arr[index];
            arr[index] = arr[i];
            arr[i] = num1;
        }
        return arr;
    }
}
