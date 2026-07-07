package cn.com.sky.algorithms.ByteDance.top10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * <pre>
 * LeetCode 1. Two Sum【Easy】
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * </pre>
 */
public class TwoSum1 {

    @Test
    public void solution() {
        int[] nums = {5, 3, 2, 1, 7, 11, 13};
        int target = 9;

        int[] sum1 = twoSum1(nums, target);
        int[] sum2 = twoSum2(nums, target);
        int[] sum3 = twoSum3(nums, target);
        System.out.println(Arrays.toString(sum1));
        System.out.println(Arrays.toString(sum2));
        System.out.println(Arrays.toString(sum3));
    }

    /**
     * 方法一：HashMap一次遍历法（最优解）
     * 时间复杂度：O(n)，空间复杂度：O(n)
     * 思路：遍历数组时同时查找补数，找到即返回，未找到则将当前元素存入map
     * 优点：只需一次遍历，效率更高
     *
     * @param nums   整数数组
     * @param target 目标和
     * @return 两个数的索引，使得它们的和等于target
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 方法二：HashMap两次遍历法（次优解）
     * 时间复杂度：O(n)，空间复杂度：O(n)
     * 思路：先将所有元素及其索引存入HashMap，然后遍历数组查找补数
     *
     * @param nums   整数数组
     * @param target 目标和
     * @return 两个数的索引，使得它们的和等于target
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法三：暴力枚举法（最差解）
     * 时间复杂度：O(n²)，空间复杂度：O(1)
     * 思路：双重循环遍历所有元素组合，找到和为target的两个数
     * 优点：无需额外空间
     * 缺点：效率较低，适合小规模数据
     *
     * @param nums   整数数组
     * @param target 目标和
     * @return 两个数的索引，使得它们的和等于target
     */
    public int[] twoSum3(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}