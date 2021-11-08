package leetcode.offer18_deleteNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.

 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * leetCode 上的题目，和原文差距较大
 */
class Solution {
    fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
        if (head?.`val` == `val`) {
            val newHead = head?.next
            head?.next = null
            return newHead
        }

        var preNode = head
        var curNode = head?.next
        while (curNode?.`val` != `val`) {
            preNode = curNode
            curNode = curNode?.next
        }

        curNode?.let {
            preNode?.next = it.next
            it.next = null
        }

        return head
    }
}

/**
 * 剑指 offer 上的原题，o(1) 时间内删除结点，输入待删除的结点
 */
class Solution_o1 {
    fun deleteNode(head: ListNode, toBeDeleted: ListNode): ListNode {
        val next = toBeDeleted.next
        if (next == null) {
            var preNode: ListNode? = head
            while (preNode?.next != toBeDeleted && preNode?.next != null) {
                preNode = preNode?.next
            }
            preNode?.next = null
        } else {
            toBeDeleted.`val` = next.`val`
            toBeDeleted.next = next.next
            next.next = null
        }
        return head
    }
}