package org.ljnpng.algorithm.bfs;

import java.util.*;

public class N0433MinMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> genes = new HashSet<>(bank.length);
        genes.addAll(Arrays.asList(bank));
        if (!genes.contains(endGene)) {
            return -1;
        }

        // 优化点
        // 可以使用领个visited数组 记录已经访问过的节点

        Queue<String> queue = new java.util.LinkedList<>();
        queue.offer(startGene);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.poll();
                if (gene.equals(endGene)) {
                    return step;
                }
                Iterator<String> iterator = genes.iterator();
                while (iterator.hasNext()) {
                    String s = iterator.next();
                    if (isMutation(gene, s)) {
                        queue.offer(s);
                        iterator.remove();
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private boolean isMutation(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

}
