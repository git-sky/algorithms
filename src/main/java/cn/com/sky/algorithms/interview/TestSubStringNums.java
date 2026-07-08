package cn.com.sky.algorithms.interview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * 子串出现次数统计【Easy】
 *
 * 题目：统计子串在主串中出现的次数
 *
 * 算法原理：
 * 方法1（正则表达式法）：使用Pattern和Matcher的find()方法逐次匹配
 * 方法2（indexOf法）：使用String.indexOf()逐次查找并截断
 *
 * 注意：两种方法都是非重叠匹配，即已匹配的部分不会再次参与匹配
 * 例如："aaaa"中查找"aa"，结果为2（非重叠），而非3（重叠）
 *
 * 时间复杂度：O(n*m)，n为主串长度，m为子串长度
 * 空间复杂度：O(1)
 * </pre>
 */
public class TestSubStringNums {

    public static void main(String[] args) {
        // 测试用例1：正常情况
        System.out.println("=== 测试用例1：正常情况 ===");
        System.out.println("count(正则): " + count("abcmnabcdefgabcxyzabcabc", "abc")); // 4
        System.out.println("count(indexOf): " + count2("abcmnabcdefgabcxyzabcabc", "abc")); // 4

        // 测试用例2：子串不存在
        System.out.println("\n=== 测试用例2：子串不存在 ===");
        System.out.println("count: " + count2("hello world", "xyz")); // 0

        // 测试用例3：重叠情况（非重叠匹配）
        System.out.println("\n=== 测试用例3：重叠情况 ===");
        System.out.println("count: " + count2("aaaa", "aa")); // 2（非重叠）

        // 测试用例4：子串等于主串
        System.out.println("\n=== 测试用例4：子串等于主串 ===");
        System.out.println("count: " + count2("abc", "abc")); // 1

        // 测试用例5：单字符
        System.out.println("\n=== 测试用例5：单字符 ===");
        System.out.println("count: " + count2("aabbaa", "a")); // 4
    }

    /**
     * 方法1：正则表达式统计子串出现次数
     */
    private static int count(String str, String regex) {
        int count = 0;
        Matcher mat = Pattern.compile(regex).matcher(str);
        while (mat.find()) {
            count++;
        }
        return count;
    }

    /**
     * 方法2：indexOf统计子串出现次数
     * 每次找到子串后，从子串后面继续查找
     */
    private static int count2(String s, String ss) {
        int count = 0;
        int index;
        while ((index = s.indexOf(ss)) != -1) {
            s = s.substring(index + ss.length());
            count++;
        }
        return count;
    }
}