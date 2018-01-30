package cn.com.sky.algorithms.interview;

import org.junit.Test;

import java.util.Arrays;

/**
 * 数组实现约瑟夫环
 */
public class JosephusProblemByArray {


    @Test
    public void solution() {

        int N = 41;
        int k = 3;
        int start = 0;

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));

        del(arr, N, k, start);

        System.out.println(Arrays.toString(arr));


    }

    private void del(int[] arr, int N, int k, int start) {

        int pos = 0;
        while (N > 0) {
            for (int i = 1; i < k; ) {
                if (arr[pos] != -1) {
                    i++;
                }
                pos++;
                if (pos >= arr.length) {
                    pos %= arr.length;
                }
            }
            arr[pos] = -1;
            pos++;
            if (pos >= arr.length) {
                pos %= arr.length;
            }
            N--;
            System.out.println(Arrays.toString(arr));
        }

    }

}
