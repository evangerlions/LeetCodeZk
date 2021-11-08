package leetcode.offer36_covertBinarySearchTreeToSortedDoublyLinkedList;

/*
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */
class Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
    private Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node tail = treeToDoublyListCore(root, null);
        tail.right = head;
        head.left = tail;
        // System.out.println(node.val);
        return head;
    }

    public Node treeToDoublyListCore(Node cur, Node lastNode) {
        // System.out.println("cur: " + cur.val + " lastNode:" + (lastNode == null ? null : lastNode.val));

        if (cur.left != null) {
            lastNode = treeToDoublyListCore(cur.left, lastNode);
        }

        cur.left = lastNode;
        if (lastNode != null) {
            lastNode.right = cur;
        } else {
            // record head node
            head = cur;
        }
        lastNode = cur;
        if (cur.right != null) {
            lastNode = treeToDoublyListCore(cur.right, cur);
        }
        return lastNode;
    }
}
