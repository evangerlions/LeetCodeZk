package leetcode.offer2.offer2_21_delNthFromEnd;

/**
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * https://leetcode-cn.com/problems/SLwz0R/
 */
public class Solution {
    private  static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p2pre = null;
        for (int i = 0; i < n - 1; i++) {
            // illegal input n
            if (p1.next == null) return null;
            p1 = p1.next;
        }

        while(p1.next != null) {
            p1 = p1.next;
            p2pre = p2;
            p2 = p2.next;
        }

        if (p2pre == null) {
            ListNode retHead = p2.next;
            p2.next = null;
            return retHead;
        }

        p2pre.next = p2.next;
        p2.next = null;
        return head;
    }
}
