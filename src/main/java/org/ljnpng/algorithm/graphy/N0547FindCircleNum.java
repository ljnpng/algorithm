package org.ljnpng.algorithm.graphy;

public class N0547FindCircleNum {

    private int[] parent;
    private int provinces;

    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        provinces = cities;

        // 一开始 每个节点都算作独立的个体, parent 都是自己
        parent = new int[cities];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        // 遍历节点, 同时根据条件对能合并的节点进行 union
        // 这道题能合并的条件是 isConnected[i][j] = 1

        for (int i = 0; i < cities; i++) {
            for (int j = i + 1; j < cities; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        return provinces;
    }

    private void union(int i, int j) {
        int rootX = find(i);
        int rootY = find(j);

        if (rootX != rootY) {
            // 还没有进行合并, 现在开始合并
            provinces--;
            parent[rootX] = parent[rootY];  // 这里 y 作为根节点 是因为 上面遍历的时候 y是后面新加入的节点, 而x已经是根节点了
        }
    }

    private int find(int i) {
        if (parent[i] == i) {
            // 如果不相等就一直往上找根节点
            return parent[i];
        }
        parent[i] = find(parent[i]); // 压缩路径
        return find(parent[i]);
    }


}
