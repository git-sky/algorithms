package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 33. 搜索旋转排序数组【Medium】（字节跳动高频）
 * 
 * 题目描述：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1。
 * 
 * 示例：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 
 * 算法原理（二分查找）：
 * 1. 旋转数组的特点：至少有一半是有序的
 * 2. 通过比较 nums[mid] 和 nums[end] 判断哪一半是有序的
 *    - 如果 nums[mid] > nums[end]：左半部分有序 [start..mid]
 *    - 否则：右半部分有序 [mid..end]
 * 3. 判断 target 是否在有序的那一半中
 *    - 如果在，缩小到有序的那一半
 *    - 如果不在，缩小到另一半
 * 
 * 关键：每次都能排除一半的搜索空间
 * 
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class SearchInRotatedSortedArray33 {

    public static void main(String[] args) {
        SearchInRotatedSortedArray33 solution = new SearchInRotatedSortedArray33();

        // 测试用例1：目标在右半部分
        System.out.println("测试用例1: " + solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4

        // 测试用例2：目标在左半部分
        System.out.println("测试用例2: " + solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5)); // 1

        // 测试用例3：目标不存在
        System.out.println("测试用例3: " + solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // -1

        // 测试用例4：单元素
        System.out.println("测试用例4: " + solution.search(new int[]{1}, 1)); // 0

        // 测试用例5：未旋转
        System.out.println("测试用例5: " + solution.search(new int[]{1, 2, 3, 4, 5}, 3)); // 2

        // 测试用例6：两元素
        System.out.println("测试用例6: " + solution.search(new int[]{3, 1}, 1)); // 1
    }

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                if (target > nums[mid] || target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }

        if (start == end && target != nums[start]) {
            return -1;
        }
        return start;
    }
}