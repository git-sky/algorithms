package cn.com.sky.algorithms.interview.stack_queue;

import java.util.Stack;

/**
 * <pre>
 * 汉诺塔问题【Hard】
 * 
 * 题目描述：有三根柱子A、B、C，A柱上有n个大小不同的盘子，
 * 要求将所有盘子从A柱移动到C柱，每次只能移动一个盘子，
 * 且任何时刻大盘子不能放在小盘子上面。
 * 
 * 算法原理（递归）：
 * 1. 将n-1个盘子从A移动到B（借助C）
 * 2. 将第n个盘子从A移动到C
 * 3. 将n-1个盘子从B移动到C（借助A）
 * 
 * 时间复杂度：O(2^n)
 * 空间复杂度：O(n)（递归栈深度）
 * 
 * 移动次数公式：2^n - 1
 * </pre>
 */
public class StackHanoiTower {

    public static void main(String[] args) {
        StackHanoiTower tower = new StackHanoiTower();
        
        // 测试用例1：3个盘子
        System.out.println("=== 测试用例1：3个盘子 ===");
        tower.hanoi(3, 'A', 'B', 'C');
        
        // 测试用例2：1个盘子
        System.out.println("\n=== 测试用例2：1个盘子 ===");
        tower.hanoi(1, 'A', 'B', 'C');
        
        // 测试用例3：2个盘子
        System.out.println("\n=== 测试用例3：2个盘子 ===");
        tower.hanoi(2, 'A', 'B', 'C');
        
        // 测试用例4：4个盘子
        System.out.println("\n=== 测试用例4：4个盘子 ===");
        tower.hanoi(4, 'A', 'B', 'C');
    }

    /**
     * 汉诺塔递归解法
     * 
     * @param n 盘子数量
     * @param from 源柱子
     * @param aux 辅助柱子
     * @param to 目标柱子
     */
    public void hanoi(int n, char from, char aux, char to) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        
        // 将n-1个盘子从from移动到aux（借助to）
        hanoi(n - 1, from, to, aux);
        
        // 将第n个盘子从from移动到to
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        
        // 将n-1个盘子从aux移动到to（借助from）
        hanoi(n - 1, aux, from, to);
    }

    /**
     * 汉诺塔非递归解法（使用栈）
     */
    public void hanoiIterative(int n, char from, char aux, char to) {
        Stack<Integer> stack = new Stack<>();
        Stack<Character> fromStack = new Stack<>();
        Stack<Character> auxStack = new Stack<>();
        Stack<Character> toStack = new Stack<>();
        
        // 初始状态：将所有盘子放入源柱子
        for (int i = n; i >= 1; i--) {
            stack.push(i);
        }
        
        // 使用三个栈模拟三根柱子
        Stack<Integer>[] towers = new Stack[3];
        towers[0] = new Stack<>(); // A
        towers[1] = new Stack<>(); // B
        towers[2] = new Stack<>(); // C
        
        // 将所有盘子放到A柱
        for (int i = n; i >= 1; i--) {
            towers[0].push(i);
        }
        
        char[] labels = {from, aux, to};
        int totalMoves = (int) Math.pow(2, n) - 1;
        
        // 奇数步：移动最小盘子到下一个柱子（循环）
        // 偶数步：移动另外两个柱子间的合法盘子
        int smallest = 0; // 当前最小盘子所在的柱子索引
        
        for (int step = 1; step <= totalMoves; step++) {
            if (step % 2 == 1) {
                // 奇数步：移动最小盘子
                int disk = towers[smallest].pop();
                int next = (smallest + 1) % 3;
                towers[next].push(disk);
                System.out.println("Move disk " + disk + " from " + labels[smallest] + " to " + labels[next]);
                smallest = next;
            } else {
                // 偶数步：移动非最小盘子
                int other1 = (smallest + 1) % 3;
                int other2 = (smallest + 2) % 3;
                
                if (towers[other1].isEmpty()) {
                    moveDisk(towers, other2, other1, labels);
                } else if (towers[other2].isEmpty()) {
                    moveDisk(towers, other1, other2, labels);
                } else if (towers[other1].peek() < towers[other2].peek()) {
                    moveDisk(towers, other1, other2, labels);
                } else {
                    moveDisk(towers, other2, other1, labels);
                }
            }
        }
    }

    private void moveDisk(Stack<Integer>[] towers, int from, int to, char[] labels) {
        int disk = towers[from].pop();
        towers[to].push(disk);
        System.out.println("Move disk " + disk + " from " + labels[from] + " to " + labels[to]);
    }
}