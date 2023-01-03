package org.ljnpng.algorithm.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class N0151ReverseWords {

    /**
     * 也算是api + 双指针reverse
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        List<String> collect = Arrays.stream(s.trim().split(" "))
                .map(String::trim)
                .filter(s1 -> s1.length() > 0)
                .collect(Collectors.toList());

        int left = 0, right = collect.size() - 1;
        while (left < right) {
            String tmp = collect.get(left);
            collect.set(left, collect.get(right));
            collect.set(right, tmp);
            left++;
            right--;
        }

        return String.join(" ", collect);
    }

    /**
     * 倒叙后 直接翻转单个单词
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (word.length() == 0) {
                    continue;
                } else {
                    res.append(word.reverse()).append(" ");
                    word = new StringBuilder();
                }
            } else {
                word.append(s.charAt(i));
            }
        }

        return res.append(word.reverse()).toString();
    }

    /**
     * API 调用
     * @param s
     * @return
     */
    public String reverseWords3(String s) {
        s = s.trim();
        List<String> strings = Arrays.asList(s.split("\\s+"));
        Collections.reverse(strings);
        return String.join(" ", strings);
    }


}
