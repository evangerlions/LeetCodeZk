package leetcode.offer2.offer2_43_CBTInserter;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer II 043. 往完全二叉树添加节点
 * https://leetcode.cn/problems/NaqhDT/
 */
class CBTInserter {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    private Queue<TreeNode> q = new LinkedList<>();

    private TreeNode root;

    public CBTInserter(TreeNode root) {
        if (root == null) { return; }

        q.add(root);
        while(q.peek().left != null && q.peek().right != null) {
            q.offer(q.peek().left);
            q.offer(q.peek().right);
            q.poll();
        }
        if (q.peek().left != null) q.offer(q.peek().left);
        this.root = root;
    }

    private void init(TreeNode root) {
        q.add(root);
        this.root = root;
    }

    private TreeNode insert(TreeNode newNode) {
        if (root == null) {
            init(newNode);
            return null;
        }

        TreeNode node = q.peek();

        if (node.left == null) {
            node.left = newNode;
        } else {
            node.right = newNode;
            q.poll();
        }
        q.offer(newNode);
        return node;
    }

    public int insert(int v) {
        TreeNode newNode = new TreeNode(v);
        TreeNode p = insert(newNode);
        return p == null ? -1 : p.val;
    }

    public TreeNode get_root() {
        return root;
    }
}