package leetcode.offer16_powxn

/**
 * 剑指 Offer 16. 数值的整数次方
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
class Solution_Recursion {
    // 方法会爆栈
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }

        if (n == 1) {
            return x
        }

        if (x == 1.0) {
            return x
        }

        val ret = myPowCore(x, Math.abs(n))
        if (n < 0) {
            return 1.0 / ret
        }
        return ret
    }

    private fun myPowCore(x: Double, n: Int): Double {
        if (n == 1) {
            return x
        }
        if(n % 2 == 0) {
            val result = myPowCore(x, n / 2)
            return result * result
        } else {
            val result = myPowCore(x, (n - 1) / 2)
            return result * result * x
        }
    }
}

/**
 * 我自己的方法，用循环求解，先用指数爆炸的特性求到最大的 2 的 n 次方，然后再循环相乘剩余的数字
 * 中间补充有剪枝，舍去已经乘出 0 的结果，不然会超时
 */
class Solution_Loog_Pruning {
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }

        if (n == 1) {
            return x
        }

        if (x == 1.0) {
            return x
        }

        if (x == 0.0) {
            return 0.0
        }

        val absN:Long = Math.abs(n.toLong())

        val absX = if (n < 0) {
            1.0 / x
        } else {
            x
        }

        var plusCount = 1L
        var result = absX
        while(plusCount < absN) {
            // 能在乘一个自己，还没超过限制，就再乘一次自己
            if(plusCount + plusCount < absN) {
                result *= result
                plusCount += plusCount
            } else {
                // 补齐剩余要乘的次数
                result *= absX
                plusCount++
            }
            if (result == 0.0) {
                break
            }
        }

        return result
    }
}

/**
 * 讲解可以见: https://zhuanlan.zhihu.com/p/95902286
 * 用二进制的思想比较好理解
 */
class Solution_Loop {
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }

        if (n == 1) {
            return x
        }

        if (x == 1.0) {
            return x
        }

        if (x == 0.0) {
            return 0.0
        }

        var absN: Long = Math.abs(n.toLong())

        var absX = if (n < 0) {
            1.0 / x
        } else {
            x
        }

        var res = 1.0
        while(absN > 0L) {
            if ((absN and 1L) == 1L) {
                res *= absX
            }
            absX *= absX
            println("res: $res, absX: $absX, absN: $absN")
            absN = absN shr 1

        }

        return res
    }
}