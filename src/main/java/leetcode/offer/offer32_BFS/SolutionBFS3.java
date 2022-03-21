package leetcode.offer.offer32_BFS;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
public class SolutionBFS3 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;

        List<TreeNode> curNodes = new LinkedList<>();
        curNodes.add(root);
        int deep = 0;

        while(!curNodes.isEmpty()) {
            boolean isEven = (deep % 2 == 0);
            // odd num add later
            if (isEven) {
                ans.add(toList(curNodes));
            }
            List<TreeNode> nextNodes = new LinkedList<>();
            for (TreeNode node : curNodes) {
                if (node.left != null) nextNodes.add(node.left);
                if (node.right != null) nextNodes.add(node.right);
            }

            if (!isEven) {
                Collections.reverse(curNodes);
                ans.add(toList(curNodes));
            }

            curNodes = nextNodes;
            deep++;
        }

        return ans;
    }

    private List<Integer> toList(List<TreeNode> nodes) {
        return nodes.stream().map(it -> it.val).collect(Collectors.toList());
    }
}
