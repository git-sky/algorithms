package cn.com.sky.algorithms.interview.stack_queue;

import java.util.Stack;

/**
 * 汉诺塔问题【Hard】
 * 
 * 有三根柱子A、B、C，A柱上有n个盘子，从上到下依次增大。
 * 要求将所有盘子从A柱移动到C柱，每次只能移动一个盘子，且大盘子不能放在小盘子上面。
 * 
 * 算法原理（递归）：
 * 1. 将n-1个盘子从A移动到B（借助C）
 * 2. 将第n个盘子从A移动到C
 * 3. 将n-1个盘子从B移动到C（借助A）
 * 
 * 时间复杂度：O(2^n)
 * 空间复杂度：O(n)（递归栈）
 */
public class StackHanoiTower {

    public static void main(String[] args) {
        StackHanoiTower solution = new StackHanoiTower();
        
        // 测试用例1：3个盘子
        System.out.println("测试用例1(3个盘子):");
        solution.hanoi(3, 'A', 'B', 'C');
        
        System.out.println("\n测试用例2(1个盘子):");
        solution.hanoi(1, 'A', 'B', 'C');
        
        System.out.println("\n测试用例3(2个盘子):");
        solution.hanoi(2, 'A', 'B', 'C');
        
        // 测试用例4：使用栈实现
        System.out.println("\n测试用例4(栈实现，3个盘子):");
        solution.hanoiWithStack(3, "A", "B", "C");
    }

    /**
     * 递归实现汉诺塔
     * 
     * @param n      盘子数量
     * @param from   源柱子
     * @param helper 辅助柱子
     * @param to     目标柱子
     */
    public void hanoi(int n, char from, char helper, char to) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        
        // 将n-1个盘子从from移动到helper
        hanoi(n - 1, from, to, helper);
        
        // 将第n个盘子从from移动到to
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        
        // 将n-1个盘子从helper移动到to
        hanoi(n - 1, helper, from, to);
    }

    /**
     * 使用栈实现汉诺塔
     */
    public void hanoiWithStack(int n, String from, String helper, String to) {
        Stack<Integer> fromStack = new Stack<>();
        Stack<Integer> helperStack = new Stack<>();
        Stack<Integer> toStack = new Stack<>();
        
        // 初始化源栈
        for (int i = n; i >= 1; i--) {
            fromStack.push(i);
        }
        
        int totalMoves = (int) Math.pow(2, n) - 1;
        
        // 如果n是偶数，交换helper和to
        if (n % 2 == 0) {
            String temp = helper;
            helper = to;
            to = temp;
        }
        
        for (int i = 1; i <= totalMoves; i++) {
            if (i % 3 == 1) {
                move(fromStack, toStack, from, to);
            } else if (i % 3 == 2) {
                move(fromStack, helperStack, from, helper);
            } else {
                move(helperStack, toStack, helper, to);
            }
        }
    }

    /**
     * 移动盘子
     */
    private void move(Stack<Integer> fromStack, Stack<Integer> toStack, String from, String to) {
        if (fromStack.isEmpty()) {
            int disk = toStack.pop();
            fromStack.push(disk);
            System.out.println("Move disk " + disk + " from " + to + " to " + from);
        } else if (toStack.isEmpty()) {
            int disk = fromStack.pop();
            toStack.push(disk);
            System.out.println("Move disk " + disk + " from " + from + " to " + to);
        } else if (fromStack.peek() < toStack.peek()) {
            int disk = fromStack.pop();
            toStack.push(disk);
            System.out.println("Move disk " + disk + " from " + from + " to " + to);
        } else {
            int disk = toStack.pop();
            fromStack.push(disk);
            System.out.println("Move disk " + disk + " from " + to + " to " + from);
        }
    }
}