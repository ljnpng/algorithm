package org.ljnpng.algorithm.array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumTest {

    @Test
    public void testNormalCase() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> actual = threeSum.threeSum(nums);

        List<List<Integer>> expected = List.of(
                List.of(-1, -1, 2),
                List.of(-1, 0, 1)
        );

        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyArray() {
        int[] nums = new int[0];
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> actual = threeSum.threeSum(nums);

        List<List<Integer>> expected = List.of();

        assertEquals(expected, actual);
    }

    @Test
    public void testQuickSort() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        threeSum.quickSort(nums);

        int[] expected = new int[]{-4, -1, -1, 0, 1, 2};

        // check element by element
        for (int i = 0; i < nums.length; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }


}