package org.ljnpng.algorithm.array;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            throw new IllegalArgumentException();
        }
//        Arrays.sort(nums);
        quickSort(nums);
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> head = new HashSet<>();
        for (int p = 0; p < nums.length - 2; p++) {

            if (head.contains(nums[p])) {
                continue;
            }
            head.add(nums[p]);

            int lo = p + 1, hi = nums.length - 1;
            while (lo < hi) {
                int candicate = nums[lo] + nums[hi];
                if (candicate + nums[p] == 0) {
                    result.add(List.of(nums[p], nums[lo], nums[hi]));
                    hi--; lo++;
                } else if (candicate + nums[p] > 0) {
                    hi--;
                } else {
                    lo++;
                }
            }

        }
        return new ArrayList<>(result);
    }

    public void quickSort(int[] nums) {
        internalSort(nums, 0, nums.length - 1);
    }

    private void internalSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivot = partition(nums, lo, hi);
        internalSort(nums, lo, pivot - 1);
        internalSort(nums, pivot + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, hi);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j ) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
