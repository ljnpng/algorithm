package org.ljnpng.algorithm.sort;

public class MergeSort {

    public static void sort(int[] arr) {
        if (arr == null) return;
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        // 左右两边都排好序了, 用双指针
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        // 剩余的元素
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        // 拷贝回原数组
        System.arraycopy(temp, 0, arr, start, temp.length);
    }
}
