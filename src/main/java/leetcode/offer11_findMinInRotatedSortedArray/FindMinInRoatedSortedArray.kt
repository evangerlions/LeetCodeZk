package leetcode.offer11_findMinInRotatedSortedArray

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 */
class Solution {
    fun minArray(numbers: IntArray): Int {
        if (numbers.isEmpty()) return -1
        var leftIndex = 0
        var rightIndex = numbers.lastIndex

        // 已经是顺序数组了，直接返回第一个元素
        if (numbers[leftIndex] < numbers[rightIndex]) {

            return numbers[leftIndex]
        }

        while (rightIndex - leftIndex > 1) {
            while (leftIndex + 1 < numbers.size && numbers[leftIndex + 1] == numbers[leftIndex]) {
                leftIndex++
            }

            while (rightIndex - 1 >= 0 && numbers[rightIndex - 1] == numbers[rightIndex]) {
                rightIndex--
            }

            val mid = Math.ceil((leftIndex + rightIndex) / 2.0).toInt()
            if (numbers[mid] > numbers[rightIndex]) {
                leftIndex = mid
            } else {
                rightIndex = mid
            }
        }

        return numbers[rightIndex]
    }
}