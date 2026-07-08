package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 414. 第三大的数【Easy】
 * 
 * 题目描述：给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。
 * 注意：第三大是指第三大的不同数。
 * 
 * 示例1：输入 [3, 2, 1]，输出 1
 * 示例2：输入 [1, 2]，输出 2（第三大不存在，返回最大值）
 * 示例3：输入 [2, 2, 3, 1]，输出 1（去重后第三大是1）
 * 
 * 算法原理（维护三个变量）：
 * 1. 使用三个变量 max1, max2, max3 分别记录第一、第二、第三大的数
 * 2. 遍历数组，对于每个元素：
 *    - 如果等于已有的最大值，跳过（去重）
 *    - 如果大于 max1，依次下移 max1→max2→max3
 *    - 如果大于 max2，依次下移 max2→max3
 *    - 如果大于 max3，更新 max3
 * 3. 如果 max3 为 null，返回 max1
 * 
 * 使用 Integer 而非 int 的原因：需要区分"未设置"和"值为0"
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class ThirdMaximumNumber414 {

    public static void main(String[] args) {
        ThirdMaximumNumber414 solution = new ThirdMaximumNumber414();

        // 测试用例1：有三个不同的数
        System.out.println("测试用例1: " + solution.thirdMax(new int[]{3, 2, 1})); // 1

        // 测试用例2：只有两个不同的数
        System.out.println("测试用例2: " + solution.thirdMax(new int[]{1, 2}));    // 2

        // 测试用例3：有重复
        System.out.println("测试用例3: " + solution.thirdMax(new int[]{2, 2, 3, 1})); // 1

        // 测试用例4：全相同
        System.out.println("测试用例4: " + solution.thirdMax(new int[]{1, 1, 1})); // 1

        // 测试用例5：含负数
        System.out.println("测试用例5: " + solution.thirdMax(new int[]{1, -1, 2})); // -1

        // 测试用例6：含0和负数
        System.out.println("测试用例6: " + solution.thirdMax(new int[]{1, 2, Integer.MIN_VALUE})); // MIN_VALUE

        // 测试用例7：单元素
        System.out.println("测试用例7: " + solution.thirdMax(new int[]{5}));       // 5
    }

    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) {
                continue;
            }
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }

        return max3 == null ? max1 : max3;
    }
}