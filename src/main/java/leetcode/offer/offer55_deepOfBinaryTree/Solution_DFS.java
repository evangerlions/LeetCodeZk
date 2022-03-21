package leetcode.offer.offer55_deepOfBinaryTree;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 */
public class Solution_DFS {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int deep = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return deep;
    }

    public void dfs(TreeNode root, int curDeep) {
        if (root == null) return;
        curDeep++;
        deep = Math.max(deep, curDeep);

        dfs(root.left, curDeep);
        dfs(root.right, curDeep);
    }
}
