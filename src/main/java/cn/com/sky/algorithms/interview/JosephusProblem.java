package cn.com.sky.algorithms.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 约瑟夫问题【Medium】
 * 
 * 题目：有一个整型数组a[n]顺序存放0 ~ n-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。
 * 
 * 以8个数(n=8)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 * 
 * 算法原理：
 * 1. 模拟法：使用数组或链表模拟删除过程
 * 2. 数学公式法（约瑟夫环公式）：f(n,k) = (f(n-1,k) + k) % n，其中f(1,k)=0
 * 
 * 时间复杂度：
 * - 模拟法：O(n^2)
 * - 公式法：O(n)
 * 空间复杂度：
 * - 模拟法：O(n)
 * - 公式法：O(1)
 * </pre>
 */
public class JosephusProblem {

    public static void main(String[] args) {
        // 测试用例1：n=8，每隔2个删除一个
        System.out.println("=== 测试用例1：n=8 ===");
        System.out.println("模拟法结果: " + solveBySimulation(8, 3));
        System.out.println("公式法结果: " + solveByFormula(8, 3));

        // 测试用例2：n=5，每隔1个删除一个
        System.out.println("\n=== 测试用例2：n=5 ===");
        System.out.println("模拟法结果: " + solveBySimulation(5, 2));
        System.out.println("公式法结果: " + solveByFormula(5, 2));

        // 测试用例3：n=1
        System.out.println("\n=== 测试用例3：n=1 ===");
        System.out.println("模拟法结果: " + solveBySimulation(1, 3));
        System.out.println("公式法结果: " + solveByFormula(1, 3));

        // 测试用例4：n=10，每隔3个删除一个
        System.out.println("\n=== 测试用例4：n=10 ===");
        System.out.println("模拟法结果: " + solveBySimulation(10, 4));
        System.out.println("公式法结果: " + solveByFormula(10, 4));
    }

    /**
     * 模拟法解决约瑟夫问题
     * 
     * @param n 总人数
     * @param k 每隔k-1个人删除第k个人
     * @return 最后剩下的人的原始位置
     */
    public static int solveBySimulation(int n, int k) {
        if (n <= 0 || k <= 0) {
            throw new IllegalArgumentException("n和k必须大于0");
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            index = (index + k - 1) % list.size();
            list.remove(index);
        }

        return list.get(0);
    }

    /**
     * 公式法解决约瑟夫问题
     * 
     * @param n 总人数
     * @param k 每隔k-1个人删除第k个人
     * @return 最后剩下的人的原始位置
     */
    public static int solveByFormula(int n, int k) {
        if (n <= 0 || k <= 0) {
            throw new IllegalArgumentException("n和k必须大于0");
        }

        int result = 0; // f(1, k) = 0
        for (int i = 2; i <= n; i++) {
            result = (result + k) % i;
        }
        return result;
    }
}