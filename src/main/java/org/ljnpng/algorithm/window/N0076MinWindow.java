package org.ljnpng.algorithm.window;

import java.util.HashMap;
import java.util.Map;

public class N0076MinWindow {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        int left = 0, right = 0;
        char[] chars = t.toCharArray();
        Map<Character, Integer> target = new HashMap<>();
        for (char c : chars) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int matched = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < m) {
            matched = pushOne(s, right, target, matched);
            right++;
            while (matched == n) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                if (len == n) {
                    // Optional: 没有可能比n还小的了,直接退出
                    return s.substring(start, start + len);
                }
                matched = pullOne(s, left, target, matched);
                left++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    private static int pushOne(String s, int index, Map<Character, Integer> target, int matched) {
        char c = s.charAt(index);
        Integer i = target.get(c);
        if (i != null) {
            target.put(c, i - 1);
            if (i >= 1) {
                matched++;
            }
        }
        return matched;
    }

    private static int pullOne(String s, int index, Map<Character, Integer> target, int matched) {
        char c = s.charAt(index);
        Integer i = target.get(c);
        if (i != null) {
            target.put(c, i + 1);
            if (i >= 0) {
                matched--;
            }
        }
        return matched;
    }
}
