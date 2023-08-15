package org.ljnpng.algorithm.hash;

public class N0242IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] words = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            words[c - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            char c = t.charAt(i);
            if (words[c - 'a'] == 0) {
                return false;
            }
            words[c - 'a']--;
        }

        return true;
    }
}
