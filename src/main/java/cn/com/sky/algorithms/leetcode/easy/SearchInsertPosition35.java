package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 35. 搜索插入位置【Easy】
 * 
 * 题目描述：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 示例1：输入 [1,3,5,6], 5 → 输出 2
 * 示例2：输入 [1,3,5,6], 2 → 输出 1
 * 示例3：输入 [1,3,5,6], 7 → 输出 4
 * 示例4：输入 [1,3,5,6], 0 → 输出 0
 * 
 * 算法原理（二分查找）：
 * 1. 标准二分查找框架
 * 2. 如果找到目标值，直接返回索引
 * 3. 如果未找到，循环结束时 high+1 即为插入位置
 *    - 因为 high 指向最后一个小于 target 的元素
 *    - high+1 就是第一个大于等于 target 的位置
 * 
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class SearchInsertPosition35 {

    public static void main(String[] args) {
        SearchInsertPosition35 solution = new SearchInsertPosition35();
        int[] nums = {1, 3, 5, 6};

        // 测试用例1：目标值在数组中
        System.out.println("测试用例1: " + solution.searchInsert(nums, 5));  // 2

        // 测试用例2：目标值应插入中间
        System.out.println("测试用例2: " + solution.searchInsert(nums, 2));  // 1

        // 测试用例3：目标值大于所有元素
        System.out.println("测试用例3: " + solution.searchInsert(nums, 7));  // 4

        // 测试用例4：目标值小于所有元素
        System.out.println("测试用例4: " + solution.searchInsert(nums, 0));  // 0

        // 测试用例5：单元素数组
        System.out.println("测试用例5: " + solution.searchInsert(new int[]{1}, 0)); // 0

        // 测试用例6：目标等于首元素
        System.out.println("测试用例6: " + solution.searchInsert(nums, 1));  // 0

        // 测试用例7：目标等于末元素
        System.out.println("测试用例7: " + solution.searchInsert(nums, 6));  // 3
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high + 1;
    }
}