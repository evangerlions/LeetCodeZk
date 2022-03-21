package leetcode.offer.offer09_useTwoStackForQueue

import java.util.*

/**
 * 剑指 Offer 09. 用两个栈实现队列。队列的声明如下，
 * 请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1)
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 */
class CQueue() {

    val stack1 = Stack<Int>()
    val stack2 = Stack<Int>()

    fun appendTail(value: Int) {
        stack1.push(value)
    }

    fun deleteHead(): Int {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop())
            }
        }
        return stack2.pop()
    }

}