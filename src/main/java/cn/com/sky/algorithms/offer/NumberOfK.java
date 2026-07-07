package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 53-I. 在排序数组中查找数字I【Easy】
 *
 * 题目：统计一个数字在排序数组中出现的次数。
 * 例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 *
 * 算法原理（二分查找）：
 * 1. 使用二分查找分别找到目标值的第一个位置和最后一个位置
 * 2. 出现次数 = lastK - firstK + 1
 *
 * 查找第一个位置：
 *   当中间值等于k时，判断前一个是否也等于k，如果不等于或已在首位，则找到第一个位置
 *
 * 查找最后一个位置：
 *   当中间值等于k时，判断后一个是否也等于k，如果不等于或已在末位，则找到最后一个位置
 *
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class NumberOfK {

    public static void main(String[] args) {
        NumberOfK solution = new NumberOfK();

        // 测试用例1：正常情况
        System.out.println("=== 测试用例1：正常情况 ===");
        int[] array1 = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println("数组中3出现的次数: " + solution.getNumberOfK(array1, 3)); // 4

        // 测试用例2：目标值不存在
        System.out.println("\n=== 测试用例2：目标值不存在 ===");
        int[] array2 = {1, 2, 4, 5, 6};
        System.out.println("数组中3出现的次数: " + solution.getNumberOfK(array2, 3)); // 0

        // 测试用例3：目标值出现一次
        System.out.println("\n=== 测试用例3：目标值出现一次 ===");
        int[] array3 = {1, 2, 3, 4, 5};
        System.out.println("数组中3出现的次数: " + solution.getNumberOfK(array3, 3)); // 1

        // 测试用例4：目标值在开头
        System.out.println("\n=== 测试用例4：目标值在开头 ===");
        int[] array4 = {1, 1, 1, 2, 3};
        System.out.println("数组中1出现的次数: " + solution.getNumberOfK(array4, 1)); // 3

        // 测试用例5：目标值在结尾
        System.out.println("\n=== 测试用例5：目标值在结尾 ===");
        int[] array5 = {1, 2, 3, 5, 5, 5};
        System.out.println("数组中5出现的次数: " + solution.getNumberOfK(array5, 5)); // 3

        // 测试用例6：单元素数组
        System.out.println("\n=== 测试用例6：单元素数组 ===");
        int[] array6 = {3};
        System.out.println("数组中3出现的次数: " + solution.getNumberOfK(array6, 3)); // 1

        // 测试用例7：空数组
        System.out.println("\n=== 测试用例7：空数组 ===");
        int[] array7 = {};
        System.out.println("数组中3出现的次数: " + solution.getNumberOfK(array7, 3)); // 0

        // 测试用例8：全部相同
        System.out.println("\n=== 测试用例8：全部相同 ===");
        int[] array8 = {2, 2, 2, 2};
        System.out.println("数组中2出现的次数: " + solution.getNumberOfK(array8, 2)); // 4
    }

    /**
     * 统计数字k在排序数组中出现的次数
     *
     * @param array 排序数组
     * @param k     目标数字
     * @return 出现次数
     */
    public int getNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int first = getFirstK(array, k, 0, array.length - 1);
        int last = getLastK(array, k, 0, array.length - 1);

        if (first > -1 && last > -1) {
            return last - first + 1;
        }
        return 0;
    }

    /**
     * 二分查找k第一次出现的位置
     */
    private int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        int midData = array[mid];

        if (midData == k) {
            // 如果前一个不等于k，或已在首位，则找到第一个位置
            if ((mid > 0 && array[mid - 1] != k) || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (midData > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        return getFirstK(array, k, start, end);
    }

    /**
     * 二分查找k最后一次出现的位置
     */
    private int getLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        int midData = array[mid];

        if (midData == k) {
            // 如果后一个不等于k，或已在末位，则找到最后一个位置
            if ((mid < array.length - 1 && array[mid + 1] != k) || mid == array.length - 1) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (midData < k) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }

        return getLastK(array, k, start, end);
    }
}