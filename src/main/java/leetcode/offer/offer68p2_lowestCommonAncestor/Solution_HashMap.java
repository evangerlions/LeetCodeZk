package leetcode.offer.offer68p2_lowestCommonAncestor;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class Solution_HashMap {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        HashSet<TreeNode> set = new HashSet<>();

        dfs(parents, root, null);
        TreeNode pParent = p;
        while(pParent != null) {
            set.add(pParent);
            pParent = parents.get(pParent);
        }

        TreeNode qParent = q;
        while(qParent != null) {
            if (set.contains(qParent)) return qParent;
            qParent = parents.get(qParent);
        }

        return null;
    }

    private void dfs(HashMap<TreeNode, TreeNode> map, TreeNode node, TreeNode parent) {
        if (node == null) return;
        map.put(node, parent);

        dfs(map, node.left, node);
        dfs(map, node.right, node);
    }
}
