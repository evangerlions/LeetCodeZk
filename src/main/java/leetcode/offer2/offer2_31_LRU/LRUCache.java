package leetcode.offer2.offer2_31_LRU;

import java.util.HashMap;

class LRUCache {

    private class Entry {
        int key;
        int value;
        Entry next;
        Entry pre;
    }

    private int capacity;
    private Entry head = new Entry();
    private Entry tail = new Entry();
    private HashMap<Integer, Entry> map = new HashMap<Integer, Entry>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        // System.out.println("get: " + key);
        Entry target = innterGet(key);
        log();
        return target == null ? -1 : target.value;
    }

    private Entry innterGet(int key) {
        if (!map.containsKey(key)) return null;

        Entry target = map.get(key);

        if (head.next == target) {
            return target;
        }

        moveToHead(target);
        return target;
    }

    private void moveToHead(Entry target) {
        removeNode(target);
        addToHead(target);
    }

    private void addToHead(Entry target) {
        Entry f = head.next;
        f.pre = target;
        target.pre = head;
        target.next = f;
        head.next = target;
    }

    private void removeNode(Entry target) {
        target.next.pre = target.pre;
        target.pre.next = target.next;
    }

    public void put(int key, int value) {
        // System.out.println("put:" + key + " " + value);
        Entry target = innterGet(key);
        if (target == null) {
            target = new Entry();
            target.key = key;
            target.value = value;
            map.put(key, target);

            addToHead(target);
        } else {
            target.value = value;
        }

        log();

        if (map.size() > capacity) {
            removeLast();
        }
        log();
    }

    private void removeLast() {
        Entry target = tail.pre;
        removeNode(target);
        map.remove(target.key);
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