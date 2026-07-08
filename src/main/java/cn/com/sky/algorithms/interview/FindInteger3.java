package cn.com.sky.algorithms.interview;

/**
 * <pre>
 * 不包含数字3的整数计数【Easy】
 *
 * 题目：0-999999之间的所有整数中，任何一位都不包括数字3的数字总数有多少个？
 *
 * 算法原理（排列组合 / 数学法）：
 * 1. 6位数，每位可选0-9共10个数字，但不能选3
 * 2. 每位可选的数字有9个（0,1,2,4,5,6,7,8,9）
 * 3. 总数 = 9^6 = 531441
 *
 * 逐位分析验证：
 * - 1位数(1-9不含3)：8个
 * - 2位数(10-99不含3)：8×9 = 72个
 * - 3位数(100-999不含3)：8×9×9 = 648个
 * - 4位数：8×9^3 = 5832个
 * - 5位数：8×9^4 = 52488个
 * - 6位数：8×9^5 = 472392个
 * - 总计：8+72+648+5832+52488+472392 = 531441 = 9^6
 *
 * 注意：0也满足条件（不包含3），所以0-999999共9^6=531441个
 *
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 * </pre>
 */
public class FindInteger3 {

    public static void main(String[] args) {
        // 测试用例1：6位数（0-999999）不含3的总数
        System.out.println("=== 测试用例1：0-999999不含3的总数 ===");
        System.out.println("公式法 9^6 = " + (int) Math.pow(9, 6));

        // 测试用例2：逐位累加验证
        System.out.println("\n=== 测试用例2：逐位累加验证 ===");
        int total = 0;
        for (int digits = 1; digits <= 6; digits++) {
            int count = 8;
            for (int i = 1; i < digits; i++) {
                count *= 9;
            }
            System.out.println(digits + "位数不含3的个数: " + count);
            total += count;
        }
        System.out.println("总计(不含0): " + total);
        System.out.println("总计(含0): " + (total + 1));

        // 测试用例3：暴力验证小范围
        System.out.println("\n=== 测试用例3：暴力验证0-99 ===");
        int bruteForce = 0;
        for (int i = 0; i < 100; i++) {
            if (!String.valueOf(i).contains("3")) {
                bruteForce++;
            }
        }
        System.out.println("0-99不含3的个数(暴力): " + bruteForce);
        System.out.println("0-99不含3的个数(公式): " + (int) Math.pow(9, 2));

        // 测试用例4：推广 - n位数不含某个数字d的个数
        System.out.println("\n=== 测试用例4：推广公式 ===");
        System.out.println("n位数(0到10^n-1)不含数字d的个数 = 9^n");
        System.out.println("n位数(1到10^n-1)不含数字d的个数 = 8×9^(n-1) + 8×9^(n-2) + ... + 8");
    }
}