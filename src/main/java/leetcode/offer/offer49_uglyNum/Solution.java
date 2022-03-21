package leetcode.offer.offer49_uglyNum;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 49. 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 */
class Solution {
    private int[] uglyNumPart = new int[] {2, 3, 5};

    public int nthUglyNumber(int n) {
        Queue<Long> heap = new PriorityQueue<>();
        HashSet<Long> visited = new HashSet<>();

        heap.add(1L);
        for (int i = 1; i < n; i++) {
            long num = heap.poll();
            for (int part : uglyNumPart) {
                if (visited.add(part * num)) {
                    heap.add(part * num);
                }
            }
        }

        long ret = heap.peek();
        return (int) ret;
    }
}