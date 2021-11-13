package leetcode.offer46_translateArrayToStr;

/**
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * 剑指 Offer 46. 把数字翻译成字符串
 */
class Solution {
    public int translateNum(int num) {
        String numStr = Integer.toString(num);

        return translateNumsCore(numStr);
    }

    private int translateNumsCore(String numStr) {


        if (numStr.length() <= 1) {
            return 1;
        }

        String subStr = numStr.substring(0, 2);
        if (subStr.compareTo("25") <= 0 && subStr.charAt(0) != '0') {
            return translateNumsCore(numStr.substring(2)) + translateNumsCore(numStr.substring(1));
        }
        return translateNumsCore(numStr.substring(1));

    }
}