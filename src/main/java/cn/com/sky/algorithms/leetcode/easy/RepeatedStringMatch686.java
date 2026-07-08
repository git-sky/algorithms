package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 686. 重复叠加字符串匹配【Medium】
 * 
 * 题目描述：给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，
 * 使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 * 
 * 示例：
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复三次为 "abcdabcdabcd"，此时 b 是其子串
 * 
 * 算法原理：
 * 1. 关键观察：如果 b 是 a 重复若干次的子串，最多只需要重复 ceil(b.len/a.len)+1 次
 *    - 最多重复次数 = ceil(b.length / a.length) + 1
 *    - 因为 b 的起始位置最多在 a 的一个周期内偏移
 * 2. 不断叠加 a，直到长度足够包含 b
 * 3. 检查 b 是否为叠加后字符串的子串
 * 
 * 时间复杂度：O(n * (m + n))，n为a的长度，m为b的长度
 * 空间复杂度：O(m + n)，存储叠加后的字符串
 * </pre>
 */
public class RepeatedStringMatch686 {

    public static void main(String[] args) {
        RepeatedStringMatch686 solution = new RepeatedStringMatch686();

        // 测试用例1：正常情况
        System.out.println("测试用例1: " + solution.repeatedStringMatch("abcd", "cdabcdab")); // 3

        // 测试用例2：a本身包含b
        System.out.println("测试用例2: " + solution.repeatedStringMatch("abc", "bc")); // 1

        // 测试用例3：不可能
        System.out.println("测试用例3: " + solution.repeatedStringMatch("abc", "cabcabca")); // 4

        // 测试用例4：b不是a的子串
        System.out.println("测试用例4: " + solution.repeatedStringMatch("abc", "xyz")); // -1

        // 测试用例5：单字符
        System.out.println("测试用例5: " + solution.repeatedStringMatch("a", "aa")); // 2

        // 测试用例6：相等
        System.out.println("测试用例6: " + solution.repeatedStringMatch("abc", "abc")); // 1
    }

    public int repeatedStringMatch(String a, String b) {
        int count = 1;
        StringBuilder sb = new StringBuilder(a);

        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if (sb.indexOf(b) != -1) {
            return count;
        }

        sb.append(a);
        count++;

        if (sb.indexOf(b) != -1) {
            return count;
        }

        return -1;
    }
}