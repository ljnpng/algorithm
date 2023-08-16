package org.ljnpng.algorithm.hash;

import java.util.ArrayList;
import java.util.List;

public class N0049GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            int j = 0;
            for (; j < result.size(); j++) {
                if (isAnagram(result.get(j).get(0), str)) {
                    result.get(j).add(str);
                    break;
                }
            }
            if (j == result.size()) {
                List<String> obj = new ArrayList<>();
                obj.add(str);
                result.add(obj);
            }
        }
        return result;
    }

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
