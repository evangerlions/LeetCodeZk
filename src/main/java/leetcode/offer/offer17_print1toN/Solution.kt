package leetcode.offer.offer17_print1toN

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */

/**
 * 未考虑大数，简单实现
 */
class Solution {

    fun printNumbers(n: Int): IntArray {
        val ans = IntArray(Math.pow(10.0, n.toDouble()).toInt() - 1) { i -> i + 1 }
        return ans;
    }
}

/**
 * 考虑大数，全排列
 */
class Solution_BigNumber {

    private val digitList = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

    fun printNumbers(n: Int): IntArray {
        val ans = mutableListOf<Int>()
        recursion(ans, CharArray(n) { digitList[0] }, n, 0)
        return ans.toIntArray();
    }

    private fun recursion(ans: MutableList<Int>, num: CharArray, n: Int, index: Int) {
        if (index >= n) {
            // 固定完所有位数，把结果记录下
            val curNum = num.joinToString("").toInt()
            // 排除下 0，答案不让输出 0
            if (curNum != 0) {
                ans.add(curNum)
            }
            return
        }

        for (c in digitList) {
            num[index] = c
            // 固定下一位
            recursion(ans, num, n, index + 1)
        }
    }
}