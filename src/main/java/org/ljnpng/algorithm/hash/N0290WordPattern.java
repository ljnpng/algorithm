package org.ljnpng.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

public class N0290WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (split.length != pattern.length()) {
            return false;
        }
        String[] chars = new String[26];
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            char c = pattern.charAt(i);
            String s1 = split[i];
            if (!map.containsKey(s1) && chars[c - 'a'] == null) {
                chars[c - 'a'] = s1;
                map.put(s1, c);
            } else if (!s1.equals(chars[c - 'a']) || map.get(s1) != c) {
                return false;
            }
        }
        return true;

    }
}
