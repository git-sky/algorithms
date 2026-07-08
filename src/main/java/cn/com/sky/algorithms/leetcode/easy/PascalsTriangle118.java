package cn.com.sky.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * LeetCode 118. 杨辉三角【Easy】
 * 
 * 题目描述：给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 示例（numRows = 5）：
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 
 * 算法原理（逐行构造）：
 * 1. 每一行的首尾元素都是1
 * 2. 中间元素等于上一行同列元素与前一列元素之和
 * 3. 利用 ArrayList 的特性，在行首插入1，然后更新中间元素
 * 
 * 巧妙实现：
 * - 每行先在头部插入1（自动将原有元素右移）
 * - 然后从第2个元素开始，每个元素加上下一个元素的值
 * - 最后一个1不需要处理
 * 
 * 时间复杂度：O(numRows^2)
 * 空间复杂度：O(numRows^2)，存储所有行
 * </pre>
 */
public class PascalsTriangle118 {

    public static void main(String[] args) {
        PascalsTriangle118 solution = new PascalsTriangle118();

        // 测试用例1：5行
        System.out.println("测试用例1 (5行): " + solution.generate(5));

        // 测试用例2：1行
        System.out.println("测试用例2 (1行): " + solution.generate(1));

        // 测试用例3：0行
        System.out.println("测试用例3 (0行): " + solution.generate(0));

        // 测试用例4：3行
        System.out.println("测试用例4 (3行): " + solution.generate(3));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            allrows.add(new ArrayList<>(row));
        }

        return allrows;
    }
}