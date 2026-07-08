package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * LeetCode 204. 计数质数【Easy】
 *
 * 题目描述：统计所有小于非负整数 n 的质数的数量。
 *
 * 示例：
 * 输入：n = 10
 * 输出：4（小于10的质数有2,3,5,7）
 *
 * 输入：n = 0
 * 输出：0
 *
 * 输入：n = 1
 * 输出：0
 *
 * 算法原理（埃拉托斯特尼筛法 / Sieve of Eratosthenes）：
 *
 * 什么是质数？
 * - 质数（素数）是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数
 * - 例如：2, 3, 5, 7, 11, 13, ...
 *
 * 筛法原理：
 * 1. 初始化一个布尔数组 isPrime[0..n-1]，全部标记为true
 * 2. 从2开始遍历，如果当前数i是质数：
 *    - 将所有i的倍数（i*i, i*(i+1), ...）标记为非质数
 *    - 为什么从i*i开始？因为更小的倍数已经被更小的质数筛掉了
 * 3. 统计剩余的质数个数
 *
 * 优化技巧：
 * - 外层循环只需到 sqrt(n)：因为如果n有大于sqrt(n)的因子，那么它一定有一个对应的小于sqrt(n)的因子
 * - 内层循环从i*i开始：避免重复标记
 * - 使用boolean数组而非HashSet提高效率
 *
 * 时间复杂度分析：
 * - O(n log log n)，接近线性时间
 * - 比逐个判断每个数是否为质数快得多
 *
 * 空间复杂度：O(n)，需要一个大小为n的数组
 *
 * 示例演示（n=20）：
 * 初始：[F,F,T,T,T,T,T,T,T,T,T,T,T,T,T,T,T,T,T]
 * i=2: 标记4,6,8,10,12,14,16,18 → [F,F,T,F,T,F,T,F,T,F,T,F,T,F,T,F,T,F,T]
 * i=3: 标记9,12,15,18       → [F,F,T,F,T,F,F,F,T,F,T,F,F,F,T,F,F,F,T]
 * i=4: 已被标记，跳过
 * i=5: 25>20，结束
 * 结果：统计true的个数 = 8个质数（2,3,5,7,11,13,17,19）
 * </pre>
 */
public class CountPrimes204 {

    @Test
    public void solution() {
        CountPrimes204 solution = new CountPrimes204();

        // 测试用例1：正常情况
        System.out.println("测试用例1 (n=10): " + solution.countPrimes(10));   // 4

        // 测试用例2：0
        System.out.println("测试用例2 (n=0): " + solution.countPrimes(0));     // 0

        // 测试用例3：1
        System.out.println("测试用例3 (n=1): " + solution.countPrimes(1));     // 0

        // 测试用例4：2（最小的质数）
        System.out.println("测试用例4 (n=2): " + solution.countPrimes(2));     // 0

        // 测试用例5：100以内的质数
        System.out.println("测试用例5 (n=100): " + solution.countPrimes(100)); // 25

        // 测试用例6：大数
        System.out.println("测试用例6 (n=1000): " + solution.countPrimes(1000)); // 168

        // 测试用例7：题目示例
        System.out.println("测试用例7 (n=20): " + solution.countPrimes(20));   // 8
    }

    /**
     * 埃拉托斯特尼筛法（最优解法）⭐
     * 时间复杂度 O(n log log n)，空间复杂度 O(n)
     *
     * @param n 上限（不包含）
     * return 小于n的质数的数量
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        // 初始化：假设所有数都是质数
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        // 筛法核心：只需要检查到sqrt(n)
        // 因为任何合数n必定有一个因子<=sqrt(n)
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) {
                continue;  // 如果i不是质数，跳过
            }

            // 将i的所有倍数标记为非质数
            // 从i*i开始，因为更小的倍数已经被更小的质数处理过了
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }

        // 统计质数个数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

    /**
     * 方法二：逐个判断是否为质数（效率较低）
     * 时间复杂度 O(n * sqrt(n)) = O(n^1.5)
     * 仅用于对比，不推荐使用
     *
     * @param n 上限（不包含）
     * @return 小于n的质数的数量
     */
    /*
    public int countPrimesBruteForce(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        // 只需检查到sqrt(num)
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    */
}