package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 60. n个骰子的点数【Medium】
 *
 * 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率。
 *
 * 算法原理（动态规划）：
 * 1. 定义dp[i][j]表示i个骰子点数之和为j的次数
 * 2. 递推关系：dp[i][j] = dp[i-1][j-1] + dp[i-1][j-2] + ... + dp[i-1][j-6]
 *    （当前骰子可能掷出1~6，所以从i-1个骰子的状态转移过来）
 * 3. 初始条件：dp[1][1] = dp[1][2] = ... = dp[1][6] = 1
 * 4. 概率 = dp[n][s] / 6^n
 *
 * 空间优化：使用两个一维数组交替使用，因为dp[i]只依赖dp[i-1]
 *
 * 时间复杂度：O(n^2)，n个骰子，点数范围n到6n
 * 空间复杂度：O(n)，使用两个一维数组
 * </pre>
 */
public class Dicesprobability43 {

    public static void main(String[] args) {
        Dicesprobability43 solution = new Dicesprobability43();

        // 测试用例1：1个骰子
        System.out.println("=== 测试用例1：1个骰子 ===");
        solution.printProbability(1);

        // 测试用例2：2个骰子
        System.out.println("\n=== 测试用例2：2个骰子 ===");
        solution.printProbability(2);

        // 测试用例3：3个骰子
        System.out.println("\n=== 测试用例3：3个骰子 ===");
        solution.printProbability(3);

        // 测试用例4：无效输入
        System.out.println("\n=== 测试用例4：无效输入 ===");
        solution.printProbability(0);
    }

    /**
     * 打印n个骰子各点数和出现的概率
     *
     * @param n 骰子数量
     */
    public void printProbability(int num) {
        if (num < 1) {
            return;
        }

        int gMaxValue = 6;

        // 使用两个数组交替存储，节省空间
        int[][] probabilities = new int[2][];
        probabilities[0] = new int[gMaxValue * num + 1];
        probabilities[1] = new int[gMaxValue * num + 1];

        int flag = 0;

        // 初始化：1个骰子时，1~6各出现1次
        for (int i = 1; i <= gMaxValue; i++) {
            probabilities[flag][i] = 1;
        }

        // 逐个增加骰子数量
        for (int k = 2; k <= num; k++) {
            // 清空当前数组
            for (int i = 0; i < k; i++) {
                probabilities[1 - flag][i] = 0;
            }

            // k个骰子的点数范围是k到6*k
            for (int i = k; i <= gMaxValue * k; i++) {
                probabilities[1 - flag][i] = 0;
                // 当前骰子可能掷出1~6
                for (int j = 1; j <= i && j <= gMaxValue; j++) {
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }

            flag = 1 - flag;
        }

        // 计算并输出概率
        double total = Math.pow(gMaxValue, num);
        for (int i = num; i <= gMaxValue * num; i++) {
            double ratio = probabilities[flag][i] / total;
            System.out.printf("点数和=%d, 次数=%d, 概率=%.4f\n", i, probabilities[flag][i], ratio);
        }
    }
}