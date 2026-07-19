package cn.com.sky.algorithms.ByteDance.top10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3. 无重复字符的最长子串【Medium】（字节跳动高频）
 * 
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * 
 * 算法原理（滑动窗口+哈希表）：
 * 1. 使用滑动窗口 [left, right] 表示当前无重复字符的子串
 * 2. 使用哈希表记录每个字符最后出现的位置
 * 3. 遍历字符串时：
 *    - 如果当前字符已在窗口内，将 left 移动到重复位置+1
 *    - 更新哈希表中当前字符的位置
 *    - 更新最大长度
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(min(m, n))，m为字符集大小
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    /**
     * 方案一：滑动窗口 + HashMap（通用方案）
     *
     * 【算法原理】
     * 1. 维护一个滑动窗口 [left, right]，表示当前无重复字符的子串范围
     * 2. 使用 HashMap 记录每个字符最后出现的位置索引
     * 3. 遍历字符串，right 指针不断右移：
     *    - 若当前字符已出现在窗口内（即上次出现位置 >= left），则将 left 跳到该位置 + 1
     *    - 更新 HashMap 中该字符的最新位置为 right
     *    - 计算当前窗口长度，更新最大值
     *
     * 【图示示例】s = "abcabcbb"
     *   right=0, c='a', map={}, window=[a]          → len=1, max=1
     *   right=1, c='b', map={a:0}, window=[ab]       → len=2, max=2
     *   right=2, c='c', map={a:0,b:1}, window=[abc] → len=3, max=3
     *   right=3, c='a', a在map中且位置0>=left(0), left跳到1, window=[bca]
     *   ...
     *
     * 【时间复杂度】O(n)，每个字符最多被访问两次（right 前进，left 跳跃）
     * 【空间复杂度】O(min(m,n))，m 为字符集大小，最坏情况存储 n 个字符
     *
     * 【优缺点】
     * ✅ 优点：代码直观易懂，支持任意 Unicode 字符
     * ❌ 缺点：HashMap 有装箱开销、哈希计算开销，性能不如数组
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            // 为啥需要大于>=left？经典案例：s = "abba"，如果不判断>=left，会导致出现第二个a时，left变小了。
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                left = charIndexMap.get(currentChar) + 1;
            }

            charIndexMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * 方案二：滑动窗口 + 数组（高性能优化方案）
     *
     * 【算法原理】
     * 与方案一逻辑完全相同，核心优化在于数据结构：
     * 1. 用固定大小的 int[128] 数组替代 HashMap，数组下标直接对应字符的 ASCII 码值
     * 2. 数组初始化为 -1，表示该字符尚未出现过
     * 3. 遍历时通过 charIndex[c] 直接访问，无需哈希计算和装箱操作
     *
     * 【为什么是 128？】
     *   标准 ASCII 字符集范围：0 ~ 127（共 128 个字符）
     *   覆盖：a-z, A-Z, 0-9, 常见符号、空格等
     *   LeetCode 测试用例均在此范围内，够用且内存最小
     *
     * 【与方案一的核心差异】
     *   ┌─────────────────┬──────────────┬──────────────┐
     *   │       对比项      │  方案一 HashMap │  方案二 数组   │
     *   ├─────────────────┼──────────────┼──────────────┤
     *   │ 查找字符位置       │ containsKey+get│ charIndex[c] │
     *   │ (需几次查找)       │    2 次       │    1 次       │
     *   ├─────────────────┼──────────────┼──────────────┤
     *   │ 字符 → 索引映射     │ 哈希计算+桶定位 │ 直接用ASCII值  │
     *   ├─────────────────┼──────────────┼──────────────┤
     *   │ 装箱/拆箱开销      │  char→Character│     无        │
     *   ├─────────────────┼──────────────┼──────────────┤
     *   │ 内存占用          │ 动态增长       │ 固定 512 bytes │
     *   └─────────────────┴──────────────┴──────────────┘
     *
     * 【图示示例】s = "abcabcbb"，charIndex 初始全为 -1
     *   right=0, c='a'(97), charIndex[97]=-1<left(0), 不移动left
     *           charIndex[97]=0, window=[a], max=1
     *   right=3, c='a'(97), charIndex[97]=0>=left(0), left跳到1
     *           charIndex[97]=3, window=[bca], max=3
     *
     * 【时间复杂度】O(n)，但常数因子更小（实测快 3~4 倍）
     * 【空间复杂度】O(1)，数组大小固定为 128，不随输入规模变化
     *
     * 【优缺点】
     * ✅ 优点：真正的 O(1) 随机访问，无装箱开销，性能最优
     * ❌ 缺点：仅支持 ASCII 字符（0~127），若含中文需改用 HashMap 或扩大数组
     */
    public int lengthOfLongestSubstringOptimized(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (charIndex[c] >= left) {
                left = charIndex[c] + 1;
            }

            charIndex[c] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }


    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters3 solution = new LongestSubstringWithoutRepeatingCharacters3();

        String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", "", "au", "abba", " "};

        System.out.println("========== 原始方法 (HashMap) ==========");
        for (int i = 0; i < testCases.length; i++) {
            String input = testCases[i];
            int result = solution.lengthOfLongestSubstring(input);
            System.out.println("测试" + (i + 1) + ": \"" + input + "\" → " + result);
        }

        System.out.println("\n========== 优化方法 (数组) ==========");
        for (int i = 0; i < testCases.length; i++) {
            String input = testCases[i];
            int result = solution.lengthOfLongestSubstringOptimized(input);
            System.out.println("测试" + (i + 1) + ": \"" + input + "\" → " + result);
        }

        System.out.println("\n========== 性能对比 ==========");
        String longStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";
        int iterations = 100000;

        long start1 = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            solution.lengthOfLongestSubstring(longStr);
        }
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            solution.lengthOfLongestSubstringOptimized(longStr);
        }
        long end2 = System.nanoTime();

        System.out.println("HashMap 方法:   " + (end1 - start1) / 1000000 + " ms");
        System.out.println("数组优化方法:   " + (end2 - start2) / 1000000 + " ms");
        System.out.println("性能提升:       " + String.format("%.2f", (double)(end1 - start1) / (end2 - start2)) + "x");
    }
}