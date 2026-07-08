package cn.com.sky.algorithms.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * LRU缓存实现与测试【Medium】（字节跳动/腾讯高频）
 *
 * 题目：设计并实现一个LRU（最近最少使用）缓存机制
 * 获取数据 get(key)：如果key存在于缓存中，则获取key的值（总是正数），否则返回-1
 * 写入数据 put(key, value)：如果key不存在，则写入其值。当缓存容量达到上限时，
 * 它应该在写入新数据之前删除最久未使用的数据值，从而为新数据值留出空间
 *
 * 算法原理（HashMap + 双向链表，最优）：
 * 1. HashMap用于O(1)时间查找key对应的链表节点
 * 2. 双向链表维护访问顺序：
 *    - 头部（靠近head）表示最近访问的节点
 *    - 尾部（靠近tail）表示最久未访问的节点
 * 3. get操作：
 *    - 通过HashMap找到节点，O(1)
 *    - 将节点移到链表头部，O(1)
 * 4. put操作：
 *    - 如果key存在：更新value并移到头部
 *    - 如果key不存在：
 *      - 创建新节点插入头部
 *      - 如果超容量，删除尾部节点
 *
 * 为什么使用双向链表？
 * - 单向链表删除节点需要前驱节点，需要O(n)查找
 * - 双向链表可以直接通过节点的pre指针删除自己，O(1)
 *
 * 为什么使用虚拟头尾节点（dummy head/tail）？
 * - 简化边界处理，避免判断null
 * - 删除和插入操作统一化
 *
 * 时间复杂度：get O(1)，put O(1)
 * 空间复杂度：O(capacity)
 * </pre>
 */
public class TestLru {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        // 测试用例1：基本操作
        System.out.println("=== 测试用例1：基本操作 ===");
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("get(1): " + cache.get(1));       // 返回 1
        cache.put(3, 3);                                     // 该操作会使得密钥 2 作废
        System.out.println("get(2): " + cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);                                     // 该操作会使得密钥 1 作废
        System.out.println("get(1): " + cache.get(1));       // 返回 -1 (未找到)
        System.out.println("get(3): " + cache.get(3));       // 返回 3
        System.out.println("get(4): " + cache.get(4));       // 返回 4

        // 测试用例2：容量为1
        System.out.println("\n=== 测试用例2：容量为1 ===");
        LRUCache cache2 = new LRUCache(1);
        cache2.put(2, 1);
        System.out.println("get(2): " + cache2.get(2));      // 返回 1
        cache2.put(3, 2);                                    // 该操作会使得密钥 2 作废
        System.out.println("get(2): " + cache2.get(2));      // 返回 -1 (未找到)
        System.out.println("get(3): " + cache2.get(3));      // 返回 2

        // 测试用例3：重复put相同key
        System.out.println("\n=== 测试用例3：重复put相同key ===");
        LRUCache cache3 = new LRUCache(2);
        cache3.put(1, 1);
        cache3.put(2, 2);
        cache3.put(1, 10);                                   // 更新key=1的value
        System.out.println("get(1): " + cache3.get(1));      // 返回 10
        cache3.put(3, 3);                                    // 淘汰key=2
        System.out.println("get(2): " + cache3.get(2));      // 返回 -1 (未找到)

        // 测试用例4：连续get同一个key
        System.out.println("\n=== 测试用例4：连续get同一个key ===");
        LRUCache cache4 = new LRUCache(2);
        cache4.put(1, 1);
        cache4.put(2, 2);
        cache4.get(1);                                       // 访问key=1，使其变为最近使用
        cache4.get(1);                                       // 再次访问
        cache4.put(3, 3);                                    // 应该淘汰key=2而不是key=1
        System.out.println("get(2): " + cache4.get(2));      // 返回 -1 (被淘汰)
        System.out.println("get(1): " + cache4.get(1));      // 返回 1
        System.out.println("get(3): " + cache4.get(3));      // 返回 3
    }

    /**
     * LRU缓存实现类（最优解：HashMap + 双向链表）
     */
    public static class LRUCache {

        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        /**
         * 双向链表节点
         */
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            DLinkedNode() {}

            DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        /**
         * 获取key对应的value，不存在返回-1
         * 时间复杂度：O(1)
         */
        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        /**
         * 写入key-value对
         * 时间复杂度：O(1)
         */
        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);

            if (node == null) {
                DLinkedNode newNode = new DLinkedNode(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
                ++size;

                if (size > capacity) {
                    DLinkedNode tail = removeTail();
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        /**
         * 将节点添加到链表头部
         */
        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        /**
         * 从链表中删除节点
         */
        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        /**
         * 将节点移动到链表头部（最近访问）
         */
        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        /**
         * 移除链表尾部节点（最久未访问）
         */
        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }
    }
}