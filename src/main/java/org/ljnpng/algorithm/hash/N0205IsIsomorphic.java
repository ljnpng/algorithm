package org.ljnpng.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

public class N0205IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char value = s.charAt(i);
            char key = t.charAt(i);
            Character c = map.getOrDefault(key, value);
            Character reverse = reverseMap.getOrDefault(value, key);
            if (c != value || reverse != key) {
                return false;
            }
            map.put(key, c);
            reverseMap.put(value, reverse);
        }
        return true;
    }
}
