package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class N0105BuildTree {

    private Map<Integer, Integer> valToIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        valToIndex = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }

        return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int inx, int[] inorder, int low, int high) {
        if (low > high) {
            return null;
        }
        int val = preorder[inx];
        TreeNode root = new TreeNode(val);
        int cur = valToIndex.get(val);
        int leftLength = cur - low;
        root.left = buildTree(preorder, inx + 1, inorder, low, cur - 1);
        root.right = buildTree(preorder, inx + leftLength + 1, inorder, cur + 1, high);
        return root;
    }

}
