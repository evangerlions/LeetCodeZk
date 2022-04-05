package sort;

public class QuickSortJava {

    public void sort(int[] nums) {
        sortCore(nums, 0, nums.length - 1);
    }

    private void sortCore(int[] nums, int start, int end) {
        if (start >= end || start < 0 || end >= nums.length) return;

        int target = nums[start];

        int k = start + 1;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < target) {
                swap(nums, i, k);
                k++;
            }
        }
        swap(nums, k - 1, start);

        sortCore(nums, start, k - 2);
        sortCore(nums, k, end);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
