package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 17. 打印从1到最大的n位数【Easy】
 *
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。
 * 比如输入3，则打印出1、2、3一直到最大的3位数即999。
 *
 * 算法原理（大数问题处理）：
 * 方法1（字符串模拟加法）：
 *   使用字符数组模拟大数加法，每次加1后打印
 *   避免int/long溢出问题
 *
 * 方法2（全排列递归）：
 *   n位数的每一位都可以是0-9，递归生成所有排列
 *   本质上是n层嵌套循环的递归实现
 *
 * 大数问题要点：
 *   - 当n较大时，最大的n位数无法用int或long表示
 *   - 需要使用字符串或数组来表示大数
 *   - 打印时需要跳过前导0
 *
 * 时间复杂度：O(10^n)，需要生成所有数字
 * 空间复杂度：O(n)，字符数组长度
 * </pre>
 */
public class PrintN {

    public static void main(String[] args) {
        PrintN solution = new PrintN();

        // 测试用例1：n=1
        System.out.println("=== 测试用例1：n=1 ===");
        solution.print1ToMaxOfNDigits(1);

        // 测试用例2：n=2
        System.out.println("\n=== 测试用例2：n=2 ===");
        solution.print1ToMaxOfNDigits(2);

        // 测试用例3：n=3
        System.out.println("\n=== 测试用例3：n=3 ===");
        solution.print1ToMaxOfNDigits(3);

        // 测试用例4：n=0
        System.out.println("\n=== 测试用例4：n=0 ===");
        solution.print1ToMaxOfNDigits(0);

        // 测试用例5：全排列方法
        System.out.println("\n=== 测试用例5：全排列方法 n=2 ===");
        solution.print1ToMaxOfNDigitsByPermutation(2);
    }

    /**
     * 方法1：字符串模拟加法
     *
     * @param n 最大位数
     */
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }

        // Increment实现在表示数字的字符串number上增加1
        while (!increment(number)) {
            printNumber(number);
        }
    }

    /**
     * 字符串表示的数字加1
     *
     * @param number 字符数组表示的数字
     * @return 是否溢出（超过n位数）
     */
    private boolean increment(char[] number) {
        boolean isOverflow = false;
        int carry = 0;
        int length = number.length;

        for (int i = length - 1; i >= 0; i--) {
            int sum = number[i] - '0' + carry;
            if (i == length - 1) {
                sum++;
            }

            if (sum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    sum -= 10;
                    carry = 1;
                    number[i] = (char) ('0' + sum);
                }
            } else {
                number[i] = (char) ('0' + sum);
                break;
            }
        }

        return isOverflow;
    }

    /**
     * 打印字符数组表示的数字（跳过前导0）
     *
     * @param number 字符数组
     */
    private void printNumber(char[] number) {
        boolean isBeginning0 = true;

        for (char c : number) {
            if (isBeginning0 && c != '0') {
                isBeginning0 = false;
            }

            if (!isBeginning0) {
                System.out.print(c);
            }
        }

        System.out.print(" ");
    }

    /**
     * 方法2：全排列递归法
     *
     * @param n 最大位数
     */
    public void print1ToMaxOfNDigitsByPermutation(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];
        printByPermutation(number, 0);
    }

    /**
     * 递归生成全排列
     *
     * @param number 字符数组
     * @param index  当前处理的位
     */
    private void printByPermutation(char[] number, int index) {
        if (index == number.length) {
            printNumber(number);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            number[index] = (char) ('0' + i);
            printByPermutation(number, index + 1);
        }
    }
}