package leetcode.offer2.offer2_41_movingAverage;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {

    private double sum = 0.0;
    private int size = 0;
    private Queue<Integer> queue = new LinkedList<Integer>();

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() >= size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */