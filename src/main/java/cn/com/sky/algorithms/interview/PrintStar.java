package cn.com.sky.algorithms.interview;

/**
 * <pre>
 * 打印星号矩阵【Easy】
 *
 * 题目：打印(2N-1)×(2N-1)的星号矩阵
 *
 * 算法原理：
 * 双重循环，外层控制行数(2N-1行)，内层控制列数(2N-1列)
 *
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 * </pre>
 */
public class PrintStar {

    public static void main(String[] args) {
        // 测试用例1：N=2，打印3×3矩阵
        System.out.println("=== 测试用例1：N=2 ===");
        printStar(2);

        // 测试用例2：N=3，打印5×5矩阵
        System.out.println("\n=== 测试用例2：N=3 ===");
        printStar(3);

        // 测试用例3：N=1，打印1×1矩阵
        System.out.println("\n=== 测试用例3：N=1 ===");
        printStar(1);

        // 测试用例4：N=5，打印9×9矩阵
        System.out.println("\n=== 测试用例4：N=5 ===");
        printStar(5);
    }

    /**
     * 打印(2N-1)×(2N-1)的星号矩阵
     *
     * @param N 参数N
     */
    public static void printStar(int N) {
        String x = "*";
        for (int i = 0; i < 2 * N - 1; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                System.out.print(x);
            }
            System.out.println();
        }
    }
}