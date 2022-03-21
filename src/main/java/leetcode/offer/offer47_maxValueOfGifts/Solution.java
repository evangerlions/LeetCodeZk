package leetcode.offer.offer47_maxValueOfGifts;

/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * 剑指 Offer 47. 礼物的最大价值
 */
class Solution {
    public int maxValue(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        int[][] values = new int[maxRow][maxCol];

        int max = 0;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                int upValue = getValue(values, i - 1, j);
                int leftValue = getValue(values, i, j - 1);

                values[i][j] = Math.max(upValue, leftValue) + grid[i][j];
                max = Math.max(values[i][j], max);
            }
        }

        return max;
    }

    private int getValue(int[][] values, int i, int j) {
        if (i < 0 || j < 0 || i >= values.length || j >= values[0].length) {
            return 0;
        }
        return values[i][j];
    }

}