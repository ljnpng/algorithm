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

        while (right < m) {
            char c = s.charAt(right);
            target.computeIfPresent(c, (ch, i) -> i - 1);
            right++;
            while (right - left >= n && matched(target)) {
                result = tryResetString(result, s.substring(left, right));
                target.computeIfPresent(s.charAt(left), (ch, i) -> i + 1);
                left++;
            }
        }
        return result;
    }

    private boolean matched(Map<Character, Integer> target) {
        return target.values().stream().allMatch(i -> i <= 0);
    }

    private String tryResetString(String src, String target) {
        return src.length() == 0 || src.length() >= target.length() ? target : src;
    }
}
