package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class N0889ConstructFromPrePost {

    private Map<Integer, Integer> valToIndex;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        valToIndex = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int lo, int hi, int[] postorder, int low, int high) {
        if (low > high || lo > hi) return null;
        TreeNode root = new TreeNode(preorder[lo]);
        if (++lo > hi) return root;
        int cur = valToIndex.get(preorder[lo]);
        int leftLen = cur - low + 1;
        root.left = build(preorder, lo, lo + leftLen - 1, postorder, low, cur);
        root.right = build(preorder, lo + leftLen, hi, postorder, cur + 1, high);
        return root;
    }
}
