package cn.com.sky.algorithms.ByteDance;

/**
 * 有序数组平方后不同元素的数量【Medium】
 * 使用双指针法实现，时间复杂度 O(n)
 */
public class SquareUniqueCount {

    /**
     * 计算有序数组平方后不同元素的数量
     *
     * @param nums 有序整数数组（可能包含负数）
     * @return 平方后不同元素的数量
     */
    public static int countUniqueSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        Integer prevSquare = null; // 记录上一个平方值，用于去重

        while (left <= right) {
            // 比较两端元素的绝对值
            int leftAbs = Math.abs(nums[left]);
            int rightAbs = Math.abs(nums[right]);

            int currentSquare;
            if (leftAbs > rightAbs) {
                currentSquare = leftAbs * leftAbs;
                left++;
            } else {
                currentSquare = rightAbs * rightAbs;
                right--;
            }

            // 如果当前平方值与上一个不同，计数加1
            if (prevSquare == null || currentSquare != prevSquare) {
                count++;
                prevSquare = currentSquare;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // 测试用例1：包含正负对称的数组
        int[] arr1 = {-3, -2, -1, 0, 1, 2, 3};
        System.out.println("数组: " + java.util.Arrays.toString(arr1));
        System.out.println("平方后不同元素数量: " + countUniqueSquares(arr1)); // 预期: 4 (0,1,4,9)

        // 测试用例2：全负数数组
        int[] arr2 = {-5, -4, -3, -2, -1};
        System.out.println("\n数组: " + java.util.Arrays.toString(arr2));
        System.out.println("平方后不同元素数量: " + countUniqueSquares(arr2)); // 预期: 5

        // 测试用例3：包含重复元素的数组
        int[] arr3 = {-2, -2, 0, 2, 2};
        System.out.println("\n数组: " + java.util.Arrays.toString(arr3));
        System.out.println("平方后不同元素数量: " + countUniqueSquares(arr3)); // 预期: 2 (0,4)

        // 测试用例4：单元素数组
        int[] arr4 = {0};
        System.out.println("\n数组: " + java.util.Arrays.toString(arr4));
        System.out.println("平方后不同元素数量: " + countUniqueSquares(arr4)); // 预期: 1
    }
}