package sort

object BubbleSort:Sort {
    override fun sort(nums: IntArray) {
        for (i in nums.size - 1 downTo 0) {
            var isSwapped = false
            for (j in 0 until i) {
                if (nums[j] > nums[j + 1]) {
                    val temp = nums[j + 1]
                    nums[j + 1] = nums[j]
                    nums[j] = temp
                    isSwapped = true
                }
            }
            if (!isSwapped) {
                break
            }
        }
    }
}
