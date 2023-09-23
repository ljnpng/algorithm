package org.ljnpng.algorithm.array;

public class N0035SearchInsert {

    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, 0, nums.length - 1, target);
    }

    private int searchInsert(int[] nums, int l, int r, int target) {
        // 边界, 如果匹配不到
        if (l > r) return l; // l 能大于 r 说明上个递归中的 nums[l] < target
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) return mid;
        return nums[mid] > target
                ? searchInsert(nums, l, mid - 1, target)
                : searchInsert(nums, mid + 1, r, target);
    }
}
