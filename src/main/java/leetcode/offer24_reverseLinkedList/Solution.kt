package leetcode.offer24_reverseLinkedList

/**
 * 剑指 Offer 24. 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        head ?: return null

        var pre: ListNode? = head
        var current: ListNode? = head.next

        pre?.next = null

        while (current != null) {
            val next = current.next
            current.next = pre

            pre = current
            current = next
        }

        return pre
    }
}