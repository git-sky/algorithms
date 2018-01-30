package cn.com.sky.algorithms.interview.string;


public class StringFind {


    public static void main(String[] args) {
        StringFind sf = new StringFind();

        String a = "ababcaaabcabcbbabc";
        String b = "abc";

        int count = sf.contains(a, b);
        System.out.println(count);
    }


    /**
     * 时间复杂度O(N x M)
     */
    private int contains(String a, String b) {

        int count = 0;

        if (a == null || b == null || a.length() < b.length()) {
            return 0;
        }

        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();

        for (int i = 0; i < aArray.length; i++) {

            int index = i;
            int j = 0;
            for (; j < bArray.length && index < aArray.length; j++, index++) {
                if (aArray[index] != bArray[j]) {
                    break;
                }
            }

            if (j >= bArray.length) {
                count++;
            }


        }


        return count;
    }

}
