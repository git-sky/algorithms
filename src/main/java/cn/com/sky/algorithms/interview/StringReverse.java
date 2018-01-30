package cn.com.sky.algorithms.interview;

import java.util.Arrays;

/**
 * 字符串反转
 */
public class StringReverse {

    public void swap(char[] arr, int begin, int end) {
        while(begin < end) {
            char temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            begin++;
            end--;
        }
    }
    //I love java
    public String swapWords(String str) {
        char[] arr = str.toCharArray();
        System.out.println(Arrays.toString(arr));

        swap(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int begin = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ' ') {
                swap(arr, begin, i - 1);
                begin = i + 1;
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String str = "I love java";
        System.out.println(new StringReverse().swapWords(str));
    }

}