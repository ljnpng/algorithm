package org.ljnpng.algorithm.array;

public class N0014LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = getCommonPrefix(strs[i], prefix);
            if (prefix.isEmpty()) {
                return "";
            }
        }
        return prefix;
    }

    private String getCommonPrefix(String str1, String str2) {
        int n = Math.min(str1.length(), str2.length());
        int i = 0;
        while (i < n && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return str1.substring(0, i);
    }
}
