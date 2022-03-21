package leetcode.offer.offer52_twoLinkedListFirstIntersection;


import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 *
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNod_best(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;

        while (node1 != node2) {
            // 注意：这里是 node1 != null 而不是 node1.next == null，是为了让 node1、node2 都等于 null（没有相交）时可以跳出
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }

        return node1;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        List<ListNode> listA = new LinkedList<ListNode>();
        List<ListNode> listB = new LinkedList<ListNode>();

        ListNode nextA = headA;
        while (nextA != null) {
            listA.add(nextA);
            nextA = nextA.next;
        }
        nextA = headA;

        ListNode nextB = headB;
        while (nextB != null) {
            listB.add(nextB);
            nextB = nextB.next;
        }
        nextB = headB;

        int delta = Math.abs(listA.size() - listB.size());
        ListNode longerListNext = listA.size() > listB.size() ? nextA : nextB;
        ListNode shorterListNext = listA.size() > listB.size() ? nextB : nextA;
        for (int i = 0; i < delta; i++) {
            longerListNext = longerListNext.next;
        }

        while (true) {
            if (longerListNext == shorterListNext) return longerListNext;

            if (longerListNext == null || shorterListNext == null) {
                return null;
            }
            longerListNext = longerListNext.next;
            shorterListNext = shorterListNext.next;
        }
    }
}
