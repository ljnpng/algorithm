package org.ljnpng.algorithm.sort;

public class QuickSort {

    public static void sort(int[] arr) {
        if (arr == null) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // what's p means in quicksort
    // p is the index of the pivot
    private static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int low = start; // 大于 p 的元素集合 的第一个起点下标
        int pivot = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr, low++, i);
            }
        }
        swap(arr, low, end);
        sort(arr, start, low - 1);
        sort(arr, low + 1, end);
    }

}
