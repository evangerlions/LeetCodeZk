package leetcode.offer2.offer2_25_addTwoNumbers;

/**
 * 剑指 Offer II 025. 链表中的两数相加
 * https://leetcode-cn.com/problems/lMSNwu/
 */
public class Solution {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode() {}
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 = reverseList(l1);
        ListNode rl2 = reverseList(l2);

        ListNode ret = new ListNode();
        ListNode p = ret;
        int carry = 0;
        while(rl1 != null || rl2 != null || carry != 0) {
            ListNode node = new ListNode();
            if (rl1 == null && rl2 != null) {
                node.val = rl2.val;
                rl2 = rl2.next;
            } else if (rl2 == null && rl1 != null) {
                node.val = rl1.val;
                rl1 = rl1.next;
            } else if (rl1 != null && rl2 != null) {
                node.val = rl1.val + rl2.val;
                rl1 = rl1.next;
                rl2 = rl2.next;
            }

            node.val += carry;
            if (node.val >= 10) {
                node.val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            p.next = node;
            p = p.next;
        }

        return reverseList(ret.next);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }

        return pre;
    }
}
