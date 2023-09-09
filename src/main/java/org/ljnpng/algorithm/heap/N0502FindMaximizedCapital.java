package org.ljnpng.algorithm.heap;

import java.util.*;

public class N0502FindMaximizedCapital {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = capital[i];
            items[i][1] = profits[i];
        }
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.offer(0);
        k++;
        int cur = 0;
        while (k > 0 && !queue.isEmpty()) {
            w += queue.poll();
            k--;
            while (cur < n && items[cur][0] <= w) {
                queue.offer(items[cur][1]);
                cur++;
            }
        }
        return w;
    }
}
