package leetcode.offer32_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 只需一层循环
    public int[] levelOrder_onLoop(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        ArrayList<TreeNode> ans = new ArrayList<TreeNode>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            ans.add(node);
            if (node.left != null) nodes.add(node.left);
            if (node.right != null) nodes.add(node.right);
        }
        return ans.stream().mapToInt(it -> it.val).toArray();
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        ArrayList<TreeNode> ans = new ArrayList<TreeNode>();
        nodes.add(root);
        levelOrderCore(nodes, ans);
        return ans.stream().mapToInt(it -> it.val).toArray();
    }

    private void levelOrderCore(ArrayList<TreeNode> nodes, ArrayList<TreeNode> ans) {
        ans.addAll(nodes);
        ArrayList<TreeNode> nextNodes = new ArrayList<TreeNode>();

        for (TreeNode node : nodes) {
            if (node == null) continue;

            if (node.left != null) nextNodes.add(node.left);
            if (node.right != null) nextNodes.add(node.right);
        }

        if (!nextNodes.isEmpty()) {
            levelOrderCore(nextNodes, ans);
        }
    }
}
