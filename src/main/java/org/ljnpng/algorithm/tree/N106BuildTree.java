package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class N106BuildTree {
    Map<Integer, Integer> valToInx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        valToInx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valToInx.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int low, int high, int[] postorder, int inx) {
        if (low > high) return null;
        int cur = valToInx.get(postorder[inx]);
        TreeNode root = new TreeNode(postorder[inx]);
        int rightLength = high - cur;
        root.left = buildTree(inorder, low, cur - 1, postorder, inx - rightLength - 1);
        root.right = buildTree(inorder, cur + 1, high, postorder, inx - 1);
        return root;
    }
}
