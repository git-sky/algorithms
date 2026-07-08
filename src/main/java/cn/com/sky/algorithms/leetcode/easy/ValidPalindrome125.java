package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 125. 验证回文串【Easy】
 * 
 * 题目描述：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，忽略大小写。
 * 
 * 示例1：
 * 输入："A man, a plan, a canal: Panama"
 * 输出：true
 * 
 * 示例2：
 * 输入："race a car"
 * 输出：false
 * 
 * 算法原理（双指针）：
 * 1. 使用左右两个指针从两端向中间移动
 * 2. 跳过非字母和数字的字符
 * 3. 比较左右指针位置的字符（忽略大小写）
 * 4. 如果不相等，返回 false
 * 
 * 时间复杂度：O(n)，n 为字符串长度
 * 空间复杂度：O(1)
 * </pre>
 */
public class ValidPalindrome125 {

    public static void main(String[] args) {
        ValidPalindrome125 solution = new ValidPalindrome125();

        // 测试用例1：回文串（含非字母数字）
        System.out.println("测试用例1: " + solution.isPalindrome("A man, a plan, a canal: Panama")); // true

        // 测试用例2：非回文串
        System.out.println("测试用例2: " + solution.isPalindrome("race a car")); // false

        // 测试用例3：空字符串
        System.out.println("测试用例3: " + solution.isPalindrome("")); // true

        // 测试用例4：单字符
        System.out.println("测试用例4: " + solution.isPalindrome("a")); // true

        // 测试用例5：纯数字回文
        System.out.println("测试用例5: " + solution.isPalindrome("0P")); // false

        // 测试用例6：只有特殊字符
        System.out.println("测试用例6: " + solution.isPalindrome(".,!")); // true

        // 测试用例7：大小写混合
        System.out.println("测试用例7: " + solution.isPalindrome("Aa")); // true
    }

    public boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; ) {
            if (!Character.isLetterOrDigit(c[i])) {
                i++;
            } else if (!Character.isLetterOrDigit(c[j])) {
                j--;
            } else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--])) {
                return false;
            }
        }
        return true;
    }
}