package leetcode.offer2.offer2_24_reverseList;

/**
 * 剑指 Offer II 024. 反转链表
 * https://leetcode-cn.com/problems/UHnkqh/
 */
public class Solution {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }

        return pre;
    }
}
