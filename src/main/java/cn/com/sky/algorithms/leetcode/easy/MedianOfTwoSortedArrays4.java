package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * LeetCode 4. 寻找两个正序数组的中位数【Hard】（字节跳动、腾讯高频）
 *
 * 题目描述：给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n))。
 *
 * 示例：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 *
 * 算法原理（二分查找）：
 *
 * 核心思想：
 * 将问题转化为寻找两个数组的分割线，使得分割线左边的元素个数等于右边（或差1）
 *
 * 关键概念：
 * - 在有序数组中，中位数的位置将数组分成左右两部分
 * - 对于合并后的数组，我们需要找到一条分割线，使得：
 *   左边部分的元素个数 = 右边部分的元素个数（或左边多1）
 *   且左边所有元素 ≤ 右边所有元素
 *
 * 算法步骤：
 * 1. 确保 nums1 是较短的数组（在较短的数组上二分）
 * 2. 对 nums1 进行二分查找，确定分割位置 partition1
 * 3. 根据 partition1 计算 partition2
 *    - partition2 = (m + n + 1) / 2 - partition1
 *    - 这样保证左边总共有 (m+n+1)/2 个元素
 * 4. 检查分割是否有效：
 *    - nums1[partition1-1] ≤ nums2[partition2]
 *    - nums2[partition2-1] ≤ nums1[partition1]
 * 5. 根据总长度奇偶性计算中位数
 *
 * 为什么在较短数组上二分？
 * - 可以确保 partition2 不会越界
 * - 减少二分次数
 *
 * 时间复杂度：O(log(min(m,n)))，对较短的数组进行二分
 * 空间复杂度：O(1)
 *
 * 示例演示（nums1=[1,3], nums2=[2]）：
 * m=2, n=1, total=3, half=2
 * 二分范围：[0, 2]
 * partition1=1, partition2=2-1=1
 * 左边最大=max(1,2)=2，右边最小=3
 * 中位数=2.0 ✓
 * </pre>
 */
public class MedianOfTwoSortedArrays4 {

    @Test
    public void solution() {
        MedianOfTwoSortedArrays4 solution = new MedianOfTwoSortedArrays4();

        // 测试用例1：正常情况（示例1）
        System.out.println("测试用例1: " + solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        // 预期输出：2.0

        // 测试用例2：偶数长度（示例2）
        System.out.println("测试用例2: " + solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        // 预期输出：2.5

        // 测试用例3：一个数组为空
        System.out.println("测试用例3: " + solution.findMedianSortedArrays(new int[]{}, new int[]{1}));
        // 预期输出：1.0

        // 测试用例4：不同长度
        System.out.println("测试用例4: " + solution.findMedianSortedArrays(new int[]{3, 7, 10}, new int[]{1, 2, 4, 5, 6, 8, 9}));
        // 预期输出：5.0

        // 测试用例5：相同元素
        System.out.println("测试用例5: " + solution.findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 1}));
        // 预期输出：1.0

        // 测试用例6：单元素数组
        System.out.println("测试用例6: " + solution.findMedianSortedArrays(new int[]{1}, new int[]{2}));
        // 预期输出：1.5

        // 测试用例7：负数
        System.out.println("测试用例7: " + solution.findMedianSortedArrays(new int[]{-1, 0}, new int[]{1, 2}));
        // 预期输出：0.5
    }

    /**
     * 二分查找法 - 最优解法 ⭐
     * 时间复杂度 O(log(min(m,n)))，空间复杂度 O(1)
     *
     * @param nums1 第一个有序数组
     * @param nums2 第二个有序数组
     * @return 两个数组合并后的中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保 nums1 是较短的数组
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;
        int totalLeft = (m + n + 1) / 2;  // 左边应该有的元素个数（多1用于处理奇数情况）

        while (low <= high) {
            // 在 nums1 上进行二分
            int partition1 = (low + high) / 2;       // nums1的分割位置
            int partition2 = totalLeft - partition1;  // nums2的分割位置

            // 获取分割线左右的四个边界值
            int nums1LeftMax = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int nums1RightMin = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            int nums2LeftMax = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int nums2RightMin = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            // 检查分割是否有效
            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // 找到了正确的分割
                if ((m + n) % 2 == 1) {
                    // 总长度为奇数，返回左边最大的值
                    return Math.max(nums1LeftMax, nums2LeftMax);
                } else {
                    // 总长度为偶数，返回左边最大和右边最小的平均值
                    return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
                }
            } else if (nums1LeftMax > nums2RightMin) {
                // nums1的分割点太靠右，需要向左移动
                high = partition1 - 1;
            } else {
                // nums1的分割点太靠右，需要向右移动
                low = partition1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted or other error occurred.");
    }

    /**
     * 方法二：归并排序法（易于理解但非最优）
     * 时间复杂度 O(m+n)，空间复杂度 O(m+n)
     * 不满足题目要求的 O(log(m+n)) 复杂度
     *
     * @param nums1 第一个有序数组
     * @param nums2 第二个有序数组
     * @return 两个数组合并后的中位数
     */
    public double findMedianSortedArraysMerge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < m) {
            merged[k++] = nums1[i++];
        }
        while (j < n) {
            merged[k++] = nums2[j++];
        }

        // 计算中位数
        if ((m + n) % 2 == 1) {
            return merged[(m + n) / 2];
        } else {
            return (merged[(m + n) / 2 - 1] + merged[(m + n) / 2]) / 2.0;
        }
    }
}