package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * 13. Roman to Integer【Easy】
 * 
 * 题目：给定一个罗马数字，将其转换为整数。
 * 
 * 罗马数字规则：
 * - I: 1, V: 5, X: 10, L: 50, C: 100, D: 500, M: 1000
 * - 通常大数字在左边，小数字在右边
 * - 特殊情况：IV=4, IX=9, XL=40, XC=90, CD=400, CM=900
 * 
 * 算法原理：
 * 1. 遍历字符串，比较当前字符和下一个字符的值
 * 2. 如果当前值 < 下一个值，减去当前值
 * 3. 否则，加上当前值
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class RomantoInteger13 {

    public static void main(String[] args) {
        // 测试用例1：基本情况
        System.out.println("=== 测试用例1：基本情况 ===");
        System.out.println("III: " + romanToInt("III"));
        System.out.println("IV: " + romanToInt("IV"));
        System.out.println("IX: " + romanToInt("IX"));
        System.out.println("LVIII: " + romanToInt("LVIII"));
        System.out.println("MCMXCIV: " + romanToInt("MCMXCIV"));

        // 测试用例2：边界情况
        System.out.println("\n=== 测试用例2：边界情况 ===");
        System.out.println("I: " + romanToInt("I"));
        System.out.println("M: " + romanToInt("M"));

        // 测试用例3：空字符串
        System.out.println("\n=== 测试用例3：空字符串 ===");
        System.out.println("\"\": " + romanToInt(""));
    }

    public static int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int current = getValue(s.charAt(i));
            
            if (i < n - 1 && current < getValue(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }

    private static int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}