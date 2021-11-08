package sort

object QuickSort : Sort {
    override fun sort(nums: IntArray) {
        if (nums.isEmpty()) return

        quickSort(nums, 0, nums.size - 1)
    }

    private fun quickSort(nums: IntArray, start: Int, end: Int) {
        if (start >= end) return

        val pivotIndex = partition(nums, start, end)
        quickSort(nums, start, pivotIndex - 1)
        quickSort(nums, pivotIndex + 1, end)
    }

    private fun partition(nums: IntArray, start: Int, end: Int): Int {
        val pivotIndex = start
        var leftSortIndex = pivotIndex + 1
        for (i in leftSortIndex..end) {
            if (nums[i] < nums[pivotIndex]) {
                swap(nums, i, leftSortIndex)
                leftSortIndex++
            }
        }
        swap(nums, leftSortIndex - 1, pivotIndex)
        return leftSortIndex - 1
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}

private data class ToBeSortedArr(
    val start: Int,
    val end: Int
)

object QuickSortLoop : Sort {

    override fun sort(nums: IntArray) {
        if (nums.size <= 1) return

        quickSort(nums)
    }

    private fun quickSort(nums: IntArray) {
        val toBeSortedArr = ArrayDeque<ToBeSortedArr>()
        toBeSortedArr.safeAdd(0, nums.size - 1)
        do {
            val target = toBeSortedArr.removeFirst()
            val start = target.start
            val end = target.end
            val pivotIndex = partition(nums, start, end)
            toBeSortedArr.safeAdd(start, pivotIndex - 1)
            toBeSortedArr.safeAdd(pivotIndex + 1, end)
        } while (toBeSortedArr.isNotEmpty())
    }

    private fun ArrayDeque<ToBeSortedArr>.safeAdd(start: Int, end: Int) {
        if (start >= end) return
        addFirst(ToBeSortedArr(start, end))
    }

    private fun partition(nums: IntArray, start: Int, end: Int): Int {
        val pivotIndex = start
        var leftSortIndex = pivotIndex + 1
        for (i in leftSortIndex..end) {
            if (nums[i] < nums[pivotIndex]) {
                swap(nums, i, leftSortIndex)
                leftSortIndex++
            }
        }
        swap(nums, leftSortIndex - 1, pivotIndex)
        return leftSortIndex - 1
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}