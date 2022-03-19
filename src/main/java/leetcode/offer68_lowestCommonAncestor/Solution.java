package leetcode.offer68_lowestCommonAncestor;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if ((root.val >= p.val && root.val <= q.val) || (root.val <= p.val && root.val >= q.val)) {
                return root;
            }

            if (root.val > p.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
