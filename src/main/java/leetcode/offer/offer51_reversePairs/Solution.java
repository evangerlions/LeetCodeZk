package leetcode.offer.offer51_reversePairs;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * 剑指 Offer 51. 数组中的逆序对
 */
class Solution {
    int[] sortArray;
    public int reversePairs(int[] nums) {
        int reverseCount = 0;

        int step = 1;
        int len = nums.length;
        sortArray = new int[len];
        while(step < len) {
            // System.out.println("step: " + step);
            int arr1Start = 0;
            while(arr1Start < len) {
                int arr1End = arr1Start + step - 1;

                int arr2Start = arr1End + 1;
                int arr2End = Math.min(arr2Start + step - 1, len - 1);

                if (arr2Start >= len) {
                    break;
                }

                reverseCount += mergeArray(nums, arr1Start, arr1End, arr2Start, arr2End);

                arr1Start = arr2End + 1;
            }
            step *= 2;
        }

        return reverseCount;
    }

    private int mergeArray(int[] nums, int arr1Start, int arr1End, int arr2Start, int arr2End) {
        // System.out.println("" + arr1Start + arr1End + arr2Start + arr2End);
        int arr1Len = arr1End - arr1Start + 1;
        int arr2Len = arr2End - arr2Start + 1;
        int sortArrayLen = arr1Len + arr2Len;

        int reverseCount = 0;
        int i = sortArrayLen - 1;
        int j = arr1End;
        int k = arr2End;

        while(i >= 0) {
            if (j < arr1Start) {
                sortArray[i] = nums[k];
                k--;
            } else if (k < arr2Start) {
                sortArray[i] = nums[j];
                j--;
            } else if (nums[k] < nums[j]) {
                sortArray[i] = nums[j];
                j--;
                reverseCount += k - arr2Start + 1;
            } else {
                sortArray[i] = nums[k];
                k--;
            }

            i--;
        }
        // System.out.println("sortNums: " + Arrays.toString(sortArray) + "count: " +reverseCount);
        j = 0;
        for (i = arr1Start; i <= arr2End; i++) {
            nums[i] = sortArray[j];
            j++;
        }
        return reverseCount;
    }
}