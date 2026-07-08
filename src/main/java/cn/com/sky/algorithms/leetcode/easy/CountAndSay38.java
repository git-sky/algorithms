package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 38. 外观数列【Easy】
 * 
 * 题目描述：给定一个正整数 n ，输出外观数列的第 n 项。
 * 外观数列是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 
 * 示例：
 * 1.     1
 * 2.     11       （一个1）
 * 3.     21       （两个1）
 * 4.     1211     （一个2，一个1）
 * 5.     111221   （一个1，一个2，两个1）
 * 
 * 算法原理（迭代法）：
 * 1. 从第1项开始，逐项生成后续项
 * 2. 对当前项进行"描述"：统计连续相同字符的个数，然后拼接"个数+字符"
 * 3. 重复n-1次即可得到第n项
 * 
 * 时间复杂度：O(n * m)，其中m为最长字符串的长度
 * 空间复杂度：O(m)，用于存储中间结果
 * </pre>
 */
public class CountAndSay38 {

    public static void main(String[] args) {
        CountAndSay38 solution = new CountAndSay38();

        // 测试用例1：基本情况
        System.out.println("n=1: " + solution.countAndSay(1));  // "1"
        System.out.println("n=2: " + solution.countAndSay(2));  // "11"
        System.out.println("n=3: " + solution.countAndSay(3));  // "21"
        System.out.println("n=4: " + solution.countAndSay(4));  // "1211"
        System.out.println("n=5: " + solution.countAndSay(5));  // "111221"

        // 测试用例2：较大值
        System.out.println("n=6: " + solution.countAndSay(6));  // "312211"
        System.out.println("n=7: " + solution.countAndSay(7));  // "13112221"

        // 测试用例3：边界情况
        System.out.println("n=10: " + solution.countAndSay(10));
    }

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = describe(result);
        }
        return result;
    }

    private String describe(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                count++;
            } else {
                sb.append(count);
                sb.append(prev);
                prev = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(prev);

        return sb.toString();
    }
}