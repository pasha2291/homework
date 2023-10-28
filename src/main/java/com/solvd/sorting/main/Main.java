package com.solvd.sorting.main;

import com.solvd.sorting.bubble_sort.BubbleSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 4, 9, 19, -3, 5, 6};
        BubbleSort.sortArray(array);
        System.out.println(Arrays.toString(array));
    }
}
