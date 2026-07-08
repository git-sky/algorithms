package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * 77. Combinations【Medium】
 *
 * 给定两个整数n和k，返回1...n中所有可能的k个数的组合。
 *
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 算法原理（回溯法）：
 * 使用深度优先搜索（DFS）生成所有组合。
 *
 * 关键优化（剪枝）：
 * - 当前位置i，还需要选k-len(path)个数
 * - 剩余可用数字：n-i+1个
 * - 如果剩余数字不够选，则剪枝：n-i+1 < k-len(path) => i > n-(k-len(path))+1
 *
 * 时间复杂度：O(C(n,k))，组合数
 * 空间复杂度：O(k)，递归栈深度
 *
 * </pre>
 */
public class Combinations77 {

    @Test
    public void solution() {
        System.out.println("测试用例1(n=4, k=2):");
        List<List<Integer>> result1 = combine(4, 2);
        for (List<Integer> comb : result1) {
            System.out.println(comb);
        }

        System.out.println("\n测试用例2(n=5, k=3):");
        List<List<Integer>> result2 = combine(5, 3);
        for (List<Integer> comb : result2) {
            System.out.println(comb);
        }

        System.out.println("\n测试用例3(n=1, k=1):");
        List<List<Integer>> result3 = combine(1, 1);
        for (List<Integer> comb : result3) {
            System.out.println(comb);
        }

        System.out.println("\n测试用例4(n=4, k=0):");
        List<List<Integer>> result4 = combine(4, 0);
        System.out.println("结果数量: " + result4.size());
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || k > n) {
            return result;
        }
        backtrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int n, int k, int start, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(n, k, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

}