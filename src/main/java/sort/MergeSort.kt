package sort

import java.lang.Integer.min

object MergeSort : Sort {
    override fun sort(nums: IntArray) {
        var step = 1
        while (step <= nums.size) {
            var begin = 0
            while (begin < nums.size) {
                val arr1End = begin + step - 1
                val arr2Begin = arr1End + 1
                if (arr2Begin >= nums.size) break

                val arr2End = min(begin + step * 2 - 1, nums.lastIndex)

                val ret = mergeArray(nums.sliceArray(begin..arr1End), nums.sliceArray(arr2Begin..arr2End))
                var j = 0
                for (i in begin..arr2End) {
                    nums[i] = ret[j]
                    j++
                }
                begin = arr2End + 1
            }
            step *= 2
        }
    }

    private fun mergeArray(arr1: IntArray, arr2: IntArray): IntArray {
        val ret = IntArray(arr1.size * 2)
        var i = 0
        var j = 0
        var k = 0
        while (i < arr1.size || j < arr2.size) {
            if (j >= arr2.size) {
                ret[k] = arr1[i]
                i++
            } else if (i >= arr1.size) {
                ret[k] = arr2[j]
                j++
            } else if (arr1[i] < arr2[j]) {
                ret[k] = arr1[i]
                i++
            } else {
                ret[k] = arr2[j]
                j++
            }
            k++
        }
        return ret
    }
}