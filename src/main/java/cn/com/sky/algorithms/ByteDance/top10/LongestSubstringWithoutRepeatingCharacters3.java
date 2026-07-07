package cn.com.sky.algorithms.ByteDance.top10;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters3 {


    // 测试方法
    public static void main(String[] args) {
        cn.com.sky.algorithms.leetcode.easy.LongestSubstringWithoutRepeatingCharacters3 solution = new cn.com.sky.algorithms.leetcode.easy.LongestSubstringWithoutRepeatingCharacters3();

        System.out.println("测试用例1: " + solution.lengthOfLongestSubstring("abcabcbb"));  // 3
        System.out.println("测试用例2: " + solution.lengthOfLongestSubstring("bbbbb"));     // 1
        System.out.println("测试用例3: " + solution.lengthOfLongestSubstring("pwwkew"));    // 3
        System.out.println("测试用例4: " + solution.lengthOfLongestSubstring(""));          // 0
        System.out.println("测试用例5: " + solution.lengthOfLongestSubstring("au"));        // 2
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