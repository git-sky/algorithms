package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 15. 二进制中1的个数【Easy】
 *
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * 例如把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 *
 * 算法原理：
 * 方法1（无符号右移）：
 *   将n不断无符号右移(>>>)，每次与1做与运算统计1的个数
 *   注意：必须用>>>而不是>>，因为>>对负数会高位补1导致死循环
 *
 * 方法2（左移标志位）：
 *   不移动n，而是将标志位1不断左移，与n做与运算
 *   缺点：无论1的个数多少，都要循环32次
 *
 * 方法3（n & (n-1)技巧）【最优】：
 *   n & (n-1) 会把n的最右边的1变成0
 *   例如：n = 1001, n-1 = 1000, n & (n-1) = 1000（消掉了最右边的1）
 *   循环次数等于1的个数，效率最高
 *
 * 相关问题：
 * (a) 用一条语句判断一个整数是不是2的整数次方
 *     答案: n > 0 && (n & (n-1)) == 0（2的整数次方只有一个1）
 * (b) 输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n
 *     答案: 先求异或m^n，然后统计结果中1的个数
 *
 * 时间复杂度：方法1和2为O(32)，方法3为O(k)，k为1的个数
 * 空间复杂度：O(1)
 * </pre>
 */
public class NumberOf1InBinary {

    public static void main(String[] args) {
        NumberOf1InBinary solution = new NumberOf1InBinary();

        // 测试用例1：正数
        System.out.println("=== 测试用例1：正数 ===");
        System.out.println("9的二进制: " + Integer.toBinaryString(9) + ", 1的个数: " + solution.numberOf1(9)); // 2
        System.out.println("1的二进制: " + Integer.toBinaryString(1) + ", 1的个数: " + solution.numberOf1(1)); // 1
        System.out.println("7的二进制: " + Integer.toBinaryString(7) + ", 1的个数: " + solution.numberOf1(7)); // 3

        // 测试用例2：0
        System.out.println("\n=== 测试用例2：0 ===");
        System.out.println("0的1的个数: " + solution.numberOf1(0)); // 0

        // 测试用例3：负数
        System.out.println("\n=== 测试用例3：负数 ===");
        System.out.println("-1的二进制: " + Integer.toBinaryString(-1) + ", 1的个数: " + solution.numberOf1(-1)); // 32
        System.out.println("-5的二进制: " + Integer.toBinaryString(-5) + ", 1的个数: " + solution.numberOf1(-5)); // 31

        // 测试用例4：2的整数次方
        System.out.println("\n=== 测试用例4：2的整数次方 ===");
        System.out.println("8的二进制: " + Integer.toBinaryString(8) + ", 1的个数: " + solution.numberOf1(8)); // 1
        System.out.println("1024的1的个数: " + solution.numberOf1(1024)); // 1

        // 测试用例5：Integer.MAX_VALUE
        System.out.println("\n=== 测试用例5：Integer.MAX_VALUE ===");
        System.out.println("MAX_VALUE的1的个数: " + solution.numberOf1(Integer.MAX_VALUE)); // 31

        // 测试用例6：Integer.MIN_VALUE
        System.out.println("\n=== 测试用例6：Integer.MIN_VALUE ===");
        System.out.println("MIN_VALUE的二进制: " + Integer.toBinaryString(Integer.MIN_VALUE) + ", 1的个数: " + solution.numberOf1(Integer.MIN_VALUE)); // 1
    }

    /**
     * 最优解法：n & (n-1) 消除最右边的1
     *
     * @param n 输入整数
     * @return 二进制中1的个数
     */
    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * 方法2：左移标志位
     * 缺点：固定循环32次
     */
    public int numberOf1ByLeftShift(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 方法1：无符号右移
     */
    public int numberOf1ByRightShift(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}