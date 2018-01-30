package cn.com.sky.algorithms.offer;

import org.junit.Test;

import java.util.Random;

/**
 * <pre>
 *  不使用额外空间，交换两个数的值。
 */
public class SwapTwoNumber {

    @Test
    public void solution() {
        Random r = new Random();
        int a = r.nextInt(100);
        int b = r.nextInt(50);

//		 System.out.println(a);
//		 System.out.println(b);

        swapWithPlus(a, b);
        swapWithXor(a, b);

        // System.out.println(a);
        // System.out.println(b);

    }

    public void swapWithPlus(int a, int b) {

        System.out.println(a);
        System.out.println(b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println(a);
        System.out.println(b);
    }

    public void swapWithXor(int a, int b) {

        System.out.println(a);
        System.out.println(b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);
    }
}
