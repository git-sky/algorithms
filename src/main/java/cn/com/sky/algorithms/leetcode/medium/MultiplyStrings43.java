package cn.com.sky.algorithms.medium;

import org.junit.Test;

/**
 * <pre>
 * LeetCode 43. 字符串相乘【Medium】
 *
 * 题目描述：给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，
 * 它们的乘积也表示为字符串形式。
 *
 * 注意：
 * - num1 和 num2 的长度小于110。
 * - num1 和 num2 只包含数字 0-9。
 * - num1 和 num2 不包含任何前导零，除了数字0本身。
 * - 不能使用任何内置 BigInteger 库或直接将输入转换为整数来处理。
 *
 * 示例：
 * 输入：num1 = "2", num2 = "3"
 * 输出："6"
 *
 * 输入：num1 = "123", num2 = "456"
 * 输出："56088"
 *
 * 算法原理（竖式乘法模拟）：
 * 1. 创建一个长度为 m+n 的数组 pos 来存储结果（m和n分别是两个字符串的长度）
 *    - 两个数相乘，结果的位数最多为 m+n 位
 * 2. 从右向左遍历两个字符串的每一位数字
 * 3. 计算当前位的乘积 mul = digits[i] * digits[j]
 * 4. 确定乘积在结果数组中的位置：
 *    - p1 = i + j（进位位置）
 *    - p2 = i + j + 1（当前位置）
 * 5. 将乘积加到对应位置上，并处理进位
 * 6. 最后跳过前导零，构建结果字符串
 *
 * 关键优化点：
 * - 利用数组索引直接定位结果位置，避免字符串拼接操作
 * - 统一处理进位，代码简洁高效
 * - 时间复杂度 O(m*n)，空间复杂度 O(m+n)
 *
 * 原理示例：
 *    123
 *  x 456
 *  -----
 *    738  (123*6)
 *   615   (123*5)
 *  492    (123*4)
 *  -----
 *  56088
 *
 * 时间复杂度：O(m * n)，m 和 n 分别是两个字符串的长度
 * 空间复杂度：O(m + n)，用于存储中间结果
 * </pre>
 */
public class MultiplyStrings43 {

    @Test
    public void solution() {
        MultiplyStrings43 solution = new MultiplyStrings43();

        // 测试用例1：正常情况
        System.out.println("测试用例1: " + solution.multiply("2", "3"));           // "6"

        // 测试用例2：多位数相乘
        System.out.println("测试用例2: " + solution.multiply("123", "456"));        // "56088"

        // 测试用例3：其中一个数为0
        System.out.println("测试用例3: " + solution.multiply("123", "0"));          // "0"

        // 测试用例4：两个数都是0
        System.out.println("测试用例4: " + solution.multiply("0", "0"));            // "0"

        // 测试用例5：大数相乘
        System.out.println("测试用例5: " + solution.multiply("999", "999"));        // "998001"

        // 测试用例6：1位数
        System.out.println("测试用例6: " + solution.multiply("9", "9"));            // "81"

        // 测试用例7：不同位数
        System.out.println("测试用例7: " + solution.multiply("123", "456789"));     // "56185047"
    }

    /**
     * 字符串相乘 - 最优解法
     * 使用竖式乘法的思想，通过数组索引直接定位结果位置
     *
     * @param num1 第一个数字字符串
     * @param num2 第二个数字字符串
     * @return 乘积的字符串表示
     */
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        // 结果数组，长度最多为 m+n
        int[] pos = new int[m + n];

        // 从右向左遍历每一位
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 当前位乘积
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                // 确定在结果数组中的位置
                int p1 = i + j;      // 高位（进位）
                int p2 = i + j + 1;  // 低位（当前位）

                // 累加到对应位置
                int sum = mul + pos[p2];

                // 处理进位
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }

        // 构建结果字符串，跳过前导零
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {  // 跳过前导零
                sb.append(p);
            }
        }

        // 如果结果为空，返回"0"
        return sb.length() == 0 ? "0" : sb.toString();
    }
}