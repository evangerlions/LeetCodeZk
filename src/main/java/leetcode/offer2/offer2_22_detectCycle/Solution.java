package leetcode.offer2.offer2_22_detectCycle;

/**
 * 剑指 Offer II 022. 链表中环的入口节点
 * https://leetcode-cn.com/problems/c32eOV/
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
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p1 != null) {
            p1 = p1.next == null ? null : p1.next.next;
            p2 = p2.next;

            // has cycle
            if (p1 == p2 && p1 != null) {
                p1 = head;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }

        // no cycle
        return null;
    }
}