package leetcode.offer2.offer2_23_getIntersectionNote;

/**
 * 剑指 Offer II 023. 两个链表的第一个重合节点
 * https://leetcode-cn.com/problems/3u1WK4/
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }
}