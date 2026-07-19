package cn.com.sky.myinterview;

public class TestContinusSign {

    public static void main(String[] args) {
        new TestContinusSign().testContinusSign();
    }


    public void testContinusSign() {
        int[] a = {1, 2, 3, 5, 6, 7, 10, 11, 12, 13};
        int curmax = 1;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (i < a.length - 1 && a[i] + 1 == a[i + 1]) {
                curmax++;
            } else {
                max = Math.max(max, curmax);
                curmax = 1;
            }
        }

        max = Math.max(max, curmax);

        System.out.println("max=" + max);

    }

}
