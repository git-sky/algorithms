package cn.com.sky.algorithms.interview;

import java.util.Arrays;

/**
 * <pre>
 * 简易HashMap实现【Medium】
 * 
 * 算法原理：
 * 1. 使用数组存储链表（链地址法解决哈希冲突）
 * 2. 通过hashCode()计算哈希值
 * 3. 通过取模运算确定数组索引
 * 4. 链表处理哈希冲突
 * 
 * 时间复杂度（平均）：
 * - get: O(1)
 * - put: O(1)
 * - remove: O(1)
 * 空间复杂度：O(n)
 * 
 * 注意：该实现未包含扩容机制
 * </pre>
 */
public class HashMap<K, V> {

    Entry[] entry;
    private int size = 16;
    private int count = 0;

    public HashMap() {
        entry = new Entry[16];
    }

    public HashMap(int capacity) {
        this.size = capacity;
        entry = new Entry[capacity];
    }

    static class Entry<K, V> {
        int hash;
        K key;
        V value;
        Entry<K, V> next;

        Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private int hash(K k) {
        return k != null ? k.hashCode() : 0;
    }

    private int index(int hash) {
        return hash & (size - 1); // 等价于hash % size（当size是2的幂次时）
    }

    public V remove(K k) {
        int hash = hash(k);
        int index = index(hash);

        Entry<K, V> first = entry[index];
        if (first != null) {
            Entry<K, V> pre = first;
            for (Entry<K, V> e = first; e != null; pre = e, e = e.next) {
                if (e.hash == hash && (k == e.key || k.equals(e.key))) {
                    if (pre == e) {
                        entry[index] = e.next;
                    } else {
                        pre.next = e.next;
                    }
                    count--;
                    return e.value;
                }
            }
        }
        return null;
    }

    public void put(K k, V v) {
        int hash = hash(k);
        int index = index(hash);

        // 先查找是否已存在相同key，存在则更新value
        for (Entry<K, V> e = entry[index]; e != null; e = e.next) {
            if (e.hash == hash && (k == e.key || k.equals(e.key))) {
                e.value = v;
                return;
            }
        }

        // 不存在则插入新节点（头插法）
        Entry<K, V> e = new Entry<>(hash, k, v, entry[index]);
        entry[index] = e;
        count++;
    }

    public V get(K k) {
        int hash = hash(k);
        int index = index(hash);

        for (Entry<K, V> e = entry[index]; e != null; e = e.next) {
            if (e.hash == hash && (k == e.key || k.equals(e.key))) {
                return e.value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // 测试用例1：基本操作
        System.out.println("=== 测试用例1：基本操作 ===");
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);
        System.out.println("apple: " + map.get("apple"));
        System.out.println("banana: " + map.get("banana"));
        System.out.println("size: " + map.size());

        // 测试用例2：更新值
        System.out.println("\n=== 测试用例2：更新值 ===");
        map.put("apple", 10);
        System.out.println("apple after update: " + map.get("apple"));

        // 测试用例3：删除操作
        System.out.println("\n=== 测试用例3：删除操作 ===");
        map.remove("banana");
        System.out.println("banana after remove: " + map.get("banana"));
        System.out.println("size after remove: " + map.size());

        // 测试用例4：获取不存在的key
        System.out.println("\n=== 测试用例4：获取不存在的key ===");
        System.out.println("grape: " + map.get("grape"));

        // 测试用例5：空map
        System.out.println("\n=== 测试用例5：空map ===");
        HashMap<Integer, String> emptyMap = new HashMap<>();
        System.out.println("emptyMap isEmpty: " + emptyMap.isEmpty());
        System.out.println("emptyMap size: " + emptyMap.size());
    }
}