package leetcode.offer2.offer2_43_CBTInserter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 双队列，自己想的解法，一列保存叶子结点，一列保存叶子结点的上一层
 */
class CBTInserter_DualQueue {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    private LinkedList<TreeNode> q1 = new LinkedList<>();
    private LinkedList<TreeNode> q2 = new LinkedList<>();
    private boolean isParentP1 = true;
    private TreeNode root;

    public CBTInserter_DualQueue(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
            // System.out.println("insert:" + node.val);
            insert(node);
        }
    }

    private void init(TreeNode root) {
        q1.add(root);
        this.root = root;
    }

    private TreeNode insert(TreeNode newNode) {
        newNode.left = null;
        newNode.right = null;

        if (root == null) {
            init(newNode);
            return null;
        }

        Queue<TreeNode> qParent = isParentP1 ? q1 : q2;
        Queue<TreeNode> qChildren = isParentP1 ? q2 : q1;

        TreeNode node = qParent.peek();
        // System.out.println("p: " + node.val + " p-l:" + node.left + " p-r:" + node.right + " new:" + newNode.val);
        if (node.left == null) {
            node.left = newNode;
        } else {
            node.right = newNode;
            qParent.poll();
        }
        if (qParent.isEmpty()) {
            isParentP1 = !isParentP1;
        }
        qChildren.add(newNode);
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