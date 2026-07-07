package cn.com.sky.algorithms.ByteDance.other;

/**
 * LeetCode 977. 有序数组的平方【Easy】（字节跳动高频）
 * 
 * 给你一个按非递减顺序排序的整数数组 nums，返回每个数字的平方组成的新数组，
 * 要求也按非递减顺序排序。
 * 
 * 算法原理（双指针）：
 * 1. 数组是有序的，平方后的最大值一定在两端
 * 2. 使用左右指针分别指向数组两端
 * 3. 比较两端元素的绝对值，将较大的平方放入结果数组末尾
 * 4. 移动对应指针，直到所有元素处理完毕
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class SquaresOfASortedArray977 {

    public static void main(String[] args) {
        SquaresOfASortedArray977 solution = new SquaresOfASortedArray977();
        
        // 测试用例1：正常情况
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] result1 = solution.sortedSquares(nums1);
        printArray(result1); // [0,1,9,16,100]
        
        // 测试用例2：全负数
        int[] nums2 = {-7, -3, -2};
        int[] result2 = solution.sortedSquares(nums2);
        printArray(result2); // [4,9,49]
        
        // 测试用例3：全正数
        int[] nums3 = {1, 2, 3, 4};
        int[] result3 = solution.sortedSquares(nums3);
        printArray(result3); // [1,4,9,16]
        
        // 测试用例4：包含零
        int[] nums4 = {-5, -3, 0, 2, 4};
        int[] result4 = solution.sortedSquares(nums4);
        printArray(result4); // [0,4,9,16,25]
        
        // 测试用例5：单元素
        int[] nums5 = {-1};
        int[] result5 = solution.sortedSquares(nums5);
        printArray(result5); // [1]
        
        // 测试用例6：空数组
        int[] nums6 = {};
        int[] result6 = solution.sortedSquares(nums6);
        printArray(result6); // []
    }

    /**
     * 打印数组
     */
    private static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;
        
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if (leftSquare > rightSquare) {
                result[index--] = leftSquare;
                left++;
            } else {
                result[index--] = rightSquare;
                right--;
            }
        }
        
        return result;
    }
}