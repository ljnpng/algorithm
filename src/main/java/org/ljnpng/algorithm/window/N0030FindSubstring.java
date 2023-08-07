package org.ljnpng.algorithm.window;

import java.util.*;
import java.util.stream.Collectors;

public class N0030FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        if (words == null || words.length < 1 || s.length() < words.length * words[0].length()) {
            return Collections.emptyList();
        }

        int n = words[0].length();
        List<Integer> res = new ArrayList<>();
        Set<String> set = Arrays.stream(words).collect(Collectors.toSet());
        for (int i = 0; i < n; i++) {
            int left = i, right = left;
            List<String> collect = Arrays.stream(words).collect(Collectors.toCollection(LinkedList::new));
            while (right <= s.length() - n) {
                String sub1 = s.substring(right, right + n);
                boolean remove = collect.remove(sub1);
                if (remove) {
                    right += n;
                } else if (set.contains(sub1)) {
                    while (left <= right - n) {
                        String sub2 = s.substring(left, left + n);
                        left += n;
                        collect.add(sub2);
                        if (sub2.equals(sub1)) {
                            break;
                        }
                    }
                } else {
                    collect = Arrays.stream(words).collect(Collectors.toCollection(LinkedList::new));
                    right += n;
                    left = right;
                }
                if (right - left == n * words.length) {
                    res.add(left);
                    collect.add(s.substring(left, left + n));
                    left += n;
                }
            }
        }
        return res;
    }

}
