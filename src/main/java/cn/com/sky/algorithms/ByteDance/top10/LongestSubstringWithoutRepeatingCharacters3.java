package cn.com.sky.algorithms.ByteDance.top10;

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

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters3 solution = new LongestSubstringWithoutRepeatingCharacters3();
        
        // 测试用例1：正常情况
        System.out.println("测试用例1: " + solution.lengthOfLongestSubstring("abcabcbb"));  // 3 "abc"
        // 测试用例2：全部重复
        System.out.println("测试用例2: " + solution.lengthOfLongestSubstring("bbbbb"));     // 1 "b"
        // 测试用例3：中间重复
        System.out.println("测试用例3: " + solution.lengthOfLongestSubstring("pwwkew"));    // 3 "wke"
        // 测试用例4：空字符串
        System.out.println("测试用例4: " + solution.lengthOfLongestSubstring(""));          // 0
        // 测试用例5：两个不同字符
        System.out.println("测试用例5: " + solution.lengthOfLongestSubstring("au"));        // 2
        // 测试用例6：特殊字符
        System.out.println("测试用例6: " + solution.lengthOfLongestSubstring("abba"));      // 2 "ab"
        // 测试用例7：单字符
        System.out.println("测试用例7: " + solution.lengthOfLongestSubstring(" "));         // 1
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;  // 窗口左边界

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 如果当前字符已存在且在窗口内，移动左边界
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                left = charIndexMap.get(currentChar) + 1;
            }

            // 更新字符位置
            charIndexMap.put(currentChar, right);

            // 更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}