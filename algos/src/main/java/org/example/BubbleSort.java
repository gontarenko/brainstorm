package org.example;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int i2 = i + 1; i2 < arr.length; i2++) {
                int left = arr[i];
                int right = arr[i2];
                if (left > right) {
                    int temp = arr[i];
                    arr[i] = arr[i2];
                    arr[i2] = temp;
                }
            }
        }
    }

}
