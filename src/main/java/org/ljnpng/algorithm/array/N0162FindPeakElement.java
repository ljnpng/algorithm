package org.ljnpng.algorithm.array;

public class N0162FindPeakElement {

    public int findPeakElement(int[] nums) {
        // 处理掉边界先
        if (nums.length <= 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        return binarySearch(nums, 1, nums.length - 2);
    }

    private int binarySearch(int[] nums, int l, int r) {
        if (l > r ) {
            return l;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid - 1] > nums[mid]) {
            return binarySearch(nums, l, mid - 1);
        } else if (nums[mid + 1] > nums[mid]) {
            return binarySearch(nums, mid + 1, r);
        } else {
            return mid;
        }
    }
}
