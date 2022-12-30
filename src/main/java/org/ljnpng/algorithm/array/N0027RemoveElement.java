package org.ljnpng.algorithm.array;

/**
 * 移除元素
 *
 * @see N0026RemoveDuplicates
 * @see org.ljnpng.algorithm.linkednode.twopoint.N0083DeleteDuplicates
 */
public class N0027RemoveElement {

    public int removeElement(int[] nums, int val) {
        int slow = -1, fast = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }

}
