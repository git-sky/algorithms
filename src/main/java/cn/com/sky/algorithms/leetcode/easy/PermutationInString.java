package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * <pre>
 * LeetCode 567. 字符串的排列【Medium】
 * 
 * 题目描述：给定两个字符串 s1 和 s2，判断 s2 是否包含 s1 的排列。
 * 换句话说，s1 的排列之一是 s2 的子串。
 * 
 * 示例1：
 * 输入：s1 = "ab", s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列 "ba"
 * 
 * 示例2：
 * 输入：s1 = "ab", s2 = "eidboaoo"
 * 输出：false
 * 
 * 算法原理（滑动窗口 + 字符计数）：
 * 1. 统计 s1 中每个字符的出现次数（目标计数数组）
 * 2. 在 s2 上维护一个长度为 s1.length() 的滑动窗口
 * 3. 统计窗口内每个字符的出现次数（窗口计数数组）
 * 4. 如果窗口计数数组与目标计数数组完全一致，则返回 true
 * 5. 滑动窗口时，移除左边字符，添加右边字符，更新计数数组
 * 
 * 优化：使用数组比较代替逐字符比较，每次滑动只需 O(1) 更新计数
 * 
 * 时间复杂度：O(l1 + 26 * (l2 - l1))，其中 l1、l2 分别为两字符串长度
 * 空间复杂度：O(1)，只使用两个长度为26的数组
 * </pre>
 */
public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();

        // 测试用例1：包含排列
        System.out.println("测试用例1: " + solution.checkInclusion("ab", "eidbaooo")); // true

        // 测试用例2：不包含排列
        System.out.println("测试用例2: " + solution.checkInclusion("ab", "eidboaoo")); // false

        // 测试用例3：s1等于s2
        System.out.println("测试用例3: " + solution.checkInclusion("abc", "abc")); // true

        // 测试用例4：s1比s2长
        System.out.println("测试用例4: " + solution.checkInclusion("abcd", "abc")); // false

        // 测试用例5：单字符
        System.out.println("测试用例5: " + solution.checkInclusion("a", "a")); // true

        // 测试用例6：边界情况
        System.out.println("测试用例6: " + solution.checkInclusion("adc", "dcda")); // true
    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < len1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(count1, count2)) {
            return true;
        }

        for (int i = len1; i < len2; i++) {
            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(i - len1) - 'a']--;

            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        return false;
    }
}