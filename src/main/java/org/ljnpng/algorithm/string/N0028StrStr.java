package org.ljnpng.algorithm.string;

public class N0028StrStr {

    /*
    * kmp 算法
    * */
    public int strStr(String hayStack, String needle) {
        if (needle == null || needle.length() ==0) {
            return 0;
        }
        int i = 0, j = 0;
        int[] lps = getNext(needle);
        while (i < hayStack.length()) {
            if (hayStack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == needle.length()) {
                return i - j;
            } else if (i < hayStack.length() && hayStack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    /**
     * 获取模式串的 next 数组
     * next 数组的含义：next[i] 表示模式串中 [0, i] 这个子串的最长公共前后缀的长度
     * 如：abababca 的 next 数组为 [0, 0, 1, 2, 3, 4, 0, 1]
     * @param needle  模式串
     * @return
     */
    private int[] getNext(String needle) {
        int n = needle.length();
        int len = 0;
        int[] lps = new int[n];
        lps[0] = 0;
        int i = 1;
        while (i < n) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    i++;
                }
            }
        }
        return lps;
    }
}
