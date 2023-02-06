package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N0144PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }
}
