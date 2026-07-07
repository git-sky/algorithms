package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 17. 打印从1到最大的n位数（测试类）
 *
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。
 * 比如输入3，则打印出1、2、3一直到最大的3位数即999。
 *
 * 算法原理（大数问题 - 全排列递归法）：
 * 1. n位数可以看作n个0-9的全排列
 * 2. 使用递归，每一位从0到9遍历
 * 3. 打印时跳过前导0
 *
 * 与PrintN.java的区别：
 * - PrintN使用字符串模拟加法（方法1）
 * - TestPrintN使用全排列递归法（方法2）
 *
 * 时间复杂度：O(10^n)
 * 空间复杂度：O(n)
 * </pre>
 */
public class TestPrintN {

    public static void main(String[] args) {
        TestPrintN solution = new TestPrintN();

        // 测试用例1：n=2
        System.out.println("=== 测试用例1：n=2 ===");
        solution.printOneToNthDigits(2);

        // 测试用例2：n=1
        System.out.println("\n=== 测试用例2：n=1 ===");
        solution.printOneToNthDigits(1);

        // 测试用例3：n=0
        System.out.println("\n=== 测试用例3：n=0 ===");
        solution.printOneToNthDigits(0);

        // 测试用例4：方法2（模拟加法）
        System.out.println("\n=== 测试用例4：模拟加法 n=2 ===");
        solution.printOneToNthDigits2(2);
    }

    /**
     * 方法1：全排列递归法
     *
     * @param n 数字的最大位数
     */
    public void printOneToNthDigits(int n) {
        if (n < 1) {
            return;
        }
        int[] arr = new int[n];
        printOneToNthDigits(0, arr);
    }

    /**
     * 递归生成全排列
     *
     * @param n   当前处理的是第几个元素
     * @param arr 存放结果的数组
     */
    private void printOneToNthDigits(int n, int[] arr) {
        if (n >= arr.length) {
            printArray(arr);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            arr[n] = i;
            printOneToNthDigits(n + 1, arr);
        }
    }

    /**
     * 打印数组（跳过前导0）
     *
     * @param arr 要输出的数组
     */
    private void printArray(int[] arr) {
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }
        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        if (index < arr.length) {
            System.out.println();
        }
    }

    /**
     * 方法2：字符串模拟加法
     *
     * @param n 数字的最大位数
     */
    public void printOneToNthDigits2(int n) {
        if (n < 1) {
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        while (addOne(arr) == 0) {
            printArray(arr);
        }
    }

    /**
     * 对数组表示的数字最低位加1
     *
     * @param arr 待加数组
     * @return 最高位是否有进位（1表示溢出，0表示未溢出）
     */
    private int addOne(int[] arr) {
        int carry = 1;
        int index = arr.length;
        do {
            index--;
            arr[index] += carry;
            carry = arr[index] / 10;
            arr[index] %= 10;
        } while (carry != 0 && index > 0);

        if (carry > 0 && index == 0) {
            return 1;
        }
        return 0;
    }
}