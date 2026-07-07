package cn.com.sky.algorithms.searching.dynamics.skiplist;

import java.util.Random;

/**
 * <pre>
 * 跳表（Skip List）【Medium】
 * 
 * 算法原理：
 * 1. 基于链表的数据结构，通过增加索引层来加速查找
 * 2. 每一层都是一个有序链表
 * 3. 查找时从顶层开始，逐层向下
 * 4. 插入时随机决定节点的层数
 * 
 * 时间复杂度（平均）：
 * - 查找：O(log n)
 * - 插入：O(log n)
 * - 删除：O(log n)
 * 空间复杂度：O(n)（平均O(n log n)）
 * 
 * 适用场景：
 * - 需要快速插入、删除、查找的场景
 * - Redis中的有序集合实现
 * </pre>
 */
public class JumpList {
    private final int MAX_LEVEL = 16;
    private JumpNode head = new JumpNode(MAX_LEVEL);
    private JumpNode tail = new JumpNode(1);
    private JumpNode[] pres = new JumpNode[MAX_LEVEL];
    private int levels = 0;
    private Random rand = new Random();

    public JumpList() {
        tail.value = Integer.MAX_VALUE;
        for (int i = 0; i < MAX_LEVEL; i++) {
            head.nextLinks[i] = tail;
            pres[i] = head;
        }
        levels = 0;
    }

    /**
     * 更新前驱节点引用数组
     */
    private void updatePresRef(int x) {
        for (int i = levels; i >= 0; i--) {
            JumpNode p = head;
            while (p.nextLinks[i].value < x) {
                p = p.nextLinks[i];
            }
            pres[i] = p;
        }
    }

    /**
     * 随机生成节点层数（几何分布，概率1/2）
     */
    private int getLevel() {
        int lev = 0;
        while (rand.nextBoolean()) {
            lev++;
            if (lev >= MAX_LEVEL - 1) {
                break;
            }
        }
        if (lev > levels) {
            lev = ++levels;
        }
        return lev;
    }

    /**
     * 插入元素（无则插入，有则忽略）
     */
    public void insertElement(int x) {
        updatePresRef(x);
        if (pres[0].nextLinks[0].value == x) {
            return;
        }

        int lev = getLevel();
        JumpNode node = new JumpNode(lev + 1);
        node.value = x;

        for (int i = 0; i <= lev; i++) {
            node.nextLinks[i] = pres[i].nextLinks[i];
            pres[i].nextLinks[i] = node;
        }
    }

    /**
     * 删除元素（有则删，无则不变）
     */
    public void deleteElement(int x) {
        updatePresRef(x);
        if (pres[0].nextLinks[0].value != x) {
            return;
        }

        for (int i = 0; i <= levels && pres[i].nextLinks[i].value == x; i++) {
            pres[i].nextLinks[i] = pres[i].nextLinks[i].nextLinks[i];
        }
    }

    /**
     * 查找元素
     */
    public boolean searchElement(int x) {
        JumpNode p = head;
        for (int i = levels; i >= 0; i--) {
            while (p.nextLinks[i].value < x) {
                p = p.nextLinks[i];
            }
        }
        return p.nextLinks[0].value == x;
    }

    /**
     * 显示底层链表
     */
    public void display() {
        JumpNode p = head.nextLinks[0];
        while (p != tail) {
            System.out.print(p.value + " ");
            p = p.nextLinks[0];
        }
        System.out.println();
    }

    public static void main(String[] args) {
        JumpList jl = new JumpList();

        // 测试用例1：基本插入
        System.out.println("=== 测试用例1：基本插入 ===");
        jl.insertElement(10);
        jl.insertElement(4);
        jl.insertElement(5);
        jl.insertElement(7);
        jl.display();

        // 测试用例2：重复插入
        System.out.println("\n=== 测试用例2：重复插入 ===");
        jl.insertElement(5);
        jl.display();

        // 测试用例3：删除不存在元素
        System.out.println("\n=== 测试用例3：删除不存在元素 ===");
        jl.deleteElement(1);
        jl.display();

        // 测试用例4：删除存在元素
        System.out.println("\n=== 测试用例4：删除存在元素 ===");
        jl.deleteElement(7);
        jl.display();

        // 测试用例5：查找
        System.out.println("\n=== 测试用例5：查找 ===");
        System.out.println("查找4: " + jl.searchElement(4));
        System.out.println("查找7: " + jl.searchElement(7));

        // 测试用例6：更多插入
        System.out.println("\n=== 测试用例6：更多插入 ===");
        jl.insertElement(1);
        jl.insertElement(15);
        jl.insertElement(8);
        jl.display();
    }
}

class JumpNode {
    public int value;
    public JumpNode[] nextLinks = null;

    public JumpNode(int size) {
        nextLinks = new JumpNode[size];
        value = Integer.MAX_VALUE;
    }
}