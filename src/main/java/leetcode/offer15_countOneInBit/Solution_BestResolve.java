package leetcode.offer15_countOneInBit;

public class Solution_BestResolve {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
