package leetcode.offer2.offer2_22_detectCycle;

public class Solution_WithLoopCount {
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

        while (p1 != null && p1.next != null && p1.next != p2) {
            p1 = p1.next.next;
            p2 = p2.next;
        }

        if (p1 == null || p1.next == null) {
            // no cycle
            return null;
        }

        ListNode dump = p1;
        p1 = p1.next;
        // length of cycle
        int i = 1;
        while(dump != p1) {
            p1 = p1.next;
            i++;
        }

        p1 = head;
        p2 = head;
        for (int j = 0; j < i; j++) {
            p1 = p1.next;
        }

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}