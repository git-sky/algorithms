package cn.com.sky.algorithms.ByteDance.top10;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LruCache146 {


    @Test
    public void testLru() {

        LruCache146.LRUCacheV1 lru = new LruCache146.LRUCacheV1(10);

        for (int i = 0; i < 100; i++) {
            lru.put(i, i);
            lru.print();
        }

        for (int i = 0; i < 100; i++) {
            lru.put(i, i);
            lru.print();
        }

        lru.get(95);
        lru.get(91);
        lru.print();
    }


    /**
     * 解法1：面试一般用这个。
     * 双向链表 + 哈希表(原生HashMap) 实现LRUCache
     */
    public static class LRUCacheV1 {
        // 双向链表节点
        static class DNode {
            int key;
            int value;
            DNode prev;
            DNode next;

            DNode() {
            }

            DNode(int k, int v) {
                key = k;
                value = v;
            }
        }

        private Map<Integer, DNode> cache;
        private DNode head, tail;
        private int capacity;
        private int size;

        public LRUCacheV1(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            head = new DNode();
            tail = new DNode();
            // 初始化哨兵头尾相连
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            DNode node = cache.get(key);
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                // 已存在，更新值并移到头部
                DNode node = cache.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                // 新建节点
                DNode newNode = new DNode(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
                size++;
                // 超出容量，删除尾节点
                if (size > capacity) {
                    DNode removeNode = removeTail();
                    cache.remove(removeNode.key);
                    size--;
                }
            }
        }

        // 将节点加入头部（head后面）
        private void addToHead(DNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        // 移除链表中该节点
        private void removeNode(DNode node) {
            DNode pre = node.prev;
            DNode nxt = node.next;
            pre.next = nxt;
            nxt.prev = pre;
        }

        // 访问后移到表头
        private void moveToHead(DNode node) {
            removeNode(node);
            addToHead(node);
        }

        // 删除最久未使用的尾部节点
        private DNode removeTail() {
            DNode last = tail.prev;
            removeNode(last);
            return last;
        }

        public void print() {
            for (DNode e = head.next; e != tail; e = e.next) {
                System.out.print(e.key + ":" + e.value);
                System.out.print("->");
            }
            System.out.println();
        }
    }

    /**
     * 解法2：面试一般不用这个。
     * 双向链表 + 哈希表(自定义HashMap) + 自定义hash冲突解决
     */
    public static class LRUCacheV2 {
        // 双向链表节点
        static class DNode {
            int key;
            int val;
            DNode prev;
            DNode next;

            DNode(int k, int v) {
                key = k;
                val = v;
            }
        }

        // 哈希表桶内单向链表节点，解决hash冲突
        static class HashNode {
            int key;
            DNode dNode;
            HashNode next;

            HashNode(int k, DNode node) {
                key = k;
                dNode = node;
            }
        }

        // 哈希桶数组，自定义容量
        private final int HASH_SIZE = 1009;
        private HashNode[] hashTable;

        // 双向链表哨兵头尾
        private DNode head;
        private DNode tail;

        private int capacity;
        private int size;

        public LRUCacheV2(int capacity) {
            this.capacity = capacity;
            size = 0;
            // 初始化哈希桶数组
            hashTable = new HashNode[HASH_SIZE];
            // 初始化双向链表哨兵
            head = new DNode(-1, -1);
            tail = new DNode(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        // hash映射
        private int hash(int key) {
            return key % HASH_SIZE;
        }

        // 在哈希表中根据key查找DNode，找不到返回null
        private DNode getNodeByKey(int key) {
            int idx = hash(key);
            HashNode cur = hashTable[idx];
            while (cur != null) {
                if (cur.key == key) {
                    return cur.dNode;
                }
                cur = cur.next;
            }
            return null;
        }

        // 哈希表新增/更新key-dNode映射
        private void putHash(int key, DNode node) {
            int idx = hash(key);
            HashNode cur = hashTable[idx];
            // 先找是否已存在，存在则更新
            while (cur != null) {
                if (cur.key == key) {
                    cur.dNode = node;
                    return;
                }
                cur = cur.next;
            }
            // 不存在，头插法加入哈希桶链表
            HashNode newHashNode = new HashNode(key, node);
            newHashNode.next = hashTable[idx];
            hashTable[idx] = newHashNode;
        }

        // 哈希表删除key
        private void removeHash(int key) {
            int idx = hash(key);
            HashNode cur = hashTable[idx];
            HashNode pre = null;
            while (cur != null) {
                if (cur.key == key) {
                    if (pre == null) {
                        hashTable[idx] = cur.next;
                    } else {
                        pre.next = cur.next;
                    }
                    return;
                }
                pre = cur;
                cur = cur.next;
            }
        }

        // 双向链表：移除指定节点
        private void removeDNode(DNode node) {
            DNode p = node.prev;
            DNode n = node.next;
            p.next = n;
            n.prev = p;
        }

        // 双向链表：节点插入头部（head后）
        private void addToHead(DNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        // 访问节点，移到表头
        private void moveToHead(DNode node) {
            removeDNode(node);
            addToHead(node);
        }

        // 删除尾部最久未使用节点
        private DNode removeTail() {
            DNode del = tail.prev;
            removeDNode(del);
            return del;
        }

        public int get(int key) {
            DNode target = getNodeByKey(key);
            if (target == null) {
                return -1;
            }
            moveToHead(target);
            return target.val;
        }

        public void put(int key, int value) {
            DNode exist = getNodeByKey(key);
            if (exist != null) {
                // 已存在，更新值并移到表头
                exist.val = value;
                moveToHead(exist);
                return;
            }
            // 新建节点
            DNode newNode = new DNode(key, value);
            putHash(key, newNode);
            addToHead(newNode);
            size++;

            // 超出容量，淘汰尾节点
            if (size > capacity) {
                DNode delNode = removeTail();
                removeHash(delNode.key);
                size--;
            }
        }


        public void print() {
            for (DNode e = head.next; e != tail; e = e.next) {
                System.out.print(e.key + ":" + e.val);
                System.out.print("->");
            }
            System.out.println();
        }
    }
}
