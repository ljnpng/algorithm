package org.ljnpng.algorithm.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0026RemoveDuplicatesTest {

    private N0026RemoveDuplicates n0026RemoveDuplicates = new N0026RemoveDuplicates();

    @Test
    void testRemoveDuplicates() {
        int[] nums = new int[]{1,2,2,3}; // 输入数组
        int[] expectedNums = new int[]{1,2,3}; // 长度正确的期望答案

        int k = n0026RemoveDuplicates.removeDuplicates(nums); // 调用

        assertEquals(expectedNums.length, k);
        for (int i = 0; i < k; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }

    }

}