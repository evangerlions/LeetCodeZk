package leetcode.offer2.offer2_69_peakIndexInMountainArray;

/**
 * 剑指 Offer II 069. 山峰数组的顶部
 * https://leetcode-cn.com/problems/B1IidL/
 */
public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length == 0) return 0;

        int start = 1;
        int end = arr.length - 2;
        while(start <= end) {
            int middle = (start + end) >> 1;
            if (arr[middle] > arr[middle + 1] && arr[middle] > arr[middle - 1]) {
                return middle;
            }
            if (arr[middle] < arr[middle + 1]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }
}
