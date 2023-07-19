package org.ljnpng.algorithm.array;

/**
 * 移除元素
 *
 * @see N0026RemoveDuplicates
 * @see org.ljnpng.algorithm.linkednode.twopoint.N0083DeleteDuplicates
 */
public class N0027RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[--j];
            } else {
                i++;
            }
        }
        return i;
    }

}
