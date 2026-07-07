package cn.com.sky.algorithms.ByteDance.top10;


import org.junit.Test;

import java.util.Arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that
 * each element appears only once and returns the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by
 * modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesFromSortedArray26 {

    @Test
    public void test() {
        // 测试用例1：正常情况
        int[] nums1 = {1, 1, 2};
        int len1 = removeDuplicates(nums1);
        System.out.println("测试用例1: 长度=" + len1 + ", 数组=" + Arrays.toString(nums1));  // 长度=2, [1,2,2]

        // 测试用例2：全部重复
        int[] nums2 = {0, 0, 0, 0};
        int len2 = removeDuplicates(nums2);
        System.out.println("测试用例2: 长度=" + len2 + ", 数组=" + Arrays.toString(nums2));  // 长度=1, [0,0,0,0]

        // 测试用例3：无重复
        int[] nums3 = {1, 2, 3, 4};
        int len3 = removeDuplicates(nums3);
        System.out.println("测试用例3: 长度=" + len3 + ", 数组=" + Arrays.toString(nums3));  // 长度=4, [1,2,3,4]

        // 测试用例4：空数组
        int[] nums4 = {};
        int len4 = removeDuplicates(nums4);
        System.out.println("测试用例4: 长度=" + len4 + ", 数组=" + Arrays.toString(nums4));  // 长度=0, []

        // 测试用例5：单元素
        int[] nums5 = {5};
        int len5 = removeDuplicates(nums5);
        System.out.println("测试用例5: 长度=" + len5 + ", 数组=" + Arrays.toString(nums5));  // 长度=1, [5]
    }

    /**
     * 双指针解法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 已排序的整数数组
     * @return 去重后的数组长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;  // 慢指针，指向当前不重复序列的最后一个位置
        for (int fast = 1; fast < nums.length; fast++) {
            // 如果快指针指向的值与慢指针不同
            if (nums[fast] != nums[slow]) {
                slow++;              // 慢指针前进一位
                nums[slow] = nums[fast];  // 更新不重复序列
            }
        }

        // 返回不重复序列的长度（慢指针位置+1）
        return slow + 1;
    }
}