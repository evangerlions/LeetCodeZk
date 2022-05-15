package leetcode.offer2.offer2_26_reorderList;


class Solution {
     private static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode lastSlow = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            fast = (fast.next == null) ? null : fast.next.next;
            lastSlow = slow;
            slow = (slow == null) ? head : slow.next;
        }

        lastSlow.next = null;
        mergeList(head, reverseList(slow));
    }

    private void mergeList(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                node.next = l1;
                node = node.next;
                // System.out.print(node.val + "-");
                l1 = l1.next;

                node.next = l2;
                node = node.next;
                // System.out.print(node.val + "-");
                l2 = l2.next;
            } else if (l1 != null) {
                node.next = l1;
                node = node.next;
                // System.out.print(node.val + "+");
                l1 = l1.next;
            } else {
                node.next = l2;
                node = node.next;
                // System.out.print(node.val + ".");
                l2 = l2.next;
            }
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;

            prev = cur;
            cur = temp;
        }
        return prev;
    }
}