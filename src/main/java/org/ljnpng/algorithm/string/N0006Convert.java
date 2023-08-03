package org.ljnpng.algorithm.string;

import java.util.Arrays;

public class N0006Convert {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int inx = 0;
        int n = s.length();
        while (inx < n) {
            int count = 0;
            while (count < numRows) {
                sbs[count++].append(s.charAt(inx++));
                if (inx == n) {
                    return collect(sbs);
                }
            }
            count -= 2;
            while (count > 0) {
                sbs[count--].append(s.charAt(inx++));
                if (inx == n) {
                    return collect(sbs);
                }
            }
        }
        return collect(sbs);
    }

    private String collect(StringBuilder[] sbs) {
        return Arrays.stream(sbs)
                .reduce(StringBuilder::append)
                .map(StringBuilder::toString)
                .orElse("");
    }

}
