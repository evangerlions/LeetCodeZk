package leetcode.offer13_robotMaxMove

/**
 * 剑指 Offer 13. 机器人的运动范围
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
class Solution {
    fun movingCount(m: Int, n: Int, k: Int): Int {

        val visited = Array<BooleanArray>(n) { BooleanArray(m) }

        return movingCountCore(0, 0, m, n, k, visited)
    }

    private fun movingCountCore(x: Int, y: Int, m: Int, n: Int, k: Int, visited: Array<BooleanArray>): Int {
        if (x !in 0 until m || y !in 0 until n || getDigitSum(x) + getDigitSum(y) > k || visited[y][x]) {
            return 0
        }

        visited[y][x] = true
        return movingCountCore(x + 1, y, m, n, k, visited) + movingCountCore(x - 1, y, m, n, k, visited) + movingCountCore(x, y + 1, m, n, k, visited) + movingCountCore(x, y - 1, m, n, k, visited) + 1
    }

    private fun getDigitSum(a : Int): Int {
        var sum = 0
        var num = a
        while(num > 0) {
            sum += num % 10
            num = num/10
        }
        return sum
    }
}