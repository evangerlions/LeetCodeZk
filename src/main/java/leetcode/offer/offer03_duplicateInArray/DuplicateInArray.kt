package leetcode.offer.offer03_duplicateInArray

/**
 * 剑指 Offer 03. 数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
class Solution {

    fun findRepeatNumber(nums: IntArray): Int {
        nums.sort()

        var lastN = 0
        for ((i, n) in nums.withIndex()) {
            if (i == 0) {
                lastN = n
                continue
            }

            if (lastN == n) {
                return lastN
            }
            lastN = n
        }
        return 0
    }
}

class Solution_Hash {

    fun findRepeatNumber(nums: IntArray): Int {
        val map = HashMap<Int, Boolean>()
        for ((i, n) in nums.withIndex()) {
            if (map[n] != null) {
                return n
            }
            map[n] = true
        }
        return 0
    }
}

/** 不额外使用空间，在原有数组中修改 */
class Solution_Replace {

    fun findRepeatNumber(nums: IntArray): Int {
        var i = 0
        while (i < nums.size) {
            val v = nums[i]
            if (i != v) {
                if (!swapNum(nums, v, i)) return v
                continue
            }
            i++
        }
        return -1
    }

    private fun swapNum(nums: IntArray, value: Int, index: Int): Boolean {
        if (nums[value] != value) {
            val otherNum = nums[value]
            nums[value] = value
            nums[index] = otherNum
            // swap success, two value different
            return true
        }
        // swap fail, two value duplicate
        return false
    }
}

class Solution_Recursion {

    fun findRepeatNumber(nums: IntArray): Int {
        return swapNum(nums, 0)
    }

    private fun swapNum(nums: IntArray, index: Int): Int {
        if (index >= nums.size) return -1

        val value = nums[index]

        // needn't swap
        if (value == index) {
            return swapNum(nums, index + 1)
        }

        // need swap
        if (nums[value] != value) {
            val otherNum = nums[value]
            nums[value] = value
            nums[index] = otherNum
            // swap success, two value diffent
            return swapNum(nums, index)
        } else {
            // swap fail, two value duplicate
            return value
        }
    }
}
