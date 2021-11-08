package leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * 接雨水
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 */
class Solution {

    private val rains = mutableListOf<Int>()

    fun trap(height: IntArray): Int {
        var result = 0
        for (index in height.indices) {
            val value = height[index]
            if (rains.isEmpty()) {
                rains.add(value)
                continue
            }

            if (value >= rains[0]) {
                rains.add(value)
                result += calculateRains()
            } else {
                rains.add(value)
            }
        }

        if (rains.isNotEmpty()) {
            result += calculateRains()
        }
        return result
    }

    private fun calculateRains(): Int {
        println("calculateRains, rains: $rains")
        var result = 0

        for (i in 1 until rains.size) {
            if (i + 1 >= rains.size) break
            val leftMax = rains.dropLast(rains.size - i - 1).maxOrNull() ?: 0
            val rightMax = rains.drop(i + 1).maxOrNull() ?: 0
            val minMax = min(leftMax, rightMax)

            val rainChunk = minMax - rains[i]
            if (rainChunk < 0) continue

            println("rainChunk: $rainChunk")
            result += rainChunk
        }
        val l = rains.last()
        rains.clear()
        rains.add(l)

        return result
    }
}

class Solution_DynamicProgramming {

    private val rains = mutableListOf<Int>()

    fun trap(height: IntArray): Int {
        val leftMax = IntArray(height.size)
        val rightMax = IntArray(height.size)

        leftMax[0] = height[0]
        rightMax[height.lastIndex] = height.last()
        for (i in 0..height.lastIndex) {
            if (i > 0) {
                leftMax[i] = max(height[i], leftMax[i - 1])
            }

            val iR = height.lastIndex - i
            if (iR < height.lastIndex) {
                rightMax[iR] = max(height[iR], rightMax[iR + 1])
            }
        }

        var ans = 0
        for (i in height.indices) {
            ans += min(leftMax[i], rightMax[i]) - height[i]
        }

        return ans
    }
}