package org.ljnpng.algorithm.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0027RemoveElementTest {

    private N0027RemoveElement n0027RemoveElement = new N0027RemoveElement();

    @Test
    void testRemoveElement() {
        int[] nums = new int[]{1,2,2,3}; // 输入数组
        int[] expectedNums = new int[]{1,3}; // 长度正确的期望答案

        int k = n0027RemoveElement.removeElement(nums, 2);

        assertEquals(expectedNums.length, k);
        for (int i = 0; i < k; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

    @Test
    void testRemoveElement_whenEmpty() {
        int[] nums = new int[0];
        assertEquals(0, n0027RemoveElement.removeElement(nums, 9));
    }

}