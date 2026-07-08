package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 *
 * 521. Longest Uncommon Subsequence I【Easy】
 *
 * 给定两个字符串，你需要找到这两个字符串的最长非公共子序列。
 * 最长非公共子序列定义为某个字符串的子序列，且该子序列不是另一个字符串的子序列。
 *
 * 示例 1:
 * 输入: "aba", "cdc"
 * 输出: 3
 * 解释: 最长非公共子序列是 "aba" (或 "cdc")，
 * 因为 "aba" 是 "aba" 的子序列，但不是 "cdc" 的子序列。
 *
 * 算法原理（数学分析）：
 * 关键观察：
 * 1. 如果两个字符串相等，则不存在非公共子序列，返回 -1
 * 2. 如果两个字符串不相等，则较长的字符串本身就是最长非公共子序列
 *    （因为如果它是另一个字符串的子序列，那么它必须 <= 另一个字符串的长度）
 * 3. 如果长度相同但内容不同，任一字符串都是对方的非公共子序列
 *
 * 因此结果为：
 * - 如果 s == t，返回 -1
 * - 否则返回 max(s.length(), t.length())
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * </pre>
 */
public class LongestUncommonSubsequenceI521 {

    @Test
    public void solution() {
        System.out.println("测试用例1: " + findLUSlength("aba", "cdc")); // 3

        System.out.println("测试用例2: " + findLUSlength("aaa", "aaa")); // -1

        System.out.println("测试用例3: " + findLUSlength("a", "b")); // 1

        System.out.println("测试用例4: " + findLUSlength("abc", "abcde")); // 5

        System.out.println("测试用例5: " + findLUSlength("", "")); // -1
    }

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

}