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
        String result = "";
        int matched = 0;
        while (right < m) {
            matched = pushOne(s, right, target, matched);
            right++;
            while (matched == n) {
                result = tryResetString(result, s.substring(left, right));
                if (result.length() == n) {
                    // Optional: 没有可能比n还小的了,直接退出
                    return result;
                }
                matched = pullOne(s, left, target, matched);
                left++;
            }
        }
        return result;
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

    private String tryResetString(String src, String target) {
        return src.isEmpty() || src.length() >= target.length() ? target : src;
    }
}
