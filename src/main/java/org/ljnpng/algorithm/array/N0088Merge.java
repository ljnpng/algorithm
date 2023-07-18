package org.ljnpng.algorithm.array;

public class N0088Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        System.arraycopy(nums1, 0, tmp, 0, m);
        int i = 0, j = 0, p = 0;
        while (i < m && j < n) {
            if (tmp[i] <= nums2[j]) {
                nums1[p++] = tmp[i++];
            } else {
                nums1[p++] = nums2[j++];
            }
        }
        while (i < m) {
            nums1[p++] = tmp[i++];
        }
        while (j < n) {
            nums1[p++] = nums2[j++];
        }
    }
}
