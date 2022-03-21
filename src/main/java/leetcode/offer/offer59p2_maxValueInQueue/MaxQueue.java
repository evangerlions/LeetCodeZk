package leetcode.offer.offer59p2_maxValueInQueue;

import java.util.Deque;
import java.util.LinkedList;

class MaxQueue {

    Deque<Integer> deque = new LinkedList<>();
    Deque<Integer> queue = new LinkedList<>();

    public MaxQueue() {

    }

    public int max_value() {
        if (deque.isEmpty()) return -1;
        return deque.peek();
    }

    public void push_back(int value) {
        while(!deque.isEmpty() && deque.peekLast() <= value) {
            deque.pollLast();
        }

        deque.addLast(value);
        queue.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int i = queue.poll();
        if (i == deque.peek()) deque.poll();

        return i;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */