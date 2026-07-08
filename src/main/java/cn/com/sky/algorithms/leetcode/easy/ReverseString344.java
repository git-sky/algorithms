package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 344. 反转字符串【Easy】
 * 
 * 题目描述：编写一个函数，其作用是将输入的字符串反转过来。
 * 
 * 示例：
 * 输入："hello"
 * 输出："olleh"
 * 
 * 算法原理（双指针交换）：
 * 1. 将字符串转为字符数组
 * 2. 使用左右两个指针，从两端向中间移动
 * 3. 交换左右指针位置的字符
 * 4. 直到两指针相遇
 * 
 * 时间复杂度：O(n)，n 为字符串长度
 * 空间复杂度：O(n)，字符数组的空间（Java字符串不可变）
 * </pre>
 */
public class ReverseString344 {

    public static void main(String[] args) {
        ReverseString344 solution = new ReverseString344();

        // 测试用例1：正常字符串
        System.out.println("测试用例1: " + solution.reverseString("hello"));   // "olleh"

        // 测试用例2：空字符串
        System.out.println("测试用例2: " + solution.reverseString(""));         // ""

        // 测试用例3：null
        System.out.println("测试用例3: " + solution.reverseString(null));       // ""

        // 测试用例4：单字符
        System.out.println("测试用例4: " + solution.reverseString("a"));        // "a"

        // 测试用例5：回文串
        System.out.println("测试用例5: " + solution.reverseString("aba"));      // "aba"

        // 测试用例6：长字符串
        System.out.println("测试用例6: " + solution.reverseString("A man, a plan, a canal: Panama"));
    }

    public String reverseString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }
}