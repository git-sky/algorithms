package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 62. 圆圈中最后剩下的数字（约瑟夫环问题）【Medium】
 *
 * 题目：0,1,...,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈中
 * 删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 算法原理（约瑟夫环数学公式）：
 * 1. 定义f(n,m)表示n个数字中每次删除第m个后最后剩下的数字
 * 2. 递推公式：f(n,m) = (f(n-1,m) + m) % n
 * 3. 边界条件：f(1,m) = 0
 *
 * 公式推导：
 *   假设n个数字中删除第m个后，剩下的n-1个数字的解为f(n-1,m)
 *   删除第m个数字后，从第m+1个数字开始重新编号
 *   新编号 = (旧编号 - m) % n
 *   旧编号 = (新编号 + m) % n
 *   因此 f(n,m) = (f(n-1,m) + m) % n
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * 对比：模拟法时间复杂度O(m*n)，空间复杂度O(n)
 * </pre>
 */
public class LastNumberInCircle {

    public static void main(String[] args) {
        LastNumberInCircle solution = new LastNumberInCircle();

        // 测试用例1：正常情况
        System.out.println("=== 测试用例1：正常情况 ===");
        System.out.println("n=6, m=3: " + solution.lastRemaining(6, 3)); // 3
        System.out.println("n=5, m=3: " + solution.lastRemaining(5, 3)); // 3
        System.out.println("n=10, m=17: " + solution.lastRemaining(10, 17)); // 2

        // 测试用例2：n=1
        System.out.println("\n=== 测试用例2：n=1 ===");
        System.out.println("n=1, m=1: " + solution.lastRemaining(1, 1)); // 0
        System.out.println("n=1, m=5: " + solution.lastRemaining(1, 5)); // 0

        // 测试用例3：m=1（每次删除第一个）
        System.out.println("\n=== 测试用例3：m=1 ===");
        System.out.println("n=5, m=1: " + solution.lastRemaining(5, 1)); // 4（最后一个）

        // 测试用例4：m=2
        System.out.println("\n=== 测试用例4：m=2 ===");
        System.out.println("n=5, m=2: " + solution.lastRemaining(5, 2)); // 2

        // 测试用例5：m=n
        System.out.println("\n=== 测试用例5：m=n ===");
        System.out.println("n=5, m=5: " + solution.lastRemaining(5, 5)); // 1

        // 测试用例6：无效输入
        System.out.println("\n=== 测试用例6：无效输入 ===");
        System.out.println("n=0, m=3: " + solution.lastRemaining(0, 3)); // -1
        System.out.println("n=5, m=0: " + solution.lastRemaining(5, 0)); // -1
    }

    /**
     * 约瑟夫环问题 - 数学公式法
     *
     * @param n 数字个数
     * @param m 每次删除第m个数字
     * @return 最后剩下的数字
     */
    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}