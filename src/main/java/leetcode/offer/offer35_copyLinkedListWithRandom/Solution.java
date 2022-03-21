package leetcode.offer.offer35_copyLinkedListWithRandom;

/*
 * 剑指 Offer 35. 复杂链表的复制
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 */
class Solution {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        copyList(head);
        connectRandomNode(head);
        Node ans = splitList(head);
        // debug(head);
        return ans;
    }

    private void copyList(Node head) {
        while (head != null) {
            Node next = head.next;
            Node copyNode = new Node(head.val);
            head.next = copyNode;
            copyNode.next = next;

            head = next;
        }
    }

    private void connectRandomNode(Node head) {
        while (head != null) {
            Node trueNext = head.next.next;
            Node randomNode = head.random;

            if (randomNode != null) {
                head.next.random = randomNode.next;
            }

            head = trueNext;
        }
    }

    private Node splitList(Node head) {
        Node copyHead = head.next;

        while (head != null) {
            Node trueNext = head.next.next;
            Node copyTrueNext;
            if (trueNext == null) {
                copyTrueNext = null;
            } else {
                copyTrueNext = trueNext.next;
            }
            Node copy = head.next;

            head.next = trueNext;
            copy.next = copyTrueNext;

            head = trueNext;
        }
        return copyHead;
    }

    private void debug(Node head) {
        while (head != null) {
            System.out.print("[" + head.val + ", " + head.random + "] ->");
            System.out.println();
            head = head.next;
        }
    }
}