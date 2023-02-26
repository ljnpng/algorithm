package org.ljnpng.algorithm.array;

public class N0912SortArray {
    /**
     * merge sort
     * 归并排序
     *
     * @param nums
     * @return
     */
    private int[] temp;
    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortArray(int[] nums, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        sortArray(nums, low, mid);
        sortArray(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }
        int i = low, j = mid + 1, k = low;
        while (i <= mid || j <= high) {
            if (i > mid) {
                nums[k++] = temp[j++];
            } else if (j > high) {
                nums[k++] = temp[i++];
            } else if (temp[i] < temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }
    }
}
