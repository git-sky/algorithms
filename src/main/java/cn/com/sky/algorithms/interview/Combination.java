package cn.com.sky.algorithms.interview;

/**
 * <pre>
 * 组合问题（0/1背包变种）【Medium】
 *
 * 题目：输入两个整数n和m，从数列1,2,3,...,n中随意取几个数，
 * 使其和等于m，要求将其中所有的可能组合列出来。
 *
 * 算法原理（递归回溯 / 0/1背包思路）：
 * 对于每个数n，有两种选择：选或不选
 * 1. 选n：子问题变为 find(n-1, m-n)
 * 2. 不选n：子问题变为 find(n-1, m)
 *
 * 剪枝优化：
 * 1. 如果n > m，则n中大于m的数不可能参与组合，直接置n = m
 * 2. 如果n == m，则1~n的所有数都必须选（唯一组合），直接输出
 *
 * 时间复杂度：O(2^n)，最坏情况下每个数都有选或不选两种情况
 * 空间复杂度：O(n)，递归栈深度和标记数组
 * </pre>
 */
public class Combination {

    public static void main(String[] args) {
        // 测试用例1：n=10, m=15
        System.out.println("=== 测试用例1：n=10, m=15 ===");
        findCombination(10, 15, new int[10]);

        // 测试用例2：n=5, m=5
        System.out.println("\n=== 测试用例2：n=5, m=5 ===");
        findCombination(5, 5, new int[5]);

        // 测试用例3：n=5, m=1
        System.out.println("\n=== 测试用例3：n=5, m=1 ===");
        findCombination(5, 1, new int[5]);

        // 测试用例4：n=5, m=20（m > 1+2+3+4+5=15，无解）
        System.out.println("\n=== 测试用例4：n=5, m=20 ===");
        findCombination(5, 20, new int[5]);

        // 测试用例5：n=1, m=1
        System.out.println("\n=== 测试用例5：n=1, m=1 ===");
        findCombination(1, 1, new int[1]);
    }

    /**
     * 递归查找和为m的组合
     *
     * @param n     当前考虑的最大数
     * @param m     剩余需要凑的和
     * @param items 标记数组，items[i]=1表示(i+1)被选中
     */
    public static void findCombination(int n, int m, int[] items) {
        if (n < 1 || m < 1) {
            return;
        }

        // 剪枝：大于m的数不可能参与组合
        if (n > m) {
            n = m;
        }

        // 边界条件：n==m时，1~n全选是唯一解
        if (n == m) {
            items[n - 1] = 1;
            print(items);
            items[n - 1] = 0;
        }

        // 选择n：递归求解 n-1, m-n
        items[n - 1] = 1;
        findCombination(n - 1, m - n, items);

        // 不选择n：递归求解 n-1, m
        items[n - 1] = 0;
        findCombination(n - 1, m, items);
    }

    private static void print(int[] items) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == 1) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }
}