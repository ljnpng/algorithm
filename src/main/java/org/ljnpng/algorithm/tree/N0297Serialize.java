package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0297Serialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        sb.append(serialize(root.left)).append(",");
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    private int i = 0;
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        return deserialize(split);
    }

    private TreeNode deserialize(String[] split) {
        if (i > split.length || split[i].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(split[i]));
        i++;
        root.left = deserialize(split);
        i++;
        root.right = deserialize(split);
        return root;
    }
}
