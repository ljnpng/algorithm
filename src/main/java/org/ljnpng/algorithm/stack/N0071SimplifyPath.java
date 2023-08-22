package org.ljnpng.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class N0071SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("/");
        int start = 1;
        for (int i = 1; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/' || i == path.length() - 1) {
                String word = path.substring(start, i + 1);
                if (word.equals("../") || word.equals("..")) {
                    if (stack.size() > 1) {
                        stack.pop();
                    }
                } else if (!word.equals("/") && !word.equals("./") && !word.equals(".")) {
                    stack.push(word);
                }
                start = i + 1;
            }
        }
        StringBuilder b = new StringBuilder();
        while (!stack.isEmpty()) {
            b.insert(0, stack.pop());
        }
        if (b.length() > 1 && b.charAt(b.length() - 1) == '/') {
            b.deleteCharAt(b.length() - 1);
        }
        return b.toString();
    }

}
