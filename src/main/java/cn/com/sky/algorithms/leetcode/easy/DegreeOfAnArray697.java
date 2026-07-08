package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *
 * 697. Degree of an Array【Easy】
 *
 * 给定非空非负整数数组，数组的度是指数组中出现次数最多元素的个数。
 * 寻找最小连续子数组，使得子数组的度与原数组的度相同。返回子数组的长度。
 *
 * 示例 1:
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2都出现了两次。
 * 具有相同度的子数组包括：
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短长度是2，所以返回2。
 *
 * 示例 2:
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 *
 * 算法原理：
 * 使用HashMap记录每个元素的信息：
 * - 出现次数（用于计算度）
 * - 首次出现位置
 * - 最后一次出现位置
 *
 * 步骤：
 * 1. 遍历数组，统计每个元素的频率、起始和结束位置
 * 2. 找到最大频率（即数组的度）
 * 3. 对于所有频率等于度的元素，计算其最后位置-起始位置+1
 * 4. 返回最小长度
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * </pre>
 */
public class DegreeOfAnArray697 {

    @Test
    public void solution() {
        int[] test1 = {1, 2, 2, 3, 1};
        System.out.println("测试用例1: " + findShortestSubArray(test1)); // 2

        int[] test2 = {1, 2, 2, 3, 1, 4, 2};
        System.out.println("测试用例2: " + findShortestSubArray(test2)); // 6

        int[] test3 = {1};
        System.out.println("测试用例3(单元素): " + findShortestSubArray(test3)); // 1

        int[] test4 = {1, 2, 3, 4, 5};
        System.out.println("测试用例4(无重复): " + findShortestSubArray(test4)); // 1

        int[] test5 = {2, 1, 1, 2, 1, 3, 3, 3, 1, 3, 1, 3, 2};
        System.out.println("测试用例5(复杂情况): " + findShortestSubArray(test5)); // 7
    }

    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{1, i, i});
            } else {
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2] = i;
            }
        }

        int maxFreq = 0;
        int minLen = Integer.MAX_VALUE;

        for (int[] value : map.values()) {
            if (value[0] > maxFreq) {
                maxFreq = value[0];
                minLen = value[2] - value[1] + 1;
            } else if (value[0] == maxFreq) {
                minLen = Math.min(minLen, value[2] - value[1] + 1);
            }
        }

        return minLen;
    }

}