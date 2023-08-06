package org.ljnpng.algorithm.window;

import java.util.HashMap;
import java.util.Map;

public class N0003LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int longest = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (right < n) {
            Integer i = map.get(s.charAt(right));
            if (i != null) {
                left = Math.max(i + 1, left); // 有可能重复元素在left 前面
            }
            map.put(s.charAt(right), right); // 重新更新下标
            right++;
            longest = Math.max(longest, right - left);
        }
        return longest;
    }
}
