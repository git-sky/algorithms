package cn.com.sky.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * <pre>
 * LeetCode 3. 无重复字符的最长子串【Medium】（字节跳动、腾讯高频）
 *
 * 题目描述：给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例：
 * 输入："abcabcbb"
 * 输出：3（最长子串是"abc"）
 *
 * 输入："bbbbb"
 * 输出：1（最长子串是"b"）
 *
 * 输入："pwwkew"
 * 输出：3（最长子串是"wke"，注意"pwke"是子序列而非子串）
 *
 * 算法原理（滑动窗口）：
 * 核心思想：使用滑动窗口 [i, j] 来表示当前的不重复子串
 *
 * 方法一：HashSet + 双指针（推荐初学者理解）
 * 1. 使用两个指针 i 和 j 表示窗口的左右边界
 * 2. 右指针 j 不断向右扩展，将字符加入集合
 * 3. 如果遇到重复字符，左指针 i 向右移动，直到移除重复字符
 * 4. 记录窗口的最大长度
 *
 * 方法二：HashMap优化（最优解法）
 * 1. 使用 HashMap 记录每个字符最后出现的位置
 * 2. 当遇到重复字符时，直接跳转到该字符上一次出现的位置之后
 * 3. 避免了方法一中逐个移动左指针的操作
 *
 * 为什么滑动窗口有效？
 * - 窗口内的子串保证无重复
 * - 当遇到重复时，缩小窗口直到再次满足条件
 * - 每个元素最多被访问2次（进入和离开窗口）
 *
 * 时间复杂度：
 * - 方法一：O(2n) = O(n)，最坏情况下每个字符被访问两次
 * - 方法二：O(n)，每个字符最多被访问一次
 *
 * 空间复杂度：
 * - O(min(m, n))，m 为字符集大小，n 为字符串长度
 * </pre>
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    @Test
    public void solution() {
        LongestSubstringWithoutRepeatingCharacters3 solution = new LongestSubstringWithoutRepeatingCharacters3();

        // 测试用例1：正常情况
        System.out.println("测试用例1: " + solution.lengthOfLongestSubstring("abcabcbb")); // 3

        // 测试用例2：全相同字符
        System.out.println("测试用例2: " + solution.lengthOfLongestSubstring("bbbbb"));     // 1

        // 测试用例3：有间隔的重复
        System.out.println("测试用例3: " + solution.lengthOfLongestSubstring("pwwkew"));   // 3

        // 测试用例4：空字符串
        System.out.println("测试用例4: " + solution.lengthOfLongestSubstring(""));         // 0

        // 测试用例5：单字符
        System.out.println("测试用例5: " + solution.lengthOfLongestSubstring("a"));        // 1

        // 测试用例6：全部不重复
        System.out.println("测试用例6: " + solution.lengthOfLongestSubstring("abcdef"));   // 6

        // 测试用例7：长字符串
        System.out.println("测试用例7: " + solution.lengthOfLongestSubstring("dvdf"));     // 3

        // 测试用例8：使用优化方法
        System.out.println("测试用例8(优化): " + solution.lengthOfLongestSubstringOptimized("abcabcbb")); // 3
    }

    /**
     * 方法一：HashSet滑动窗口（易于理解）
     * 时间复杂度 O(2n) = O(n)
     * 空间复杂度 O(min(m, n))
     *
     * @param s 输入字符串
     * @return 最长无重复子串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;

        while (i < n && j < n) {
            // 尝试扩展窗口右边界
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);  // 更新最大长度
            } else {
                // 遇到重复字符，收缩窗口左边界
                set.remove(s.charAt(i++));
            }
        }

        return ans;
    }

    /**
     * 方法二：HashMap优化版（最优解法）⭐
     * 通过记录字符位置直接跳转，避免逐个移动左指针
     * 时间复杂度 O(n)
     * 空间复杂度 O(min(m, n))
     *
     * @param s 输入字符串
     * @return 最长无重复子串的长度
     */
    public int lengthOfLongestSubstringOptimized(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();  // 字符 → 最后出现的索引+1

        // 尝试扩展窗口右边界 [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            // 如果字符已存在，更新左边界到该字符上次位置之后
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            // 更新最大长度
            ans = Math.max(ans, j - i + 1);
            // 记录字符的位置（存j+1以便下次直接跳转）
            map.put(s.charAt(j), j + 1);
        }

        return ans;
    }

    /**
     * 方法三：数组优化（适用于ASCII字符集）
     * 使用固定大小的数组代替HashMap，速度更快
     * 时间复杂度 O(n)
     * 空间复杂度 O(m)，m为字符集大小（如128或256）
     */
    /*
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        int[] lastIndex = new int[128];  // ASCII字符集
        Arrays.fill(lastIndex, -1);      // 初始化为-1

        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(i, lastIndex[s.charAt(j)] + 1);
            ans = Math.max(ans, j - i + 1);
            lastIndex[s.charAt(j)] = j;
        }

        return ans;
    }
    */
}