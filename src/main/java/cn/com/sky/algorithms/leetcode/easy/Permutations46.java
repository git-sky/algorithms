package cn.com.sky.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * LeetCode 46. 全排列【Medium】（字节跳动高频）
 * 
 * 题目描述：给定一个不含重复数字的数组 nums ，返回其所有可能的全排列。
 * 
 * 示例：
 * 输入：[1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 算法原理（回溯法）：
 * 1. 从第一个位置开始，依次将每个未使用的数字放到当前位置
 * 2. 递归处理下一个位置
 * 3. 回溯：撤销选择，恢复状态，尝试下一个数字
 * 4. 当所有位置都填满时，得到一个排列
 * 
 * 时间复杂度：O(n * n!)，共有n!个排列，每个排列需要O(n)时间复制
 * 空间复杂度：O(n)，递归深度为n
 * </pre>
 */
public class Permutations46 {

    public static void main(String[] args) {
        Permutations46 solution = new Permutations46();

        // 测试用例1：正常情况
        int[] nums1 = {1, 2, 3};
        System.out.println("测试用例1: " + solution.permute(nums1));

        // 测试用例2：单元素
        int[] nums2 = {1};
        System.out.println("测试用例2: " + solution.permute(nums2));

        // 测试用例3：两个元素
        int[] nums3 = {1, 2};
        System.out.println("测试用例3: " + solution.permute(nums3));

        // 测试用例4：空数组
        int[] nums4 = {};
        System.out.println("测试用例4: " + solution.permute(nums4));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}