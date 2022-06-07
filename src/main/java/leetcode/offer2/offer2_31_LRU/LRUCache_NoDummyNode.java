package leetcode.offer2.offer2_31_LRU;

import java.util.HashMap;

/**
 * 没有 dummy 结点的 lru
 */
public class LRUCache_NoDummyNode {
    private class Entry {
        int key;
        int value;
        Entry next;
        Entry pre;
    }

    private int capacity;
    private Entry head;
    private Entry tail;;
    private HashMap<Integer, Entry> map = new HashMap<Integer, Entry>();


    public LRUCache_NoDummyNode(int capacity) {
        this.capacity = capacity;

    }

    public int get(int key) {
        System.out.println("get: " + key);
        Entry target = innterGet(key);
        log();
        return target == null ? -1 : target.value;
    }

    private Entry innterGet(int key) {
        if (!map.containsKey(key)) return null;

        Entry target = map.get(key);

        if (target == head) return head;

        if (target.pre != null) {
            target.pre.next = target.next;
            if (target.next != null ) target.next.pre = target.pre;
            if (target == tail) tail = target.pre;
        }

        head.pre = target;

        target.pre = null;
        target.next = head;
        head = target;

        return head;
    }

    public void put(int key, int value) {
        System.out.println("put:" + key + " " + value);
        Entry target = innterGet(key);
        if (target == null) {
            target = new Entry();
            target.key = key;
            target.value = value;
            map.put(key, target);

            target.next = head;
            if (head != null) head.pre = target;
            head = target;

            if (tail == null) tail = head;
        } else {
            target.value = value;
        }

        log();

        if (map.size() > capacity) {
            Entry lastTail = tail.pre;
            tail.pre = null;
            if (lastTail != null) lastTail.next = null;
            map.remove(tail.key);
            tail = lastTail;
        }
        log();
    }

    private void log() {

        // Entry node = head;
        // while (node != null) {
        //     System.out.print("[" + node.key + " " + node.value + "] ->");
        //     node = node.next;
        // }
        // System.out.println();
        // node = tail;
        // while (node != null) {
        //     System.out.print("[" + node.key + " " + node.value + "] <-");
        //     node = node.pre;
        // }
        // System.out.println();
    }
}
