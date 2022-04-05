package sort

interface Sort {
    fun sort(nums: IntArray)
}

fun main(args: Array<String>) {
    val nums1 = intArrayOf(18, 9, 48, 59, 85, 89, 78, 13, 4, 41)
    val nums2 = intArrayOf(87, 84, 76, 4, 32, 43, 71, 33, 79, 62)
    val nums3 = intArrayOf(46, 68, 26, 48, 25, 44, 10, 41, 81, 27)
    val nums4 = intArrayOf(98, 97, 10, 61, 28, 44, 54, 70, 82, 21)
    val nums5 = intArrayOf(1, 2, 2, 3, 0, 8, 8, 6, 4, 4)
    val nums6 = intArrayOf(1, 5, 1, 7, 6, 9, 0, 6, 7, 1)
    val nums7 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val nums8 = intArrayOf(1)
    val nums9 = intArrayOf()

    val numsList = listOf(nums1, nums2, nums3, nums4, nums5, nums6, nums7, nums8, nums9)

    for (nums in numsList) {
        val originNums = nums.clone()
        sort.QuickSortJava().sort(nums)
        if (!checkResult(nums, originNums)) {
            println("originNum: ${originNums.joinToString()}")
            println("num: ${nums.joinToString()}")
            throw RuntimeException("check sort result failed")
        } else {
            println("after sort: ${nums.joinToString()}")
        }
    }

}

fun checkResult(nums: IntArray, originNums: IntArray): Boolean {
    val correctResult = originNums.sorted()
    for (i in correctResult.indices) {
        if (nums[i] != correctResult[i]) return false
    }
    return true
}
