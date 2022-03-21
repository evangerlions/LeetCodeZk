package leetcode.offer.offer55p2_judgeIsBalancedBinaryTree;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
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

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        boolean ret = Math.abs(getDeep(root.left) - getDeep(root.right)) <= 1;
        if (!ret) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDeep(TreeNode root) {
        if (root == null) return 0;

        return Math.max(getDeep(root.left), getDeep(root.right)) + 1;
    }
}
