package leetcode.offer25_mergeTwoSortedLists

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        l1 ?: return l2
        l2 ?: return l1

        var head: ListNode = ListNode(0)
        var ans: ListNode = head

        var l1Node: ListNode? = l1
        var l2Node: ListNode? = l2
        while(l1Node != null || l2Node != null) {
            if (l2Node == null) {
                ans.next = l1Node

                l1Node = l1Node?.next
                ans = ans.next!!
                continue
            }

            if (l1Node == null) {
                ans.next = l2Node

                l2Node = l2Node?.next
                ans = ans.next!!
                continue
            }

            if (l1Node!!.`val` > l2Node!!.`val`) {
                ans.next = l2Node

                l2Node = l2Node.next
                ans = ans.next!!
            } else {
                ans.next = l1Node

                l1Node = l1Node.next
                ans = ans.next!!
            }
        }
        return head.next
    }
}