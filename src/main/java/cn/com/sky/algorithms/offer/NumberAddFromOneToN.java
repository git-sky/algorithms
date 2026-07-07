package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 64. 求1+2+3+...+n【Medium】
 *
 * 题目：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、
 * switch、case等关键字及条件判断语句(a?b:c)。
 *
 * 算法原理（短路递归）：
 * 1. 利用逻辑与(&&)的短路特性代替if判断
 * 2. 当n > 0时，继续递归；当n = 0时，短路直接返回false（不执行递归）
 * 3. 递归实现累加：sum += n，然后递归调用 add(n-1)
 *
 * 核心思想：
 *   A && B：当A为false时，B不会被执行（短路特性）
 *   用 (n > 0) && add(n-1) 代替 if (n > 0) add(n-1)
 *
 * 其他解法：
 *   1. 数学公式：n*(n+1)/2（但用了乘法和除法，不符合题意）
 *   2. 利用异常处理：try-catch中用ArrayIndexOutOfBoundsException终止递归
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)，递归栈深度
 * </pre>
 */
public class NumberAddFromOneToN {

    public static void main(String[] args) {
        NumberAddFromOneToN solution = new NumberAddFromOneToN();

        // 测试用例1：正常情况
        System.out.println("=== 测试用例1：正常情况 ===");
        System.out.println("1+2+...+5 = " + solution.sum(5));   // 15
        System.out.println("1+2+...+10 = " + solution.sum(10)); // 55
        System.out.println("1+2+...+100 = " + solution.sum(100)); // 5050

        // 测试用例2：n=1
        System.out.println("\n=== 测试用例2：n=1 ===");
        System.out.println("sum(1) = " + solution.sum(1)); // 1

        // 测试用例3：n=0
        System.out.println("\n=== 测试用例3：n=0 ===");
        System.out.println("sum(0) = " + solution.sum(0)); // 0

        // 测试用例4：大数
        System.out.println("\n=== 测试用例4：大数 ===");
        System.out.println("sum(1000) = " + solution.sum(1000)); // 500500
    }

    /**
     * 求1+2+3+...+n，使用短路递归
     *
     * @param n 正整数
     * @return 1到n的和
     */
    public int sum(int n) {
        int result = 0;
        // 利用&&的短路特性：当n>0为false时，后面的递归不会执行
        boolean flag = (n > 0) && (result = n + sum(n - 1)) > 0;
        return result;
    }
}