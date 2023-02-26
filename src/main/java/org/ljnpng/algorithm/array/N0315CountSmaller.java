package org.ljnpng.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class N0315CountSmaller {

    class Pair {
        int val;
        int id;
        Pair (int val, int id) {
            this.val = val;
            this.id = id;
        }
    }

    Pair[] temp;
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        count = new int[n];
        temp = new Pair[n];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, n - 1);

        ArrayList<Integer> res = new ArrayList<>();
        for (int i : count) {
            res.add(i);
        }
        return res;
    }

    private void mergeSort(Pair[] arr, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private void merge(Pair[] arr, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                arr[k] = temp[j++];
            } else if (j > high) {
                arr[k] = temp[i++];
                count[arr[k].id] += j - mid - 1;
            } else if (temp[i].val <= temp[j].val) {
                arr[k] = temp[i++];
                count[arr[k].id] += j - mid - 1;
            } else {
                arr[k] = temp[j++];
            }
        }
    }
}
