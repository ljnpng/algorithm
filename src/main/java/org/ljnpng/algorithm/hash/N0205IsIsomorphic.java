package org.ljnpng.algorithm.hash;

public class N0205IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        // ASCII 字符 只有 128 个
        int[] sChars = new int[128]; // 记录每个字符第一次出现的下标
        int[] tChars = new int[128];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char s_c = s.charAt(i);
            char t_c = t.charAt(i);
            if (sChars[s_c] != tChars[t_c]) {
                return false;
            } else {
                if (sChars[s_c] == 0) {
                    sChars[s_c] = i + 1;
                    tChars[t_c] = i + 1;
                }
            }
        }
        return true;
    }
}
