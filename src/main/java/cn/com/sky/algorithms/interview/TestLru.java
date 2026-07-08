package cn.com.sky.algorithms.interview;

/**
 * <pre>
 * LRU缓存测试类【Medium】
 *
 * 测试LRU缓存的put、get操作，验证最近最少使用淘汰策略
 *
 * LRU算法原理（Least Recently Used）：
 * 1. 使用双向链表维护访问顺序，最近访问的节点在头部，最久未访问的在尾部
 * 2. put操作：新元素插入头部，超过容量时淘汰尾部元素
 * 3. get操作：命中后将元素移到头部
 * 4. 使用头结点（dummy head）简化边界处理
 *
 * 时间复杂度：
 * - get: O(n)（当前实现需遍历链表查找，可用HashMap优化为O(1)）
 * - put: O(n)（需先get判断是否存在）
 *
 * 优化方向：加入HashMap使get/put达到O(1)
 * </pre>
 */
public class TestLru {

    public static void main(String[] args) {
        // 测试用例1：基本操作
        System.out.println("=== 测试用例1：基本操作 ===");
        Lru lru = new Lru(5);
        lru.put("1");
        lru.put("2");
        lru.put("3");
        lru.put("4");
        lru.put("5");
        lru.print(); // 5->4->3->2->1->

        // 测试用例2：超过容量，淘汰最久未访问
        System.out.println("\n=== 测试用例2：超过容量 ===");
        lru.put("6");
        lru.print(); // 6->5->4->3->2->（1被淘汰）

        // 测试用例3：get后移到头部
        System.out.println("\n=== 测试用例3：get后移到头部 ===");
        lru.get("3");
        lru.print(); // 3->6->5->4->2->

        // 测试用例4：get不存在的元素
        System.out.println("\n=== 测试用例4：get不存在的元素 ===");
        String result = lru.get("1");
        System.out.println("get(1): " + result); // null

        // 测试用例5：put已存在的元素
        System.out.println("\n=== 测试用例5：put已存在的元素 ===");
        lru.put("4");
        lru.print(); // 4->3->6->5->2->

        // 测试用例6：容量为1
        System.out.println("\n=== 测试用例6：容量为1 ===");
        Lru lru2 = new Lru(1);
        lru2.put("a");
        lru2.put("b");
        lru2.print(); // b->（a被淘汰）
    }

    /**
     * LRU缓存实现
     *
     * 实现思路：put和get的时候把元素放到头部，当大于capacity的时候，移除最后一个元素。
     *
     * 使用双向链表实现，带有头结点，头结点的next指向第一个元素，pre指向最后一个元素，最后一个元素的next指向头结点。
     */
    public static class Lru {

        private Entry<String> head = new Entry<String>(null, "head", null);

        private int capacity;
        private int count;

        Lru(int capacity) {
            this.capacity = capacity;
            init();
        }

        private void init() {
            head.next = head;
            head.pre = head;
        }

        public void put(String str) {
            String ret = get(str);
            if (ret == null) {
                if (count >= capacity) {
                    removeOldest();
                }
                count++;
                add(str);
            }
        }

        /**
         * 移除最久未访问的节点（尾部节点）
         */
        private void removeOldest() {
            Entry entry = head.pre;
            entry.pre.next = head;
            head.pre = entry.pre;
            entry.pre = null;
            entry.next = null;
        }

        /**
         * 头部插入新节点
         * head.next指向第一个元素，head.pre指向最后一个元素
         */
        public void add(String str) {
            Entry<String> entry = new Entry<String>(head, str, head.next);
            head.next.pre = entry;
            head.next = entry;
        }

        /**
         * 获取元素，命中后移到头部
         */
        public String get(String str) {
            for (Entry<String> e = head.next; e != head; e = e.next) {
                if (e.value.equals(str)) {
                    recordAccess(e);
                    return e.value;
                }
            }
            return null;
        }

        public void print() {
            for (Entry<String> e = head.next; e != head; e = e.next) {
                System.out.print(e.value);
                System.out.print("->");
            }
            System.out.println();
        }

        /**
         * 每访问一次，就移动到头部
         */
        private void recordAccess(Entry e) {
            e.next.pre = e.pre;
            e.pre.next = e.next;

            e.next = head.next;
            head.next.pre = e;

            head.next = e;
            e.pre = head;
        }

        class Entry<E> {
            Entry pre;
            E value;
            Entry next;

            Entry(Entry pre, E value, Entry next) {
                this.pre = pre;
                this.value = value;
                this.next = next;
            }
        }
    }
}