package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 *
 * 575. Distribute Candies【Easy】
 *
 * 给定一个偶数长度的整数数组，其中不同的数字代表不同种类的糖果。
 * 每个数字意味着一颗对应种类的糖果。你需要将这些糖果平均分配给弟弟和妹妹。
 * 返回妹妹可以获得的最大糖果种类数。
 *
 * 示例 1:
 * 输入: candies = [1,1,2,2,3,3]
 * 输出: 3
 * 解释: 有三种不同的糖果(1, 2, 3)，每种各有两颗。
 * 最优分配: 妹妹得到 [1,2,3]，弟弟也得到 [1,2,3]。
 * 妹妹有三种不同的糖果。
 *
 * 示例 2:
 * 输入: candies = [1,1,2,3]
 * 输出: 2
 * 解释: 妹妹得到 [2,3]，弟弟得到 [1,1]。
 * 妹妹有两种不同的糖果，弟弟只有一种。
 *
 * 算法原理（贪心/数学分析）：
 * 妹妹分到糖果总数的一半（n/2颗），她能获得的种类数取决于：
 * - 如果糖果种类数 >= n/2，则妹妹最多获得 n/2 种（每种一颗）
 * - 如果糖果种类数 < n/2，则妹妹最多获得全部种类（种类数）
 *
 * 因此结果为 min(糖果种类数, n/2)
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * </pre>
 */
public class DistributeCandies575 {

    @Test
    public void solution() {
        int[] test1 = {1, 1, 2, 2, 3, 3};
        System.out.println("测试用例1: " + distributeCandies(test1)); // 3

        int[] test2 = {1, 1, 2, 3};
        System.out.println("测试用例2: " + distributeCandies(test2)); // 2

        int[] test3 = {1, 1, 1, 1};
        System.out.println("测试用例3(全部相同): " + distributeCandies(test3)); // 1

        int[] test4 = {1, 2, 3, 4};
        System.out.println("测试用例4(全部不同): " + distributeCandies(test4)); // 2

        int[] test5 = {1, 1, 2, 2, 3, 3, 4, 4};
        System.out.println("测试用例5: " + distributeCandies(test5)); // 4
    }

    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies) {
            kinds.add(candy);
        }
        return Math.min(kinds.size(), candies.length / 2);
    }

}