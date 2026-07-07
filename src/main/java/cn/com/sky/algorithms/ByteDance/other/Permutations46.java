package cn.com.sky.algorithms.ByteDance.other;

import java.util.*;

/**
 * LeetCode 46. 全排列【Medium】（美团/京东高频）
 * 
 * 给定一个不含重复数字的数组 nums ，返回其所有可能的全排列。
 * 
 * 算法原理（回溯法）：
 * 1. 使用回溯遍历所有可能的排列
 * 2. 用visited数组记录已使用的数字
 * 3. 每次选择一个未使用的数字加入当前排列
 * 4. 递归到底后回溯，尝试其他选择
 * 
 * 时间复杂度：O(n * n!)
 * 空间复杂度：O(n)
 */
public class Permutations46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(nums[i]);
                backtrack(nums, visited, current, result);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutations46 solution = new Permutations46();
        
        int[] nums = {1, 2, 3};
        System.out.println("输入: [1,2,3]");
        System.out.println("全排列: " + solution.permute(nums));
    }
}