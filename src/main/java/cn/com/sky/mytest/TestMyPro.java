package cn.com.sky.mytest;

import java.util.HashMap;

public class TestMyPro {

    public static void main(String[] args) {
        String input = "aabcdeefghijkllmn";
        testMyPro(input);

//        String a = "aabcdeefghijkllmn";
//        testMyPro2(a);
    }

    private static int testMyPro(String input) {
        if (input == null || input.isEmpty()) return 0;
        System.out.println(input);

        HashMap<Character, Integer> charIndexMap = new HashMap();

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < input.length(); right++) {
            Character ch = input.charAt(right);
            if (charIndexMap.containsKey(ch)) {
                int curmax = right - left;
                maxLength = Math.max(curmax, maxLength);
                left = Math.max(left, charIndexMap.get(ch) + 1);
            }
            charIndexMap.put(ch, right);
        }

        maxLength = Math.max(maxLength, input.length() - left);

        System.out.println("max=" + maxLength);

        return maxLength;
    }


    private static int testMyPro2() {
        String a = "aabcdeefghijkllmn";

        System.out.println(a);

        HashMap<Character, Integer> map = new HashMap();

        int max = 0;
        int left = 0;

        int maxleft = 0;
        int maxright = 0;

        for (int i = 0; i < a.length(); i++) {
            Character ch = a.charAt(i);
            if (map.containsKey(ch)) {
                int curmax = i - left;

                if (curmax > max) {
                    max = curmax;
                    maxleft = left;
                    maxright = i;
                }
                left = map.get(ch) + 1;
            }
            map.put(ch, i);
        }

        System.out.println("max=" + max);
        System.out.println(a.substring(maxleft, maxright));

        return max;
    }
}