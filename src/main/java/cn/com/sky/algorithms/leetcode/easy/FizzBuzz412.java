package cn.com.sky.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * <pre>
 * LeetCode 412. Fizz Buzz【Easy】
 *
 * 题目描述：写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 规则：
 * - 如果 n 是3的倍数，输出"Fizz"；
 * - 如果 n 是5的倍数，输出"Buzz"；
 * - 如果 n 同时是3和5的倍数，输出"FizzBuzz"；
 * - 如果都不是，输出数字本身。
 *
 * 示例（n = 15）：
 * 返回：
 * [
 *   "1",    "2",    "Fizz", "4",    "Buzz",
 *   "Fizz", "7",    "8",    "Fizz", "Buzz",
 *   "11",   "Fizz", "13",   "14",   "FizzBuzz"
 * ]
 *
 * 算法原理（条件判断 / 字符串拼接）：
 *
 * 方法一：条件判断（当前使用的方法）⭐
 * 关键点：必须先检查 i % 15 == 0（即同时是3和5的倍数）
 * 原因：如果先检查3或5的倍数，会提前返回而不会执行到FizzBuzz的情况
 *
 * 时间复杂度：O(n)，只需一次遍历
 * 空间复杂度：O(n)，存储结果列表
 *
 * 方法二：字符串拼接法
 * 思路：不使用if-else，而是通过字符串拼接来构建结果
 * - 初始化空字符串result
 * - 如果是3的倍数，拼接"Fizz"
 * - 如果是5的倍数，拼接"Buzz"
 * - 如果result为空，说明不是3或5的倍数，使用数字
 * - 否则使用拼接后的字符串
 *
 * 应用场景：
 * - 面试中的基础编程题，考察对条件判断的理解
 * - 实际应用：游戏开发、规则引擎等场景
 * </pre>
 */
public class FizzBuzz412 {

    @Test
    public void solution() {
        FizzBuzz412 solution = new FizzBuzz412();

        // 测试用例1：标准示例（n=15）
        System.out.println("测试用例1 (n=15): ");
        List<String> result1 = solution.fizzBuzz(15);
        System.out.println(result1);

        // 测试用例2：小范围（n=5）
        System.out.println("\n测试用例2 (n=5): ");
        System.out.println(solution.fizzBuzz(5));

        // 测试用例3：单元素（n=1）
        System.out.println("\n测试用例3 (n=1): ");
        System.out.println(solution.fizzBuzz(1));

        // 测试用例4：刚好是3的倍数（n=3）
        System.out.println("\n测试用例4 (n=3): ");
        System.out.println(solution.fizzBuzz(3));

        // 测试用例5：刚好是5的倍数（n=10）
        System.out.println("\n测试用例5 (n=10): ");
        System.out.println(solution.fizzBuzz(10));
    }

    /**
     * 方法一：条件判断法（最优解法）⭐
     * 使用if-else if-else结构，清晰直观
     * 时间复杂度 O(n)，空间复杂度 O(n)
     *
     * @param n 上限数字
     * @return Fizz Buzz列表
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            // 注意：必须先检查15的倍数！
            if (i % 15 == 0) {
                // 同时是3和5的倍数
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                // 只是3的倍数
                result.add("Fizz");
            } else if (i % 5 == 0) {
                // 只是5的倍数
                result.add("Buzz");
            } else {
                // 不是3或5的倍数
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

    /**
     * 方法二：字符串拼接法（更优雅）
     * 通过拼接字符串来构建结果，避免多层嵌套判断
     * 时间复杂度 O(n)，空间复杂度 O(n)
     *
     * @param n 上限数字
     * @return Fizz Buzz列表
     */
    public List<String> fizzBuzzStringConcatenation(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            // 根据倍数拼接对应字符串
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }

            // 如果StringBuilder为空，说明不是3或5的倍数
            if (sb.length() == 0) {
                result.add(String.valueOf(i));
            } else {
                result.add(sb.toString());
            }
        }

        return result;
    }
}