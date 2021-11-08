package sort

object SelectionSort : Sort {

    override fun sort(nums: IntArray) {
        for (i in nums.indices) {
            var minNumIndex = i
            for (j in i..nums.lastIndex) {
                if (nums[j] < nums[minNumIndex]) {
                    minNumIndex = j
                }
            }
            if (minNumIndex != i) {
                val temp = nums[i]
                nums[i] = nums[minNumIndex]
                nums[minNumIndex] = temp
            }
        }
    }
}