package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 581. 最短无序连续子数组【Medium】
 * 
 * 题目描述：给定一个整数数组，你需要寻找一个连续的子数组，
 * 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 找到最短的这样的子数组，并输出它的长度。
 * 
 * 示例：
 * 输入：[2, 6, 4, 8, 10, 9, 15]
 * 输出：5（对 [6, 4, 8, 10, 9] 排序后整个数组有序）
 * 
 * 算法原理（一次遍历）：
 * 1. 从左到右遍历，维护当前最大值 max
 *    - 如果 A[i] < max，说明 A[i] 不在正确位置，更新 end = i
 * 2. 从右到左遍历，维护当前最小值 min
 *    - 如果 A[n-1-i] > min，说明该元素不在正确位置，更新 begin = n-1-i
 * 3. 结果为 end - begin + 1
 * 
 * 原理：
 * - 从左到右，max 记录已遍历部分的最大值
 * - 如果当前元素小于 max，说明排序后它应该在 max 之前
 * - 最右端这样的位置就是无序子数组的右边界
 * - 同理可得左边界
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class ShortestUnsortedContinuousSubarray581 {

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray581 solution = new ShortestUnsortedContinuousSubarray581();

        // 测试用例1：正常情况
        System.out.println("测试用例1: " + solution.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15})); // 5

        // 测试用例2：已排序
        System.out.println("测试用例2: " + solution.findUnsortedSubarray(new int[]{1, 2, 3, 4})); // 0

        // 测试用例3：逆序
        System.out.println("测试用例3: " + solution.findUnsortedSubarray(new int[]{4, 3, 2, 1})); // 4

        // 测试用例4：单元素
        System.out.println("测试用例4: " + solution.findUnsortedSubarray(new int[]{1})); // 0

        // 测试用例5：两个元素
        System.out.println("测试用例5: " + solution.findUnsortedSubarray(new int[]{2, 1})); // 2

        // 测试用例6：首尾有序
        System.out.println("测试用例6: " + solution.findUnsortedSubarray(new int[]{1, 3, 2, 4})); // 2
    }

    public int findUnsortedSubarray(int[] A) {
        int n = A.length;
        int begin = -1, end = -2;
        int min = A[n - 1], max = A[0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n - 1 - i]);

            if (A[i] < max) {
                end = i;
            }
            if (A[n - 1 - i] > min) {
                begin = n - 1 - i;
            }
        }

        return end - begin + 1;
    }
}