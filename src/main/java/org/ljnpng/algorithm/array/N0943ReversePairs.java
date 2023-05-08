package org.ljnpng.algorithm.array;

public class N0943ReversePairs {

    private int count;

    private int[] temp;
    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return count;
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) >> 1;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) {
            if ((long) nums[i] > (long) nums[j] * 2) {
                count += mid + 1 - i;
                j++;
            } else {
                i++;
            }
        }

        i = lo;
        j = mid + 1;
        while (i <= mid && j <= hi) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= hi) {
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp, lo, nums, lo, hi - lo +1);
    }
}
