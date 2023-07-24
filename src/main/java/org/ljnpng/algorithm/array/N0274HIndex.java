package org.ljnpng.algorithm.array;

public class N0274HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] counter = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n) {
                counter[n]++;
            } else {
                counter[citation]++;
            }
        }
        int h = 0;
        int i = n;
        while (i > 0) {
            h += counter[i];
            if (h >= i) {
                return i;
            }
            i--;
        }
        return 0;

    }
}
