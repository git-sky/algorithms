package cn.com.sky.algorithms.interview;

import java.util.Arrays;

/**
 * <pre>
 * 约瑟夫环 - 数组模拟法【Medium】
 *
 * 题目：N个人围成一圈，从第1个人开始报数，报到k的人出列，
 * 然后从下一个人重新开始报数，求出列顺序。
 *
 * 算法原理（数组标记法）：
 * 1. 使用数组标记每个人是否已出列（-1表示已出列）
 * 2. 每次数k个未出列的人，将第k个人标记为出列
 * 3. 循环直到所有人都出列
 *
 * 时间复杂度：O(n*k)
 * 空间复杂度：O(n)
 *
 * 注意：此方法效率低于公式法O(n)，但直观易懂，适合理解约瑟夫环的过程
 * 最优解法见 JosephusProblem.java 的公式法 f(n,k) = (f(n-1,k) + k) % n
 * </pre>
 */
public class JosephusProblemByArray {

    public static void main(String[] args) {
        // 测试用例1：N=41, k=3
        System.out.println("=== 测试用例1：N=41, k=3 ===");
        int[] arr1 = new int[41];
        for (int i = 0; i < 41; i++) {
            arr1[i] = i + 1;
        }
        del(arr1, 41, 3);

        // 测试用例2：N=5, k=2
        System.out.println("\n=== 测试用例2：N=5, k=2 ===");
        int[] arr2 = new int[5];
        for (int i = 0; i < 5; i++) {
            arr2[i] = i + 1;
        }
        del(arr2, 5, 2);

        // 测试用例3：N=1, k=1
        System.out.println("\n=== 测试用例3：N=1, k=1 ===");
        int[] arr3 = new int[1];
        arr3[0] = 1;
        del(arr3, 1, 1);

        // 测试用例4：N=7, k=1（每次出列第1个人）
        System.out.println("\n=== 测试用例4：N=7, k=1 ===");
        int[] arr4 = new int[7];
        for (int i = 0; i < 7; i++) {
            arr4[i] = i + 1;
        }
        del(arr4, 7, 1);
    }

    /**
     * 数组模拟约瑟夫环
     *
     * @param arr 人员数组（出列后置为-1）
     * @param N   总人数
     * @param k   报数到k出列
     */
    private static void del(int[] arr, int N, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return;
        }

        int pos = 0;
        int remaining = N;

        while (remaining > 0) {
            // 数k个未出列的人
            for (int i = 1; i < k; ) {
                if (arr[pos] != -1) {
                    i++;
                }
                pos++;
                if (pos >= arr.length) {
                    pos %= arr.length;
                }
            }
            // 跳过已出列的人
            while (arr[pos] == -1) {
                pos++;
                if (pos >= arr.length) {
                    pos %= arr.length;
                }
            }
            // 标记出列
            System.out.println("出列: " + arr[pos]);
            arr[pos] = -1;
            remaining--;
            pos++;
            if (pos >= arr.length) {
                pos %= arr.length;
            }
        }
        System.out.println("最终数组: " + Arrays.toString(arr));
    }
}