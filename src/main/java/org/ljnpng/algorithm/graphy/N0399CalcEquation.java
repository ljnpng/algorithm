package org.ljnpng.algorithm.graphy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N0399CalcEquation {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        UnionFind unionFind = new UnionFind(n * 2);
        Map<String, Integer> dic = new HashMap<>(n * 2);
        int id = 0;
        for (int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            if (!dic.containsKey(a)) {
                dic.put(a, id++);
            }
            if (!dic.containsKey(b)) {
                dic.put(b, id++);
            }
            unionFind.union(dic.get(a), dic.get(b), values[i]);
        }

        // 求解
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> equation = queries.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            if (!dic.containsKey(a) || !dic.containsKey(b)) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(dic.get(a), dic.get(b));
            }
        }
        return res;
    }

    static final class UnionFind {

        private int[] parent;

        private double[] weight;


        UnionFind(int n) {
            parent = new int[n];
            weight = new double[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        void union(int a, int b, double value) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootB != rootA) {
                parent[rootA] = rootB;
                weight[rootA] = weight[b] * value / weight[a];
            }

        }

        int find(int a) {
            if (parent[a] == a) {
                return parent[a];
            }

            // 压缩路径
            int originalParent = parent[a];
            parent[a] = find(parent[a]);
            weight[a] *= weight[originalParent];
            return parent[a];
        }

        double isConnected(int a, int b) {
            if (find(a) == find(b)) {
                return weight[a] / weight[b];
            } else {
                return -1.0d;
            }
        }

    }


}
