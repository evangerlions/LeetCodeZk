package leetcode.offer14_cutRope

/**
 * 剑指 Offer 14- I. 剪绳子
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 */
class Solution {
    fun cuttingRope(n: Int): Int {
        if (n <= 1) {
            return n
        }

        if (n == 2) {
            return 1
        }

        if (n == 3) {
            return 2
        }

        val ans = IntArray(n + 1)

        ans[0] = 0
        ans[1] = 1
        ans[2] = 2
        ans[3] = 3

        for (i in 4..n) {
            for (j in 1..i/2) {
                ans[i] = Math.max(ans[j] * ans[i - j], ans[i])
            }
        }

        println(ans.joinToString())
        return ans.last()
    }
}