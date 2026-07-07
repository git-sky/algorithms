package cn.com.sky.algorithms.ByteDance.top10;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 146. LRU缓存机制【Medium】（字节跳动高频）
 * 
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存约束的数据结构。
 * 实现 LRUCache 类：
 * - LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * - int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * - void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 *   如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，
 *   则应该逐出最久未使用的关键字。
 * 
 * 算法原理：
 * 使用哈希表+双向链表实现：
 * 1. 哈希表：O(1)查找节点
 * 2. 双向链表：O(1)删除和移动节点
 *   - 链表头部：最近使用的节点
 *   - 链表尾部：最久未使用的节点
 * 
 * 时间复杂度：O(1)（所有操作）
 * 空间复杂度：O(capacity)
 */
public class LruCache146 {

    public static void main(String[] args) {
        LruCache146 cache = new LruCache146(2);
        
        // 测试用例1：正常操作
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("测试用例1(get 1): " + cache.get(1)); // 1
        
        // 测试用例2：超出容量
        cache.put(3, 3);
        System.out.println("测试用例2(get 2): " + cache.get(2)); // -1
        
        // 测试用例3：更新值
        cache.put(4, 4);
        System.out.println("测试用例3(get 1): " + cache.get(1)); // -1
        System.out.println("测试用例3(get 3): " + cache.get(3)); // 3
        System.out.println("测试用例3(get 4): " + cache.get(4)); // 4
    }

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public LruCache146(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        
        // 初始化双向链表的哨兵节点
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        
        // 移动到链表头部
        removeNode(node);
        addToHead(node);
        
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        
        if (node == null) {
            // 新节点
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size++;
            
            // 超出容量，删除尾部节点
            if (size > capacity) {
                Node tailNode = removeTail();
                map.remove(tailNode.key);
                size--;
            }
        } else {
            // 更新值并移动到头部
            node.value = value;
            removeNode(node);
            addToHead(node);
        }
    }

    /**
     * 将节点添加到链表头部
     */
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 删除指定节点
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 删除尾部节点（最久未使用）
     */
    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }
}