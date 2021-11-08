package sort

object InsertionSort : Sort {

    override fun sort(nums: IntArray) {
        if (nums.size <= 1) return

        for (i in 1..nums.lastIndex) {
            val value = nums[i]
            if (value >= nums[i - 1]) continue

            for (j in i - 1 downTo 0) {
                if (nums[j] >= value) {
                    nums[j + 1] = nums[j]
                    nums[j] = value
                    continue
                }
                break
            }
        }
    }
}