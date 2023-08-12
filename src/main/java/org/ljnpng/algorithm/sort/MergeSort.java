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
        int[] temp = new int[mid - start + 1]; // 优化: 只复制前半部分就行了, 因为安装双子针逐步后移, 会一直满足 k <= j, 也就是 后半部分始终能有空出位置给k
        System.arraycopy(arr, start, temp, 0, temp.length);
        int i = 0, j = mid + 1, k = start;
        while (i < temp.length && j <= end) {
            arr[k++] = temp[i] < arr[j] ? temp[i++] : arr[j++];
        }
        // 剩余的元素
        while (i < temp.length) {
            arr[k++] = temp[i++];
        }
    }
}
