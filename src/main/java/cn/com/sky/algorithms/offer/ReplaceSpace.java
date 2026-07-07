package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 5. 替换空格【Easy】
 *
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如输入"We are happy."，则输出"We%20are%20happy."
 *
 * 算法原理（从后往前复制）：
 * 1. 先遍历一次字符串，统计空格的数量
 * 2. 计算替换后的新长度：原长度 + 空格数 * 2
 * 3. 从后往前复制字符，遇到空格则替换为"%20"
 *
 * 为什么从后往前？
 * - 从前往后替换需要每次移动后面的所有字符，O(n^2)
 * - 从后往前每个字符最多移动一次，O(n)
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * </pre>
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        ReplaceSpace solution = new ReplaceSpace();

        // 测试用例1：正常情况
        System.out.println("=== 测试用例1：正常情况 ===");
        String str1 = "We are happy.";
        System.out.println("输入: \"" + str1 + "\"");
        System.out.println("输出: \"" + solution.replaceSpace(str1) + "\"");

        // 测试用例2：无空格
        System.out.println("\n=== 测试用例2：无空格 ===");
        String str2 = "HelloWorld";
        System.out.println("输入: \"" + str2 + "\"");
        System.out.println("输出: \"" + solution.replaceSpace(str2) + "\"");

        // 测试用例3：全是空格
        System.out.println("\n=== 测试用例3：全是空格 ===");
        String str3 = "   ";
        System.out.println("输入: \"" + str3 + "\"");
        System.out.println("输出: \"" + solution.replaceSpace(str3) + "\"");

        // 测试用例4：空字符串
        System.out.println("\n=== 测试用例4：空字符串 ===");
        String str4 = "";
        System.out.println("输入: \"" + str4 + "\"");
        System.out.println("输出: \"" + solution.replaceSpace(str4) + "\"");

        // 测试用例5：首尾有空格
        System.out.println("\n=== 测试用例5：首尾有空格 ===");
        String str5 = " Hello ";
        System.out.println("输入: \"" + str5 + "\"");
        System.out.println("输出: \"" + solution.replaceSpace(str5) + "\"");

        // 测试用例6：连续空格
        System.out.println("\n=== 测试用例6：连续空格 ===");
        String str6 = "a  b  c";
        System.out.println("输入: \"" + str6 + "\"");
        System.out.println("输出: \"" + solution.replaceSpace(str6) + "\"");
    }

    /**
     * 替换空格为%20
     *
     * @param str 输入字符串
     * @return 替换后的字符串
     */
    public String replaceSpace(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        char[] arr = str.toCharArray();

        // 统计空格数量
        int spaceCount = 0;
        for (char c : arr) {
            if (c == ' ') {
                spaceCount++;
            }
        }

        // 计算新数组长度
        int newLength = arr.length + spaceCount * 2;
        char[] result = new char[newLength];

        // 从后往前复制
        int oldIndex = arr.length - 1;
        int newIndex = newLength - 1;

        while (oldIndex >= 0) {
            if (arr[oldIndex] == ' ') {
                result[newIndex--] = '0';
                result[newIndex--] = '2';
                result[newIndex--] = '%';
            } else {
                result[newIndex--] = arr[oldIndex];
            }
            oldIndex--;
        }

        return new String(result);
    }
}