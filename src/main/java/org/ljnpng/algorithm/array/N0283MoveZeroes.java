package org.ljnpng.algorithm.array;

/**
 * 移动零
 * @see N0027RemoveElement
 */
public class N0283MoveZeroes {

    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        final int ZERO = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != ZERO) {
                nums[slow++] = nums[fast];
            }
        }
        for (; slow < nums.length; slow++) {
            nums[slow] = ZERO;
        }
    }
}
