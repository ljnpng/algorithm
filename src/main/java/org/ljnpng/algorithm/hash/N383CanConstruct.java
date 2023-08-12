package org.ljnpng.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

public class N383CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            Integer count = charCount.get(c);
            if (count == null || count < 1) {
                return false;
            }
            charCount.put(c, count - 1);
        }
        return true;
    }
}
