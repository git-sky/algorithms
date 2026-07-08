package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 231. 2的幂【Easy】
 * 
 * 题目描述：给定一个整数，写一个函数来判断它是否是 2 的幂次方。
 * 
 * 示例1：输入 1，输出 true（2^0 = 1）
 * 示例2：输入 16，输出 true（2^4 = 16）
 * 示例3：输入 218，输出 false
 * 
 * 算法原理（位运算）：
 * 2的幂的二进制表示中只有一个1：
 * - 1 = 0001, 2 = 0010, 4 = 0100, 8 = 1000
 * 
 * 利用 n & (n-1) 的特性：
 * - n-1 会将最低位的1变为0，其后的0变为1
 * - 如果 n 是2的幂，n & (n-1) = 0
 * - 例如：8(1000) & 7(0111) = 0
 * 
 * 注意：n 必须大于0，因为0和负数不是2的幂
 * 
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 * </pre>
 */
public class PowerOfTwo231 {

    public static void main(String[] args) {
        PowerOfTwo231 solution = new PowerOfTwo231();

        // 测试用例1：2的幂
        System.out.println("测试用例1: " + solution.isPowerOfTwo(1));    // true
        System.out.println("测试用例2: " + solution.isPowerOfTwo(16));   // true
        System.out.println("测试用例3: " + solution.isPowerOfTwo(1024)); // true

        // 测试用例2：非2的幂
        System.out.println("测试用例4: " + solution.isPowerOfTwo(218));  // false
        System.out.println("测试用例5: " + solution.isPowerOfTwo(3));    // false

        // 测试用例3：边界情况
        System.out.println("测试用例6: " + solution.isPowerOfTwo(0));    // false
        System.out.println("测试用例7: " + solution.isPowerOfTwo(-1));   // false

        // 测试用例4：2的31次方
        System.out.println("测试用例8: " + solution.isPowerOfTwo(1073741824)); // true
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n - 1) & n) == 0;
    }
}