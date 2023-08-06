package org.ljnpng.algorithm.window;

public class N0003LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int longest = 0;
        int n = s.length();
        while (right < n) {
            char cur = s.charAt(right);
            for (int i = left; i < right; i++) {
                if (s.charAt(i) == cur) {
                    left = i + 1;
                    break;
                }
            }
            right++;
            longest = Math.max(longest, right - left);
        }
        return longest;
    }
}
