package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * <pre>
 * LeetCode 242. 有效的字母异位词【Easy】
 * 
 * 题目描述：给定两个字符串 s 和 t，判断 t 是否是 s 的字母异位词（anagram）。
 * 字母异位词指字母相同但排列不同的字符串。
 * 
 * 示例1：s = "anagram", t = "nagaram" → true
 * 示例2：s = "rat", t = "car" → false
 * 
 * 算法原理（字符计数法）：
 * 1. 使用长度为26的数组统计 s 中每个字符的出现次数
 * 2. 遍历 t，对应字符计数减1
 * 3. 如果减1后计数小于0，说明 t 中有 s 没有的字符或数量更多，返回 false
 * 
 * 方法二（排序法）：将两个字符串排序后比较是否相等
 * - 时间 O(n log n)，空间 O(n)
 * - 适用于包含 Unicode 字符的情况
 * 
 * 时间复杂度：O(n)，n 为字符串长度
 * 空间复杂度：O(1)，固定26长度的数组
 * </pre>
 */
public class ValidAnagram242 {

    public static void main(String[] args) {
        ValidAnagram242 solution = new ValidAnagram242();

        // 测试用例1：异位词
        System.out.println("测试用例1: " + solution.isAnagram("anagram", "nagaram")); // true

        // 测试用例2：非异位词
        System.out.println("测试用例2: " + solution.isAnagram("rat", "car")); // false

        // 测试用例3：长度不同
        System.out.println("测试用例3: " + solution.isAnagram("ab", "abc")); // false

        // 测试用例4：空字符串
        System.out.println("测试用例4: " + solution.isAnagram("", "")); // true

        // 测试用例5：单字符
        System.out.println("测试用例5: " + solution.isAnagram("a", "a")); // true

        // 测试用例6：相同字符不同数量
        System.out.println("测试用例6: " + solution.isAnagram("aab", "abb")); // false
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (--arr[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagramBySort(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return String.valueOf(sc).equals(String.valueOf(tc));
    }
}