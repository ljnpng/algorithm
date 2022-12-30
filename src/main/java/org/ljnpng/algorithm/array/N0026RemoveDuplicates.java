package org.ljnpng.algorithm.array;

/**
 * 删除有序数组中的重复项
 */
public class N0026RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int slow,fast;
        for (fast = 1, slow = 0; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
