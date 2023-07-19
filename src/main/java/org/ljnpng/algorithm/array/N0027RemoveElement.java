package org.ljnpng.algorithm.array;

/**
 * 移除元素
 *
 * @see N0026RemoveDuplicates
 * @see org.ljnpng.algorithm.linkednode.twopoint.N0083DeleteDuplicates
 */
public class N0027RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] != val) {
                i++;
            }
            while (i < j && nums[j] == val) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j--];
            }
        }
        return i == j && nums[i] == val ? j : j + 1;
    }

}
