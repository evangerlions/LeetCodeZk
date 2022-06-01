package leetcode.offer2.offer2_30_randomizedSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器
 * https://leetcode.cn/problems/FortPu/
 */
class RandomizedSet {

    private ArrayList<Integer> arr = new ArrayList<>();
    private HashMap<Integer, Integer> map = new HashMap<>();

    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        map.put(val, arr.size());
        arr.add(val);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int index = map.get(val);
        int lastValue = arr.get(arr.size() - 1);

        arr.set(index, lastValue);
        map.put(lastValue, index);
        map.remove(val);
        arr.remove(arr.size() - 1);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        int i = r.nextInt(arr.size());
        return arr.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */