package cn.com.sky.algorithms.interview;

/**
 * <pre>
 * 打印菱形图案【Easy】
 *
 * 题目：打印由星号组成的菱形图案
 *
 * 算法原理：
 * 将菱形分为上半部分和下半部分：
 * 上半部分（i从1到N）：
 *   - 空格数：N-i（逐行减少）
 *   - 星号数：2*i-1（奇数递增：1,3,5,7,...）
 * 下半部分（i从1到N-1）：
 *   - 空格数：i（逐行增加）
 *   - 星号数：2*(N-i)-1（奇数递减：7,5,3,1）
 *
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 * </pre>
 */
public class 菱形 {

    public static void main(String[] args) {
        // 测试用例1：N=5
        System.out.println("=== 测试用例1：N=5 ===");
        printDiamond(5);

        // 测试用例2：N=3
        System.out.println("\n=== 测试用例2：N=3 ===");
        printDiamond(3);

        // 测试用例3：N=1
        System.out.println("\n=== 测试用例3：N=1 ===");
        printDiamond(1);

        // 测试用例4：N=7
        System.out.println("\n=== 测试用例4：N=7 ===");
        printDiamond(7);
    }

    /**
     * 打印菱形
     *
     * @param N 菱形上半部分的行数
     */
    public static void printDiamond(int N) {
        // 上半部分
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print('*');
            }
            System.out.println();
        }
        // 下半部分
        for (int i = 1; i <= N - 1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = 2 * (N - i) - 1; k >= 1; k--) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}