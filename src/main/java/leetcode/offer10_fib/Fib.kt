package leetcode.offer10_fib

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
class Solution {
    fun fib(n: Int): Int {
        if (n <= 0) return 0
        if (n <= 1) return 1

        var `n-1` = 0
        var `n-2` = 0

        for (i in 1 until n) {
            if (`n-1` == 0) {
                `n-1` = 1
                continue
            }

            val ret = `n-1` + `n-2`
            `n-2` = `n-1`
            `n-1` = ret
        }
        return `n-1` + `n-2`
    }
}