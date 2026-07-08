package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 9. 回文数【Easy】
 * 
 * 题目描述：给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * 示例1：输入 121，输出 true
 * 示例2：输入 -121，输出 false（负数不是回文数）
 * 示例3：输入 10，输出 false
 * 
 * 算法原理（反转一半数字）：
 * 1. 负数直接返回 false
 * 2. 反转数字的后半部分，与前半部分比较
 * 3. 当原始数字小于反转后的数字时，意味着已经处理了一半的数字
 * 4. 偶数位：前后完全相等；奇数位：前半部分等于后半部分/10
 * 
 * 优化：只反转一半数字，避免完整反转可能导致的溢出问题
 * 
 * 时间复杂度：O(log n)，n 为数字的位数
 * 空间复杂度：O(1)
 * </pre>
 */
public class PalindromeNumber9 {

    public static void main(String[] args) {
        PalindromeNumber9 solution = new PalindromeNumber9();

        // 测试用例1：回文数
        System.out.println("测试用例1: " + solution.isPalindrome(121));    // true

        // 测试用例2：负数
        System.out.println("测试用例2: " + solution.isPalindrome(-121));   // false

        // 测试用例3：非回文数
        System.out.println("测试用例3: " + solution.isPalindrome(10));     // false

        // 测试用例4：0
        System.out.println("测试用例4: " + solution.isPalindrome(0));      // true

        // 测试用例5：个位数
        System.out.println("测试用例5: " + solution.isPalindrome(7));      // true

        // 测试用例6：奇数位回文
        System.out.println("测试用例6: " + solution.isPalindrome(12321));  // true

        // 测试用例7：偶数位回文
        System.out.println("测试用例7: " + solution.isPalindrome(1221));   // true

        // 测试用例8：非回文
        System.out.println("测试用例8: " + solution.isPalindrome(123432)); // false
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf / 10;
    }
}