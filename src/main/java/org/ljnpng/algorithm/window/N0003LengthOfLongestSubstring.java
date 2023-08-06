package org.ljnpng.algorithm.window;

import java.util.HashMap;
import java.util.Map;

public class N0003LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int longest = 0;
        int n = s.length();
        Map<Character, Integer> cur = new HashMap<>();
        while (right < n) {
            Integer i = cur.get(s.charAt(right));
            if (i == null) {
                cur.put(s.charAt(right), right);
                right++;
                longest = Math.max(right - left, longest);
            } else {
                while (left <= i) {
                    cur.remove(s.charAt(left));
                    left++;
                }
                cur.put(s.charAt(right), right);
                right++;
            }
        }
        return longest;
    }
}
