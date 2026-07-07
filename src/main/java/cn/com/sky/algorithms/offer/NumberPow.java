package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 16. 数值的整数次方【Medium】
 *
 * 题目：实现函数double Power(double base, int exponent)，
 * 求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * 算法原理（快速幂）：
 * 1. 将指数转化为二进制表示，例如 13 = 1101 = 8 + 4 + 1
 * 2. 通过平方逐步计算 base^1, base^2, base^4, base^8, ...
 * 3. 如果指数的二进制对应位为1，则将结果乘以当前的base幂
 *
 * 快速幂核心思想：
 *   x^n = x^(n/2) * x^(n/2)          当n为偶数
 *   x^n = x^((n-1)/2) * x^((n-1)/2) * x  当n为奇数
 *
 * 处理负指数：x^(-n) = 1 / x^n
 * 处理0的0次方：约定为1
 *
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class NumberPow {

    public static void main(String[] args) {
        NumberPow solution = new NumberPow();

        // 测试用例1：正指数
        System.out.println("=== 测试用例1：正指数 ===");
        System.out.println("2^10 = " + solution.power(2, 10)); // 1024.0
        System.out.println("2^1 = " + solution.power(2, 1));   // 2.0
        System.out.println("2^0 = " + solution.power(2, 0));   // 1.0

        // 测试用例2：负指数
        System.out.println("\n=== 测试用例2：负指数 ===");
        System.out.println("2^(-2) = " + solution.power(2, -2)); // 0.25
        System.out.println("2^(-1) = " + solution.power(2, -1)); // 0.5

        // 测试用例3：base为0
        System.out.println("\n=== 测试用例3：base为0 ===");
        System.out.println("0^5 = " + solution.power(0, 5));   // 0.0
        System.out.println("0^0 = " + solution.power(0, 0));   // 1.0

        // 测试用例4：base为1
        System.out.println("\n=== 测试用例4：base为1 ===");
        System.out.println("1^100 = " + solution.power(1, 100)); // 1.0

        // 测试用例5：base为负数
        System.out.println("\n=== 测试用例5：base为负数 ===");
        System.out.println("(-2)^3 = " + solution.power(-2, 3));  // -8.0
        System.out.println("(-2)^2 = " + solution.power(-2, 2));  // 4.0

        // 测试用例6：小数base
        System.out.println("\n=== 测试用例6：小数base ===");
        System.out.println("2.5^3 = " + solution.power(2.5, 3));  // 15.625

        // 测试用例7：Integer.MIN_VALUE
        System.out.println("\n=== 测试用例7：极端负指数 ===");
        System.out.println("2^(MIN_VALUE) = " + solution.power(2, Integer.MIN_VALUE)); // 接近0
    }

    /**
     * 快速幂计算base的exponent次方
     *
     * @param base     底数
     * @param exponent 指数
     * @return base^exponent
     */
    public double power(double base, int exponent) {
        // 处理0的0次方，约定为1
        if (base == 0 && exponent == 0) {
            return 1;
        }

        // 处理0的正数次方
        if (base == 0 && exponent > 0) {
            return 0;
        }

        // 使用long处理Integer.MIN_VALUE的情况
        // 因为 -Integer.MIN_VALUE 仍然等于 Integer.MIN_VALUE（溢出）
        long exp = exponent;
        if (exp < 0) {
            base = 1.0 / base;
            exp = -exp;
        }

        double result = 1.0;
        double currentProduct = base;

        // 快速幂：将指数按二进制分解
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct;
            exp >>= 1;
        }

        return result;
    }
}