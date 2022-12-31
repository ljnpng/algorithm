package org.ljnpng.algorithm.array;

public class N0005LongestPalindrome {
    /**
     * 双指针
     * @param s 字符串
     * @return 最大子回文串
     */
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = palindrome(s, i, i);
            int len2 = palindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 从中心向两端找回文串
     * @param s 字符串
     * @param left 左下标 left <= right
     * @param right 右下标
     * @return 回文串长度
     */
    private int palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
