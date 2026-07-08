package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 680. 验证回文字符串 II【Easy】
 * 
 * 题目描述：给定一个非空字符串 s，最多删除一个字符，判断是否能成为回文字符串。
 * 
 * 示例1：
 * 输入："aba"
 * 输出：true
 * 
 * 示例2：
 * 输入："abca"
 * 输出：true（删除 'c'）
 * 
 * 算法原理（双指针 + 贪心）：
 * 1. 使用双指针从两端向中间检查
 * 2. 遇到不匹配时，有两种选择：删除左边字符或删除右边字符
 * 3. 分别检查两种情况是否为回文，只要有一种成立即可
 * 4. 不需要实际删除，只需跳过该字符继续比较
 * 
 * 时间复杂度：O(n)，最多遍历两次字符串
 * 空间复杂度：O(1)
 * </pre>
 */
public class ValidPalindromeII680 {

    public static void main(String[] args) {
        ValidPalindromeII680 solution = new ValidPalindromeII680();

        // 测试用例1：本身就是回文
        System.out.println("测试用例1: " + solution.validPalindrome("aba")); // true

        // 测试用例2：删除一个字符后是回文
        System.out.println("测试用例2: " + solution.validPalindrome("abca")); // true

        // 测试用例3：需要删除多个字符
        System.out.println("测试用例3: " + solution.validPalindrome("abc")); // false

        // 测试用例4：删除左边
        System.out.println("测试用例4: " + solution.validPalindrome("cbbcc")); // true

        // 测试用例5：删除右边
        System.out.println("测试用例5: " + solution.validPalindrome("abccbca")); // true

        // 测试用例6：单字符
        System.out.println("测试用例6: " + solution.validPalindrome("a")); // true

        // 测试用例7：两个字符
        System.out.println("测试用例7: " + solution.validPalindrome("ab")); // true
    }

    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1);
            }
        }
        return true;
    }

    private boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) {
                return false;
            }
        }
        return true;
    }
}