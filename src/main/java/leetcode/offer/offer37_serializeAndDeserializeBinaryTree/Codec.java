package leetcode.offer.offer37_serializeAndDeserializeBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 37. 序列化二叉树
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 */
public class Codec {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static final String NULL = "$";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                sb.append(Integer.toString(node.val)).append(",");
                q.add(node.left);
                q.add(node.right);

            } else {
                sb.append(NULL).append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // System.out.println(data);
        if (data.isEmpty()) return null;

        String[] stringArray = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(stringArray[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                continue;
            }
            TreeNode left = getNode(stringArray, i);
            TreeNode right = getNode(stringArray, ++i);
            node.left = left;
            node.right = right;
            q.add(left);
            q.add(right);

            i++;
        }
        return root;
    }

    private TreeNode getNode(String[] stringArray, int i) {
        String nodeString = stringArray[i];
        if (nodeString.equals(NULL)) return null;
        return new TreeNode(Integer.parseInt(nodeString));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));