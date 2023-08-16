package org.ljnpng.algorithm.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class N0049GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
//                .collect(Collectors.groupingBy(s -> Arrays.stream(s.split("")).sorted().collect(Collectors.joining(""))))
                .collect(Collectors.groupingBy(s -> {
                    char[] chars = s.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }))
                .values());
    }


}
