package org.ljnpng.algorithm.array;

/**
 * 删除有序数组中的重复项
 *
 * 相似题目，删除排序链表中的重复元素
 * @see org.ljnpng.algorithm.linkednode.twopoint.N0083DeleteDuplicates
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
