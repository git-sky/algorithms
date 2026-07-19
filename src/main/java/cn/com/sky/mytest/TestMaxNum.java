package cn.com.sky.mytest;

import java.util.Arrays;

public class TestMaxNum {


    public static void main(String[] str) {
        Integer num = 23121;
        String s = String.valueOf(num);
        // Integer num=Integer.parseInt(s);
        int[] sel = {4, 2, 9};
        // Character[] c={'2','3','9'};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sel.length; i++) {
            sb.append(sel[i]);
        }
        System.out.println(sb);

        int[] result = new TestMaxNum().getMaxNum(s, sel);
        System.out.println(Arrays.toString(result));

    }

    public int[] getMaxNum(String str, int[] sel) {

// 原始数字
        int[] intArray = new int[str.length()];
        char[] charArray = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            intArray[i] = Integer.parseInt(charArray[i] + "");
        }

        System.out.println(charArray);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArray.length; i++) {
            sb.append(intArray[i]);
        }
        System.out.println(sb);


// 可挑选的数字
        Arrays.sort(sel);
        System.out.println(Arrays.toString(sel));

        int maxNum = sel[sel.length - 1];

        int len = intArray.length;
        int[] maxArray = new int[len];

// 每位进行比对
        int pos = 0;

        while (pos < len) {
            int curNum = intArray[pos];

            // 找小于等于当前值的数字
            int findNumIdx = findLessOrEqual(curNum, sel);

            // 未找到，返回。需要回溯上一个数字。
            if (findNumIdx == -1) {
                break;
            }

            //小于，则后续所有用最大的值
            if (sel[findNumIdx] < curNum) {
                pos++;
                while (pos < len) {
                    maxArray[pos] = maxNum;
                    pos++;
                }
                //找到了
                return maxArray;
            }
            maxArray[pos] = curNum;

            //继续下一个
            pos++;

        }

// 执行到这里，说明没找到，得回溯。
        while (pos > 0) {
            pos--;
            int curNum = maxArray[pos];

            // 找必须小的
            int findNumIdx = findLess(curNum, sel);
            // 未找到，继续回溯
            if (findNumIdx == -1) {
                continue;
            }

            // 找到了
            maxArray[pos] = sel[findNumIdx];
            pos += 1;

            while (pos < len) {
                maxArray[pos] = maxNum;
                pos++;
            }
            return maxArray;
        }

//回溯到头也没找到？直接少一位，用最大值填充吧
        maxArray = new int[len - 1];
        for (int i = 0; i < len; i++) {
            maxArray[i] = maxNum;
        }

        return maxArray;
    }

    // 找小于等于的
    private int findLessOrEqual(int curNum, int[] sel) {
        int targetIdx = -1;
        int low = 0;
        int high = sel.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (curNum >= sel[mid]) {
                targetIdx = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return targetIdx;
    }

    // 找小于的
    private int findLess(int curNum, int[] sel) {
        int targetIdx = -1;
        int low = 0;
        int high = sel.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (curNum > sel[mid]) {
                targetIdx = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return targetIdx;
    }


}