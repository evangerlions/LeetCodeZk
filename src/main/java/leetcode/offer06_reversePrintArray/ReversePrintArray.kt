package leetcode.offer06_reversePrintArray

import java.util.*

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
class Solution {
    fun reversePrint(head: ListNode?): IntArray {
        val stack = Stack<Int>()
        var nextNode = head
        var size = 0
        while (nextNode != null) {

            stack.push(nextNode.`val`)
            nextNode = nextNode.next
            size++
        }

        val ans = IntArray(size)
        var i = 0
        while (!stack.isEmpty()) {
            ans[i] = stack.pop()
            i++
        }
        return ans
    }
}

class Solution_List {

    fun reversePrint(head: ListNode?): IntArray {
        val list = ArrayList<Int>()
        var nextNode = head
        while (nextNode != null) {
            list.add(nextNode.`val`)
            nextNode = nextNode.next
        }
        val ans = list.toIntArray()
        ans.reverse()
        return ans
    }

}

class Solution_Recursion {
    fun reversePrint(head: ListNode?): IntArray {
        val ans = ArrayList<Int>()
        head?.let {
            innerReverse(ans, it)
        }
        return ans.toIntArray()
    }

    private fun innerReverse(ans: ArrayList<Int>, node: ListNode) {
        val next = node.next
        if (next != null) {
            innerReverse(ans, next)
        }
        ans.add(node.`val`)
    }
}