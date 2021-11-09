package leetcode.offer44_nthDigit;

/**
 * 指 Offer 44. 数字序列中某一位的数字
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/submissions/
 */
class Solution {

    int digit = 0;
    int reminder = 0;
    long start = 1;
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }

        calculateReminder(n);

        long target = (reminder / digit) + start;

        int charIndex = (reminder) % digit;
        // System.out.println("target " + target + " charIndex " + charIndex);
        char c = String.valueOf(target).charAt(charIndex);
        return c - '0';
    }

    private void calculateReminder(int n) {
        long ln = n;
        long count = 1;
        long lastCount = 0;
        while(count < ln) {
            digit = digit + 1;
            lastCount = count;
            count = count + start * 9 * digit;
            start = 10 * start;

            // System.out.println("digit " + digit + " start " + start + " count " + count);
        }
        start = (int)(start / 10);
        reminder = (int) (n - lastCount);
        // System.out.println("reminder " + reminder + " start " + start + " digit " + digit);
    }
}