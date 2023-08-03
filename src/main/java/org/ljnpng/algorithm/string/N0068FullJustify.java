package org.ljnpng.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class N0068FullJustify {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        int n = words.length;
        int cur = 0;
        int count = 0;
        List<String> res = new ArrayList<>();
        while (i < n) {
            int space = Math.max(0, count);
            cur += words[i].length();
            if (cur + space < maxWidth) {
                i++; count++;
            } else if (cur + space == maxWidth) {
                res.add(format(words, i, count, maxWidth));
                count = 0;
                i++;
                cur = 0;
            } else {
                res.add(format(words, i - 1, count - 1, maxWidth));
                count = 0;
                cur = 0;
            }
        }

        if (count > 0) {
            StringBuilder sb = new StringBuilder();
            for (int k = i - count; k < n; k++) {
                sb.append(words[k]).append(" ");
            }
            sb.append(" ".repeat(Math.max(0, maxWidth - sb.length())));
            res.add(sb.toString());
        }
        return res;
    }

    private String format(String[] words, int endInclude, int length, int maxWidth) {
        if (length == 0) {
            return words[endInclude] +
                    " ".repeat(Math.max(0, maxWidth - words[endInclude].length()));
        }
        int sum = 0;
        for (int i = endInclude - length; i <= endInclude; i++) {
            sum += words[i].length();
        }

        int space = (maxWidth - sum) / (length);
        int i = (maxWidth - sum) % (length);
        StringBuilder s = new StringBuilder();
        for (int j = endInclude - length; j < endInclude; j++) {
            s.append(words[j]).append(" ".repeat(space));
            if (i > 0) {
                s.append(" ");
                i--;
            }
        }
        s.append(words[endInclude]);
        return s.toString();
    }

}
