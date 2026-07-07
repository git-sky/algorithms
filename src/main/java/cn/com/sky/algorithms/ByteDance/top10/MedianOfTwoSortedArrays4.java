package cn.com.sky.algorithms.ByteDance.top10;

/**
 * LeetCode 4. 寻找两个正序数组的中位数【Hard】（字节跳动高频）
 * 
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的中位数。
 * 
 * 算法原理（二分查找）：
 * 1. 确保 nums1 是较短的数组，减少二分次数
 * 2. 在 nums1 上进行二分查找，找到分割点 i
 * 3. 根据 i 计算 nums2 的分割点 j = (m+n+1)/2 - i
 * 4. 确保分割后左边所有元素 <= 右边所有元素
 * 5. 根据总长度奇偶性返回中位数
 * 
 * 时间复杂度：O(log(min(m,n)))
 * 空间复杂度：O(1)
 */
public class MedianOfTwoSortedArrays4 {

    public static void main(String[] args) {
        MedianOfTwoSortedArrays4 solution = new MedianOfTwoSortedArrays4();
        
        // 测试用例1：奇数长度
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("测试用例1: " + solution.findMedianSortedArrays(nums1, nums2)); // 2.0
        
        // 测试用例2：偶数长度
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("测试用例2: " + solution.findMedianSortedArrays(nums3, nums4)); // 2.5
        
        // 测试用例3：空数组1
        int[] nums5 = {};
        int[] nums6 = {1};
        System.out.println("测试用例3: " + solution.findMedianSortedArrays(nums5, nums6)); // 1.0
        
        // 测试用例4：空数组2
        int[] nums7 = {2};
        int[] nums8 = {};
        System.out.println("测试用例4: " + solution.findMedianSortedArrays(nums7, nums8)); // 2.0
        
        // 测试用例5：重叠数组
        int[] nums9 = {1, 3, 5};
        int[] nums10 = {2, 4, 6};
        System.out.println("测试用例5: " + solution.findMedianSortedArrays(nums9, nums10)); // 3.5
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保 nums1 是较短的数组
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        
        int left = 0;
        int right = m;
        
        while (left <= right) {
            // 在 nums1 中的分割点
            int i = (left + right) / 2;
            // 在 nums2 中的分割点
            int j = (m + n + 1) / 2 - i;
            
            // 处理边界情况
            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];
            
            // 找到正确的分割
            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                // 总长度为奇数
                if ((m + n) % 2 == 1) {
                    return Math.max(nums1Left, nums2Left);
                } else {
                    // 总长度为偶数
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                }
            } else if (nums1Left > nums2Right) {
                // 需要向左移动分割点
                right = i - 1;
            } else {
                // 需要向右移动分割点
                left = i + 1;
            }
        }
        
        return 0.0;
    }
}