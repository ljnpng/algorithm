package org.ljnpng.algorithm.array;

import java.util.Arrays;

public class N0274HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;
        for (int i =  n - 1; i >= 0; i--) {
            if (citations[i] <= h) {
                break;
            }
            h++;
        }
        return h;
    }
}
