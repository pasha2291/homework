package com.solvd.sorting.bubble_sort;

public class BubbleSort {
    public static void sortArray(int[] array) {
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for(int i = 0; i < array.length - 1; i++) {
                if(array[i] > array[i + 1]) {
                    exchange(array, i, i + 1);
                    isSorted = false;
                }
            }
        }
    }

    private static void exchange(int[] array, int first, int second) {
        int a = array[first];
        array[first] = array[second];
        array[second] = a;
    }
}
