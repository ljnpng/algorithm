package org.ljnpng.algorithm.array;

public class N0005LongestPalindrome {
    /**
     * 双指针
     * @param s 字符串
     * @return 最大子回文串
     */
    public String longestPalindrome(String s) {
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            longest = longestStr(longest, palindrome(s, i, i), palindrome(s, i, i + 1));
        }
        return longest;
    }

    /**
     * 从中心向两端找回文串
     * @param s 字符串
     * @param left 左下标 left <= right
     * @param right 右下标
     * @return 找到的回文串
     */
    private String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    private String longestStr(String s1, String s2, String s3) {
        String temp = s1.length() >= s2.length() ? s1 : s2;
        return temp.length() >= s3.length() ? temp : s3;
    }

}
