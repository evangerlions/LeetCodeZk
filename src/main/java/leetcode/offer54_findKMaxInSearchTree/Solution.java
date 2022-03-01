package leetcode.offer54_findKMaxInSearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int k;
    int ret = -1;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ret;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.right);

        // pruning
        if (k == 0) {
            return;
        }

        // get target
        if (--k == 0) {
            ret = root.val;
            return;
        }

        dfs(root.left);
    }
}
