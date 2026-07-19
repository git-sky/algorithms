package cn.com.sky.algorithms.ByteDance.other;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 340. Longest Substring with At Most K Distinct Characters【Medium】
 * <p>
 * 题目：给定一个字符串 s 和一个整数 k，找出至多包含 k 个不同字符的最长子串的长度。
 * 示例 1：
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 最长子串是 "ece"，它包含 2 个不同的字符（'e' 和 'c'）。
 * 示例 2：
 * 输入: s = "aa", k = 1
 * 输出: 2
 * 解释: 最长子串是 "aa"，它包含 1 个不同的字符（'a'）。
 *
 * <p>
 * 算法原理（滑动窗口）：
 * 1. 维护滑动窗口 [left, right]，保证窗口内不同字符数 ≤ k
 * 2. 用 HashMap 记录每个字符在窗口内的出现次数
 * 3. right 不断右移扩展窗口，当不同字符数 > k 时，left 右移收缩窗口
 * 4. 每次移动后更新最大长度
 * <p>
 * 时间复杂度：O(n)，每个字符最多被左右指针各访问一次
 * 空间复杂度：O(min(n, k))，HashMap 最多存储 k+1 个字符
 */
public class LongestSubstringWithAtMostKDistinctCharacters340 {

    /**
     * 方法一：滑动窗口 + HashMap（通用解法）
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // ① 边界条件：空串、null、k=0 都返回 0
        if (s == null || s.isEmpty() || k == 0) {
            return 0;
        }

        // ② HashMap 记录窗口内每个字符的出现次数
        Map<Character, Integer> charCountMap = new HashMap<>();
        int left = 0;          // 窗口左边界
        int maxLength = 0;     // 记录最大长度

        // ③ right 指针不断右移，扩展窗口
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            // 当前字符计数 +1（若不存在则默认0+1=1）
            charCountMap.put(rightChar, charCountMap.getOrDefault(rightChar, 0) + 1);

            // ④ 关键：如果不同字符数超过 k，收缩窗口
            // map.size() 就是当前窗口内不同字符的数量
            while (charCountMap.size() > k) {
                char leftChar = s.charAt(left);
                // 左边界字符计数 -1
                charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);
                // 如果计数变为 0，从 map 中移除（否则 map.size() 会不准确）
                if (charCountMap.get(leftChar) == 0) {
                    charCountMap.remove(leftChar);
                }
                // 左边界右移
                left++;
            }

            // ⑤ 当前窗口 [left, right] 满足条件，更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // ⑥ 返回最大长度
        return maxLength;
    }

    /**
     * 方法二：滑动窗口 + 数组（适用于 ASCII 字符，性能更优）
     */
    public int lengthOfLongestSubstringKDistinctOptimized(String s, int k) {
        if (s == null || s.isEmpty() || k == 0) {
            return 0;
        }

        int[] charCountArray = new int[128];
        int left = 0;
        int distinctCount = 0;  // 当前窗口内不同字符的数量
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (charCountArray[rightChar] == 0) {
                distinctCount++;  // 首次出现，不同字符数+1
            }
            charCountArray[rightChar]++;

            // 超过 k 个不同字符，收缩窗口
            while (distinctCount > k) {
                char leftChar = s.charAt(left);
                charCountArray[leftChar]--;
                if (charCountArray[leftChar] == 0) {
                    distinctCount--;  // 该字符在窗口内完全消失
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters340 solution =
                new LongestSubstringWithAtMostKDistinctCharacters340();

        // 测试用例1：标准情况，k=2
        System.out.println("测试用例1: " + solution.lengthOfLongestSubstringKDistinct("eceba", 2));
        // 预期: 3 ("ece" 或 "ece")

        // 测试用例2：全是相同字符，k=1
        System.out.println("测试用例2: " + solution.lengthOfLongestSubstringKDistinct("aa", 1));
        // 预期: 2

        // 测试用例3：k=0
        System.out.println("测试用例3: " + solution.lengthOfLongestSubstringKDistinct("abc", 0));
        // 预期: 0

        // 测试用例4：k >= 字符种类数
        System.out.println("测试用例4: " + solution.lengthOfLongestSubstringKDistinct("abc", 5));
        // 预期: 3

        // 测试用例5：空字符串
        System.out.println("测试用例5: " + solution.lengthOfLongestSubstringKDistinct("", 2));
        // 预期: 0

        // 测试用例6：交替字符
        System.out.println("测试用例6: " + solution.lengthOfLongestSubstringKDistinct("abaccc", 2));
        // 预期: 4 ("accc")

        // 测试用例7：用优化方法
        System.out.println("\n===== 优化方法 =====");
        System.out.println("优化测试1: " + solution.lengthOfLongestSubstringKDistinctOptimized("eceba", 2));  // 3
        System.out.println("优化测试2: " + solution.lengthOfLongestSubstringKDistinctOptimized("aa", 1));     // 2
        System.out.println("优化测试3: " + solution.lengthOfLongestSubstringKDistinctOptimized("abaccc", 2)); // 4
    }
}