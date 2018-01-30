package cn.com.sky.algorithms.offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * <pre>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度O(1)。
 */
public class ArrayOnlyOnce {

    @Test
    public void solution() {
        int[] arr = init();

        System.out.println(Arrays.toString(arr));

        // find(arr);

        findNumsAppearOnce(arr);

    }

    public void find(int[] arr) {

        //1、所有元素进行异或，result是两个不重复的数的异或。
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }

        //2、通过移动mask找到最后为1的数
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            int x = result & mask;
            if (x != 0)
                break;
            mask <<= 1;
        }

        System.out.println(mask);

        //3、使用mask异或所有的数，得到做后的结果。
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            if (0 == (mask & arr[i])) {
                a ^= arr[i];
            } else {
                b ^= arr[i];
            }
        }

        System.out.println("a:" + a);
        System.out.println("b:" + b);

    }

    /**
     * 初始化数组
     */
    public int[] init() {

        Random r = new Random();
        int len = r.nextInt(3) + 5;
        int[] arr = new int[2 * (len + 1)];

        for (int i = 0; i < 2 * len; ) {

            int x = r.nextInt(20) + 1;
            arr[i++] = x;
            arr[i++] = x;
        }

        arr[2 * len] = r.nextInt(10) + 5;
        arr[2 * len + 1] = r.nextInt(10) + 5;

        return arr;
    }

    private static void findNumsAppearOnce(int[] array) {
        if (array == null)
            return;
        int num = 0;
        for (int i : array) {
            num ^= i;
        }
        int index = findFirstBitIs1(num);
        int number1 = 0;
        int number2 = 0;
        for (int i : array) {
            if (isBit1(i, index))
                number1 ^= i;
            else
                number2 ^= i;
        }
        System.out.println(number1);
        System.out.println(number2);
    }

    private static boolean isBit1(int number, int index) {
        number = number >> index;
        return (number & 1) == 0;
    }

    private static int findFirstBitIs1(int num) {
        int index = 0;
        while ((num & 1) == 0) {
            num = num >> 1;
            index++;
        }
        return index;
    }

}
