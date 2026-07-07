package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 58-I. 翻转单词顺序【Easy】
 *
 * 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student."，则输出"student. a am I"
 *
 * 算法原理（两次翻转法）：
 * 1. 第一次翻转：翻转整个字符串，此时单词顺序和单词内字符顺序都反了
 * 2. 第二次翻转：逐个翻转每个单词，恢复单词内字符的正确顺序
 *
 * 例如："I am a student."
 * 第一步：".tneduts a ma I"
 * 第二步："student. a am I"
 *
 * 时间复杂度：O(n)，每个字符被翻转两次
 * 空间复杂度：O(n)，需要转换为字符数组
 * </pre>
 */
public class RotateString42 {

    public static void main(String[] args) {
        RotateString42 solution = new RotateString42();

        // 测试用例1：正常句子
        System.out.println("=== 测试用例1：正常句子 ===");
        String str1 = "I am a student.";
        System.out.println("输入: \"" + str1 + "\"");
        System.out.println("输出: \"" + solution.reverseSentence(str1) + "\"");

        // 测试用例2：单个单词
        System.out.println("\n=== 测试用例2：单个单词 ===");
        String str2 = "Hello";
        System.out.println("输入: \"" + str2 + "\"");
        System.out.println("输出: \"" + solution.reverseSentence(str2) + "\"");

        // 测试用例3：空字符串
        System.out.println("\n=== 测试用例3：空字符串 ===");
        String str3 = "";
        System.out.println("输入: \"" + str3 + "\"");
        System.out.println("输出: \"" + solution.reverseSentence(str3) + "\"");

        // 测试用例4：只有空格
        System.out.println("\n=== 测试用例4：只有空格 ===");
        String str4 = "   ";
        System.out.println("输入: \"" + str4 + "\"");
        System.out.println("输出: \"" + solution.reverseSentence(str4) + "\"");

        // 测试用例5：多个连续空格
        System.out.println("\n=== 测试用例5：多个连续空格 ===");
        String str5 = "  hello   world  ";
        System.out.println("输入: \"" + str5 + "\"");
        System.out.println("输出: \"" + solution.reverseSentence(str5) + "\"");

        // 测试用例6：两个单词
        System.out.println("\n=== 测试用例6：两个单词 ===");
        String str6 = "Hello World";
        System.out.println("输入: \"" + str6 + "\"");
        System.out.println("输出: \"" + solution.reverseSentence(str6) + "\"");
    }

    /**
     * 翻转句子中的单词顺序
     *
     * @param str 输入句子
     * @return 翻转后的句子
     */
    public String reverseSentence(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        char[] arr = str.toCharArray();

        // 第一步：翻转整个字符串
        reverse(arr, 0, arr.length - 1);

        // 第二步：逐个翻转每个单词
        int start = 0;
        int end = 0;
        while (end <= arr.length) {
            if (end == arr.length || arr[end] == ' ') {
                reverse(arr, start, end - 1);
                start = end + 1;
            }
            end++;
        }

        return new String(arr);
    }

    /**
     * 翻转字符数组的指定区间
     *
     * @param arr   字符数组
     * @param start 起始索引
     * @param end   结束索引
     */
    private void reverse(char[] arr, int start, int end) {
        if (start < 0 || end >= arr.length || start >= end) {
            return;
        }
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}