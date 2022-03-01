package leetcode.offer54_findKMaxInSearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class Solution_Simple {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



    // 朴素解
    public int kthLargestSimple(TreeNode root, int k) {
        List<Integer> ret = new ArrayList<>();
        inOrderTraverse(root, 0, ret);
        return ret.get(ret.size() - k);
    }

    public void inOrderTraverse(TreeNode root, int k, List<Integer> ret) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inOrderTraverse(root.left, k, ret);
        }

        ret.add(root.val);

        if (root.right != null) {
            inOrderTraverse(root.right, k, ret);
        }
    }
}
