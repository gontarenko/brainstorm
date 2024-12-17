package medium;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

    class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }

    Node head;
    Node tail;

    int capacity;

    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        map = HashMap.newHashMap(capacity);
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addToHead(Node node) {
        node.next = this.head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        this.remove(node);
        this.addToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            this.remove(node);
            this.addToHead(node);
            return;
        }

        if (this.map.size() >= this.capacity) {
            node = tail.prev;
            this.remove(node);
            this.map.remove(node.key);
        }

        node = new Node();
        node.key = key;
        node.value = value;
        this.addToHead(node);
        map.put(key, node);
    }
}