package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * <pre>
 * LeetCode 66. 加一【Easy】
 * 
 * 题目描述：给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位，数组中每个元素只存储单个数字。
 * 
 * 示例1：输入 [1,2,3]，输出 [1,2,4]
 * 示例2：输入 [4,3,2,1]，输出 [4,3,2,2]
 * 示例3：输入 [9,9,9]，输出 [1,0,0,0]
 * 
 * 算法原理（从末尾遍历）：
 * 1. 从数组末尾开始，逐位加一
 * 2. 如果当前位小于9，加一后直接返回（无需进位）
 * 3. 如果当前位等于9，置0继续进位
 * 4. 如果所有位都进位了（如999），创建新数组，首位为1
 * 
 * 优化：相比逐位计算进位的方式，这种方法更简洁
 * - 遇到小于9的位直接加一返回，无需继续处理
 * - 只有全9的情况才需要创建新数组
 * 
 * 时间复杂度：O(n)，最坏情况遍历整个数组
 * 空间复杂度：O(1)，除全9情况外原地修改
 * </pre>
 */
public class PlusOne66 {

    public static void main(String[] args) {
        PlusOne66 solution = new PlusOne66();

        // 测试用例1：无进位
        System.out.println("测试用例1: " + Arrays.toString(solution.plusOne(new int[]{1, 2, 3}))); // [1,2,4]

        // 测试用例2：中间进位
        System.out.println("测试用例2: " + Arrays.toString(solution.plusOne(new int[]{4, 3, 2, 1}))); // [4,3,2,2]

        // 测试用例3：全9进位
        System.out.println("测试用例3: " + Arrays.toString(solution.plusOne(new int[]{9, 9, 9}))); // [1,0,0,0]

        // 测试用例4：末尾9
        System.out.println("测试用例4: " + Arrays.toString(solution.plusOne(new int[]{1, 9, 9}))); // [2,0,0]

        // 测试用例5：单数字9
        System.out.println("测试用例5: " + Arrays.toString(solution.plusOne(new int[]{9}))); // [1,0]

        // 测试用例6：单数字非9
        System.out.println("测试用例6: " + Arrays.toString(solution.plusOne(new int[]{5}))); // [6]

        // 测试用例7：0
        System.out.println("测试用例7: " + Arrays.toString(solution.plusOne(new int[]{0}))); // [1]
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}