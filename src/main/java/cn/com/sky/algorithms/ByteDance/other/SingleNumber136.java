package cn.com.sky.algorithms.ByteDance.other;

import org.junit.Test;

/**
 * 136. Single Number
 */
public class SingleNumber136 {

    @Test
    public void test() {
        int[] nums1 = {2, 2, 1};
        int[] nums2 = {4, 1, 2, 1, 2};
        int[] nums3 = {1};
        System.out.println(singleNumber(nums1));  // 1
        System.out.println(singleNumber(nums2));  // 4
        System.out.println(singleNumber(nums3));  // 1
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) result ^= num;
        return result;
    }
}