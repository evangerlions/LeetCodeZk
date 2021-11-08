package leetcode.offer22_lastNNodeInList

import java.lang.RuntimeException

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
        head ?: return null
        if (k <= 0) return null

        var p1: ListNode? = head
        var p2: ListNode? = head

        repeat(k - 1) {
            // 求倒数第 k 个结点，但是没有 k 个节点，返回 null
            val next = p1?.next ?: return null
            p1 = next
        }

        while(p1?.next != null) {
            p1 = p1?.next
            p2 = p2?.next
        }

        return p2
    }
}