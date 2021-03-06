package leetcode.offer.offer18_deleteNode

/**
 * 剑指 Offer 18. 删除链表的节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 */

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