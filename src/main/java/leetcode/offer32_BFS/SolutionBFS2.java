package leetcode.offer32_BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */
public class SolutionBFS2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        LinkedList<TreeNode> curNodes = new LinkedList<>();
        curNodes.add(root);

        while(!curNodes.isEmpty()) {
            ans.add(curNodes.stream().map(it -> it.val).collect(Collectors.toList()));
            LinkedList<TreeNode> nextNodes = new LinkedList<>();
            for (TreeNode node : curNodes) {
                if (node.left != null) nextNodes.add(node.left);
                if (node.right != null) nextNodes.add(node.right);
            }

            curNodes = nextNodes;
        }

        return ans;
    }
}
