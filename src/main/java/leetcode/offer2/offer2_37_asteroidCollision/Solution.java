package leetcode.offer2.offer2_37_asteroidCollision;

import java.util.LinkedList;

/**
 * 剑指 Offer II 037. 小行星碰撞
 * https://leetcode.cn/problems/XagZNi/
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();

        LinkedList<Integer> ret = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if (stack.isEmpty()) {
                // move to right, add straightly
                if (asteroid < 0) {
                    ret.add(asteroid);
                } else {
                    stack.add(asteroid);
                }
                continue;
            }

            // will collide
            if (asteroid < 0) {
                boolean isCrashed = false;
                while (!stack.isEmpty()) {
                    int leftAsteroid = stack.peekLast();
                    if (leftAsteroid > Math.abs(asteroid)) {
                        // this asteroid crashed, just continue
                        isCrashed = true;
                        break;
                    }
                    if (leftAsteroid == Math.abs(asteroid)) {
                        // both crashed;
                        isCrashed = true;
                        stack.removeLast();
                        break;
                    }
                    // left asteroid crashed
                    stack.removeLast();
                }
                if (!isCrashed) {
                    ret.add(asteroid);
                }
            } else {
                stack.add(asteroid);
            }
        }

        ret.addAll(stack);
        return ret.stream().mapToInt(Integer::valueOf).toArray();
    }
}