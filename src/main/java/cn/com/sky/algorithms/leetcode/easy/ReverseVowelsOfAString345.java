package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 345. 反转字符串中的元音字母【Easy】
 * 
 * 题目描述：编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * 示例1：
 * 输入："hello"
 * 输出："holle"
 * 
 * 示例2：
 * 输入："leetcode"
 * 输出："leotcede"
 * 
 * 算法原理（双指针）：
 * 1. 使用左右两个指针从两端向中间移动
 * 2. 左指针找到元音字母后停止
 * 3. 右指针找到元音字母后停止
 * 4. 交换两个元音字母
 * 5. 继续移动直到两指针相遇
 * 
 * 元音字母：a, e, i, o, u（大小写都算）
 * 
 * 时间复杂度：O(n)，n 为字符串长度
 * 空间复杂度：O(n)，字符数组的空间
 * </pre>
 */
public class ReverseVowelsOfAString345 {

    public static void main(String[] args) {
        ReverseVowelsOfAString345 solution = new ReverseVowelsOfAString345();

        // 测试用例1：正常情况
        System.out.println("测试用例1: " + solution.reverseVowels("hello"));     // "holle"

        // 测试用例2：多个元音
        System.out.println("测试用例2: " + solution.reverseVowels("leetcode"));   // "leotcede"

        // 测试用例3：无元音
        System.out.println("测试用例3: " + solution.reverseVowels("bcdfg"));      // "bcdfg"

        // 测试用例4：全元音
        System.out.println("测试用例4: " + solution.reverseVowels("aeiou"));      // "uoiea"

        // 测试用例5：大小写混合
        System.out.println("测试用例5: " + solution.reverseVowels("aA"));         // "Aa"

        // 测试用例6：空字符串
        System.out.println("测试用例6: " + solution.reverseVowels(""));           // ""

        // 测试用例7：单字符
        System.out.println("测试用例7: " + solution.reverseVowels("a"));          // "a"
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }
            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
}