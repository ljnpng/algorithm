package org.ljnpng.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class N0020Isvalid {

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) return false;

        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pair = Map.of(')', '(', ']', '[', '}', '{');
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!pair.containsKey(c)) {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty() || stack.pop() != pair.get(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
