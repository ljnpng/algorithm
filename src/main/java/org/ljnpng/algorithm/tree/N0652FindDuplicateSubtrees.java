package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N0652FindDuplicateSubtrees {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    public String dfs(TreeNode root) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",")
                .append(dfs(root.left)).append(",").append(dfs(root.right));
        String key = sb.toString();
        map.put(key, map.getOrDefault(key, 0) + 1);
        if (map.get(key) == 2) {
            ans.add(root);
        }
        return key;
    }
}
