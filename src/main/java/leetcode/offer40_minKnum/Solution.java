package leetcode.offer40_minKnum;

class Solution {
    int k;
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        if(k <= 0) {
            return new int[0];
        }

        this.k = k;
        Parition(0, arr.length - 1, arr);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    private void Parition(int start, int end, int[] arr) {

        int index = start + 1;
        for (int i = start + 1; i <= end; i++) {
            if(arr[i] < arr[start]) {
                swap(arr, i, index);
                index++;
            }
        }

        int curNumI = index - 1;
        if (curNumI <= end) {
            swap(arr, start, curNumI);
        }


        if (curNumI == k) {
            return;
        }

        if (curNumI > k) {
            Parition(start, curNumI - 1, arr);
        } else {
            Parition(curNumI + 1, end, arr);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}