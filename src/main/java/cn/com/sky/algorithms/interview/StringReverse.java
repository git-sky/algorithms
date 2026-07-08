package cn.com.sky.algorithms.interview;

import java.util.Arrays;

/**
 * <pre>
 * 字符串单词反转【Easy】
 *
 * 题目：将字符串中的单词顺序反转，例如 "I love java" 反转为 "java love I"
 *
 * 算法原理（两次翻转法）：
 * 1. 先翻转整个字符串："I love java" -> "avaj evol I"
 * 2. 再逐个翻转每个单词："avaj" -> "java", "evol" -> "love", "I" -> "I"
 * 3. 最终结果："java love I"
 *
 * 优势：原地操作，不需要额外空间
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)（toCharArray创建了新数组）
 * </pre>
 */
public class StringReverse {

    public static void main(String[] args) {
        StringReverse sr = new StringReverse();

        // 测试用例1：正常句子
        System.out.println("=== 测试用例1：正常句子 ===");
        System.out.println(sr.swapWords("I love java"));

        // 测试用例2：单个单词
        System.out.println("\n=== 测试用例2：单个单词 ===");
        System.out.println(sr.swapWords("hello"));

        // 测试用例3：空字符串
        System.out.println("\n=== 测试用例3：空字符串 ===");
        System.out.println(sr.swapWords(""));

        // 测试用例4：两个单词
        System.out.println("\n=== 测试用例4：两个单词 ===");
        System.out.println(sr.swapWords("Hello World"));

        // 测试用例5：多个单词
        System.out.println("\n=== 测试用例5：多个单词 ===");
        System.out.println(sr.swapWords("a b c d e"));
    }

    /**
     * 反转字符数组中指定范围的字符
     */
    public void swap(char[] arr, int begin, int end) {
        while (begin < end) {
            char temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            begin++;
            end--;
        }
    }

    /**
     * 反转字符串中的单词顺序
     * 例如："I love java" -> "java love I"
     */
    public String swapWords(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        char[] arr = str.toCharArray();

        // 第一步：翻转整个字符串
        swap(arr, 0, arr.length - 1);

        // 第二步：逐个翻转每个单词
        int begin = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ' ') {
                swap(arr, begin, i - 1);
                begin = i + 1;
            }
        }
        // 翻转最后一个单词
        swap(arr, begin, arr.length - 1);

        return new String(arr);
    }
}