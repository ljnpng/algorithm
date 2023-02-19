package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class N0105BuildTree {

    private int inx = -1;

    Map<Integer, Integer> valToIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        valToIndex = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int low, int high) {
        if (low > high) return null;
        TreeNode root = new TreeNode(preorder[++inx]);
        int cur = valToIndex.get(preorder[inx]);
        root.left = buildTree(preorder, inorder, low, cur - 1);
        root.right = buildTree(preorder, inorder, cur + 1, high);
        return root;
    }
}
