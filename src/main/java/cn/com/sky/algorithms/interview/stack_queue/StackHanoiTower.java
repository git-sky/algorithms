package cn.com.sky.algorithms.interview.stack_queue;

import java.util.Stack;

/**
 * <pre>
 * 汉诺塔问题（栈模拟）【Medium】
 *
 * 题目：将N个圆盘从左塔移动到右塔，每次只能移动一个圆盘，
 * 且大盘不能放在小盘上面。用栈模拟塔。
 *
 * 算法原理（递归分治）：
 * 1. 将n-1个圆盘从源塔移动到辅助塔（借助目标塔）
 * 2. 将第n个圆盘从源塔移动到目标塔
 * 3. 将n-1个圆盘从辅助塔移动到目标塔（借助源塔）
 *
 * 递归关系：T(n) = 2*T(n-1) + 1
 * 总移动次数：2^n - 1
 *
 * 时间复杂度：O(2^n)
 * 空间复杂度：O(n)（递归栈深度）
 * </pre>
 */
public class StackHanoiTower {

    public static void main(String[] args) {
        // 测试用例1：3个圆盘
        System.out.println("=== 测试用例1：3个圆盘 ===");
        hanoi(3, "A", "B", "C");

        // 测试用例2：1个圆盘
        System.out.println("\n=== 测试用例2：1个圆盘 ===");
        hanoi(1, "A", "B", "C");

        // 测试用例3：2个圆盘
        System.out.println("\n=== 测试用例3：2个圆盘 ===");
        hanoi(2, "A", "B", "C");

        // 测试用例4：栈模拟汉诺塔
        System.out.println("\n=== 测试用例4：栈模拟汉诺塔 ===");
        Stack<Integer> left = new Stack<>();
        Stack<Integer> mid = new Stack<>();
        Stack<Integer> right = new Stack<>();

        for (int i = 5; i >= 1; i--) {
            left.push(i);
        }

        System.out.println("移动前 left: " + left);
        hanoiStack(5, left, mid, right, "left", "mid", "right");
        System.out.println("移动后 right: " + right);
    }

    /**
     * 递归法求解汉诺塔
     *
     * @param n    圆盘数量
     * @param from 源塔
     * @param mid  辅助塔
     * @param to   目标塔
     */
    public static void hanoi(int n, String from, String mid, String to) {
        if (n == 1) {
            System.out.println("移动圆盘 " + n + " 从 " + from + " 到 " + to);
            return;
        }
        hanoi(n - 1, from, to, mid);
        System.out.println("移动圆盘 " + n + " 从 " + from + " 到 " + to);
        hanoi(n - 1, mid, from, to);
    }

    /**
     * 用栈模拟汉诺塔
     * 原理与递归法相同，但使用栈来存储圆盘
     */
    public static int hanoiStack(int n, Stack<Integer> left, Stack<Integer> mid,
                                  Stack<Integer> right, String from, String midName, String to) {
        if (n == 1) {
            int disk = left.pop();
            right.push(disk);
            System.out.println("Move " + disk + " from " + from + " to " + to);
            return 1;
        }

        Stack<Integer> tempLeft = new Stack<>();
        Stack<Integer> tempMid = new Stack<>();

        // 将n-1个圆盘从left移到mid
        int count = hanoiStack(n - 1, left, right, mid, from, to, midName);

        // 将第n个圆盘从left移到right
        int disk = left.pop();
        right.push(disk);
        System.out.println("Move " + disk + " from " + from + " to " + to);
        count++;

        // 将n-1个圆盘从mid移到right
        count += hanoiStack(n - 1, mid, left, right, midName, from, to);

        return count;
    }
}