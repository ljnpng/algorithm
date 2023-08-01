package org.ljnpng.algorithm.array;

public class N0058LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int l = 0;
        while (s.charAt(n - 1) == ' ') {
            n--;
        }
        while (l < n && s.charAt(n - 1 - l) != ' ') {
            l++;
        }
        return l;
    }
}