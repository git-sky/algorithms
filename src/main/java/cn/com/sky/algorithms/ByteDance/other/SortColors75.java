package cn.com.sky.algorithms.ByteDance.other;

import java.util.Arrays;

/**
 * LeetCode 75. 颜色分类【Medium】（美团高频）
 * 
 * 给定一个包含红色、白色和蓝色的数组，原地排序使相同颜色相邻，按红、白、蓝顺序排列。
 * 使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 
 * 算法原理（三指针法）：
 * 1. left指针：指向下一个0应该放置的位置
 * 2. right指针：指向下一个2应该放置的位置
 * 3. curr指针：遍历数组
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class SortColors75 {

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int curr = 0;
        
        while (curr <= right) {
            if (nums[curr] == 0) {
                swap(nums, left, curr);
                left++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(nums, curr, right);
                right--;
            } else {
                curr++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors75 solution = new SortColors75();
        
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        System.out.println("输入: " + Arrays.toString(nums1));
        solution.sortColors(nums1);
        System.out.println("输出: " + Arrays.toString(nums1));
    }
}