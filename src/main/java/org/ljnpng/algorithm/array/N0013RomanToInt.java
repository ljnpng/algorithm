package org.ljnpng.algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class N0013RomanToInt {

    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        Map<String, Integer> sp = new HashMap<>();
        sp.put("IV", 4);
        sp.put("IX", 9);
        sp.put("XL", 40);
        sp.put("XC", 90);
        sp.put("CD", 400);
        sp.put("CM", 900);

        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length) {
                Integer num = sp.get("" + chars[i] + chars[i + 1]);
                if (num != null) {
                    sum += num;
                    i++;
                    continue;
                }
            }
            sum += roman.get(chars[i]);
        }
        return sum;
    }
}
