package org.ljnpng.algorithm.heap;

public class N0215FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        createHeap(nums, n);

        // 删除前k个元素
        int ans = nums[0];
        for (int i = 0; i < k; i++) {
            ans = pop(nums, n - i);
        }
        return ans;
    }

    private int pop(int[] nums, int len) {
        int pop = nums[0];
        swap(nums, 0, len - 1);
        shiftDown(nums, 0, len - 1);
        return pop;
    }


    private void createHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; i--) {
            shiftDown(nums, i, len);
        }
    }

    private void shiftDown(int[] nums, int index, int len) {
        int l = index * 2 + 1; // left child
        int r = index * 2 + 2; // right child

        int largest = index;
        if (l < len && nums[l] > nums[largest]) {
            largest = l;
        }

        if (r < len && nums[r] > nums[largest]) {
            largest = r;
        }

        if (largest != index) {
            swap(nums, index, largest);
            shiftDown(nums, largest, len);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

