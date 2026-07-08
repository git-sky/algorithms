package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 479. 最大回文数乘积【Hard】
 * 
 * 题目描述：找到由两个 n 位数的乘积构成的最大回文数。
 * 由于结果可能很大，返回最大回文数 mod 1337。
 * 
 * 示例：
 * 输入：2
 * 输出：987
 * 解释：99 x 91 = 9009，9009 % 1337 = 987
 * 
 * 算法原理（构造回文数 + 验证）：
 * 1. 最大回文数一定由最大的 n 位数相乘产生
 * 2. 从最大的 n 位数开始，构造回文数（将数字翻转拼接）
 * 3. 验证该回文数是否能分解为两个 n 位数的乘积
 * 4. 找到第一个满足条件的即为最大回文数
 * 
 * 构造回文数的方法：
 * - 取一个数的前半部分，翻转后拼接到后面
 * - 例如：99 -> 9999, 98 -> 9889, 97 -> 9779
 * 
 * 时间复杂度：O(10^n * sqrt(p))，其中 p 为回文数
 * 空间复杂度：O(1)
 * </pre>
 */
public class LargestPalindromeProduct479 {

    public static void main(String[] args) {
        LargestPalindromeProduct479 solution = new LargestPalindromeProduct479();

        // 测试用例1：n=1
        System.out.println("n=1: " + solution.largestPalindrome(1)); // 9

        // 测试用例2：n=2
        System.out.println("n=2: " + solution.largestPalindrome(2)); // 987

        // 测试用例3：n=3
        System.out.println("n=3: " + solution.largestPalindrome(3)); // 123

        // 测试用例4：n=4
        System.out.println("n=4: " + solution.largestPalindrome(4)); // 977

        // 测试用例5：n=5
        System.out.println("n=5: " + solution.largestPalindrome(5)); // 677

        // 测试用例6：n=8
        System.out.println("n=8: " + solution.largestPalindrome(8)); // 475
    }

    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }

        long max = (long) Math.pow(10, n) - 1;
        long min = (long) Math.pow(10, n - 1);

        for (long i = max; i >= min; i--) {
            long palindrome = createPalindrome(i);
            for (long j = max; j * j >= palindrome; j--) {
                if (palindrome % j == 0 && palindrome / j >= min && palindrome / j <= max) {
                    return (int) (palindrome % 1337);
                }
            }
        }

        return -1;
    }

    private long createPalindrome(long num) {
        String s = String.valueOf(num);
        String reversed = new StringBuilder(s).reverse().toString();
        return Long.parseLong(s + reversed);
    }
}