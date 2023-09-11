package org.ljnpng.algorithm.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class N0373KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<int[]> idx = new PriorityQueue<>(k, (a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
        int n = nums1.length;
        int m = nums2.length;
        for (int i = 0; i < n; i++) {
            idx.offer(new int[]{i, 0});
        }

        while (k-- > 0 && !idx.isEmpty()) {
            int[] cur = idx.poll();
            result.add(List.of(nums1[cur[0]], nums2[cur[1]]));
            if (cur[1] + 1 < m) {
                idx.offer(new int[]{cur[0], cur[1] + 1});
            }
        }
        return result;
    }
}
