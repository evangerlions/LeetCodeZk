package leetcode.offer04_searchA2dMatrix

/**
 * 剑指 Offer 04. 二维数组中的查找
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
class Solution {
    fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) return false
        if (matrix[0].isEmpty()) return false

        val maxColumn = matrix[0].lastIndex
        val maxRow = matrix.lastIndex

        var column = maxColumn
        var row = 0
        while (row <= maxRow && column >= 0) {
            val value = matrix[row][column]
            if (value == target) return true

            if (value > target) {
                column--
            }

            if (value < target) {
                row++
            }
        }
        return false
    }
}